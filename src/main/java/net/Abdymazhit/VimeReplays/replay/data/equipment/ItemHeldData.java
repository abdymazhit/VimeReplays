package net.Abdymazhit.VimeReplays.replay.data.equipment;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.EquipmentType;
import net.Abdymazhit.VimeReplays.playing.NPC;
import net.minecraft.server.v1_8_R3.ItemStack;

import java.io.Serializable;

/**
 * Конструктор создания записи изменения незачарованного предмета в руке игрока для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class ItemHeldData extends ItemData implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public ItemHeldData() { }

    /**
     * Инициализирует запись изменения незачарованного предмета в руке игрока
     */
    public ItemHeldData(short entityId, short itemId) {
        super(entityId, itemId);
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(ItemHeldData.class));
        super.write(output);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        super.read(input);
    }

    /**
     * Выполняет действия изменения незачарованного предмета в руке игрока
     */
    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(getEntityId());
        ItemStack itemStack = VimeReplays.getItemUtils().getItemStack(getItemId(), null);
        npc.setEquipment(EquipmentType.HAND, itemStack);
    }
}
