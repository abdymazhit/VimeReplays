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

/**
 * Конструктор создания записи изменения зачарованного предмета в руке игрока для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class EnchantedItemHeldData extends EnchantedItemData implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public EnchantedItemHeldData() { }

    /**
     * Инициализирует запись изменения зачарованного предмета в руке игрока
     */
    public EnchantedItemHeldData(short entityId, short itemId, Map<Enchantment, Integer> enchantments) {
        super(entityId, itemId, enchantments);
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(EnchantedItemHeldData.class));
        super.write(output);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        super.read(input);
    }

    /**
     * Выполняет действия изменения зачарованного предмета в руке игрока
     */
    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(getEntityId());
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(getItemId(), getEnchantments());
        npc.setEquipment(EquipmentType.HAND, itemStack);
    }
}
