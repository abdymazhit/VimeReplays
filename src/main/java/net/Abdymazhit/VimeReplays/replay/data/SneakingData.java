package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.playing.NPC;

import java.io.Serializable;

/**
 * Конструктор создания анимации подкрадывания для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class SneakingData extends RecordingData implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    /** Id игрока */
    private short entityId;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public SneakingData() { }

    /**
     * Инициализирует запись анимации подкрадывания
     */
    public SneakingData(short entityId) {
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
        output.writeByte(VimeReplays.getSerializationUtils().getId(SneakingData.class));
        output.writeShort(entityId);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityId = input.readShort();
    }

    /**
     * Выполняет действия анимации подкрадывания
     */
    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(entityId);
        npc.setSneaking(true);
    }
}
