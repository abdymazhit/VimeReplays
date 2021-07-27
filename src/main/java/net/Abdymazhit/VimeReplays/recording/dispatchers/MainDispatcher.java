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

/**
 * Главный диспетчер, отвечает за запись повторяющихся данных
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class MainDispatcher {

    /** Хранит информацию о последнем местоположении игрока */
    private final Map<Short, MovingData> playerLastLocation;

    /** Хранит информацию о последнем предмете в руке игрока */
    private final Map<Short, ItemData> playerLastItemInHand;

    /** Хранит информацию о последнем шлеме игрока */
    private final Map<Short, ItemData> playerLastHelmet;

    /** Хранит информацию о последнем нагруднике игрока */
    private final Map<Short, ItemData> playerLastChestplate;

    /** Хранит информацию о последнем штане игрока */
    private final Map<Short, ItemData> playerLastLeggings;

    /** Хранит информацию о последнем ботинке игрока */
    private final Map<Short, ItemData> playerLastBoots;

    /**
     * Инициализирует главный диспетчер
     */
    public MainDispatcher() {
        playerLastLocation = new HashMap<>();
        playerLastItemInHand = new HashMap<>();
        playerLastHelmet = new HashMap<>();
        playerLastChestplate = new HashMap<>();
        playerLastLeggings = new HashMap<>();
        playerLastBoots = new HashMap<>();
    }

    /**
     * Добавляет запись о добавлении игрока
     */
    public void sendAddPlayerData(AddPlayerData data) {
        MovingData movingData = new MovingData(data.getEntityId(), data.getX(), data.getY(), data.getZ(), data.getYaw(), data.getPitch());
        playerLastLocation.put(data.getEntityId(), movingData);
        VimeReplays.getRecordingManager().addRecordingData(data);
    }

    /**
     * Добавляет запись о движений игрока
     */
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

    /**
     * Добавляет запись о экипировке игрока
     * @param equipmentType тип экипировки
     * @param itemStack предмет экипировки
     */
    public void addItemData(Player player, EquipmentType equipmentType, ItemStack itemStack) {
        // Проверка, существует ли предмет
        if(itemStack == null) {
            itemStack = new ItemStack(Material.AIR);
        }

        // Получить id игрока и id предмета
        short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
        short itemId = (short) VimeReplays.getItemUtils().getItemId(itemStack);

        // Установить необходимый последний HashMap и ItemData для дальнейшей записи
        Map<Short, ItemData> lastDataMap = null;
        ItemData data = null;

        // Проверка, есть ли зачарования у игрока
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
            // Добавить запись о зачарованной экипировке
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
            // Добавить запись о экипировке
            addLastItemData(lastDataMap, data);
        }
    }

    /**
     * Добавляет запись о незачарованной экипировке игрока только если запись не повторяется
     */
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

    /**
     * Добавляет запись о зачарованной экипировке игрока только если запись не повторяется
     */
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
