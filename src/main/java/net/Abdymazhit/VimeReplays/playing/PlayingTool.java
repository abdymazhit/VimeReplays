package net.Abdymazhit.VimeReplays.playing;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.PlayingStatus;
import net.Abdymazhit.VimeReplays.replay.data.*;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class PlayingTool {

    private PlayingStatus playingStatus;
    private int currentTick;
    private double playingSpeed;

    private final ScheduledExecutorService scheduledExecutorService;
    private ScheduledFuture<?> scheduler;

    private Player player;

    public PlayingTool() {
        playingStatus = PlayingStatus.PAUSE;
        currentTick = 0;
        playingSpeed = 1.0;
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
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
}
