package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.playing.NPC;

import java.io.Serializable;

public class MovingData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private short entityId;
    private short x;
    private short y;
    private short z;
    private short yaw;
    private short pitch;

    public MovingData() { }

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

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(MovingData.class));
        output.writeShort(entityId);
        output.writeShort(x);
        output.writeShort(y);
        output.writeShort(z);
        output.writeShort(yaw);
        output.writeShort(pitch);
    }

    public void read(Input input) {
        entityId = input.readShort();
        x = input.readShort();
        y = input.readShort();
        z = input.readShort();
        yaw = input.readShort();
        pitch = input.readShort();
    }

    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(entityId);
        double x = VimeReplays.getLocationUtils().getLocationDouble(this.x);
        double y = VimeReplays.getLocationUtils().getLocationDouble(this.y);
        double z = VimeReplays.getLocationUtils().getLocationDouble(this.z);
        float yaw = VimeReplays.getLocationUtils().getLocationFloat(this.yaw);
        float pitch = VimeReplays.getLocationUtils().getLocationFloat(this.pitch);
        npc.teleport(x, y, z, yaw, pitch);
    }
}
