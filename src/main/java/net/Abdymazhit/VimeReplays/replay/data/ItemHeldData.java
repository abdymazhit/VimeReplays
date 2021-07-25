package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;

import java.io.Serializable;

public class ItemHeldData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final short entityId;
    private final short itemId;

    public ItemHeldData(short entityId, short itemId) {
        this.entityId = entityId;
        this.itemId = itemId;
    }

    public ItemHeldData(Input input) {
        entityId = input.readShort();
        itemId = input.readShort();
    }

    public short getEntityId() {
        return entityId;
    }

    public short getItemId() {
        return itemId;
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(ItemHeldData.class));
        output.writeShort(entityId);
        output.writeShort(itemId);
    }
}
