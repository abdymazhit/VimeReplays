package net.Abdymazhit.VimeReplays.recording.dispatchers;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.AddPlayerData;
import net.Abdymazhit.VimeReplays.replay.data.EnchantedItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.ItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.MovingData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class MainDispatcher {

    private final Map<Short, MovingData> playerLastLocation;
    private final Map<Short, ItemHeldData> playerLastItemInHandId;

    public MainDispatcher() {
        playerLastLocation = new HashMap<>();
        playerLastItemInHandId = new HashMap<>();
    }

    public void sendAddPlayerData(AddPlayerData data) {
        MovingData movingData = new MovingData(data.getEntityId(), data.getX(), data.getY(), data.getZ(), data.getYaw(), data.getPitch());
        playerLastLocation.put(data.getEntityId(), movingData);
        VimeReplays.getRecordingManager().addRecordingData(data);
    }

    public void sendMovingData(MovingData data) {
        if(playerLastLocation.containsKey(data.getEntityId())) {
            MovingData lastMovingData = playerLastLocation.get(data.getEntityId());

            if(lastMovingData.getX() != data.getX() || lastMovingData.getY() != data.getY() || lastMovingData.getZ() != data.getZ()
                    || lastMovingData.getYaw() != data.getYaw() || lastMovingData.getPitch() != data.getPitch()) {
                playerLastLocation.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        } else {
            playerLastLocation.put(data.getEntityId(), data);
            VimeReplays.getRecordingManager().addRecordingData(data);
        }
    }

    public void sendItemHeldData(Player player, ItemStack itemStack) {
        short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
        short itemId = (short) VimeReplays.getItemUtils().getItemId(itemStack);

        if(!itemStack.getEnchantments().isEmpty()) {
            EnchantedItemHeldData data = new EnchantedItemHeldData(playerId, itemId, itemStack.getEnchantments());

            if(playerLastItemInHandId.containsKey(data.getEntityId())) {
                if(playerLastItemInHandId.get(data.getEntityId()) instanceof EnchantedItemHeldData) {
                    EnchantedItemHeldData enchantedItemHeldData = (EnchantedItemHeldData) playerLastItemInHandId.get(data.getEntityId());

                    if(enchantedItemHeldData.getItemId() == data.getItemId()) {
                        if(!enchantedItemHeldData.getEnchantments().equals(data.getEnchantments())) {
                            playerLastItemInHandId.put(data.getEntityId(), data);
                            VimeReplays.getRecordingManager().addRecordingData(data);
                        }
                    } else {
                        playerLastItemInHandId.put(data.getEntityId(), data);
                        VimeReplays.getRecordingManager().addRecordingData(data);
                    }
                } else {
                    playerLastItemInHandId.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastItemInHandId.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        } else {
            ItemHeldData data = new ItemHeldData(playerId, itemId);

            if(playerLastItemInHandId.containsKey(data.getEntityId())) {
                ItemHeldData itemHeldData = playerLastItemInHandId.get(data.getEntityId());

                if(itemHeldData.getItemId() != data.getItemId()) {
                    playerLastItemInHandId.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastItemInHandId.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        }
    }
}
