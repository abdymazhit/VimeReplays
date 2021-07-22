package net.Abdymazhit.VimeReplays.managers;

import net.Abdymazhit.VimeReplays.Config;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.StatusCode;
import net.Abdymazhit.VimeReplays.dispatcher.events.*;
import net.Abdymazhit.VimeReplays.dispatcher.packets.PacketsListener;
import net.Abdymazhit.VimeReplays.dispatcher.ticks.MovingDispatcher;
import net.Abdymazhit.VimeReplays.replay.Replay;
import net.Abdymazhit.VimeReplays.replay.data.*;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordingManager {

    private List<Player> recordablePlayers;
    private Replay replay;

    private PacketsListener packetsListener;

    private BukkitTask ticksDispatcherTask;
    private BukkitTask playerMoveDispatcherTask;

    private SneakDispatcher sneakDispatcher;
    private ArmSwingDispatcher armSwingDispatcher;
    private BlockPlaceDispatcher blockPlaceDispatcher;
    private BlockBreakDispatcher blockBreakDispatcher;
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

        VimeReplays.getRecordingManager().getReplay().records.put(0, new ArrayList<>());

        ticksDispatcherTask = VimeReplays.getRecordingTools().startRecordingTicksTask();
        playerMoveDispatcherTask = new MovingDispatcher().runTaskTimer(VimeReplays.getInstance(), 0L, 1L);

        sneakDispatcher = new SneakDispatcher();
        armSwingDispatcher = new ArmSwingDispatcher();
        blockPlaceDispatcher = new BlockPlaceDispatcher();
        blockBreakDispatcher = new BlockBreakDispatcher();
        itemHeldDispatcher = new ItemHeldDispatcher();

        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(sneakDispatcher, VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(armSwingDispatcher, VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(blockPlaceDispatcher, VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(blockBreakDispatcher, VimeReplays.getInstance());
        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(itemHeldDispatcher, VimeReplays.getInstance());

        return StatusCode.OK;
    }

    public void stopRecording() {
        for(Player player : VimeReplays.getRecordingManager().getRecordablePlayers()) {
            packetsListener.removePlayer(player);
        }

        playerMoveDispatcherTask.cancel();
        HandlerList.unregisterAll(sneakDispatcher);
        HandlerList.unregisterAll(armSwingDispatcher);
        HandlerList.unregisterAll(blockPlaceDispatcher);
        HandlerList.unregisterAll(blockBreakDispatcher);
        HandlerList.unregisterAll(itemHeldDispatcher);
        ticksDispatcherTask.cancel();

        VimeReplays.getFileUtils().saveFile(replay);

        // Проверка десериализации
        Replay replay = VimeReplays.getFileUtils().readFile();
    }

    public void removeRecordablePlayer(Player player) {
        recordablePlayers.remove(player);
    }

    public List<Player> getRecordablePlayers() {
        return recordablePlayers;
    }

    public Replay getReplay() {
        return replay;
    }

    public PacketsListener getPacketsListener() { return packetsListener; }
}
