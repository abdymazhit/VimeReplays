package net.Abdymazhit.VimeReplays.recording;

import net.Abdymazhit.VimeReplays.Config;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.enums.EquipmentType;
import net.Abdymazhit.VimeReplays.enums.RecordingStatus;
import net.Abdymazhit.VimeReplays.recording.dispatchers.MainDispatcher;
import net.Abdymazhit.VimeReplays.recording.dispatchers.events.*;
import net.Abdymazhit.VimeReplays.recording.dispatchers.packets.PacketsListener;
import net.Abdymazhit.VimeReplays.recording.dispatchers.ticks.MovingDispatcher;
import net.Abdymazhit.VimeReplays.replay.Replay;
import net.Abdymazhit.VimeReplays.replay.data.customs.RecordingData;
import org.bukkit.entity.Entity;
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
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class RecordingManager {

    /** Текущий тик записи игры */
    private int currentTick;

    /** Отвечает за изменение времени (текущего тика) */
    private BukkitTask ticksTask;

    /** Список записываемых entity */
    private List<Entity> recordableEntities;

    /** Запись игры */
    private Replay replay;

    /** Обработчик пакетов */
    private PacketsListener packetsListener;

    /** Главный диспетчер, отвечает за повторяющиеся записи */
    private MainDispatcher mainDispatcher;

    /** Диспетчер записи движений entity */
    private BukkitTask movingDispatcherTask;

    /**
     * Начинает запись игры и возвращает статус кода записи игры
     * @param gameName название игры
     * @param gameType название типа игры
     * @param mapName название карты
     * @param players начальные список записываемых игроков
     */
    public RecordingStatus startRecording(String gameName, String gameType, String mapName, List<Player> players) {
        // Проверка, добавлена ли мини-игра в список записываемых мини-игр
        byte gameNameId = Config.getGameNameIdByString(gameName);
        if(gameNameId < 0) {
            return RecordingStatus.GameNameError;
        }

        // Проверка, добавлен ли режим мини-игры в список записываемых режимов мини-игры
        byte gameTypeId = Config.getGameTypeIdByString(gameType);
        if(gameTypeId < 0) {
            return RecordingStatus.GameTypeError;
        }

        // Проверка, добавлена ли карта в список записываемых карт
        byte mapNameId = Config.getMapNameIdByString(mapName);
        if(mapNameId < 0) {
            return RecordingStatus.MapNameError;
        }

        // Проверка, существуют ли начальные записываемые игроки
        if(players.isEmpty()) {
            return RecordingStatus.NoPlayersError;
        }

        // Добавить начальных записываемых игроков в список записываемых entity
        recordableEntities = new ArrayList<>();
        recordableEntities.addAll(players);

        // Запустить обработчик пакетов
        packetsListener = new PacketsListener();
        for(Player player : players) {
            packetsListener.addPlayer(player);
        }

        // Создать объект записи игры
        replay = new Replay(gameNameId, gameTypeId, mapNameId, new HashMap<>(), new HashMap<>());

        // Проинициализировать главный диспетчер для обработки повторяющихся записей
        mainDispatcher = new MainDispatcher();

        // Добавить записи первого тика (чтобы при воспроизведении игрок сразу видел NPC)
        addFirstTickData();

        // Начать шуделер для изменение тика
        currentTick = 0;
        ticksTask = startRecordingTicksTask();

        // Проинициализировать обработчики для записи записываемых данных
        movingDispatcherTask = new MovingDispatcher().runTaskTimer(VimeReplays.getInstance(), 0L, 1L);
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new SneakDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new ArmSwingDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new DamageDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new EquipmentDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new ProjectileDispatcher(), VimeReplays.getInstance());

        // Вернуть положительные код записи
        return RecordingStatus.OK;
    }

    /**
     * Добавляет записи первого тика (чтобы при воспроизведении игрок сразу видел NPC)
     */
    private void addFirstTickData() {
        VimeReplays.getRecordingManager().getReplay().records.put(0, new ArrayList<>());

        for(Entity entity : getRecordableEntities()) {
            if(entity instanceof Player) {
                Player player = (Player) entity;

                // Добавить запись о спавне игрока
                mainDispatcher.sendPlayerSpawnData(player);

                // Добавить записи о экипировке игрока
                VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.HAND, player.getItemInHand());
                VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.HELMET, player.getInventory().getHelmet());
                VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.CHESTPLATE, player.getInventory().getChestplate());
                VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.LEGGINGS, player.getInventory().getLeggings());
                VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.BOOTS, player.getInventory().getBoots());
            }
        }
    }

    /**
     * Завершает запись игры
     */
    public void stopRecording() {
        for(Entity entity : getRecordableEntities()) {
            if (entity instanceof Player) {
                Player player = (Player) entity;
                packetsListener.removePlayer(player);
            }
        }

        movingDispatcherTask.cancel();
        HandlerList.unregisterAll();
        ticksTask.cancel();

        VimeReplays.getFileUtils().saveFile(replay);
    }

    /**
     * Запускает шуделер для изменения времени (текущего тика)
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
     * Возвращает запись игры
     */
    public Replay getReplay() {
        return replay;
    }

    /**
     * Возвращает список записываемых entity
     */
    public List<Entity> getRecordableEntities() {
        return recordableEntities;
    }

    /**
     * Возвращает главный диспетчер
     */
    public MainDispatcher getMainDispatcher() {
        return mainDispatcher;
    }

    /**
     * Возвращает обработчик пакетов
     */
    public PacketsListener getPacketsListener() { return packetsListener; }
}
