package net.Abdymazhit.VimeReplays.replay.data.equipments.boots;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.enums.EquipmentType;
import net.Abdymazhit.VimeReplays.playing.nms.NMSEntity;
import net.Abdymazhit.VimeReplays.replay.data.customs.ItemData;
import net.minecraft.server.v1_8_R3.ItemStack;

/**
 * Отвечает за запись изменения незачарованной экипировки (ботинки)
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class BootsData extends ItemData {

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public BootsData() { }

    /**
     * Инициализирует запись изменения незачарованной экипировки (ботинки)
     */
    public BootsData(short entityId, short itemId) {
        super(entityId, itemId);
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(BootsData.class));
        super.write(output);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        super.read(input);
    }

    /**
     * Выполняет действия изменения незачарованной экипировки (ботинки)
     */
    public void performAction() {
        NMSEntity nmsEntity = VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(getEntityId());
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(getItemId(), null);
        nmsEntity.setEquipment(EquipmentType.BOOTS, itemStack);
    }
}
