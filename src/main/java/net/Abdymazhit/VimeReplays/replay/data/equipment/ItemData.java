package net.Abdymazhit.VimeReplays.replay.data.equipment;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.replay.data.RecordingData;

import java.io.Serializable;

/**
 * Конструктор создания записи изменения незачарованной экипировки игрока для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class ItemData extends RecordingData implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    private short entityId;
    private short itemId;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public ItemData() { }

    /**
     * Инициализирует запись изменения незачарованной экипировки игрока
     */
    public ItemData(short entityId, short itemId) {
        this.entityId = entityId;
        this.itemId = itemId;
    }

    /**
     * Возвращает id игрока
     */
    public short getEntityId() {
        return entityId;
    }

    /**
     * Возвращает id предмета
     */
    public short getItemId() {
        return itemId;
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeShort(entityId);
        output.writeShort(itemId);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityId = input.readShort();
        itemId = input.readShort();
    }
}