package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;

import java.io.Serializable;

public class ArmSwingData extends RecordingData implements Serializable {

    private final short entityId;

    public ArmSwingData(short entityId) {
        this.entityId = entityId;
    }

    public ArmSwingData(Input input) {
        entityId = input.readShort();
    }

    public short getEntityId() {
        return entityId;
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(ArmSwingData.class));
        output.writeShort(entityId);
    }
}
