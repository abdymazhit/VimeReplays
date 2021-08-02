package net.Abdymazhit.VimeReplays.replay.data.customs;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Конструктор создания записи связанных с местоположением
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class LocationData extends RecordingData {

    /** Id entity */
    public short entityId;

    /** Координата x entity */
    public short x;

    /** Координата y entity */
    public short y;

    /** Координата z entity */
    public short z;

    /** Значение yaw entity */
    public short yaw;

    /** Значение pitch entity */
    public short pitch;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public LocationData() { }

    /**
     * Инициализирует запись движения
     */
    public LocationData(short entityId, short x, short y, short z, short yaw, short pitch) {
        this.entityId = entityId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    /**
     * Возвращает id entity
     */
    public short getEntityId() {
        return entityId;
    }

    /**
     * Возвращает координату x entity
     */
    public short getX() {
        return x;
    }

    /**
     * Возвращает координату y entity
     */
    public short getY() {
        return y;
    }

    /**
     * Возвращает координату z entity
     */
    public short getZ() {
        return z;
    }

    /**
     * Возвращает значение yaw entity
     */
    public short getYaw() {
        return yaw;
    }

    /**
     * Возвращает значение pitch entity
     */
    public short getPitch() {
        return pitch;
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeShort(entityId);
        output.writeShort(x);
        output.writeShort(y);
        output.writeShort(z);
        output.writeShort(yaw);
        output.writeShort(pitch);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityId = input.readShort();
        x = input.readShort();
        y = input.readShort();
        z = input.readShort();
        yaw = input.readShort();
        pitch = input.readShort();
    }
}
