package net.Abdymazhit.VimeReplays.playing;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.UUID;

public class NPCManager {

    public EntityPlayer create(String playerName, double x, double y, double z, float pitch, float yaw) {
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

        return npc;
    }

    public void teleport(EntityPlayer npc, double x, double y, double z, float pitch, float yaw) {
        PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport();
        setValue(packet, "a", npc.getId());
        setValue(packet, "b", getFixLocation(x));
        setValue(packet, "c", getFixLocation(y));
        setValue(packet, "d", getFixLocation(z));
        setValue(packet, "e", getFixRotation(yaw));
        setValue(packet, "f", getFixRotation(pitch));

        sendPacket(packet);
        headRotation(npc, yaw, pitch);
    }

    public void headRotation(EntityPlayer npc, float yaw, float pitch) {
        PacketPlayOutEntity.PacketPlayOutEntityLook packet = new PacketPlayOutEntity.PacketPlayOutEntityLook(npc.getId(), getFixRotation(yaw), getFixRotation(pitch) , true);
        PacketPlayOutEntityHeadRotation packetHead = new PacketPlayOutEntityHeadRotation();
        setValue(packetHead, "a", npc.getId());
        setValue(packetHead, "b", getFixRotation(yaw));
        setValue(packetHead, "c", getFixRotation(pitch));

        sendPacket(packet);
        sendPacket(packetHead);
    }

    public void armSwing(EntityPlayer npc) {
        PacketPlayOutAnimation packet = new PacketPlayOutAnimation();

        setValue(packet, "a", npc.getId());
        setValue(packet, "b", 0);

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
        for(Player player : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
        }
    }

    public int getFixLocation(double d) {
        return MathHelper.floor(d * 32.0D);
    }

    public byte getFixRotation(float f) {
        return (byte) ((int) (f * 256.0F / 360.0F));
    }
}
