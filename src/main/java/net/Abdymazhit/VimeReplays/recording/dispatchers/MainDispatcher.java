package net.Abdymazhit.VimeReplays.recording.dispatchers;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.enums.EquipmentType;
import net.Abdymazhit.VimeReplays.replay.data.customs.EnchantedItemData;
import net.Abdymazhit.VimeReplays.replay.data.customs.ItemData;
import net.Abdymazhit.VimeReplays.replay.data.entities.MovementData;
import net.Abdymazhit.VimeReplays.replay.data.entities.death.EntityDeathData;
import net.Abdymazhit.VimeReplays.replay.data.entities.spawn.ProjectileSpawnData;
import net.Abdymazhit.VimeReplays.replay.data.entities.spawn.PlayerSpawnData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.boots.BootsData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.boots.EnchantedBootsData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.chestplate.ChestplateData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.chestplate.EnchantedChestplateData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.helmet.EnchantedHelmetData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.helmet.HelmetData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.itemheld.EnchantedItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.itemheld.ItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.leggings.EnchantedLeggingsData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.leggings.LeggingsData;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Главный диспетчер, отвечает за запись повторяющихся данных
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class MainDispatcher {

    /** Хранит информацию о последнем id entity */
    private Short lastEntityId;

    /** Хранит информацию о id entity по entity id */
    private final Map<Integer, Short> entityIds;

    /** Хранит информацию о последнем местоположении entity */
    private final Map<Short, MovementData> entityLastLocation;

    /** Хранит информацию о последнем предмете в руке entity */
    private final Map<Short, ItemData> entityLastItemInHand;

    /** Хранит информацию о последнем шлеме entity */
    private final Map<Short, ItemData> entityLastHelmet;

    /** Хранит информацию о последнем нагруднике entity */
    private final Map<Short, ItemData> entityLastChestplate;

    /** Хранит информацию о последнем штане entity */
    private final Map<Short, ItemData> entityLastLeggings;

    /** Хранит информацию о последнем ботинке entity */
    private final Map<Short, ItemData> entityLastBoots;

    /**
     * Инициализирует главный диспетчер
     */
    public MainDispatcher() {
        lastEntityId = 0;
        entityIds = new HashMap<>();
        entityLastLocation = new HashMap<>();
        entityLastItemInHand = new HashMap<>();
        entityLastHelmet = new HashMap<>();
        entityLastChestplate = new HashMap<>();
        entityLastLeggings = new HashMap<>();
        entityLastBoots = new HashMap<>();
    }

    /**
     * Добавляет запись о спавне игрока
     */
    public void sendPlayerSpawnData(Player player) {
        String playerName = player.getName();
        short x = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getX());
        short y = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getY());
        short z = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getZ());
        short yaw = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getYaw());
        short pitch = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getPitch());

        if(entityIds.containsKey(player.getEntityId())) {
            short entityId = entityIds.get(player.getEntityId());

            MovementData movementData = new MovementData(entityId, x, y, z, yaw, pitch);
            entityLastLocation.put(entityId, movementData);

            PlayerSpawnData data = new PlayerSpawnData(entityId, x, y, z, yaw, pitch);
            VimeReplays.getRecordingManager().addRecordingData(data);
        } else {
            VimeReplays.getRecordingManager().getReplay().players.put(lastEntityId, playerName);

            entityIds.put(player.getEntityId(), lastEntityId);

            MovementData movementData = new MovementData(lastEntityId, x, y, z, yaw, pitch);
            entityLastLocation.put(lastEntityId, movementData);

            PlayerSpawnData data = new PlayerSpawnData(lastEntityId, x, y, z, yaw, pitch);
            VimeReplays.getRecordingManager().addRecordingData(data);

            lastEntityId++;
        }
    }

    /**
     * Добавляет запись о спавне метательных entity
     */
    public void sendProjectileSpawnData(Entity entity) {
        short x = VimeReplays.getLocationUtils().getLocationShort(entity.getLocation().getX());
        short y = VimeReplays.getLocationUtils().getLocationShort(entity.getLocation().getY());
        short z = VimeReplays.getLocationUtils().getLocationShort(entity.getLocation().getZ());
        short yaw = VimeReplays.getLocationUtils().getLocationShort(entity.getLocation().getYaw());
        short pitch = VimeReplays.getLocationUtils().getLocationShort(entity.getLocation().getPitch());

        if(entityIds.containsKey(entity.getEntityId())) {
            short entityId = entityIds.get(entity.getEntityId());

            MovementData movementData = new MovementData(entityId, x, y, z, yaw, pitch);
            entityLastLocation.put(entityId, movementData);

            ProjectileSpawnData data = new ProjectileSpawnData(VimeReplays.getEntityUtils().getEntityId(entity.getType()), entityId, x, y, z, yaw, pitch);
            VimeReplays.getRecordingManager().addRecordingData(data);
        } else {
            entityIds.put(entity.getEntityId(), lastEntityId);

            MovementData movementData = new MovementData(lastEntityId, x, y, z, yaw, pitch);
            entityLastLocation.put(lastEntityId, movementData);

            ProjectileSpawnData data = new ProjectileSpawnData(VimeReplays.getEntityUtils().getEntityId(entity.getType()), lastEntityId, x, y, z, yaw, pitch);
            VimeReplays.getRecordingManager().addRecordingData(data);

            lastEntityId++;
        }

        if(!VimeReplays.getRecordingManager().getRecordableEntities().contains(entity)) {
            VimeReplays.getRecordingManager().getRecordableEntities().add(entity);
        }
    }

    /**
     * Добавляет запись о движений entity
     */
    public void sendMovingData(Entity entity) {
        short playerId = entityIds.get(entity.getEntityId());

        short x = VimeReplays.getLocationUtils().getLocationShort(entity.getLocation().getX());
        short y = VimeReplays.getLocationUtils().getLocationShort(entity.getLocation().getY());
        short z = VimeReplays.getLocationUtils().getLocationShort(entity.getLocation().getZ());
        short yaw = VimeReplays.getLocationUtils().getLocationShort(entity.getLocation().getYaw());
        short pitch = VimeReplays.getLocationUtils().getLocationShort(entity.getLocation().getPitch());

        MovementData data = new MovementData(playerId, x, y, z, yaw, pitch);

        if(entityLastLocation.containsKey(data.getEntityId())) {
            MovementData lastMovementData = entityLastLocation.get(data.getEntityId());

            if(lastMovementData.getX() != data.getX() || lastMovementData.getY() != data.getY() || lastMovementData.getZ() != data.getZ()
                    || lastMovementData.getYaw() != data.getYaw() || lastMovementData.getPitch() != data.getPitch()) {
                entityLastLocation.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        } else {
            entityLastLocation.put(data.getEntityId(), data);
            VimeReplays.getRecordingManager().addRecordingData(data);
        }
    }

    /**
     * Добавляет запись о смерти entity
     */
    public void sendEntityDeathData(Entity entity) {
        short entityId = entityIds.get(entity.getEntityId());
        VimeReplays.getRecordingManager().addRecordingData(new EntityDeathData(entityId));
        entityLastLocation.remove(entityId);
        VimeReplays.getRecordingManager().getRecordableEntities().remove(entity);
    }

    /**
     * Добавляет запись о экипировке entity
     * @param equipmentType тип экипировки
     * @param itemStack предмет экипировки
     */
    public void addItemData(Entity entity, EquipmentType equipmentType, ItemStack itemStack) {
        // Проверка, существует ли предмет
        if(itemStack == null) {
            itemStack = new ItemStack(Material.AIR);
        }

        // Получить id entity и id предмета
        short playerId = entityIds.get(entity.getEntityId());
        short itemId = (short) VimeReplays.getItemUtils().getItemId(itemStack);

        // Установить необходимый последний HashMap и ItemData для дальнейшей записи
        Map<Short, ItemData> lastDataMap = null;
        ItemData data = null;

        // Проверка, есть ли зачарования у экипировки
        if(!itemStack.getEnchantments().isEmpty()) {
            if(equipmentType.equals(EquipmentType.HAND)) {
                lastDataMap = entityLastItemInHand;
                data = new EnchantedItemHeldData(playerId, itemId, itemStack.getEnchantments());
            } else if(equipmentType.equals(EquipmentType.HELMET)) {
                lastDataMap = entityLastHelmet;
                data = new EnchantedHelmetData(playerId, itemId, itemStack.getEnchantments());
            } else if(equipmentType.equals(EquipmentType.CHESTPLATE)) {
                lastDataMap = entityLastChestplate;
                data = new EnchantedChestplateData(playerId, itemId, itemStack.getEnchantments());
            } else if(equipmentType.equals(EquipmentType.LEGGINGS)) {
                lastDataMap = entityLastLeggings;
                data = new EnchantedLeggingsData(playerId, itemId, itemStack.getEnchantments());
            } else if(equipmentType.equals(EquipmentType.BOOTS)) {
                lastDataMap = entityLastBoots;
                data = new EnchantedBootsData(playerId, itemId, itemStack.getEnchantments());
            }
            // Добавить запись о зачарованной экипировке
            addLastEnchantedItemData(lastDataMap, (EnchantedItemData) data);
        } else {
            if(equipmentType.equals(EquipmentType.HAND)) {
                lastDataMap = entityLastItemInHand;
                data = new ItemHeldData(playerId, itemId);
            } else if(equipmentType.equals(EquipmentType.HELMET)) {
                lastDataMap = entityLastHelmet;
                data = new HelmetData(playerId, itemId);
            } else if(equipmentType.equals(EquipmentType.CHESTPLATE)) {
                lastDataMap = entityLastChestplate;
                data = new ChestplateData(playerId, itemId);
            } else if(equipmentType.equals(EquipmentType.LEGGINGS)) {
                lastDataMap = entityLastLeggings;
                data = new LeggingsData(playerId, itemId);
            } else if(equipmentType.equals(EquipmentType.BOOTS)) {
                lastDataMap = entityLastBoots;
                data = new BootsData(playerId, itemId);
            }
            // Добавить запись о экипировке
            addLastItemData(lastDataMap, data);
        }
    }

    /**
     * Добавляет запись о незачарованной экипировке entity только если запись не повторяется
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
     * Добавляет запись о зачарованной экипировке entity только если запись не повторяется
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

    /**
     * Возвращает id entity
     */
    public short getEntityId(Entity entity) {
        return entityIds.get(entity.getEntityId());
    }
}
