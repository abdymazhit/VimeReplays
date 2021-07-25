package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.EnchantedItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.ItemHeldData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ItemHeldDispatcher implements Listener {

    private final Map<Short, Short> lastPlayerItemId;

    public ItemHeldDispatcher() {
        lastPlayerItemId = new HashMap<>();
    }

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();

        if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
            ItemStack item = player.getInventory().getItem(event.getNewSlot());

            short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
            short itemId = (short) VimeReplays.getItemUtils().getItemId(item);

            ItemHeldData itemHeldData;

            if(!item.getEnchantments().isEmpty()) {
                itemHeldData = new EnchantedItemHeldData(playerId, itemId, item.getEnchantments());
            } else {
                itemHeldData = new ItemHeldData(playerId, itemId);
            }

            if(lastPlayerItemId.containsKey(playerId)) {
                short lastItemId = lastPlayerItemId.get(playerId);

                if(lastItemId != itemId) {
                    lastPlayerItemId.put(playerId, itemHeldData.getItemId());
                    VimeReplays.getRecordingManager().addRecordingData(itemHeldData);
                }
            } else {
                lastPlayerItemId.put(playerId, itemHeldData.getItemId());
                VimeReplays.getRecordingManager().addRecordingData(itemHeldData);
            }
        }
    }
}
