package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.EquipmentType;
import net.Abdymazhit.VimeReplays.playing.NPC;
import net.minecraft.server.v1_8_R3.ItemStack;

import java.io.Serializable;

public class LeggingsData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final short entityId;
    private final short itemId;

    public LeggingsData(short entityId, short itemId) {
        this.entityId = entityId;
        this.itemId = itemId;
    }

    public LeggingsData(Input input) {
        entityId = input.readShort();
        itemId = input.readShort();
    }

    public short getEntityId() {
        return entityId;
    }

    public short getItemId() {
        return itemId;
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(LeggingsData.class));
        output.writeShort(entityId);
        output.writeShort(itemId);
    }

    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(entityId);
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(itemId, null);
        npc.setEquipment(EquipmentType.LEGGINGS, itemStack);
    }
}
