package net.Abdymazhit.VimeReplays.playing;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.AnimationType;
import net.Abdymazhit.VimeReplays.replay.data.*;
import net.minecraft.server.v1_8_R3.EntityPlayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayingHandler {

    private final NPCManager npcManager;
    private final Map<Short, EntityPlayer> npcMap;

    public PlayingHandler() {
        npcManager = new NPCManager();
        npcMap = new HashMap<>();
    }

    public void performAction(List<RecordingData> tickRecords) {
        for(RecordingData recordingData : tickRecords) {
            if(recordingData instanceof MovingData) {
                MovingData data = (MovingData) recordingData;

                EntityPlayer npc = npcMap.get(data.getEntityId());
                double x = VimeReplays.getLocationUtils().getLocationDouble(data.getX());
                double y = VimeReplays.getLocationUtils().getLocationDouble(data.getY());
                double z = VimeReplays.getLocationUtils().getLocationDouble(data.getZ());
                float yaw = VimeReplays.getLocationUtils().getLocationFloat(data.getYaw());
                float pitch = VimeReplays.getLocationUtils().getLocationFloat(data.getPitch());

                npcManager.teleport(npc, x, y, z, yaw, pitch);
            } else if(recordingData instanceof SneakingData) {
                SneakingData data = (SneakingData) recordingData;

                EntityPlayer npc = npcMap.get(data.getEntityId());
                npcManager.setSneaking(npc, true);
            } else if(recordingData instanceof UnsneakingData) {
                UnsneakingData data = (UnsneakingData) recordingData;

                EntityPlayer npc = npcMap.get(data.getEntityId());
                npcManager.setSneaking(npc, false);
            } else if(recordingData instanceof ItemHeldData) {
                ItemHeldData data = (ItemHeldData) recordingData;

            } else if(recordingData instanceof BlockPlaceData) {
                BlockPlaceData data = (BlockPlaceData) recordingData;

            } else if(recordingData instanceof BlockBreakData) {
                BlockBreakData data = (BlockBreakData) recordingData;

            } else if(recordingData instanceof ArmSwingData) {
                ArmSwingData data = (ArmSwingData) recordingData;

                EntityPlayer npc = npcMap.get(data.getEntityId());
                npcManager.setAnimation(npc, AnimationType.ARM_SWING);
            } else if(recordingData instanceof AddPlayerData) {
                AddPlayerData data = (AddPlayerData) recordingData;
                if(!npcMap.containsKey(data.getEntityId())) {
                    double x = VimeReplays.getLocationUtils().getLocationDouble(data.getX());
                    double y = VimeReplays.getLocationUtils().getLocationDouble(data.getY());
                    double z = VimeReplays.getLocationUtils().getLocationDouble(data.getZ());
                    float yaw = VimeReplays.getLocationUtils().getLocationFloat(data.getYaw());
                    float pitch = VimeReplays.getLocationUtils().getLocationFloat(data.getPitch());

                    EntityPlayer entityPlayer = npcManager.create(getPlayerName(data.getEntityId()), x, y, z, yaw, pitch);

                    npcMap.put(data.getEntityId(), entityPlayer);
                } else {
                    EntityPlayer npc = npcMap.get(data.getEntityId());
                    double x = VimeReplays.getLocationUtils().getLocationDouble(data.getX());
                    double y = VimeReplays.getLocationUtils().getLocationDouble(data.getY());
                    double z = VimeReplays.getLocationUtils().getLocationDouble(data.getZ());
                    float yaw = VimeReplays.getLocationUtils().getLocationFloat(data.getYaw());
                    float pitch = VimeReplays.getLocationUtils().getLocationFloat(data.getPitch());

                    npcManager.teleport(npc, x, y, z, yaw, pitch);
                }
            } else if(recordingData instanceof RemovePlayerData) {
                RemovePlayerData data = (RemovePlayerData) recordingData;

            } else if(recordingData instanceof DamageData) {
                DamageData data = (DamageData) recordingData;

                EntityPlayer npc = npcMap.get(data.getEntityId());
                npcManager.setAnimation(npc, AnimationType.DAMAGE);
            }
        }
    }

    private String getPlayerName(int id) {
        return VimeReplays.getPlayingManager().getReplay().players.get(id);
    }
}
