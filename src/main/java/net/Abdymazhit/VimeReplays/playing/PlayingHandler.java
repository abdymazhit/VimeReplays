package net.Abdymazhit.VimeReplays.playing;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.enums.PlayingStatus;
import net.Abdymazhit.VimeReplays.playing.nms.NMSEntity;
import net.Abdymazhit.VimeReplays.replay.data.customs.RecordingData;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Отвечает за воспроизведение игры
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class PlayingHandler {

    /** Статус воспроизведения игры */
    private PlayingStatus playingStatus;

    /** Текущий тик воспроизведения игры */
    private int currentTick;

    /** Скорость воспроизведения игры */
    private double playingSpeed;

    /** Базовый класс для воспроизведение игры с разными скоростями */
    private final ScheduledExecutorService scheduledExecutorService;

    /** Шедулер воспроизведения игры */
    private ScheduledFuture<?> scheduler;

    /** Зритель воспроизведения игры */
    private Player viewer;

    /** Хранит информацию о entity и его id */
    private final Map<Short, NMSEntity> entityList;

    /**
     * Инициализирует начальные значения для воспроизведения игры
     */
    public PlayingHandler() {
        playingStatus = PlayingStatus.PAUSE;
        currentTick = 0;
        playingSpeed = 1.0;
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        entityList = new HashMap<>();
    }

    /**
     * Устанавливает игрока зрителем воспроизведения игры
     */
    public void setViewer(Player viewer) {
        this.viewer = viewer;
    }

    /**
     * Начинает воспроизведение игры
     */
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
        VimeReplays.getPlayingManager().getPlayingItems().givePlayItem(viewer);
    }

    /**
     * Выполняет действия первого тика (добавляет NPC, чтобы игрок сразу их видел)
     */
    public void performFirstTickActions() {
        List<RecordingData> tickRecords = VimeReplays.getPlayingManager().getReplay().records.get(0);
        for(RecordingData recordingData : tickRecords) {
            recordingData.performAction();
        }
    }

    /**
     * Выполняет действия тика
     */
    private void performTickActions() {
        List<RecordingData> tickRecords = VimeReplays.getPlayingManager().getReplay().records.get(currentTick);
        for(RecordingData recordingData : tickRecords) {
            recordingData.performAction();
        }

        currentTick++;

        // Завершать воспроизведение, если вся игра была просмотрена
        if(VimeReplays.getPlayingManager().getReplay().records.size() == currentTick) {
            finish();
        }
    }

    /**
     * Ставит на паузу воспроизведение игры
     */
    public void pause() {
        playingStatus = PlayingStatus.PAUSE;
        scheduler.cancel(true);
        VimeReplays.getPlayingManager().getPlayingItems().givePauseItem(viewer);
    }

    /**
     * Завершает воспроизведение игры
     */
    public void finish() {
        playingStatus = PlayingStatus.FINISH;
        scheduler.cancel(true);
        VimeReplays.getPlayingManager().getPlayingItems().giveFinishItem(viewer);
    }

    /**
     * Начинает заново воспроизведение игры
     */
    public void restart() {
        currentTick = 0;
        playingStatus = PlayingStatus.PAUSE;
        scheduler.cancel(true);
        VimeReplays.getPlayingManager().getPlayingItems().givePauseItem(viewer);
        performFirstTickActions();
    }

    /**
     * Уменьшает скорость воспроизведения игры
     */
    public void minusPlayingSpeed() {
        if(playingSpeed == 0.25) {
            viewer.sendMessage("§cВы не можете изменить скорость воспроизведения ниже чем 0.25x!");
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
            viewer.sendMessage("§cПроизошла ошибка с изменением скорости воспроизведения!");
        }
    }

    /**
     * Увеличивает скорость воспроизведения игры
     */
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
            viewer.sendMessage("§cВы не можете изменить скорость воспроизведения больше чем 4x!");
        } else {
            viewer.sendMessage("§cПроизошла ошибка с изменением скорости воспроизведения!");
        }
    }

    /**
     * Возвращает статус воспроизведения игры
     */
    public PlayingStatus getPlayingStatus() {
        return playingStatus;
    }

    /**
     * Возвращает текущий тик воспроизведения игры
     */
    public int getCurrentTick() {
        return currentTick;
    }

    /**
     * Возвращает скорость воспроизведения игры
     */
    public double getPlayingSpeed() {
        return playingSpeed;
    }

    /**
     * Возвращает зрителя воспроизведения игры
     */
    public Player getViewer() {
        return viewer;
    }

    /**
     * Возвращает имя игрока по его id
     */
    public String getPlayerName(short id) {
        return VimeReplays.getPlayingManager().getReplay().players.get(id);
    }

    /**
     * Возвращает список entity
     */
    public Map<Short, NMSEntity> getEntityList() {
        return entityList;
    }
}
