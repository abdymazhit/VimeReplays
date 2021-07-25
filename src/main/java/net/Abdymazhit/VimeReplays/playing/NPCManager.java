package net.Abdymazhit.VimeReplays.playing;

import com.mojang.authlib.GameProfile;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.AnimationType;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.UUID;

public class NPCManager {

    public EntityPlayer create(String playerName, double x, double y, double z, float yaw, float pitch) {
        MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld) Bukkit.getWorld("replayMap")).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), playerName);

        EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile, new PlayerInteractManager(nmsWorld));
        Player npcPlayer = npc.getBukkitEntity().getPlayer();
        npcPlayer.setPlayerListName("");

        npc.setLocation(x, y, z, yaw, pitch);

        sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
        sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
        sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));

        setHeadRotation(npc, yaw, pitch);

        return npc;
    }

    public void teleport(EntityPlayer npc, double x, double y, double z, float yaw, float pitch) {
        PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport();
        setValue(packet, "a", npc.getId());
        setValue(packet, "b", VimeReplays.getLocationUtils().getFixLocation(x));
        setValue(packet, "c", VimeReplays.getLocationUtils().getFixLocation(y));
        setValue(packet, "d", VimeReplays.getLocationUtils().getFixLocation(z));
        setValue(packet, "e", VimeReplays.getLocationUtils().getFixRotation(yaw));
        setValue(packet, "f", VimeReplays.getLocationUtils().getFixRotation(pitch));

        sendPacket(packet);
        setHeadRotation(npc, yaw, pitch);
    }

    public void setHeadRotation(EntityPlayer npc, float yaw, float pitch) {
        PacketPlayOutEntity.PacketPlayOutEntityLook packet = new PacketPlayOutEntity.PacketPlayOutEntityLook(npc.getId(),
                VimeReplays.getLocationUtils().getFixRotation(yaw), VimeReplays.getLocationUtils().getFixRotation(pitch) , true);
        PacketPlayOutEntityHeadRotation packetHead = new PacketPlayOutEntityHeadRotation();
        setValue(packetHead, "a", npc.getId());
        setValue(packetHead, "b", VimeReplays.getLocationUtils().getFixRotation(yaw));
        setValue(packetHead, "c", VimeReplays.getLocationUtils().getFixRotation(pitch));

        sendPacket(packet);
        sendPacket(packetHead);
    }

    public void setAnimation(EntityPlayer npc, AnimationType animationType) {
        PacketPlayOutAnimation packet = new PacketPlayOutAnimation();
        setValue(packet, "a", npc.getId());

        if(animationType.equals(AnimationType.ARM_SWING)) {
            setValue(packet, "b", 0);
        } else if(animationType.equals(AnimationType.DAMAGE)) {
            setValue(packet, "b", 1);
        }

        sendPacket(packet);
    }

    public void setSneaking(EntityPlayer npc, boolean isSneaking) {
        DataWatcher dw = npc.getDataWatcher();
        if(isSneaking) {
            dw.watch(0, (byte) 0x02);
        } else {
            dw.watch(0, (byte) 0);
        }
        PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(npc.getId(), dw, true);
        sendPacket(packet);
    }

    public void setItemInHand(EntityPlayer npc, ItemStack itemStack) {
        PacketPlayOutEntityEquipment packet = new PacketPlayOutEntityEquipment();
        setValue(packet, "a", npc.getId());
        setValue(packet, "b", 0);
        setValue(packet, "c", itemStack);

        sendPacket(packet);
    }

    public void setValue(Object obj,String name,Object value) {
        try{
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(obj, value);
        } catch(Exception ignored) {

        }
    }

    public void sendPacket(Packet<?> packet) {
        ((CraftPlayer) VimeReplays.getPlayingManager().getPlayingTool().getPlayer()).getHandle().playerConnection.sendPacket(packet);
    }
}
