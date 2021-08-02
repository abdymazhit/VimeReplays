package net.Abdymazhit.VimeReplays.replay.data.entities.death;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.playing.nms.NMSEntity;
import net.Abdymazhit.VimeReplays.replay.data.customs.RecordingData;

/**
 * Отвечает за запись смерти entity
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class EntityDeathData extends RecordingData {

    /** Id entity */
    private short entityId;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public EntityDeathData() { }

    /**
     * Инициализирует запись смерти entity
     */
    public EntityDeathData(short entityId) {
        this.entityId = entityId;
    }

    /**
     * Возвращает id entity
     */
    public short getEntityId() {
        return entityId;
    }

    /**
     * Записывает запись в файл (сериализация)
     */
    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(EntityDeathData.class));
        output.writeShort(entityId);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityId = input.readShort();
    }

    /**
     * Выполняет действия смерти entity
     */
    public void performAction() {
        if(VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().containsKey(entityId)) {
            NMSEntity entity = VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(entityId);
            entity.destroy();
            VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().remove(entityId);
        }
    }
}
