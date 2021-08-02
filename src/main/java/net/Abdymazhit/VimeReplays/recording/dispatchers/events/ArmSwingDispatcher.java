package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.animations.ArmSwingData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;

/**
 * Диспетчер обработки анимации взмаха руки игрока
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class ArmSwingDispatcher implements Listener {

    /**
     * Событие анимации игрока
     */
    @EventHandler
    public void onPlayerAnimation(PlayerAnimationEvent e) {
        Player player = e.getPlayer();

        // Проверить, является ли игрок записываемым
        if(VimeReplays.getRecordingManager().getRecordableEntities().contains(player)) {
            // Проверить анимацию на взмах руки
            if (e.getAnimationType().equals(PlayerAnimationType.ARM_SWING)) {
                // Добавить запись о взмахе руки
                VimeReplays.getRecordingManager().addRecordingData(new ArmSwingData(VimeReplays.getRecordingManager().getMainDispatcher().getEntityId(player)));
            }
        }
    }
}
