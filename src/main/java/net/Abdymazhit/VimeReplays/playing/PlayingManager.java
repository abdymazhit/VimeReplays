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

public class PlayingManager {

    private final Replay replay;
    private final PlayingItems playingItems;
    private final PlayingHandler playingHandler;

    public PlayingManager(String gameName, String mapName) {
        replay = VimeReplays.getFileUtils().readFile();
        playingItems = new PlayingItems();
        playingHandler = new PlayingHandler();

        startActionBarTask();

        setupMap(gameName, mapName);

        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new BlockEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new EntityEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new InventoryEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new PaintingEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new PlayerEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new WeatherEventsListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new WorldEventsListener(), VimeReplays.getInstance());

        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new PlayerInteractEventListener(), VimeReplays.getInstance());
    }

    private void setupMap(String gameName, String mapName) {
        try {
            FileUtils.deleteDirectory(new File(Bukkit.getWorldContainer() + "/replayMap/"));

            if(new File(Bukkit.getWorldContainer() + "/replayMap/").mkdirs()) {
                try {
                    FileUtils.copyDirectory(new File(Bukkit.getWorldContainer() + "/plugins/VimeReplays/maps/" + gameName + "/" + mapName),
                            new File(Bukkit.getWorldContainer() + "/replayMap"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        WorldCreator wc = new WorldCreator("replayMap");
        wc.environment(World.Environment.NORMAL);
        Bukkit.createWorld(wc);
    }

    private void startActionBarTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if(getPlayingHandler().getPlayer() != null) {
                    Player player = getPlayingHandler().getPlayer();
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

                    sendActionbar(player, message);
                }
            }
        }.runTaskTimer(VimeReplays.getInstance(), 0L, 1L);
    }

    public static void sendActionbar(Player p, String message) {
        IChatBaseComponent iChatBaseComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', message) + "\"}");
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(iChatBaseComponent, (byte) 2);
        (((CraftPlayer)p).getHandle()).playerConnection.sendPacket(packetPlayOutChat);
    }

    public Replay getReplay() {
        return replay;
    }

    public PlayingItems getPlayingItems() {
        return playingItems;
    }

    public PlayingHandler getPlayingHandler() {
        return playingHandler;
    }
}
