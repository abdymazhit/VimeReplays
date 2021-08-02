package net.Abdymazhit.VimeReplays.playing.nms;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.util.CraftChatMessage;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

/**
 * Отвечает за работу NPC
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class NMSPlayer extends NMSEntity {

    /**
     * Инициализирует NPC и добавляет в мир
     */
    public NMSPlayer(String npcName, double x, double y, double z, float yaw, float pitch) {
        MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld) Bukkit.getWorld("replayMap")).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), npcName);

        entity = new EntityPlayer(nmsServer, nmsWorld, gameProfile, new PlayerInteractManager(nmsWorld));
        Player npcPlayer = ((EntityPlayer) entity).getBukkitEntity().getPlayer();
        npcPlayer.setPlayerListName("");

        entity.setLocation(x, y, z, yaw, pitch);

        sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, ((EntityPlayer) entity)));
        sendPacket(new PacketPlayOutNamedEntitySpawn(((EntityPlayer) entity)));
        sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, ((EntityPlayer) entity)));

        addToTabList();
        setHeadRotation(yaw, pitch);
    }

    /**
     * Добавляет NPC в таб
     */
    public void addToTabList() {
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();

        List<PacketPlayOutPlayerInfo.PlayerInfoData> players = (List<PacketPlayOutPlayerInfo.PlayerInfoData>) getValue(packet, "b");
        players.add(packet.new PlayerInfoData(((EntityPlayer) entity).getProfile(), 1, WorldSettings.EnumGamemode.NOT_SET, CraftChatMessage.fromString(((EntityPlayer) entity).getProfile().getName())[0]));

        setValue(packet, "a", PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER);
        setValue(packet, "b", players);

        sendPacket(packet);
    }

    /**
     * Удаляет NPC с таба
     */
    public void removeFromTabList() {
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();

        List<PacketPlayOutPlayerInfo.PlayerInfoData> players = (List<PacketPlayOutPlayerInfo.PlayerInfoData>) getValue(packet, "b");
        players.add(packet.new PlayerInfoData(((EntityPlayer) entity).getProfile(), 1, WorldSettings.EnumGamemode.NOT_SET, CraftChatMessage.fromString(((EntityPlayer) entity).getProfile().getName())[0]));

        setValue(packet, "a", PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER);
        setValue(packet, "b", players);

        sendPacket(packet);
    }

    /**
     * Устанавливает анимацию, крадется ли NPC
     */
    public void setSneaking(boolean isSneaking) {
        DataWatcher dw = entity.getDataWatcher();
        if(isSneaking) {
            dw.watch(0, (byte) 0x02);
        } else {
            dw.watch(0, (byte) 0);
        }
        PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(entity.getId(), dw, true);
        sendPacket(packet);
    }
}
