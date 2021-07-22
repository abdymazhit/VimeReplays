package net.Abdymazhit.VimeReplays.replay.data;

import java.io.Serializable;

public class ArmSwingData extends RecordingData implements Serializable {

    private final short entityId;

    public ArmSwingData(short entityId) {
        this.entityId = entityId;
    }

    public short getEntityId() { return entityId; }
}