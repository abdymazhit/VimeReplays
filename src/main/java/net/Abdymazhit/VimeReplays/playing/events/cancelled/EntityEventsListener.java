package net.Abdymazhit.VimeReplays.playing.events.cancelled;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

/**
 * Отменяет события связанные с entity
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class EntityEventsListener implements Listener {

    /**
     * Событие спавна entity
     */
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if(!event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.CUSTOM)) {
            event.setCancelled(true);
        }
    }

    /**
     * Событие возгорания entity
     */
    @EventHandler
    public void onEntityCombust(EntityCombustEvent event) {
        event.setCancelled(true);
    }

    /**
     * Событие изменения уровня голода
     */
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }
}
