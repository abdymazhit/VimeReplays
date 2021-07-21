package net.Abdymazhit.VimeReplays.dispatcher.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.ArmSwingData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;

public class ArmSwingDispatcher implements Listener {

    @EventHandler
    public void onPlayerAnimation(PlayerAnimationEvent e) {
        Player player = e.getPlayer();

        if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
            if (e.getAnimationType().equals(PlayerAnimationType.ARM_SWING)) {
                VimeReplays.getRecordingTools().addRecordingData(new ArmSwingData(VimeReplays.getRecordingTools().getPlayerId(player.getName())));
            }
        }
    }
}
