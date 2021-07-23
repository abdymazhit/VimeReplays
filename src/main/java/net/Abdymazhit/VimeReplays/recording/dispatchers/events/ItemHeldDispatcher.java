package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.ItemHeldData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.HashMap;
import java.util.Map;

public class ItemHeldDispatcher implements Listener {

    private Map<Short, ItemHeldData> lastPlayerItemId;

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();

        if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
            short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
            byte itemId = (byte) player.getItemInHand().getTypeId();

            ItemHeldData itemHeldData = new ItemHeldData(playerId, itemId);

            if(lastPlayerItemId == null) {
                lastPlayerItemId = new HashMap<>();
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
