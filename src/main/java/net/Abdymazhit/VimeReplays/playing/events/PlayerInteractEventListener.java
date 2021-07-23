package net.Abdymazhit.VimeReplays.playing.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractEventListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                ItemStack item = event.getItem();
                if (item.equals(VimeReplays.getPlayingManager().getPlayingItems().getTeleportItem())) {

                } else if (item.equals(VimeReplays.getPlayingManager().getPlayingItems().getMinusItem())) {
                    VimeReplays.getPlayingManager().getPlayingTool().minusPlayingSpeed();
                } else if (item.equals(VimeReplays.getPlayingManager().getPlayingItems().getBackItem())) {

                } else if (item.equals(VimeReplays.getPlayingManager().getPlayingItems().getPlayItem())) {
                    VimeReplays.getPlayingManager().getPlayingTool().pause();
                } else if (item.equals(VimeReplays.getPlayingManager().getPlayingItems().getPauseItem())) {
                    VimeReplays.getPlayingManager().getPlayingTool().start();
                } else if (item.equals(VimeReplays.getPlayingManager().getPlayingItems().getFinishItem())) {
                    VimeReplays.getPlayingManager().getPlayingTool().restart();
                } else if (item.equals(VimeReplays.getPlayingManager().getPlayingItems().getForwardItem())) {

                } else if (item.equals(VimeReplays.getPlayingManager().getPlayingItems().getPlusItem())) {
                    VimeReplays.getPlayingManager().getPlayingTool().plusPlayingSpeed();
                } else if (item.equals(VimeReplays.getPlayingManager().getPlayingItems().getSettingsItem())) {

                }
            }
        }
    }
}
