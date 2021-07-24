package net.Abdymazhit.VimeReplays.playing;

import net.Abdymazhit.VimeReplays.VimeReplays;
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
                double x = data.getX();
                double y = data.getY();
                double z = data.getZ();
                float pitchRadian = data.getPitch();
                float yawRadian = data.getYaw();

                float pitch = (float) Math.toDegrees(pitchRadian / 160);
                float yaw = (float) Math.toDegrees(yawRadian / 160);

                npcManager.teleport(npc, x / 100, y / 100, z / 100, pitch, yaw);
            } else if(recordingData instanceof SneakingData) {
                SneakingData data = (SneakingData) recordingData;

            } else if(recordingData instanceof UnsneakingData) {
                UnsneakingData data = (UnsneakingData) recordingData;

            } else if(recordingData instanceof ItemHeldData) {
                ItemHeldData data = (ItemHeldData) recordingData;

            } else if(recordingData instanceof BlockPlaceData) {
                BlockPlaceData data = (BlockPlaceData) recordingData;

            } else if(recordingData instanceof BlockBreakData) {
                BlockBreakData data = (BlockBreakData) recordingData;

            } else if(recordingData instanceof ArmSwingData) {
                ArmSwingData data = (ArmSwingData) recordingData;

                EntityPlayer npc = npcMap.get(data.getEntityId());
                npcManager.armSwing(npc);
            } else if(recordingData instanceof AddPlayerData) {
                AddPlayerData data = (AddPlayerData) recordingData;
                if(!npcMap.containsKey(data.getEntityId())) {
                    double x = data.getX();
                    double y = data.getY();
                    double z = data.getZ();
                    float pitchRadian = data.getPitch();
                    float yawRadian = data.getYaw();

                    float pitch = (float) Math.toDegrees(pitchRadian / 160);
                    float yaw = (float) Math.toDegrees(yawRadian / 160);

                    EntityPlayer entityPlayer = npcManager.create(getPlayerName(data.getEntityId()), x / 100, y / 100, z / 100, pitch, yaw);

                    npcMap.put(data.getEntityId(), entityPlayer);
                }
            } else if(recordingData instanceof RemovePlayerData) {
                RemovePlayerData data = (RemovePlayerData) recordingData;

            }
        }
    }

    private String getPlayerName(int id) {
        return VimeReplays.getPlayingManager().getReplay().players.get(id);
    }
}
