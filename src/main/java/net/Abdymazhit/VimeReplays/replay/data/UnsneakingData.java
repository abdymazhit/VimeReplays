package net.Abdymazhit.VimeReplays.replay.data;

import java.io.Serializable;

public class UnsneakingData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final short entityId;

    public UnsneakingData(short entityId) {
        this.entityId = entityId;
    }

    public short getEntityId() { return entityId; }
}