package net.Abdymazhit.VimeReplays.replay.data;

import java.io.Serializable;

public class AddPlayerData extends RecordingData implements Serializable {

    private final short entityId;

    public AddPlayerData(short entityId) {
        this.entityId = entityId;
    }

    public short getEntityId() {
        return entityId;
    }
}
