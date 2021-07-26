package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;

import java.io.Serializable;

public class EquipmentData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final short entityId;
    private final short itemId;

    public EquipmentData(short entityId, short itemId) {
        this.entityId = entityId;
        this.itemId = itemId;
    }

    public EquipmentData(Input input) {
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
        output.writeByte(VimeReplays.getSerializationUtils().getId(EquipmentData.class));
        output.writeShort(entityId);
        output.writeShort(itemId);
    }
}
