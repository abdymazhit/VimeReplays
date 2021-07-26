package net.Abdymazhit.VimeReplays.replay.data.equipment;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.bukkit.enchantments.Enchantment;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EnchantedItemData extends ItemData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<Enchantment, Integer> enchantments;

    public EnchantedItemData() { }

    public EnchantedItemData(short entityId, short itemId, Map<Enchantment, Integer> enchantments) {
        super(entityId, itemId);
        this.enchantments = enchantments;
    }

    public Map<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }

    public void write(Output output) {
        output.writeShort(getEntityId());
        output.writeShort(getItemId());
        output.writeByte(enchantments.size());

        for(Enchantment enchantment : enchantments.keySet()) {
            byte enchantmentId = (byte) enchantment.getId();
            byte level = enchantments.get(enchantment).byteValue();

            output.writeByte(enchantmentId);
            output.writeByte(level);
        }
    }

    public void read(Input input) {
        super.read(input);
        byte enchantmentsSize = input.readByte();

        enchantments = new HashMap<>();
        for(byte id = 0; id < enchantmentsSize; id++) {
            byte enchantmentId = input.readByte();
            byte level = input.readByte();

            enchantments.put(Enchantment.getById(enchantmentId), (int) level);
        }
    }
}