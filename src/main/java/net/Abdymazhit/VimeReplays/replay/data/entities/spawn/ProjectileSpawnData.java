package net.Abdymazhit.VimeReplays.replay.data.entities.spawn;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.playing.nms.NMSProjectile;
import net.Abdymazhit.VimeReplays.replay.data.customs.LocationData;

/**
 * Отвечает за запись спавна метательных entity
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class ProjectileSpawnData extends LocationData {

    /** Тип метательного entity */
    private byte entityType;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public ProjectileSpawnData() { }

    /**
     * Инициализирует запись спавна метательных entity
     */
    public ProjectileSpawnData(byte entityType, short entityId, short x, short y, short z, short yaw, short pitch) {
        super(entityId, x, y, z, yaw, pitch);
        this.entityType = entityType;
    }

    /**
     * Возвращает тип метательного entity
     */
    public short getEntityType() {
        return entityType;
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(ProjectileSpawnData.class));
        output.writeByte(entityType);
        super.write(output);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityType = input.readByte();
        super.read(input);
    }

    /**
     * Выполняет действия спавна метательных entity
     */
    public void performAction() {
        double x = VimeReplays.getLocationUtils().getLocationDouble(this.x);
        double y = VimeReplays.getLocationUtils().getLocationDouble(this.y);
        double z = VimeReplays.getLocationUtils().getLocationDouble(this.z);
        float yaw = VimeReplays.getLocationUtils().getLocationFloat(this.yaw);
        float pitch = VimeReplays.getLocationUtils().getLocationFloat(this.pitch);

        if(!VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().containsKey(entityId)) {
            NMSProjectile entity = new NMSProjectile(VimeReplays.getEntityUtils().getEntityType(entityType), x, y, z, yaw, pitch);
            VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().put(entityId, entity);
        } else {
            NMSProjectile entity = (NMSProjectile) VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(entityId);
            entity.teleport(x, y, z, yaw, pitch);
        }
    }
}