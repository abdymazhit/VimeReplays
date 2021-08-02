package net.Abdymazhit.VimeReplays.replay.data.animations;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.enums.AnimationType;
import net.Abdymazhit.VimeReplays.playing.nms.NMSEntity;
import net.Abdymazhit.VimeReplays.replay.data.customs.RecordingData;

/**
 * Отвечает за запись анимации получения урона
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class DamageData extends RecordingData {

    /** Id entity */
    private short entityId;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public DamageData() { }

    /**
     * Инициализирует запись анимации получения урона
     */
    public DamageData(short entityId) {
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
        output.writeByte(VimeReplays.getSerializationUtils().getId(DamageData.class));
        output.writeShort(entityId);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityId = input.readShort();
    }

    /**
     * Выполняет действия анимации получения урона
     */
    public void performAction() {
        NMSEntity entity = VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(entityId);
        entity.setAnimation(AnimationType.DAMAGE);
    }
}
