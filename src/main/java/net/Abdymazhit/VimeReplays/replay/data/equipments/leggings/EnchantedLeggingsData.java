package net.Abdymazhit.VimeReplays.replay.data.equipments.leggings;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.enums.EquipmentType;
import net.Abdymazhit.VimeReplays.playing.nms.NMSPlayer;
import net.Abdymazhit.VimeReplays.replay.data.customs.EnchantedItemData;
import net.minecraft.server.v1_8_R3.ItemStack;
import org.bukkit.enchantments.Enchantment;

import java.util.Map;

/**
 * Отвечает за запись изменения зачарованной экипировки (штаны)
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class EnchantedLeggingsData extends EnchantedItemData {

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public EnchantedLeggingsData() { }

    /**
     * Инициализирует запись изменения зачарованной экипировки (штаны)
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
     * Выполняет действия изменения зачарованной экипировки (штаны)
     */
    public void performAction() {
        NMSPlayer entity = (NMSPlayer) VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(getEntityId());
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(getItemId(), getEnchantments());
        entity.setEquipment(EquipmentType.LEGGINGS, itemStack);
    }
}