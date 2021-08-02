package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

/**
 * Диспетчер обработки метательных entity
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class ProjectileDispatcher implements Listener {

    /**
     * Событие запуска метательного entity
     */
    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if(!event.isCancelled()) {
            VimeReplays.getRecordingManager().getMainDispatcher().sendProjectileSpawnData(event.getEntity());
        }
    }

    /**
     * Событие попадения метательного entity
     */
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        VimeReplays.getRecordingManager().getMainDispatcher().sendEntityDeathData(event.getEntity());
    }
}
