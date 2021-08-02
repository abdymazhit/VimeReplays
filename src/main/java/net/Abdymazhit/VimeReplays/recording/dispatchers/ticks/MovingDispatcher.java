package net.Abdymazhit.VimeReplays.recording.dispatchers.ticks;

import net.Abdymazhit.VimeReplays.VimeReplays;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Диспетчер обработки движений entity
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class MovingDispatcher extends BukkitRunnable {

    /**
     * Каждый тик проверяет движения entity и отправляет запись о движений
     */
    @Override
    public void run() {
        for(Entity entity : VimeReplays.getRecordingManager().getRecordableEntities()) {
            VimeReplays.getRecordingManager().getMainDispatcher().sendMovingData(entity);
        }
    }
}
