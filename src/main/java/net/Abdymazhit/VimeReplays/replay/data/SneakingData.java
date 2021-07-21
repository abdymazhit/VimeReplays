package net.Abdymazhit.VimeReplays.replay.data;

import java.io.Serializable;

public class SneakingData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int entityId;

    public SneakingData(int entityId) {
        this.entityId = entityId;
    }

    public int getEntityId() { return entityId; }
}