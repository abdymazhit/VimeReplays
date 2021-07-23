package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.SneakingData;
import net.Abdymazhit.VimeReplays.replay.data.UnsneakingData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class SneakDispatcher implements Listener {

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();

        if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
            if (event.isSneaking()) {
                VimeReplays.getRecordingManager().addRecordingData(new SneakingData(VimeReplays.getRecordingManager().getPlayerId(player.getName())));
            } else {
                VimeReplays.getRecordingManager().addRecordingData(new UnsneakingData(VimeReplays.getRecordingManager().getPlayerId(player.getName())));
            }
        }
    }
}
