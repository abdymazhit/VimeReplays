package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.EnchantedItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.ItemHeldData;
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
                short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
                short itemId = (short) VimeReplays.getItemUtils().getItemId(item);

                ItemHeldData itemHeldData;

                if(!item.getEnchantments().isEmpty()) {
                    itemHeldData = new EnchantedItemHeldData(playerId, itemId, item.getEnchantments());
                } else {
                    itemHeldData = new ItemHeldData(playerId, itemId);
                }

                VimeReplays.getRecordingManager().getMainDispatcher().sendItemHeldData(itemHeldData);
            }
        }
    }
}
