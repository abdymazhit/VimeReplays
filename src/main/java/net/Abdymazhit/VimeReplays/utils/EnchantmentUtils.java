package net.Abdymazhit.VimeReplays.utils;

import org.bukkit.enchantments.Enchantment;

public class EnchantmentUtils {

    public byte getEnchantmentId(Enchantment enchantment) {
        if(enchantment.equals(Enchantment.ARROW_DAMAGE)) {
            return 0;
        } else if(enchantment.equals(Enchantment.ARROW_FIRE)) {
            return 1;
        } else if(enchantment.equals(Enchantment.ARROW_INFINITE)) {
            return 2;
        } else if(enchantment.equals(Enchantment.ARROW_KNOCKBACK)) {
            return 3;
        } else if(enchantment.equals(Enchantment.DAMAGE_ALL)) {
            return 4;
        } else if(enchantment.equals(Enchantment.DAMAGE_ARTHROPODS)) {
            return 5;
        } else if(enchantment.equals(Enchantment.DAMAGE_UNDEAD)) {
            return 6;
        } else if(enchantment.equals(Enchantment.DEPTH_STRIDER)) {
            return 7;
        } else if(enchantment.equals(Enchantment.DIG_SPEED)) {
            return 8;
        } else if(enchantment.equals(Enchantment.DURABILITY)) {
            return 9;
        } else if(enchantment.equals(Enchantment.FIRE_ASPECT)) {
            return 10;
        } else if(enchantment.equals(Enchantment.KNOCKBACK)) {
            return 11;
        } else if(enchantment.equals(Enchantment.LOOT_BONUS_BLOCKS)) {
            return 12;
        } else if(enchantment.equals(Enchantment.LOOT_BONUS_MOBS)) {
            return 13;
        } else if(enchantment.equals(Enchantment.LUCK)) {
            return 14;
        } else if(enchantment.equals(Enchantment.LURE)) {
            return 15;
        } else if(enchantment.equals(Enchantment.OXYGEN)) {
            return 16;
        } else if(enchantment.equals(Enchantment.PROTECTION_ENVIRONMENTAL)) {
            return 17;
        } else if(enchantment.equals(Enchantment.PROTECTION_EXPLOSIONS)) {
            return 18;
        } else if(enchantment.equals(Enchantment.PROTECTION_FALL)) {
            return 19;
        } else if(enchantment.equals(Enchantment.PROTECTION_FIRE)) {
            return 20;
        } else if(enchantment.equals(Enchantment.PROTECTION_PROJECTILE)) {
            return 21;
        } else if(enchantment.equals(Enchantment.SILK_TOUCH)) {
            return 22;
        } else if(enchantment.equals(Enchantment.THORNS)) {
            return 23;
        } else if(enchantment.equals(Enchantment.WATER_WORKER)) {
            return 24;
        } else {
            return -1;
        }
    }

    public Enchantment getEnchantment(byte enchantmentId) {
        if(enchantmentId == 0) {
            return Enchantment.ARROW_DAMAGE;
        } else if(enchantmentId == 1) {
            return Enchantment.ARROW_FIRE;
        } else if(enchantmentId == 2) {
            return Enchantment.ARROW_INFINITE;
        } else if(enchantmentId == 3) {
            return Enchantment.ARROW_KNOCKBACK;
        } else if(enchantmentId == 4) {
            return Enchantment.DAMAGE_ALL;
        } else if(enchantmentId == 5) {
            return Enchantment.DAMAGE_ARTHROPODS;
        } else if(enchantmentId == 6) {
            return Enchantment.DAMAGE_UNDEAD;
        } else if(enchantmentId == 7) {
            return Enchantment.DEPTH_STRIDER;
        } else if(enchantmentId == 8) {
            return Enchantment.DIG_SPEED;
        } else if(enchantmentId == 9) {
            return Enchantment.DURABILITY;
        } else if(enchantmentId == 10) {
            return Enchantment.FIRE_ASPECT;
        } else if(enchantmentId == 11) {
            return Enchantment.KNOCKBACK;
        } else if(enchantmentId == 12) {
            return Enchantment.LOOT_BONUS_BLOCKS;
        } else if(enchantmentId == 13) {
            return Enchantment.LOOT_BONUS_MOBS;
        } else if(enchantmentId == 14) {
            return Enchantment.LUCK;
        } else if(enchantmentId == 15) {
            return Enchantment.LURE;
        } else if(enchantmentId == 16) {
            return Enchantment.OXYGEN;
        } else if(enchantmentId == 17) {
            return Enchantment.PROTECTION_ENVIRONMENTAL;
        } else if(enchantmentId == 18) {
            return Enchantment.PROTECTION_EXPLOSIONS;
        } else if(enchantmentId == 19) {
            return Enchantment.PROTECTION_FALL;
        } else if(enchantmentId == 20) {
            return Enchantment.PROTECTION_FIRE;
        } else if(enchantmentId == 21) {
            return Enchantment.PROTECTION_PROJECTILE;
        } else if(enchantmentId == 22) {
            return Enchantment.SILK_TOUCH;
        } else if(enchantmentId == 23) {
            return Enchantment.THORNS;
        } else if(enchantmentId == 24) {
            return Enchantment.WATER_WORKER;
        } else {
            return null;
        }
    }
}
