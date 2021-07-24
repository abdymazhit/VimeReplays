package net.Abdymazhit.VimeReplays.replay.data;

import java.io.Serializable;

public class DamageData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final short entityId;

    public DamageData(short entityId) {
        this.entityId = entityId;
    }

    public short getEntityId() {
        return entityId;
    }
}
