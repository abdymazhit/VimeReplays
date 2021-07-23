package net.Abdymazhit.VimeReplays.playing;

import net.Abdymazhit.VimeReplays.replay.data.*;

import java.util.List;

public class PlayingHandler {

    public void performAction(List<RecordingData> tickRecords) {
        for(RecordingData recordingData : tickRecords) {
            if(recordingData instanceof MovingData) {
                MovingData data = (MovingData) recordingData;

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

            } else if(recordingData instanceof AddPlayerData) {
                AddPlayerData data = (AddPlayerData) recordingData;

            } else if(recordingData instanceof RemovePlayerData) {
                RemovePlayerData data = (RemovePlayerData) recordingData;

            }
        }
    }
}
