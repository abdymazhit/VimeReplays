package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.SneakingData;
import net.Abdymazhit.VimeReplays.replay.data.UnsneakingData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

/**
 * Диспетчер обработки крадется ли игрок (shift)
 *
 * @version   27.07.2021
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
        if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
            if (event.isSneaking()) {
                VimeReplays.getRecordingManager().addRecordingData(new SneakingData(VimeReplays.getRecordingManager().getPlayerId(player.getName())));
            } else {
                VimeReplays.getRecordingManager().addRecordingData(new UnsneakingData(VimeReplays.getRecordingManager().getPlayerId(player.getName())));
            }
        }
    }
}
