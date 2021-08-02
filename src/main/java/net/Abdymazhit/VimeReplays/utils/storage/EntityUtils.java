package net.Abdymazhit.VimeReplays.utils.storage;

import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

/**
 * Отвечает за хранение id entity
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class EntityUtils {

    /** Хранит id entity */
    private final Map<EntityType, Byte> entities;

    /**
     * Добавляет entity с их id
     */
    public EntityUtils() {
        entities = new HashMap<>();
        entities.put(EntityType.DROPPED_ITEM, (byte) 0);
        entities.put(EntityType.EXPERIENCE_ORB, (byte) 1);
        entities.put(EntityType.LEASH_HITCH, (byte) 2);
        entities.put(EntityType.PAINTING, (byte) 3);
        entities.put(EntityType.ARROW, (byte) 4);
        entities.put(EntityType.SNOWBALL, (byte) 5);
        entities.put(EntityType.FIREBALL, (byte) 6);
        entities.put(EntityType.SMALL_FIREBALL, (byte) 7);
        entities.put(EntityType.ENDER_PEARL, (byte) 8);
        entities.put(EntityType.ENDER_SIGNAL, (byte) 9);
        entities.put(EntityType.THROWN_EXP_BOTTLE, (byte) 10);
        entities.put(EntityType.ITEM_FRAME, (byte) 11);
        entities.put(EntityType.WITHER_SKULL, (byte) 12);
        entities.put(EntityType.PRIMED_TNT, (byte) 13);
        entities.put(EntityType.FALLING_BLOCK, (byte) 14);
        entities.put(EntityType.FIREWORK, (byte) 15);
        entities.put(EntityType.ARMOR_STAND, (byte) 16);
        entities.put(EntityType.MINECART_COMMAND, (byte) 17);
        entities.put(EntityType.BOAT, (byte) 18);
        entities.put(EntityType.MINECART, (byte) 19);
        entities.put(EntityType.MINECART_CHEST, (byte) 20);
        entities.put(EntityType.MINECART_FURNACE, (byte) 21);
        entities.put(EntityType.MINECART_TNT, (byte) 22);
        entities.put(EntityType.MINECART_HOPPER, (byte) 23);
        entities.put(EntityType.MINECART_MOB_SPAWNER, (byte) 24);
        entities.put(EntityType.CREEPER, (byte) 25);
        entities.put(EntityType.SKELETON, (byte) 26);
        entities.put(EntityType.SPIDER, (byte) 27);
        entities.put(EntityType.GIANT, (byte) 28);
        entities.put(EntityType.ZOMBIE, (byte) 29);
        entities.put(EntityType.SLIME, (byte) 30);
        entities.put(EntityType.GHAST, (byte) 31);
        entities.put(EntityType.PIG_ZOMBIE, (byte) 32);
        entities.put(EntityType.ENDERMAN, (byte) 33);
        entities.put(EntityType.CAVE_SPIDER, (byte) 34);
        entities.put(EntityType.SILVERFISH, (byte) 35);
        entities.put(EntityType.BLAZE, (byte) 36);
        entities.put(EntityType.MAGMA_CUBE, (byte) 37);
        entities.put(EntityType.ENDER_DRAGON, (byte) 38);
        entities.put(EntityType.WITHER, (byte) 39);
        entities.put(EntityType.BAT, (byte) 40);
        entities.put(EntityType.WITCH, (byte) 41);
        entities.put(EntityType.ENDERMITE, (byte) 42);
        entities.put(EntityType.GUARDIAN, (byte) 43);
        entities.put(EntityType.PIG, (byte) 44);
        entities.put(EntityType.SHEEP, (byte) 45);
        entities.put(EntityType.COW, (byte) 46);
        entities.put(EntityType.CHICKEN, (byte) 47);
        entities.put(EntityType.SQUID, (byte) 48);
        entities.put(EntityType.WOLF, (byte) 49);
        entities.put(EntityType.MUSHROOM_COW, (byte) 50);
        entities.put(EntityType.SNOWMAN, (byte) 51);
        entities.put(EntityType.OCELOT, (byte) 52);
        entities.put(EntityType.IRON_GOLEM, (byte) 53);
        entities.put(EntityType.HORSE, (byte) 54);
        entities.put(EntityType.RABBIT, (byte) 55);
        entities.put(EntityType.VILLAGER, (byte) 56);
        entities.put(EntityType.ENDER_CRYSTAL, (byte) 57);
        entities.put(EntityType.SPLASH_POTION, (byte) 58);
        entities.put(EntityType.EGG, (byte) 59);
        entities.put(EntityType.FISHING_HOOK, (byte) 60);
        entities.put(EntityType.LIGHTNING, (byte) 61);
        entities.put(EntityType.WEATHER, (byte) 62);
        entities.put(EntityType.PLAYER, (byte) 63);
        entities.put(EntityType.COMPLEX_PART, (byte) 64);
        entities.put(EntityType.UNKNOWN, (byte) 65);
    }

    /**
     * Возвращает id entity
     */
    public byte getEntityId(EntityType entityType) {
        return entities.get(entityType);
    }

    /**
     * Возвращает тип entity по id
     */
    public EntityType getEntityType(byte id) {
        for(EntityType entityType : entities.keySet()) {
            if(entities.get(entityType).equals(id)) {
                return entityType;
            }
        }
        return null;
    }
}
