package net.Abdymazhit.VimeReplays.playing.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractEventListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                VimeReplays.getPlayingManager().getPlayingItems().performClickAction(event.getItem());
            }
        }
    }
}
