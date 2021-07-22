package net.Abdymazhit.VimeReplays.dispatcher.events;

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
                VimeReplays.getRecordingTools().addRecordingData(new SneakingData(VimeReplays.getRecordingTools().getPlayerId(player.getName())));
            } else {
                VimeReplays.getRecordingTools().addRecordingData(new UnsneakingData(VimeReplays.getRecordingTools().getPlayerId(player.getName())));
            }
        }
    }
}
