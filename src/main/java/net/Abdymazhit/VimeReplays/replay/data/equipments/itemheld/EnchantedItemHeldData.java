package net.Abdymazhit.VimeReplays.replay.data.equipments.itemheld;

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
 * Отвечает за запись изменения зачарованного предмета в руке
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class EnchantedItemHeldData extends EnchantedItemData {

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public EnchantedItemHeldData() { }

    /**
     * Инициализирует запись изменения зачарованного предмета в руке
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
     * Выполняет действия изменения зачарованного предмета в руке
     */
    public void performAction() {
        NMSPlayer entity = (NMSPlayer) VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(getEntityId());
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(getItemId(), getEnchantments());
        entity.setEquipment(EquipmentType.HAND, itemStack);
    }
}
