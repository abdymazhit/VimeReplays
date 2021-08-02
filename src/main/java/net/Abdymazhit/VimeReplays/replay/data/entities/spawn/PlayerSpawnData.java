package net.Abdymazhit.VimeReplays.replay.data.entities.spawn;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.playing.nms.NMSPlayer;
import net.Abdymazhit.VimeReplays.replay.data.customs.LocationData;

/**
 * Отвечает за запись спавна игрока
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class PlayerSpawnData extends LocationData {

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public PlayerSpawnData() { }

    /**
     * Инициализирует запись спавна игрока
     */
    public PlayerSpawnData(short entityId, short x, short y, short z, short yaw, short pitch) {
        super(entityId, x, y, z, yaw, pitch);
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(PlayerSpawnData.class));
        super.write(output);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        super.read(input);
    }

    /**
     * Выполняет действия спавна игрока
     */
    public void performAction() {
        double x = VimeReplays.getLocationUtils().getLocationDouble(this.x);
        double y = VimeReplays.getLocationUtils().getLocationDouble(this.y);
        double z = VimeReplays.getLocationUtils().getLocationDouble(this.z);
        float yaw = VimeReplays.getLocationUtils().getLocationFloat(this.yaw);
        float pitch = VimeReplays.getLocationUtils().getLocationFloat(this.pitch);

        if(!VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().containsKey(entityId)) {
            NMSPlayer entity = new NMSPlayer(VimeReplays.getPlayingManager().getPlayingHandler().getPlayerName(entityId), x, y, z, yaw, pitch);
            VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().put(entityId, entity);
        } else {
            NMSPlayer entity = (NMSPlayer) VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(entityId);
            entity.teleport(x, y, z, yaw, pitch);
        }
    }
}
