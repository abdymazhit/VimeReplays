package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.Serializable;
import net.Abdymazhit.VimeReplays.VimeReplays;

/**
 * Конструктор создания записи удаления игрока для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class RemovePlayerData extends RecordingData implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    /** Id игрока */
    private short entityId;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public RemovePlayerData() { }

    /**
     * Инициализирует запись удаления игрока
     */
    public RemovePlayerData(short entityId) {
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
        output.writeByte(VimeReplays.getSerializationUtils().getId(RemovePlayerData.class));
        output.writeShort(entityId);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityId = input.readShort();
    }

    /**
     * Выполняет действия удаления игрока
     */
    public void performAction() {

    }
}
