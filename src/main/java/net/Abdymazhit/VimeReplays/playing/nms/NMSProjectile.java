package net.Abdymazhit.VimeReplays.playing.nms;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.EntityType;

/**
 * Отвечает за работу с метательными entity
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class NMSProjectile extends NMSEntity {

    /**
     * Инициализирует метательного entity и добавляет в мир
     */
    public NMSProjectile(EntityType entityType, double x, double y, double z, float yaw, float pitch) {
        entity = getNMSEntity(entityType);
        if(entity != null) {
            entity.setLocation(x, y, z, yaw, pitch);
            PacketPlayOutSpawnEntity packet = new PacketPlayOutSpawnEntity(entity, getNMSEntitySpawnId(entityType));
            sendPacket(packet);
        }
    }

    /**
     * Возвращает NMS метательного entity
     */
    private Entity getNMSEntity(EntityType entityType) {
        WorldServer worldServer = ((CraftWorld) Bukkit.getWorld("replayMap")).getHandle();
        if(entityType.equals(EntityType.ARROW)) {
            return new EntityArrow(worldServer);
        } else if(entityType.equals(EntityType.EGG)) {
            return new EntityEgg(worldServer);
        } else if(entityType.equals(EntityType.ENDER_PEARL)) {
            return new EntityEnderPearl(worldServer);
        } else if(entityType.equals(EntityType.FIREBALL)) {
            return new EntityLargeFireball(worldServer);
        } else if(entityType.equals(EntityType.FISHING_HOOK)) {
            return new EntityFishingHook(worldServer);
        } else if(entityType.equals(EntityType.SMALL_FIREBALL)) {
            return new EntitySmallFireball(worldServer);
        } else if(entityType.equals(EntityType.SNOWBALL)) {
            return new EntitySnowball(worldServer);
        } else if(entityType.equals(EntityType.THROWN_EXP_BOTTLE)) {
            return new EntityThrownExpBottle(worldServer);
        } else if(entityType.equals(EntityType.SPLASH_POTION)) {
            return new EntityPotion(worldServer);
        } else if(entityType.equals(EntityType.WITHER_SKULL)) {
            return new EntityWitherSkull(worldServer);
        } else {
            return null;
        }
    }

    /**
     * Возвращает id спавна метательного entity
     */
    private int getNMSEntitySpawnId(EntityType entityType) {
        if(entityType.equals(EntityType.ARROW)) {
            return 60;
        } else if(entityType.equals(EntityType.EGG)) {
            return 62;
        } else if(entityType.equals(EntityType.ENDER_PEARL)) {
            return 65;
        } else if(entityType.equals(EntityType.FIREBALL)) {
            return 63;
        } else if(entityType.equals(EntityType.FISHING_HOOK)) {
            return 90;
        } else if(entityType.equals(EntityType.SMALL_FIREBALL)) {
            return 64;
        } else if(entityType.equals(EntityType.SNOWBALL)) {
            return 61;
        } else if(entityType.equals(EntityType.THROWN_EXP_BOTTLE)) {
            return 75;
        } else if(entityType.equals(EntityType.SPLASH_POTION)) {
            return 73;
        } else if(entityType.equals(EntityType.WITHER_SKULL)) {
            return 66;
        } else {
            return 0;
        }
    }
}
