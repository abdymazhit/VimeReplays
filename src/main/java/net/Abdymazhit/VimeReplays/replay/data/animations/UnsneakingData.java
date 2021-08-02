package net.Abdymazhit.VimeReplays.replay.data.animations;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.playing.nms.NMSPlayer;
import net.Abdymazhit.VimeReplays.replay.data.customs.RecordingData;

/**
 * Отвечает за запись анимации отжатия подкрадывания игрока
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class UnsneakingData extends RecordingData {

    /** Id игрока */
    private short entityId;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public UnsneakingData() { }

    /**
     * Инициализирует запись анимации отжатия подкрадывания игрока
     */
    public UnsneakingData(short entityId) {
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
        output.writeByte(VimeReplays.getSerializationUtils().getId(UnsneakingData.class));
        output.writeShort(entityId);
    }

    /**
     * Читает запись из файла (десериализация)
     */
    public void read(Input input) {
        entityId = input.readShort();
    }

    /**
     * Выполняет действия анимации отжатия подкрадывания игрока
     */
    public void performAction() {
        NMSPlayer entity = (NMSPlayer) VimeReplays.getPlayingManager().getPlayingHandler().getEntityList().get(getEntityId());
        entity.setSneaking(false);
    }
}
