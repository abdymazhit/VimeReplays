package net.Abdymazhit.VimeReplays.playing;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.PlayingStatus;
import net.Abdymazhit.VimeReplays.playing.events.PlayerInteractEventListener;
import net.Abdymazhit.VimeReplays.playing.events.PlayerJoinEventListener;
import net.Abdymazhit.VimeReplays.playing.events.cancelled.*;
import net.Abdymazhit.VimeReplays.replay.Replay;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;

/**
 * Базовый класс для воспроизведения игры
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class PlayingManager {

    /** Запись воспроизведения игры */
    private final Replay replay;

    /** Объект, отвечает за предметы воспроизведения игры */
    private final PlayingItems playingItems;

    /** Объект, отвечает за воспроизведения игры */
    private final PlayingHandler playingHandler;

    /**
     * Инициализирует начальные значения для воспроизведения игры
     */
    public PlayingManager(String gameName, String mapName) {
        replay = VimeReplays.getFileUtils().readFile();
        playingItems = new PlayingItems();
        playingHandler = new PlayingHandler();

        // Настроить карту для воспроизведения игры
        setupMap(gameName, mapName);

        // Начать обновление action bar'а для зрителя
        startActionBarTask();

        // Отменить мешающие события для воспроизведения игры
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new BlockEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new EntityEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new InventoryEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new PaintingEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new PlayerEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new WeatherEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new WorldEventsListener(), VimeReplays.getInstance());

        // Зарегистрировать события для воспроизведения игры
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new PlayerInteractEventListener(), VimeReplays.getInstance());
    }

    /**
     * Настраивает карту для воспроизведения игры
     */
    private void setupMap(String gameName, String mapName) {
        try {
            // Удаляет папку replayMap
            FileUtils.deleteDirectory(new File(Bukkit.getWorldContainer() + "/replayMap/"));

            // Создает папку replayMap
            if(new File(Bukkit.getWorldContainer() + "/replayMap/").mkdirs()) {
                try {
                    // Копирует папку карты игры в replayMap
                    FileUtils.copyDirectory(new File(Bukkit.getWorldContainer() + "/plugins/VimeReplays/maps/" + gameName + "/" + mapName),
                            new File(Bukkit.getWorldContainer() + "/replayMap"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Добавляет карту как отдельный мир
        WorldCreator wc = new WorldCreator("replayMap");
        wc.environment(World.Environment.NORMAL);
        Bukkit.createWorld(wc);
    }

    /**
     * Обновляет action bar зрителю
     */
    private void startActionBarTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if(getPlayingHandler().getViewer() != null) {
                    Player player = playingHandler.getViewer();
                    String message = "";

                    PlayingStatus playingStatus = VimeReplays.getPlayingManager().getPlayingHandler().getPlayingStatus();

                    if(playingStatus.equals(PlayingStatus.PLAY)) {
                        message += "§aВОСПРОИЗВЕДЕНИЕ";
                    } else if(playingStatus.equals(PlayingStatus.PAUSE)) {
                        message += "§cПАУЗА";
                    } else if(playingStatus.equals(PlayingStatus.FINISH)) {
                        message += "§bЗАВЕРШЕНО";
                    }
                    message += "         ";
                    message += "§e" + VimeReplays.getPlayingManager().getPlayingHandler().getCurrentTick() + "/" + replay.records.size();
                    message += "         ";
                    message += "§6" + VimeReplays.getPlayingManager().getPlayingHandler().getPlayingSpeed() + "x";

                    IChatBaseComponent iChatBaseComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', message) + "\"}");
                    PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(iChatBaseComponent, (byte) 2);
                    (((CraftPlayer) player).getHandle()).playerConnection.sendPacket(packetPlayOutChat);
                }
            }
        }.runTaskTimer(VimeReplays.getInstance(), 0L, 1L);
    }

    /**
     * Возвращает запись игры
     */
    public Replay getReplay() {
        return replay;
    }

    /**
     * Возвращает объект, отвечающий за предметы для воспроизведения игры
     */
    public PlayingItems getPlayingItems() {
        return playingItems;
    }

    /**
     * Возвращает объект, отвечающий за воспроизведения игры
     */
    public PlayingHandler getPlayingHandler() {
        return playingHandler;
    }
}
