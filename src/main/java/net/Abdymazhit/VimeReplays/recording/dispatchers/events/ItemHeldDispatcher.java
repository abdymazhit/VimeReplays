package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.EnchantedItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.ItemHeldData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ItemHeldDispatcher implements Listener {

    private final Map<Short, ItemHeldData> lastPlayerItemId;

    public ItemHeldDispatcher() {
        lastPlayerItemId = new HashMap<>();
    }

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();

        if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
            ItemStack item = player.getItemInHand();

            short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
            short itemId;

            if(item.getType() == Material.POTION) {
                itemId = (short) VimeReplays.getItemUtils().getPotionItemId(item.getType(), item.getData().getData());
            } else {
                itemId = (short) VimeReplays.getItemUtils().getItemId(item.getType(), item.getData().getData());
            }

            ItemHeldData itemHeldData;

            if(!item.getEnchantments().isEmpty()) {
                itemHeldData = new EnchantedItemHeldData(playerId, itemId, item.getEnchantments());
            } else {
                itemHeldData = new ItemHeldData(playerId, itemId);
            }

            if(lastPlayerItemId.containsKey(playerId)) {
                ItemHeldData lastItemHeldData = lastPlayerItemId.get(playerId);

                if(lastItemHeldData.getItemId() != itemId) {
                    lastPlayerItemId.put(playerId, itemHeldData);
                    VimeReplays.getRecordingManager().addRecordingData(itemHeldData);
                }
            } else {
                lastPlayerItemId.put(playerId, itemHeldData);
                VimeReplays.getRecordingManager().addRecordingData(itemHeldData);
            }
        }
    }
}
