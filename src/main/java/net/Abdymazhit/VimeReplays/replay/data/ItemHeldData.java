package net.Abdymazhit.VimeReplays.replay.data;

import java.io.Serializable;

public class ItemHeldData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final short entityId;
    private final short itemId;

    public ItemHeldData(short entityId, short itemId) {
        this.entityId = entityId;
        this.itemId = itemId;
    }

    public short getEntityId() {
        return entityId;
    }

    public short getItemId() {
        return itemId;
    }
}
