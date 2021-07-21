package net.Abdymazhit.VimeReplays.replay.data;

import java.io.Serializable;

public class MovingData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int entityId;
    private final int x;
    private final int y;
    private final int z;
    private final int pitch;
    private final int yaw;

    public MovingData(int entityId, int x, int y, int z, int pitch, int yaw) {
        this.entityId = entityId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public int getEntityId() { return entityId; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getPitch() {
        return pitch;
    }

    public int getYaw() {
        return yaw;
    }
}