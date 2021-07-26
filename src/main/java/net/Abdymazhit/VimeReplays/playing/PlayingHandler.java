package net.Abdymazhit.VimeReplays.playing;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayingHandler {

    private final Map<Short, NPC> npcList;

    public PlayingHandler() {
        npcList = new HashMap<>();
    }

    public void performAction(List<RecordingData> tickRecords) {
        for(RecordingData recordingData : tickRecords) {
            if(recordingData instanceof AddPlayerData) {
                AddPlayerData data = (AddPlayerData) recordingData;
                data.performAction();
            } else if(recordingData instanceof RemovePlayerData) {
                RemovePlayerData data = (RemovePlayerData) recordingData;
//                data.performAction();
            } else if(recordingData instanceof MovingData) {
                MovingData data = (MovingData) recordingData;
                data.performAction();
            } else if(recordingData instanceof ArmSwingData) {
                ArmSwingData data = (ArmSwingData) recordingData;
                data.performAction();
            } else if(recordingData instanceof DamageData) {
                DamageData data = (DamageData) recordingData;
                data.performAction();
            } else if(recordingData instanceof SneakingData) {
                SneakingData data = (SneakingData) recordingData;
                data.performAction();
            } else if(recordingData instanceof UnsneakingData) {
                UnsneakingData data = (UnsneakingData) recordingData;
                data.performAction();
            } else if(recordingData instanceof BlockBreakData) {
                BlockBreakData data = (BlockBreakData) recordingData;
//                data.performAction();
            } else if(recordingData instanceof BlockPlaceData) {
                BlockPlaceData data = (BlockPlaceData) recordingData;
//                data.performAction();
            } else if(recordingData instanceof EnchantedItemHeldData) {
                EnchantedItemHeldData data = (EnchantedItemHeldData) recordingData;
                data.performAction();
            } else if(recordingData instanceof ItemHeldData) {
                ItemHeldData data = (ItemHeldData) recordingData;
                data.performAction();
            } else if(recordingData instanceof EnchantedHelmetData) {
                EnchantedHelmetData data = (EnchantedHelmetData) recordingData;
                data.performAction();
            } else if(recordingData instanceof HelmetData) {
                HelmetData data = (HelmetData) recordingData;
                data.performAction();
            } else if(recordingData instanceof EnchantedChestplateData) {
                EnchantedChestplateData data = (EnchantedChestplateData) recordingData;
                data.performAction();
            } else if(recordingData instanceof ChestplateData) {
                ChestplateData data = (ChestplateData) recordingData;
                data.performAction();
            } else if(recordingData instanceof EnchantedLeggingsData) {
                EnchantedLeggingsData data = (EnchantedLeggingsData) recordingData;
                data.performAction();
            } else if(recordingData instanceof LeggingsData) {
                LeggingsData data = (LeggingsData) recordingData;
                data.performAction();
            } else if(recordingData instanceof EnchantedBootsData) {
                EnchantedBootsData data = (EnchantedBootsData) recordingData;
                data.performAction();
            } else if(recordingData instanceof BootsData) {
                BootsData data = (BootsData) recordingData;
                data.performAction();
            }
        }
    }

    public String getPlayerName(int id) {
        return VimeReplays.getPlayingManager().getReplay().players.get(id);
    }

    public Map<Short, NPC> getNPCList() {
        return npcList;
    }
}
