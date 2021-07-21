package net.Abdymazhit.VimeReplays.managers;

import net.Abdymazhit.VimeReplays.Config;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.StatusCode;
import net.Abdymazhit.VimeReplays.dispatcher.events.SneakDispatcher;
import net.Abdymazhit.VimeReplays.dispatcher.ticks.MovingDispatcher;
import net.Abdymazhit.VimeReplays.replay.Replay;
import net.Abdymazhit.VimeReplays.replay.data.MovingData;
import net.Abdymazhit.VimeReplays.replay.data.RecordingData;
import net.Abdymazhit.VimeReplays.replay.data.SneakingData;
import net.Abdymazhit.VimeReplays.replay.data.UnsneakingData;
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

    private BukkitTask ticksDispatcherTask;
    private BukkitTask playerMoveDispatcherTask;

    private SneakDispatcher sneakDispatcher;

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

        List<String> playersId = new ArrayList<>();
        for(Player player : players) {
            playersId.add(player.getName());
        }

        replay = new Replay(gameNameId, gameTypeId, mapNameId, playersId, new HashMap<>());

        VimeReplays.getRecordingManager().getReplay().records.put(0, new ArrayList<>());

        ticksDispatcherTask = VimeReplays.getRecordingTools().startRecordingTicksTask();
        playerMoveDispatcherTask = new MovingDispatcher().runTaskTimer(VimeReplays.getInstance(), 0L, 1L);

        sneakDispatcher = new SneakDispatcher();

        VimeReplays.getInstance().getServer().getPluginManager().registerEvents(sneakDispatcher, VimeReplays.getInstance());

        return StatusCode.OK;
    }

    public void stopRecording() {
        playerMoveDispatcherTask.cancel();
        HandlerList.unregisterAll(sneakDispatcher);
        ticksDispatcherTask.cancel();

        VimeReplays.getFileUtils().saveFile(replay);

        // Проверка десериализации
        Replay replay = VimeReplays.getFileUtils().readFile();
        Map<Integer, List<RecordingData>> records = replay.records;
        for(int tick = 0; tick < records.size(); tick++) {
            List<RecordingData> tickRecords = records.get(tick);

            for(RecordingData recordingData : tickRecords) {
                if(recordingData instanceof MovingData) {
                    MovingData movingData = (MovingData) recordingData;
                    System.out.println("Moving: " + movingData.getEntityId() + ", " +
                            movingData.getX() + ", " +
                            movingData.getY() + ", " +
                            movingData.getZ() + ", " +
                            movingData.getPitch() + ", " +
                            movingData.getYaw() + ", ");
                } else if (recordingData instanceof SneakingData) {
                    SneakingData sneakingData = (SneakingData) recordingData;
                    System.out.println("Sneaking: " + sneakingData.getEntityId());
                } else if (recordingData instanceof UnsneakingData) {
                    UnsneakingData unsneakingData = (UnsneakingData) recordingData;
                    System.out.println("Unsneaking: " + unsneakingData.getEntityId());
                }
            }
        }
    }

    public List<Player> getRecordablePlayers() {
        return recordablePlayers;
    }

    public Replay getReplay() {
        return replay;
    }
}
