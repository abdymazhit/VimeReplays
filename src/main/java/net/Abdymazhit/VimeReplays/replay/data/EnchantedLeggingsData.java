package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.EquipmentType;
import net.Abdymazhit.VimeReplays.playing.NPC;
import net.minecraft.server.v1_8_R3.ItemStack;
import org.bukkit.enchantments.Enchantment;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EnchantedLeggingsData extends LeggingsData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<Enchantment, Integer> enchantments;

    public EnchantedLeggingsData(short entityId, short itemId, Map<Enchantment, Integer> enchantments) {
        super(entityId, itemId);
        this.enchantments = enchantments;
    }

    public EnchantedLeggingsData(Input input) {
        super(input.readShort(), input.readShort());
        int enchantmentsSize = input.readByte();

        enchantments = new HashMap<>();
        for(byte id = 0; id < enchantmentsSize; id++) {
            byte enchantmentId = input.readByte();
            byte level = input.readByte();

            enchantments.put(VimeReplays.getEnchantmentUtils().getEnchantment(enchantmentId), (int) level);
        }
    }

    public Map<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(EnchantedLeggingsData.class));
        output.writeShort(getEntityId());
        output.writeShort(getItemId());
        output.writeByte(enchantments.size());

        for(Enchantment enchantment : enchantments.keySet()) {
            byte enchantmentId = VimeReplays.getEnchantmentUtils().getEnchantmentId(enchantment);
            byte level = enchantments.get(enchantment).byteValue();

            output.writeByte(enchantmentId);
            output.writeByte(level);
        }
    }

    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(getEntityId());
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(getItemId(), getEnchantments());
        npc.setEquipment(EquipmentType.LEGGINGS, itemStack);
    }
}