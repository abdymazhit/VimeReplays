package net.Abdymazhit.VimeReplays.replay.data.animations;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.enums.AnimationType;
import net.Abdymazhit.VimeReplays.playing.nms.NMSEntity;
import net.Abdymazhit.VimeReplays.replay.data.customs.RecordingData;

/**
 * Отвечает за запись анимации взмаха руки игрока
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class ArmSwingData extends RecordingData {

    /** Id игрока */
    private short entityId;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public ArmSwingData() { }

    /**
     * Инициализирует запись анимации взмаха руки игрока
     */
    public ArmSwingData(short entityId) {
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
        output.writeByte(VimeReplays.getSerializationUtils().getId(ArmSwingData.class));
        output.writeShort(entityId);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityId = input.readShort();
    }

    /**
     * Выполняет действия анимации взмаха руки игрока
     */
    public void performAction() {
        NMSEntity entity = VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(getEntityId());
        entity.setAnimation(AnimationType.ARM_SWING);
    }
}
