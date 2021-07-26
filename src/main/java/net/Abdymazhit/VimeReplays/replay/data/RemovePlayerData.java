package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;

import java.io.Serializable;

public class RemovePlayerData extends RecordingData implements Serializable {

    private short entityId;

    public RemovePlayerData() { }

    public RemovePlayerData(short entityId) {
        this.entityId = entityId;
    }

    public short getEntityId() {
        return entityId;
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(RemovePlayerData.class));
        output.writeShort(entityId);
    }

    public void read(Input input) {
        entityId = input.readShort();
    }
}
