package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.DamageData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Диспетчер обработки анимации дамага
 *
 * @version   27.07.2021
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
            if(event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();

                // Проверить, является ли игрок записываемым
                if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
                    // Добавить запись о дамаге
                    VimeReplays.getRecordingManager().addRecordingData(new DamageData(VimeReplays.getRecordingManager().getPlayerId(player.getName())));
                }
            }
        }
    }
}
