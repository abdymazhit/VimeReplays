package net.Abdymazhit.VimeReplays.replay.data;

import java.io.Serializable;

public class ArmSwingData extends RecordingData implements Serializable {

    private final int entityId;

    public ArmSwingData(int entityId) {
        this.entityId = entityId;
    }

    public int getEntityId() { return entityId; }
}