package net.Abdymazhit.VimeReplays.dispatcher.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.BlockPlaceData;
import net.Abdymazhit.VimeReplays.replay.data.ItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.MovingData;
import org.bukkit.block.Block;
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
            short playerId = VimeReplays.getRecordingTools().getPlayerId(player.getName());
            byte itemId = (byte) player.getItemInHand().getTypeId();

            ItemHeldData itemHeldData = new ItemHeldData(playerId, itemId);

            if(lastPlayerItemId == null) {
                lastPlayerItemId = new HashMap<>();
            }

            if(lastPlayerItemId.containsKey(playerId)) {
                ItemHeldData lastItemHeldData = lastPlayerItemId.get(playerId);

                if(lastItemHeldData.getItemId() != itemId) {
                    lastPlayerItemId.put(playerId, itemHeldData);
                    VimeReplays.getRecordingTools().addRecordingData(itemHeldData);
                }
            } else {
                lastPlayerItemId.put(playerId, itemHeldData);
                VimeReplays.getRecordingTools().addRecordingData(itemHeldData);
            }
        }
    }
}
