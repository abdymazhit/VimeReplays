package net.Abdymazhit.VimeReplays.replay.data.customs;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Конструктор создания записи изменения незачарованной экипировки
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class ItemData extends RecordingData {

    /** Id entity */
    private short entityId;

    /** Id предмета экипировки */
    private short itemId;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public ItemData() { }

    /**
     * Инициализирует запись изменения незачарованной экипировки
     */
    public ItemData(short entityId, short itemId) {
        this.entityId = entityId;
        this.itemId = itemId;
    }

    /**
     * Возвращает id entity
     */
    public short getEntityId() {
        return entityId;
    }

    /**
     * Возвращает id предмета экипировки
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