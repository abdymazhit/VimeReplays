package net.Abdymazhit.VimeReplays.replay.data;

import java.io.Serializable;

public class ItemHeldData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final short entityId;
    private final byte itemId;

    public ItemHeldData(short entityId, byte itemId) {
        this.entityId = entityId;
        this.itemId = itemId;
    }

    public short getEntityId() {
        return entityId;
    }

    public byte getItemId() {
        return itemId;
    }
}
