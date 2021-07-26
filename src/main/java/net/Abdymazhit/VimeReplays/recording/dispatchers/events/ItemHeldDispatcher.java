package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class ItemHeldDispatcher implements Listener {

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();

        if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
            ItemStack item = player.getInventory().getItem(event.getNewSlot());
            if(item != null) {
                VimeReplays.getRecordingManager().getMainDispatcher().sendItemHeldData(player, item);
            } else {
                VimeReplays.getRecordingManager().getMainDispatcher().sendItemHeldData(player, new ItemStack(Material.AIR));
            }
        }
    }
}
