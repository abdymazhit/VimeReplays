package net.Abdymazhit.VimeReplays.replay.data;

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
}
