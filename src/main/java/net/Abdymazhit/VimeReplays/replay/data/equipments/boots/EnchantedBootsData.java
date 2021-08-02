package net.Abdymazhit.VimeReplays.replay.data.equipments.boots;

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
 * Отвечает за запись изменения зачарованной экипировки (ботинки)
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class EnchantedBootsData extends EnchantedItemData {

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public EnchantedBootsData() { }

    /**
     * Инициализирует запись изменения зачарованной экипировки (ботинки)
     */
    public EnchantedBootsData(short entityId, short itemId, Map<Enchantment, Integer> enchantments) {
        super(entityId, itemId, enchantments);
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(EnchantedBootsData.class));
        super.write(output);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        super.read(input);
    }

    /**
     * Выполняет действия изменения зачарованной экипировки (ботинки)
     */
    public void performAction() {
        NMSPlayer NMSPlayer = (NMSPlayer) VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(getEntityId());
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(getItemId(), getEnchantments());
        NMSPlayer.setEquipment(EquipmentType.BOOTS, itemStack);
    }
}