package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;

import java.io.Serializable;

public class SneakingData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final short entityId;

    public SneakingData(short entityId) {
        this.entityId = entityId;
    }

    public SneakingData(Input input) {
        entityId = input.readShort();
    }

    public short getEntityId() {
        return entityId;
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(SneakingData.class));
        output.writeShort(entityId);
    }
}
