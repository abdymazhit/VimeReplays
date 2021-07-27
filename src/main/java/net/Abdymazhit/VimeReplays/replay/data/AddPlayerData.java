package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.playing.NPC;

import java.io.Serializable;

/**
 * Конструктор создания записи добавления игрока для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class AddPlayerData extends RecordingData implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    /** Id игрока */
    private short entityId;

    /** Координата x игрока */
    private short x;

    /** Координата y игрока */
    private short y;

    /** Координата z игрока */
    private short z;

    /** Значение yaw игрока */
    private short yaw;

    /** Значение pitch игрока */
    private short pitch;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public AddPlayerData() { }

    /**
     * Инициализирует запись добавления игрока
     */
    public AddPlayerData(short entityId, short x, short y, short z, short yaw, short pitch) {
        this.entityId = entityId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    /**
     * Возвращает id игрока
     */
    public short getEntityId() {
        return entityId;
    }

    /**
     * Возвращает координату x игрока
     */
    public short getX() {
        return x;
    }

    /**
     * Возвращает координату y игрока
     */
    public short getY() {
        return y;
    }

    /**
     * Возвращает координату z игрока
     */
    public short getZ() {
        return z;
    }

    /**
     * Возвращает значение yaw игрока
     */
    public short getYaw() {
        return yaw;
    }

    /**
     * Возвращает значение pitch игрока
     */
    public short getPitch() {
        return pitch;
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(AddPlayerData.class));
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

    /**
     * Выполняет действия добавления игрока
     */
    public void performAction() {
        double x = VimeReplays.getLocationUtils().getLocationDouble(this.x);
        double y = VimeReplays.getLocationUtils().getLocationDouble(this.y);
        double z = VimeReplays.getLocationUtils().getLocationDouble(this.z);
        float yaw = VimeReplays.getLocationUtils().getLocationFloat(this.yaw);
        float pitch = VimeReplays.getLocationUtils().getLocationFloat(this.pitch);

        if(!VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().containsKey(entityId)) {
            VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().put(entityId, new NPC(VimeReplays.getPlayingManager().getPlayingHandler().getPlayerName(entityId), x, y, z, yaw ,pitch));
        } else {
            NPC npc = VimeReplays.getPlayingManager().getPlayingHandler().getNPCList().get(entityId);
            npc.teleport(x, y, z, yaw, pitch);
        }
    }
}
