package net.Abdymazhit.VimeReplays.recording;

import net.Abdymazhit.VimeReplays.Config;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.EquipmentType;
import net.Abdymazhit.VimeReplays.customs.StatusCode;
import net.Abdymazhit.VimeReplays.recording.dispatchers.MainDispatcher;
import net.Abdymazhit.VimeReplays.recording.dispatchers.events.*;
import net.Abdymazhit.VimeReplays.recording.dispatchers.packets.PacketsListener;
import net.Abdymazhit.VimeReplays.recording.dispatchers.ticks.MovingDispatcher;
import net.Abdymazhit.VimeReplays.replay.Replay;
import net.Abdymazhit.VimeReplays.replay.data.AddPlayerData;
import net.Abdymazhit.VimeReplays.replay.data.RecordingData;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Базовый класс для записи игры
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class RecordingManager {

    /** Текущий тик записи игры */
    private int currentTick;

    /** Отвечает за изменение текущего тика */
    private BukkitTask ticksTask;

    /** Список записываемых игроков */
    private List<Player> recordablePlayers;

    /** Запись игры */
    private Replay replay;

    /** Обработчик пакетов */
    private PacketsListener packetsListener;

    /** Главный диспетчер, отвечает за повторяющиеся записи */
    private MainDispatcher mainDispatcher;

    /** Диспетчер записи движений игроков */
    private BukkitTask movingDispatcherTask;

    /**
     * Начинает запись игры и возвращает статус кода записи игры
     * @param gameName название игры
     * @param gameType название типа игры
     * @param mapName название карты
     * @param players начальные список записываемых игроков
     */
    public StatusCode startRecording(String gameName, String gameType, String mapName, List<Player> players) {
        // Проверка, добавлена ли мини-игра в список записываемых мини-игр
        byte gameNameId = Config.getGameNameIdByString(gameName);
        if(gameNameId < 0) {
            return StatusCode.GameNameError;
        }

        // Проверка, добавлен ли режим мини-игры в список записываемых режимов мини-игры
        byte gameTypeId = Config.getGameTypeIdByString(gameType);
        if(gameTypeId < 0) {
            return StatusCode.GameTypeError;
        }

        // Проверка, добавлена ли карта в список записываемых карт
        byte mapNameId = Config.getMapNameIdByString(mapName);
        if(mapNameId < 0) {
            return StatusCode.MapNameError;
        }

        // Устанавить начальных записываемых игроков
        this.recordablePlayers = players;
        if(players == null || players.isEmpty()) {
            return StatusCode.NoPlayersError;
        }

        // Запустить обработчик пакетов
        packetsListener = new PacketsListener();

        // Добавить записываемых игроков в список для создания записи игры
        // Добавить игроков в обработчик пакетов
        List<String> playersId = new ArrayList<>();
        for(Player player : players) {
            playersId.add(player.getName());
            packetsListener.addPlayer(player);
        }

        // Создать объект записи игры
        replay = new Replay(gameNameId, gameTypeId, mapNameId, playersId, new HashMap<>());

        // Добавить записи первого тика (чтобы при воспроизведении игрок сразу видел NPC)
        addFirstTickData();

        // Начать шуделер для изменение тика
        currentTick = 0;
        ticksTask = startRecordingTicksTask();

        // Проинициализировать главный диспетчер для обработки повторяющихся записей
        mainDispatcher = new MainDispatcher();

        // Проинициализировать обработчики для записи записываемых данных
        movingDispatcherTask = new MovingDispatcher().runTaskTimer(VimeReplays.getInstance(), 0L, 1L);
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new SneakDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new ArmSwingDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new DamageDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new EquipmentDispatcher(), VimeReplays.getInstance());

        return StatusCode.OK;
    }

    /**
     * Добавляет записи первого тика (чтобы при воспроизведении игрок сразу видел NPC)
     */
    private void addFirstTickData() {
        VimeReplays.getRecordingManager().getReplay().records.put(0, new ArrayList<>());

        for(Player player : getRecordablePlayers()) {
            short playerId = getPlayerId(player.getName());

            // Добавить запись о добавлении игрока
            short x = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getX());
            short y = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getY());
            short z = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getZ());
            short yaw = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getYaw());
            short pitch = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getPitch());
            mainDispatcher.sendAddPlayerData(new AddPlayerData(playerId, x, y, z, yaw, pitch));

            // Добавить записи о экипировке игрока
            VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.HAND, player.getItemInHand());
            VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.HELMET, player.getInventory().getHelmet());
            VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.CHESTPLATE, player.getInventory().getChestplate());
            VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.LEGGINGS, player.getInventory().getLeggings());
            VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.BOOTS, player.getInventory().getBoots());
        }
    }

    /**
     * Завершает запись игры
     */
    public void stopRecording() {
        for(Player player : VimeReplays.getRecordingManager().getRecordablePlayers()) {
            packetsListener.removePlayer(player);
        }

        movingDispatcherTask.cancel();
        HandlerList.unregisterAll();
        ticksTask.cancel();

        VimeReplays.getFileUtils().saveFile(replay);
    }

    /**
     * Запускает шуделер для изменения текущего тика
     */
    private BukkitTask startRecordingTicksTask() {
        return new BukkitRunnable() {
            @Override
            public void run() {
                currentTick++;
                VimeReplays.getRecordingManager().getReplay().records.put(currentTick, new ArrayList<>());
            }
        }.runTaskTimer(VimeReplays.getInstance(), 0L, 1L);
    }

    /**
     * Добавляет записываемые данные
     */
    public void addRecordingData(RecordingData recordingData) {
        List<RecordingData> tickRecords = VimeReplays.getRecordingManager().getReplay().records.get(currentTick);
        tickRecords.add(recordingData);
        VimeReplays.getRecordingManager().getReplay().records.put(currentTick, tickRecords);
    }

    /**
     * Возвращает id игрока по его имени
     */
    public short getPlayerId(String playerName) {
        for(short id = 0; id < VimeReplays.getRecordingManager().getReplay().players.size(); id++) {
            String name = VimeReplays.getRecordingManager().getReplay().players.get(id);
            if(name.equals(playerName)) {
                return id;
            }
        }
        return -1;
    }

    /**
     * Удаляет записываемого игрока
     */
    public void removeRecordablePlayer(Player player) {
        recordablePlayers.remove(player);
    }

    /**
     * Возвращает список записываемых игроков
     */
    public List<Player> getRecordablePlayers() {
        return recordablePlayers;
    }

    /**
     * Возвращает главный диспетчер
     */
    public MainDispatcher getMainDispatcher() {
        return mainDispatcher;
    }

    /**
     * Возвращает запись игры
     */
    public Replay getReplay() {
        return replay;
    }

    /**
     * Возвращает обработчик пакетов
     */
    public PacketsListener getPacketsListener() { return packetsListener; }
}
