package net.Abdymazhit.VimeReplays.recording;

import net.Abdymazhit.VimeReplays.Config;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.StatusCode;
import net.Abdymazhit.VimeReplays.recording.dispatchers.MainDispatcher;
import net.Abdymazhit.VimeReplays.recording.dispatchers.events.*;
import net.Abdymazhit.VimeReplays.recording.dispatchers.packets.PacketsListener;
import net.Abdymazhit.VimeReplays.recording.dispatchers.ticks.MovingDispatcher;
import net.Abdymazhit.VimeReplays.replay.Replay;
import net.Abdymazhit.VimeReplays.replay.data.AddPlayerData;
import net.Abdymazhit.VimeReplays.replay.data.RecordingData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordingManager {

    private int currentTick;

    private List<Player> recordablePlayers;
    private Replay replay;

    private MainDispatcher mainDispatcher;

    private PacketsListener packetsListener;

    private BukkitTask ticksDispatcherTask;
    private BukkitTask movingDispatcherTask;

    public StatusCode startRecording(String gameName, String gameType, String mapName, List<Player> players) {
        byte gameNameId = Config.getGameNameIdByString(gameName);
        if(gameNameId < 0) {
            return StatusCode.GameNameError;
        }

        byte gameTypeId = Config.getGameTypeIdByString(gameType);
        if(gameTypeId < 0) {
            return StatusCode.GameTypeError;
        }

        byte mapNameId = Config.getMapNameIdByString(mapName);
        if(mapNameId < 0) {
            return StatusCode.MapNameError;
        }

        this.recordablePlayers = players;
        if(players == null || players.isEmpty()) {
            return StatusCode.NoPlayersError;
        }

        mainDispatcher = new MainDispatcher();

        packetsListener = new PacketsListener();

        List<String> playersId = new ArrayList<>();
        for(Player player : players) {
            playersId.add(player.getName());
            packetsListener.addPlayer(player);
        }

        replay = new Replay(gameNameId, gameTypeId, mapNameId, playersId, new HashMap<>());

        currentTick = 0;

        addFirstTickData();
        ticksDispatcherTask = startRecordingTicksTask();
        movingDispatcherTask = new MovingDispatcher().runTaskTimer(VimeReplays.getInstance(), 0L, 1L);

        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new SneakDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new ArmSwingDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new BlockPlaceDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new BlockBreakDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new ItemHeldDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new DamageDispatcher(), VimeReplays.getInstance());

        return StatusCode.OK;
    }

    private void addFirstTickData() {
        VimeReplays.getRecordingManager().getReplay().records.put(currentTick, new ArrayList<>());

        for(Player player : getRecordablePlayers()) {
            short playerId = getPlayerId(player.getName());

            short x = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getX());
            short y = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getY());
            short z = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getZ());
            short yaw = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getYaw());
            short pitch = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getPitch());

            mainDispatcher.sendAddPlayerData(new AddPlayerData(playerId, x, y, z, yaw, pitch));

            ItemStack itemInHand = player.getItemInHand();
            if(itemInHand != null) {
                VimeReplays.getRecordingManager().getMainDispatcher().sendItemHeldData(player, itemInHand);
            } else {
                VimeReplays.getRecordingManager().getMainDispatcher().sendItemHeldData(player, new ItemStack(Material.AIR));
            }
        }
    }

    public void stopRecording() {
        for(Player player : VimeReplays.getRecordingManager().getRecordablePlayers()) {
            packetsListener.removePlayer(player);
        }

        movingDispatcherTask.cancel();
        HandlerList.unregisterAll();
        ticksDispatcherTask.cancel();

        VimeReplays.getFileUtils().saveFile(replay);
    }

    private BukkitTask startRecordingTicksTask() {
        return new BukkitRunnable() {
            @Override
            public void run() {
                currentTick++;
                VimeReplays.getRecordingManager().getReplay().records.put(currentTick, new ArrayList<>());
            }
        }.runTaskTimer(VimeReplays.getInstance(), 0L, 1L);
    }

    public void addRecordingData(RecordingData recordingData) {
        List<RecordingData> tickRecords = VimeReplays.getRecordingManager().getReplay().records.get(currentTick);
        tickRecords.add(recordingData);
        VimeReplays.getRecordingManager().getReplay().records.put(currentTick, tickRecords);
    }

    public short getPlayerId(String playerName) {
        for(short id = 0; id < VimeReplays.getRecordingManager().getReplay().players.size(); id++) {
            String name = VimeReplays.getRecordingManager().getReplay().players.get(id);
            if(name.equals(playerName)) {
                return id;
            }
        }
        return -1;
    }

    public List<Player> getRecordablePlayers() {
        return recordablePlayers;
    }

    public void removeRecordablePlayer(Player player) {
        recordablePlayers.remove(player);
    }

    public MainDispatcher getMainDispatcher() {
        return mainDispatcher;
    }

    public Replay getReplay() {
        return replay;
    }

    public PacketsListener getPacketsListener() { return packetsListener; }
}
