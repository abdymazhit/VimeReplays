package net.Abdymazhit.VimeReplays.recording.dispatchers;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.EquipmentType;
import net.Abdymazhit.VimeReplays.replay.data.AddPlayerData;
import net.Abdymazhit.VimeReplays.replay.data.MovingData;
import net.Abdymazhit.VimeReplays.replay.data.equipment.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class MainDispatcher {

    private final Map<Short, MovingData> playerLastLocation;

    private final Map<Short, ItemData> playerLastItemInHand;
    private final Map<Short, ItemData> playerLastHelmet;
    private final Map<Short, ItemData> playerLastChestplate;
    private final Map<Short, ItemData> playerLastLeggings;
    private final Map<Short, ItemData> playerLastBoots;

    public MainDispatcher() {
        playerLastLocation = new HashMap<>();

        playerLastItemInHand = new HashMap<>();
        playerLastHelmet = new HashMap<>();
        playerLastChestplate = new HashMap<>();
        playerLastLeggings = new HashMap<>();
        playerLastBoots = new HashMap<>();
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

    public void addItemData(Player player, EquipmentType equipmentType, ItemStack itemStack) {
        if(itemStack == null) {
            itemStack = new ItemStack(Material.AIR);
        }

        short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
        short itemId = (short) VimeReplays.getItemUtils().getItemId(itemStack);

        Map<Short, ItemData> lastDataMap = null;
        ItemData data = null;

        if(!itemStack.getEnchantments().isEmpty()) {
            if(equipmentType.equals(EquipmentType.HAND)) {
                lastDataMap = playerLastItemInHand;
                data = new EnchantedItemHeldData(playerId, itemId, itemStack.getEnchantments());
            } else if(equipmentType.equals(EquipmentType.HELMET)) {
                lastDataMap = playerLastHelmet;
                data = new EnchantedHelmetData(playerId, itemId, itemStack.getEnchantments());
            } else if(equipmentType.equals(EquipmentType.CHESTPLATE)) {
                lastDataMap = playerLastChestplate;
                data = new EnchantedChestplateData(playerId, itemId, itemStack.getEnchantments());
            } else if(equipmentType.equals(EquipmentType.LEGGINGS)) {
                lastDataMap = playerLastLeggings;
                data = new EnchantedLeggingsData(playerId, itemId, itemStack.getEnchantments());
            } else if(equipmentType.equals(EquipmentType.BOOTS)) {
                lastDataMap = playerLastBoots;
                data = new EnchantedBootsData(playerId, itemId, itemStack.getEnchantments());
            }
            addLastEnchantedItemData(lastDataMap, (EnchantedItemData) data);
        } else {
            if(equipmentType.equals(EquipmentType.HAND)) {
                lastDataMap = playerLastItemInHand;
                data = new ItemHeldData(playerId, itemId);
            } else if(equipmentType.equals(EquipmentType.HELMET)) {
                lastDataMap = playerLastHelmet;
                data = new HelmetData(playerId, itemId);
            } else if(equipmentType.equals(EquipmentType.CHESTPLATE)) {
                lastDataMap = playerLastChestplate;
                data = new ChestplateData(playerId, itemId);
            } else if(equipmentType.equals(EquipmentType.LEGGINGS)) {
                lastDataMap = playerLastLeggings;
                data = new LeggingsData(playerId, itemId);
            } else if(equipmentType.equals(EquipmentType.BOOTS)) {
                lastDataMap = playerLastBoots;
                data = new BootsData(playerId, itemId);
            }
            addLastItemData(lastDataMap, data);
        }
    }

    private void addLastItemData(Map<Short, ItemData> lastDataMap, ItemData data) {
        if(lastDataMap.containsKey(data.getEntityId())) {
            ItemData lastData = lastDataMap.get(data.getEntityId());

            if(lastData.getItemId() != data.getItemId()) {
                lastDataMap.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        } else {
            lastDataMap.put(data.getEntityId(), data);
            VimeReplays.getRecordingManager().addRecordingData(data);
        }
    }

    private void addLastEnchantedItemData(Map<Short, ItemData> lastDataMap, EnchantedItemData data) {
        if(lastDataMap.containsKey(data.getEntityId())) {
            if(lastDataMap.get(data.getEntityId()) instanceof EnchantedItemData) {
                EnchantedItemData enchantedHelmetData = (EnchantedItemData) lastDataMap.get(data.getEntityId());

                if(enchantedHelmetData.getItemId() == data.getItemId()) {
                    if(!enchantedHelmetData.getEnchantments().equals(data.getEnchantments())) {
                        lastDataMap.put(data.getEntityId(), data);
                        VimeReplays.getRecordingManager().addRecordingData(data);
                    }
                } else {
                    lastDataMap.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                lastDataMap.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        } else {
            lastDataMap.put(data.getEntityId(), data);
            VimeReplays.getRecordingManager().addRecordingData(data);
        }
    }
}
