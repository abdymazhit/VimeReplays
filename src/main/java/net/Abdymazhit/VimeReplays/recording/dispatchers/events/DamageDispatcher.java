package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.DamageData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageDispatcher implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if(!event.isCancelled()) {
            if(event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();

                if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
                    VimeReplays.getRecordingManager().addRecordingData(new DamageData(VimeReplays.getRecordingManager().getPlayerId(player.getName())));
                }
            }
        }
    }
}
