package net.Abdymazhit.VimeReplays.recording.dispatchers;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.ItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.MovingData;

import java.util.HashMap;
import java.util.Map;

public class MainDispatcher {

    private final Map<Short, MovingData> playerLastLocation;
    private final Map<Short, Short> playerLastItemId;

    public MainDispatcher() {
        playerLastLocation = new HashMap<>();
        playerLastItemId = new HashMap<>();
    }

    public void sendMovingData(MovingData movingData) {
        if(playerLastLocation.containsKey(movingData.getEntityId())) {
            MovingData lastMovingData = playerLastLocation.get(movingData.getEntityId());

            if(lastMovingData.getX() != movingData.getX() || lastMovingData.getY() != movingData.getY() || lastMovingData.getZ() != movingData.getZ()
                    || lastMovingData.getYaw() != movingData.getYaw() || lastMovingData.getPitch() != movingData.getPitch()) {
                playerLastLocation.put(movingData.getEntityId(), movingData);
                VimeReplays.getRecordingManager().addRecordingData(movingData);
            }
        } else {
            playerLastLocation.put(movingData.getEntityId(), movingData);
            VimeReplays.getRecordingManager().addRecordingData(movingData);
        }
    }

    public void sendItemHeldData(ItemHeldData itemHeldData) {
        if(playerLastItemId.containsKey(itemHeldData.getEntityId())) {
            short lastItemId = playerLastItemId.get(itemHeldData.getEntityId());

            if(lastItemId != itemHeldData.getItemId()) {
                playerLastItemId.put(itemHeldData.getEntityId(), itemHeldData.getItemId());
                VimeReplays.getRecordingManager().addRecordingData(itemHeldData);
            }
        } else {
            playerLastItemId.put(itemHeldData.getEntityId(), itemHeldData.getItemId());
            VimeReplays.getRecordingManager().addRecordingData(itemHeldData);
        }
    }
}
