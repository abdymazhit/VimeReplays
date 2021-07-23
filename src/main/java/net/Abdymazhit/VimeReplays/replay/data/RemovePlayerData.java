package net.Abdymazhit.VimeReplays.replay.data;

import java.io.Serializable;

public class RemovePlayerData extends RecordingData implements Serializable {

    private final short entityId;

    public RemovePlayerData(short entityId) {
        this.entityId = entityId;
    }

    public short getEntityId() {
        return entityId;
    }
}
