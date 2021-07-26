package net.Abdymazhit.VimeReplays.playing;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.PlayingStatus;
import net.Abdymazhit.VimeReplays.replay.data.RecordingData;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class PlayingHandler {

    private PlayingStatus playingStatus;
    private int currentTick;
    private double playingSpeed;

    private final ScheduledExecutorService scheduledExecutorService;
    private ScheduledFuture<?> scheduler;

    private Player player;
    private final Map<Short, NPC> npcList;

    public PlayingHandler() {
        playingStatus = PlayingStatus.PAUSE;
        currentTick = 0;
        playingSpeed = 1.0;
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        npcList = new HashMap<>();
    }

    public void start() {
        playingStatus = PlayingStatus.PLAY;
        if(playingSpeed == 0.25) {
            scheduler = scheduledExecutorService.scheduleWithFixedDelay(this::performTickActions, 0, 200000, TimeUnit.MICROSECONDS);
        } else if(playingSpeed == 0.5) {
            scheduler = scheduledExecutorService.scheduleWithFixedDelay(this::performTickActions, 0, 100000, TimeUnit.MICROSECONDS);
        } else if(playingSpeed == 1.0) {
            scheduler = scheduledExecutorService.scheduleWithFixedDelay(this::performTickActions, 0, 50000, TimeUnit.MICROSECONDS);
        } else if(playingSpeed == 2.0) {
            scheduler = scheduledExecutorService.scheduleWithFixedDelay(this::performTickActions, 0, 25000, TimeUnit.MICROSECONDS);
        } else if(playingSpeed == 3.0) {
            scheduler = scheduledExecutorService.scheduleWithFixedDelay(this::performTickActions, 0, 12500, TimeUnit.MICROSECONDS);
        } else if(playingSpeed == 4.0) {
            scheduler = scheduledExecutorService.scheduleWithFixedDelay(this::performTickActions, 0, 6250, TimeUnit.MICROSECONDS);
        }
        VimeReplays.getPlayingManager().getPlayingItems().givePlayItem(player);
    }

    public void performFirstTickActions() {
        List<RecordingData> tickRecords = VimeReplays.getPlayingManager().getReplay().records.get(0);
        VimeReplays.getPlayingManager().getPlayingHandler().performAction(tickRecords);
    }

    private void performTickActions() {
        List<RecordingData> tickRecords = VimeReplays.getPlayingManager().getReplay().records.get(currentTick);
        VimeReplays.getPlayingManager().getPlayingHandler().performAction(tickRecords);

        currentTick++;

        if(VimeReplays.getPlayingManager().getReplay().records.size() == currentTick) {
            finish();
        }
    }

    public void pause() {
        playingStatus = PlayingStatus.PAUSE;
        scheduler.cancel(true);
        VimeReplays.getPlayingManager().getPlayingItems().givePauseItem(player);
    }

    public void finish() {
        playingStatus = PlayingStatus.FINISH;
        scheduler.cancel(true);
        VimeReplays.getPlayingManager().getPlayingItems().giveFinishItem(player);
    }

    public void restart() {
        currentTick = 0;
        playingStatus = PlayingStatus.PAUSE;
        scheduler.cancel(true);
        VimeReplays.getPlayingManager().getPlayingItems().givePauseItem(player);
        performFirstTickActions();
    }

    public void performAction(List<RecordingData> tickRecords) {
        for(RecordingData recordingData : tickRecords) {
            recordingData.performAction();
        }
    }

    public void minusPlayingSpeed() {
        if(playingSpeed == 0.25) {
            player.sendMessage("§cВы не можете изменить скорость воспроизведения ниже чем 0.25x!");
        } else if(playingSpeed == 0.5) {
            playingSpeed = 0.25;
        } else if(playingSpeed == 1.0) {
            playingSpeed = 0.5;
        } else if(playingSpeed == 2.0) {
            playingSpeed = 1.0;
        } else if(playingSpeed == 3.0) {
            playingSpeed = 2.0;
        } else if(playingSpeed == 4.0) {
            playingSpeed = 3.0;
        } else {
            player.sendMessage("§cПроизошла ошибка с изменением скорости воспроизведения!");
        }
    }

    public void plusPlayingSpeed() {
        if(playingSpeed == 0.25) {
            playingSpeed = 0.5;
        } else if(playingSpeed == 0.5) {
            playingSpeed = 1.0;
        } else if(playingSpeed == 1.0) {
            playingSpeed = 2.0;
        } else if(playingSpeed == 2.0) {
            playingSpeed = 3.0;
        } else if(playingSpeed == 3.0) {
            playingSpeed = 4.0;
        } else if(playingSpeed == 4.0) {
            player.sendMessage("§cВы не можете изменить скорость воспроизведения больше чем 4x!");
        } else {
            player.sendMessage("§cПроизошла ошибка с изменением скорости воспроизведения!");
        }
    }

    public PlayingStatus getPlayingStatus() {
        return playingStatus;
    }

    public int getCurrentTick() {
        return currentTick;
    }

    public double getPlayingSpeed() {
        return playingSpeed;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public String getPlayerName(int id) {
        return VimeReplays.getPlayingManager().getReplay().players.get(id);
    }

    public Map<Short, NPC> getNPCList() {
        return npcList;
    }
}
