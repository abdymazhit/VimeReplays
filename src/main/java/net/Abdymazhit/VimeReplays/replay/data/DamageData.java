package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.AnimationType;
import net.Abdymazhit.VimeReplays.playing.NPC;

import java.io.Serializable;

/**
 * Конструктор создания записи анимации урона игрока для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class DamageData extends RecordingData implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    /** Id игрока */
    private short entityId;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public DamageData() { }

    /**
     * Инициализирует запись анимации дамага игрока
     */
    public DamageData(short entityId) {
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
        output.writeByte(VimeReplays.getSerializationUtils().getId(DamageData.class));
        output.writeShort(entityId);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityId = input.readShort();
    }

    /**
     * Выполняет действия анимации дамага игрока
     */
    public void performAction() {
        NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(entityId);
        npc.setAnimation(AnimationType.DAMAGE);
    }
}
