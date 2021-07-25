package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;

import java.io.Serializable;

public class MovingData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final short entityId;
    private final short x;
    private final short y;
    private final short z;
    private final short yaw;
    private final short pitch;

    public MovingData(short entityId, short x, short y, short z, short yaw, short pitch) {
        this.entityId = entityId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public MovingData(Input input) {
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

    public short getYaw() {
        return yaw;
    }

    public short getPitch() {
        return pitch;
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(MovingData.class));
        output.writeShort(entityId);
        output.writeShort(x);
        output.writeShort(y);
        output.writeShort(z);
        output.writeShort(yaw);
        output.writeShort(pitch);
    }
}
