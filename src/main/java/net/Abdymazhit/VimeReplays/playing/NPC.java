package net.Abdymazhit.VimeReplays.playing;

import com.mojang.authlib.GameProfile;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.AnimationType;
import net.Abdymazhit.VimeReplays.customs.EquipmentType;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.util.CraftChatMessage;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

public class NPC {

    private final EntityPlayer npc;

    public NPC(String playerName, double x, double y, double z, float yaw, float pitch) {
        MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld) Bukkit.getWorld("replayMap")).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), playerName);

        npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile, new PlayerInteractManager(nmsWorld));
        Player npcPlayer = npc.getBukkitEntity().getPlayer();
        npcPlayer.setPlayerListName("");

        npc.setLocation(x, y, z, yaw, pitch);

        sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
        sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
        sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));

        addToTabList();

        setHeadRotation(yaw, pitch);
    }

    public void addToTabList() {
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();

        List<PacketPlayOutPlayerInfo.PlayerInfoData> players = (List<PacketPlayOutPlayerInfo.PlayerInfoData>) getValue(packet, "b");
        players.add(packet.new PlayerInfoData(npc.getProfile(), 1, WorldSettings.EnumGamemode.NOT_SET, CraftChatMessage.fromString(npc.getProfile().getName())[0]));

        setValue(packet, "a", PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER);
        setValue(packet, "b", players);

        sendPacket(packet);
    }

    public void removeFromTabList() {
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();

        List<PacketPlayOutPlayerInfo.PlayerInfoData> players = (List<PacketPlayOutPlayerInfo.PlayerInfoData>) getValue(packet, "b");
        players.add(packet.new PlayerInfoData(npc.getProfile(), 1, WorldSettings.EnumGamemode.NOT_SET, CraftChatMessage.fromString(npc.getProfile().getName())[0]));

        setValue(packet, "a", PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER);
        setValue(packet, "b", players);

        sendPacket(packet);
    }

    public void teleport(double x, double y, double z, float yaw, float pitch) {
        PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport();
        setValue(packet, "a", npc.getId());
        setValue(packet, "b", VimeReplays.getLocationUtils().getFixLocation(x));
        setValue(packet, "c", VimeReplays.getLocationUtils().getFixLocation(y));
        setValue(packet, "d", VimeReplays.getLocationUtils().getFixLocation(z));
        setValue(packet, "e", VimeReplays.getLocationUtils().getFixRotation(yaw));
        setValue(packet, "f", VimeReplays.getLocationUtils().getFixRotation(pitch));

        sendPacket(packet);
        setHeadRotation(yaw, pitch);
    }

    public void setHeadRotation(float yaw, float pitch) {
        PacketPlayOutEntity.PacketPlayOutEntityLook packet = new PacketPlayOutEntity.PacketPlayOutEntityLook(npc.getId(),
                VimeReplays.getLocationUtils().getFixRotation(yaw), VimeReplays.getLocationUtils().getFixRotation(pitch) , true);
        PacketPlayOutEntityHeadRotation packetHead = new PacketPlayOutEntityHeadRotation();
        setValue(packetHead, "a", npc.getId());
        setValue(packetHead, "b", VimeReplays.getLocationUtils().getFixRotation(yaw));
        setValue(packetHead, "c", VimeReplays.getLocationUtils().getFixRotation(pitch));

        sendPacket(packet);
        sendPacket(packetHead);
    }

    public void setAnimation(AnimationType animationType) {
        PacketPlayOutAnimation packet = new PacketPlayOutAnimation();
        setValue(packet, "a", npc.getId());

        if(animationType.equals(AnimationType.ARM_SWING)) {
            setValue(packet, "b", 0);
        } else if(animationType.equals(AnimationType.DAMAGE)) {
            setValue(packet, "b", 1);
        }

        sendPacket(packet);
    }

    public void setSneaking(boolean isSneaking) {
        DataWatcher dw = npc.getDataWatcher();
        if(isSneaking) {
            dw.watch(0, (byte) 0x02);
        } else {
            dw.watch(0, (byte) 0);
        }
        PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(npc.getId(), dw, true);
        sendPacket(packet);
    }

    public void setEquipment(EquipmentType equipmentType, ItemStack itemStack) {
        PacketPlayOutEntityEquipment packet = new PacketPlayOutEntityEquipment();
        setValue(packet, "a", npc.getId());
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

    public void setValue(Object obj, String name, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(obj, value);
        } catch(Exception ignored) {

        }
    }

    public Object getValue(Object obj, String name) {
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field.get(obj);
        } catch(Exception ignored) {

        }
        return null;
    }

    public void sendPacket(Packet<?> packet) {
        ((CraftPlayer) VimeReplays.getPlayingManager().getPlayingHandler().getPlayer()).getHandle().playerConnection.sendPacket(packet);
    }
}
