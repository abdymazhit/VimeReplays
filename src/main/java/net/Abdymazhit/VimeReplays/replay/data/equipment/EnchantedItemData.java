package net.Abdymazhit.VimeReplays.replay.data.equipment;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.bukkit.enchantments.Enchantment;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Конструктор создания записи изменения зачарованной экипировки игрока для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class EnchantedItemData extends ItemData implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    private Map<Enchantment, Integer> enchantments;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public EnchantedItemData() { }

    /**
     * Инициализирует запись изменения зачарованной экипировки игрока
     */
    public EnchantedItemData(short entityId, short itemId, Map<Enchantment, Integer> enchantments) {
        super(entityId, itemId);
        this.enchantments = enchantments;
    }

    /**
     * Возвращает зачарования предмета
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
            byte enchantmentId = (byte) enchantment.getId();
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

            enchantments.put(Enchantment.getById(enchantmentId), (int) level);
        }
    }
}