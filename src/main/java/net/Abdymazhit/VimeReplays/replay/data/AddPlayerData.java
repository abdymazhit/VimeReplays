package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;

import java.io.Serializable;

public class AddPlayerData extends RecordingData implements Serializable {

    private final short entityId;
    private final short x;
    private final short y;
    private final short z;
    private final short pitch;
    private final short yaw;

    public AddPlayerData(short entityId, short x, short y, short z, short pitch, short yaw) {
        this.entityId = entityId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public AddPlayerData(Input input) {
        entityId = input.readShort();
        x = input.readShort();
        y = input.readShort();
        z = input.readShort();
        yaw = input.readShort();
        pitch = input.readShort();
    }

    public short getEntityId() {
        return entityId;
    }

    public short getX() {
        return x;
    }

    public short getY() {
        return y;
    }

    public short getZ() {
        return z;
    }

    public short getPitch() {
        return pitch;
    }

    public short getYaw() {
        return yaw;
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(AddPlayerData.class));
        output.writeShort(entityId);
        output.writeShort(x);
        output.writeShort(y);
        output.writeShort(z);
        output.writeShort(yaw);
        output.writeShort(pitch);
    }
}
