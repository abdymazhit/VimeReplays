package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.AnimationType;
import net.Abdymazhit.VimeReplays.playing.NPC;

import java.io.Serializable;

public class ArmSwingData extends RecordingData implements Serializable {

    private short entityId;

    public ArmSwingData() { }

    public ArmSwingData(short entityId) {
        this.entityId = entityId;
    }

    public short getEntityId() {
        return entityId;
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(ArmSwingData.class));
        output.writeShort(entityId);
    }

    public void read(Input input) {
        entityId = input.readShort();
    }

    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(entityId);
        npc.setAnimation(AnimationType.ARM_SWING);
    }
}
