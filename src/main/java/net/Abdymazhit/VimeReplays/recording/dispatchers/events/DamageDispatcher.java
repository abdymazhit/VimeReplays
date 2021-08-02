package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.animations.DamageData;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Диспетчер обработки анимации получения урона entity
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class DamageDispatcher implements Listener {

    /**
     * Событие получения урона
     */
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        // Проверить, не отменено ли событие
        if(!event.isCancelled()) {
            Entity entity = event.getEntity();

            // Проверить, является ли entity записываемым
            if(VimeReplays.getRecordingManager().getRecordableEntities().contains(entity)) {
                // Добавить запись о дамаге
                VimeReplays.getRecordingManager().addRecordingData(new DamageData(VimeReplays.getRecordingManager().getMainDispatcher().getEntityId(entity)));
            }
        }
    }
}
