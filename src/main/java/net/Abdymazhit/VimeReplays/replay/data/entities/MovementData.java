package net.Abdymazhit.VimeReplays.replay.data.entities;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.playing.nms.NMSEntity;
import net.Abdymazhit.VimeReplays.replay.data.customs.LocationData;

/**
 * Отвечает за запись движения entity
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class MovementData extends LocationData {

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public MovementData() { }

    /**
     * Инициализирует запись движения entity
     */
    public MovementData(short entityId, short x, short y, short z, short yaw, short pitch) {
        super(entityId, x, y, z, yaw, pitch);
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(MovementData.class));
        super.write(output);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        super.read(input);
    }

    /**
     * Выполняет действия движения entity
     */
    public void performAction() {
        double x = VimeReplays.getLocationUtils().getLocationDouble(this.x);
        double y = VimeReplays.getLocationUtils().getLocationDouble(this.y);
        double z = VimeReplays.getLocationUtils().getLocationDouble(this.z);
        float yaw = VimeReplays.getLocationUtils().getLocationFloat(this.yaw);
        float pitch = VimeReplays.getLocationUtils().getLocationFloat(this.pitch);

        if(VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(entityId) != null) {
            NMSEntity entity = VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(entityId);
            entity.teleport(x, y, z, yaw, pitch);
        }
    }
}
