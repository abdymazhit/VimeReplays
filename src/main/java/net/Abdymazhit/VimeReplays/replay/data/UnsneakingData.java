package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.playing.NPC;

import java.io.Serializable;

/**
 * Конструктор создания анимации отжатия подкрадывания для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class UnsneakingData extends RecordingData implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    /** Id игрока */
    private short entityId;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public UnsneakingData() { }

    /**
     * Инициализирует запись анимации отжатия подкрадывания
     */
    public UnsneakingData(short entityId) {
        this.entityId = entityId;
    }

    /**
     * Возвращает id игрока
     */
    public short getEntityId() {
        return entityId;
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(UnsneakingData.class));
        output.writeShort(entityId);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityId = input.readShort();
    }

    /**
     * Выполняет действия анимации отжатия подкрадывания
     */
    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(entityId);
        npc.setSneaking(false);
    }
}
