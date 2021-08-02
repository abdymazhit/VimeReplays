package net.Abdymazhit.VimeReplays.playing.nms;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.enums.AnimationType;
import net.Abdymazhit.VimeReplays.enums.EquipmentType;
import net.minecraft.server.v1_8_R3.*;

/**
 * Отвечает за за работу entity
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class NMSEntity extends Reflections {

    /** NMS entity */
    public Entity entity;

    /**
     * Телепортирует entity в местоположение
     */
    public void teleport(double x, double y, double z, float yaw, float pitch) {
        PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport();
        setValue(packet, "a", entity.getId());
        setValue(packet, "b", VimeReplays.getLocationUtils().getFixLocation(x));
        setValue(packet, "c", VimeReplays.getLocationUtils().getFixLocation(y));
        setValue(packet, "d", VimeReplays.getLocationUtils().getFixLocation(z));
        setValue(packet, "e", VimeReplays.getLocationUtils().getFixRotation(yaw));
        setValue(packet, "f", VimeReplays.getLocationUtils().getFixRotation(pitch));

        sendPacket(packet);
        setHeadRotation(yaw, pitch);
    }

    /**
     * Устанавливает положие головы для entity
     */
    public void setHeadRotation(float yaw, float pitch) {
        PacketPlayOutEntity.PacketPlayOutEntityLook packet = new PacketPlayOutEntity.PacketPlayOutEntityLook(entity.getId(),
                VimeReplays.getLocationUtils().getFixRotation(yaw), VimeReplays.getLocationUtils().getFixRotation(pitch) , true);
        PacketPlayOutEntityHeadRotation packetHead = new PacketPlayOutEntityHeadRotation();
        setValue(packetHead, "a", entity.getId());
        setValue(packetHead, "b", VimeReplays.getLocationUtils().getFixRotation(yaw));

        sendPacket(packet);
        sendPacket(packetHead);
    }

    /**
     * Устанавливает экипировку для entity
     * @param equipmentType тип экипировки
     * @param itemStack предмет экипировки
     */
    public void setEquipment(EquipmentType equipmentType, ItemStack itemStack) {
        PacketPlayOutEntityEquipment packet = new PacketPlayOutEntityEquipment();
        setValue(packet, "a", entity.getId());
        if(equipmentType.equals(EquipmentType.HAND)) {
            setValue(packet, "b", 0);
        } else if(equipmentType.equals(EquipmentType.HELMET)) {
            setValue(packet, "b", 4);
        } else if(equipmentType.equals(EquipmentType.CHESTPLATE)) {
            setValue(packet, "b", 3);
        } else if(equipmentType.equals(EquipmentType.LEGGINGS)) {
            setValue(packet, "b", 2);
        } else if(equipmentType.equals(EquipmentType.BOOTS)) {
            setValue(packet, "b", 1);
        }
        setValue(packet, "c", itemStack);
        sendPacket(packet);
    }

    /**
     * Устанавливает анимацию для entity
     * @param animationType тип анимации
     */
    public void setAnimation(AnimationType animationType) {
        PacketPlayOutAnimation packet = new PacketPlayOutAnimation();
        setValue(packet, "a", entity.getId());

        if(animationType.equals(AnimationType.ARM_SWING)) {
            setValue(packet, "b", 0);
        } else if(animationType.equals(AnimationType.DAMAGE)) {
            setValue(packet, "b", 1);
        }

        sendPacket(packet);
    }

    /**
     * Удаляет entity
     */
    public void destroy() {
        PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(entity.getId());
        sendPacket(packet);
    }
}
