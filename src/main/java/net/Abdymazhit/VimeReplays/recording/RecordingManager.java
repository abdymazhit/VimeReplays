package net.Abdymazhit.VimeReplays.recording;

import net.Abdymazhit.VimeReplays.Config;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.StatusCode;
import net.Abdymazhit.VimeReplays.recording.dispatchers.events.*;
import net.Abdymazhit.VimeReplays.recording.dispatchers.packets.PacketsListener;
import net.Abdymazhit.VimeReplays.recording.dispatchers.ticks.MovingDispatcher;
import net.Abdymazhit.VimeReplays.replay.Replay;
import net.Abdymazhit.VimeReplays.replay.data.AddPlayerData;
import net.Abdymazhit.VimeReplays.replay.data.EnchantedItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.ItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.RecordingData;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordingManager {

    private int currentTick = 0;

    private List<Player> recordablePlayers;
    private Replay replay;

    private PacketsListener packetsListener;

    private BukkitTask ticksDispatcherTask;
    private BukkitTask movingDispatcherTask;

    private ItemHeldDispatcher itemHeldDispatcher;

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

        packetsListener = new PacketsListener();

        List<String> playersId = new ArrayList<>();
        for(Player player : players) {
            playersId.add(player.getName());
            packetsListener.addPlayer(player);
        }

        replay = new Replay(gameNameId, gameTypeId, mapNameId, playersId, new HashMap<>());

        addFirstTickData();
        ticksDispatcherTask = startRecordingTicksTask();
        movingDispatcherTask = new MovingDispatcher().runTaskTimer(VimeReplays.getInstance(), 0L, 1L);

        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new SneakDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new ArmSwingDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new BlockPlaceDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new BlockBreakDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(itemHeldDispatcher = new ItemHeldDispatcher(), VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(new DamageDispatcher(), VimeReplays.getInstance());

        return StatusCode.OK;
    }

    private void addFirstTickData() {
        List<RecordingData> tickRecords = new ArrayList<>();
        for(Player player : getRecordablePlayers()) {
            short playerId = getPlayerId(player.getName());

            short x = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getX());
            short y = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getY());
            short z = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getZ());
            short yaw = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getYaw());
            short pitch = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getPitch());

            tickRecords.add(new AddPlayerData(playerId, x, y, z, yaw, pitch));

            if(player.getItemInHand() != null) {
                ItemStack item = player.getItemInHand();

                short itemId = (short) VimeReplays.getItemUtils().getItemId(item);

                ItemHeldData itemHeldData;

                if(!item.getEnchantments().isEmpty()) {
                    itemHeldData = new EnchantedItemHeldData(playerId, itemId, item.getEnchantments());
                } else {
                    itemHeldData = new ItemHeldData(playerId, itemId);
                }

                tickRecords.add(itemHeldData);
            }
        }
        VimeReplays.getRecordingManager().getReplay().records.put(0, tickRecords);
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

    public Replay getReplay() {
        return replay;
    }

    public PacketsListener getPacketsListener() { return packetsListener; }
}
