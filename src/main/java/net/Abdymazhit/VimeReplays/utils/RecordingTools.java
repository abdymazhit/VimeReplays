package net.Abdymazhit.VimeReplays.utils;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.RecordingData;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class RecordingTools {

    private int currentTick = 0;

    public BukkitTask startRecordingTicksTask() {
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

    public int getPlayerId(String playerName) {
        for(int id = 0; id < VimeReplays.getRecordingManager().getReplay().players.size(); id++) {
            String name = VimeReplays.getRecordingManager().getReplay().players.get(id);
            if(name.equals(playerName)) {
                return id;
            }
        }
        return -1;
    }

    public String getPlayerName(int playerId) {
        return VimeReplays.getRecordingManager().getReplay().players.get(playerId);
    }
}
