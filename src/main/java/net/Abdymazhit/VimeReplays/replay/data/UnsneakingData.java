package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;

import java.io.Serializable;

public class UnsneakingData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final short entityId;

    public UnsneakingData(short entityId) {
        this.entityId = entityId;
    }

    public UnsneakingData(Input input) {
        entityId = input.readShort();
    }

    public short getEntityId() {
        return entityId;
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(UnsneakingData.class));
        output.writeShort(entityId);
    }
}
