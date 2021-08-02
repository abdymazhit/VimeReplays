package net.Abdymazhit.VimeReplays.utils.storage;

import org.bukkit.enchantments.Enchantment;

import java.util.HashMap;
import java.util.Map;

/**
 * Отвечает за хранение id зачарований
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class EnchantmentUtils {

    /** Хранит id зачарований */
    private final Map<Enchantment, Byte> enchantments;

    /**
     * Добавляет зачарования с их id
     */
    public EnchantmentUtils() {
        enchantments = new HashMap<>();
        enchantments.put(Enchantment.ARROW_DAMAGE, (byte) 0);
        enchantments.put(Enchantment.ARROW_FIRE, (byte) 1);
        enchantments.put(Enchantment.ARROW_INFINITE, (byte) 2);
        enchantments.put(Enchantment.ARROW_KNOCKBACK, (byte) 3);
        enchantments.put(Enchantment.DAMAGE_ALL, (byte) 4);
        enchantments.put(Enchantment.DAMAGE_ARTHROPODS, (byte) 5);
        enchantments.put(Enchantment.DAMAGE_UNDEAD, (byte) 6);
        enchantments.put(Enchantment.DEPTH_STRIDER, (byte) 7);
        enchantments.put(Enchantment.DIG_SPEED, (byte) 8);
        enchantments.put(Enchantment.DURABILITY, (byte) 9);
        enchantments.put(Enchantment.FIRE_ASPECT, (byte) 10);
        enchantments.put(Enchantment.KNOCKBACK, (byte) 11);
        enchantments.put(Enchantment.LOOT_BONUS_BLOCKS, (byte) 12);
        enchantments.put(Enchantment.LOOT_BONUS_MOBS, (byte) 13);
        enchantments.put(Enchantment.LUCK, (byte) 14);
        enchantments.put(Enchantment.LURE, (byte) 15);
        enchantments.put(Enchantment.OXYGEN, (byte) 16);
        enchantments.put(Enchantment.PROTECTION_ENVIRONMENTAL, (byte) 17);
        enchantments.put(Enchantment.PROTECTION_EXPLOSIONS, (byte) 18);
        enchantments.put(Enchantment.PROTECTION_FALL, (byte) 19);
        enchantments.put(Enchantment.PROTECTION_FIRE, (byte) 20);
        enchantments.put(Enchantment.PROTECTION_PROJECTILE, (byte) 21);
        enchantments.put(Enchantment.SILK_TOUCH, (byte) 22);
        enchantments.put(Enchantment.THORNS, (byte) 23);
        enchantments.put(Enchantment.WATER_WORKER, (byte) 24);
    }

    /**
     * Возвращает id зачарования
     */
    public byte getId(Enchantment enchantment) {
        return enchantments.get(enchantment);
    }

    /**
     * Возвращает зачарование по id
     */
    public Enchantment getEnchantment(byte id) {
        for(Enchantment enchantment : enchantments.keySet()) {
            if(enchantments.get(enchantment).equals(id)) {
                return enchantment;
            }
        }
        return null;
    }
}
