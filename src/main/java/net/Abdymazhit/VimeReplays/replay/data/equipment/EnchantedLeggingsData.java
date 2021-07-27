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
 * Конструктор создания записи изменения зачарованной экипировки (штаны) игрока для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class EnchantedLeggingsData extends EnchantedItemData implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public EnchantedLeggingsData() { }

    /**
     * Инициализирует запись изменения зачарованной экипировки (штаны) игрока
     */
    public EnchantedLeggingsData(short entityId, short itemId, Map<Enchantment, Integer> enchantments) {
        super(entityId, itemId, enchantments);
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(EnchantedLeggingsData.class));
        super.write(output);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        super.read(input);
    }

    /**
     * Выполняет действия изменения зачарованной экипировки (штаны) игрока
     */
    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(getEntityId());
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(getItemId(), getEnchantments());
        npc.setEquipment(EquipmentType.LEGGINGS, itemStack);
    }
}