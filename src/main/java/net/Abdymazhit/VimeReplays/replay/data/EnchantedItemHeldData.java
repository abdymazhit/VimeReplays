package net.Abdymazhit.VimeReplays.replay.data;

import org.bukkit.enchantments.Enchantment;

import java.io.Serializable;
import java.util.Map;

public class EnchantedItemHeldData extends ItemHeldData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<Enchantment, Integer> enchantments;

    public EnchantedItemHeldData(short entityId, short itemId, Map<Enchantment, Integer> enchantments) {
        super(entityId, itemId);
        this.enchantments = enchantments;
    }

    public Map<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }
}
