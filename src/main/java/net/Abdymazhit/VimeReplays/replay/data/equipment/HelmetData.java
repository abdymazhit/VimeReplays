package net.Abdymazhit.VimeReplays.replay.data.equipment;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.EquipmentType;
import net.Abdymazhit.VimeReplays.playing.NPC;
import net.minecraft.server.v1_8_R3.ItemStack;

import java.io.Serializable;

public class HelmetData extends ItemData implements Serializable {

    private static final long serialVersionUID = 1L;

    public HelmetData() { }

    public HelmetData(short entityId, short itemId) {
        super(entityId, itemId);
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(HelmetData.class));
        super.write(output);
    }

    public void read(Input input) {
        super.read(input);
    }

    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(getEntityId());
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(getItemId(), null);
        npc.setEquipment(EquipmentType.HELMET, itemStack);
    }
}
