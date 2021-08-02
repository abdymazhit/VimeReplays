package net.Abdymazhit.VimeReplays.replay.data.equipments.helmet;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.enums.EquipmentType;
import net.Abdymazhit.VimeReplays.playing.nms.NMSPlayer;
import net.Abdymazhit.VimeReplays.replay.data.customs.ItemData;
import net.minecraft.server.v1_8_R3.ItemStack;

/**
 * Отвечает за запись изменения незачарованной экипировки (шлем)
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class HelmetData extends ItemData {

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public HelmetData() { }

    /**
     * Инициализирует запись изменения незачарованной экипировки (шлем)
     */
    public HelmetData(short entityId, short itemId) {
        super(entityId, itemId);
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(HelmetData.class));
        super.write(output);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        super.read(input);
    }

    /**
     * Выполняет действия изменения незачарованной экипировки (шлем)
     */
    public void performAction() {
        NMSPlayer NMSPlayer = (NMSPlayer) VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(getEntityId());
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(getItemId(), null);
        NMSPlayer.setEquipment(EquipmentType.HELMET, itemStack);
    }
}
