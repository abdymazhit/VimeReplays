package net.Abdymazhit.VimeReplays.replay.data.equipment;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.EquipmentType;
import net.Abdymazhit.VimeReplays.playing.NPC;
import net.minecraft.server.v1_8_R3.ItemStack;
import org.bukkit.enchantments.Enchantment;

import java.io.Serializable;
import java.util.Map;

public class EnchantedItemHeldData extends EnchantedItemData implements Serializable {

    private static final long serialVersionUID = 1L;

    public EnchantedItemHeldData() { }

    public EnchantedItemHeldData(short entityId, short itemId, Map<Enchantment, Integer> enchantments) {
        super(entityId, itemId, enchantments);
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(EnchantedItemHeldData.class));
        super.write(output);
    }

    public void read(Input input) {
        super.read(input);
    }

    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(getEntityId());
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(getItemId(), getEnchantments());
        npc.setEquipment(EquipmentType.HAND, itemStack);
    }
}
