package net.Abdymazhit.VimeReplays.replay.data.customs;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import org.bukkit.enchantments.Enchantment;

import java.util.HashMap;
import java.util.Map;

/**
 * Конструктор создания записи изменения зачарованной экипировки
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class EnchantedItemData extends ItemData {

    /** Хранит зачарования экипировки */
    private Map<Enchantment, Integer> enchantments;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public EnchantedItemData() { }

    /**
     * Инициализирует запись изменения зачарованной экипировки
     */
    public EnchantedItemData(short entityId, short itemId, Map<Enchantment, Integer> enchantments) {
        super(entityId, itemId);
        this.enchantments = enchantments;
    }

    /**
     * Возвращает зачарования экипировки
     */
    public Map<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeShort(getEntityId());
        output.writeShort(getItemId());
        output.writeByte(enchantments.size());

        for(Enchantment enchantment : enchantments.keySet()) {
            byte enchantmentId = VimeReplays.getEnchantmentUtils().getId(enchantment);
            byte level = enchantments.get(enchantment).byteValue();

            output.writeByte(enchantmentId);
            output.writeByte(level);
        }
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        super.read(input);
        byte enchantmentsSize = input.readByte();

        enchantments = new HashMap<>();
        for(byte id = 0; id < enchantmentsSize; id++) {
            byte enchantmentId = input.readByte();
            byte level = input.readByte();

            enchantments.put(VimeReplays.getEnchantmentUtils().getEnchantment(enchantmentId), (int) level);
        }
    }
}