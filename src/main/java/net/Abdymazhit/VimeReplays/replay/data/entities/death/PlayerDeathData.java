package net.Abdymazhit.VimeReplays.replay.data.entities.death;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.customs.RecordingData;

/**
 * Отвечает за запись смерти игрока
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class PlayerDeathData extends RecordingData {

    /** Id игрока */
    private short entityId;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public PlayerDeathData() { }

    /**
     * Инициализирует запись смерти игрока
     */
    public PlayerDeathData(short entityId) {
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
        output.writeByte(VimeReplays.getSerializationUtils().getId(PlayerDeathData.class));
        output.writeShort(entityId);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityId = input.readShort();
    }

    /**
     * Выполняет действия смерти игрока
     */
    public void performAction() {

    }
}
