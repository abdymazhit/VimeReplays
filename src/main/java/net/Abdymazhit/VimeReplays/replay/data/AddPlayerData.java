package net.Abdymazhit.VimeReplays.replay.data;

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
}
