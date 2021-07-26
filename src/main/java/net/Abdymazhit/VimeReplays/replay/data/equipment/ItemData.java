package net.Abdymazhit.VimeReplays.replay.data.equipment;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.replay.data.RecordingData;

import java.io.Serializable;

public class ItemData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private short entityId;
    private short itemId;

    public ItemData() { }

    public ItemData(short entityId, short itemId) {
        this.entityId = entityId;
        this.itemId = itemId;
    }

    public short getEntityId() {
        return entityId;
    }

    public short getItemId() {
        return itemId;
    }

    public void write(Output output) {
        output.writeShort(entityId);
        output.writeShort(itemId);
    }

    public void read(Input input) {
        entityId = input.readShort();
        itemId = input.readShort();
    }
}