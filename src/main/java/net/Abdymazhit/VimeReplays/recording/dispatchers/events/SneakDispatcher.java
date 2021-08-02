package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.animations.SneakingData;
import net.Abdymazhit.VimeReplays.replay.data.animations.UnsneakingData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

/**
 * Диспетчер обработки анимации крадется ли игрок (shift)
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class SneakDispatcher implements Listener {

    /**
     * Событие крадется ли игрок (нажатие по shift)
     */
    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();

        // Проверить игрока на записываемость и записать запись
        if(VimeReplays.getRecordingManager().getRecordableEntities().contains(player)) {
            if (event.isSneaking()) {
                VimeReplays.getRecordingManager().addRecordingData(new SneakingData(VimeReplays.getRecordingManager().getMainDispatcher().getEntityId(player)));
            } else {
                VimeReplays.getRecordingManager().addRecordingData(new UnsneakingData(VimeReplays.getRecordingManager().getMainDispatcher().getEntityId(player)));
            }
        }
    }
}
