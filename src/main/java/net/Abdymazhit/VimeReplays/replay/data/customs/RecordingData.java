package net.Abdymazhit.VimeReplays.replay.data.customs;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Конструктор создания записи для сериализации
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class RecordingData {

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public RecordingData() { }

    /** Пустая функция записи в файл (нужна для вызова через class.newInstance()) */
    public void write(Output output) { }

    /** Пустая функция чтения записи из файла (нужна для вызова через class.newInstance()) */
    public void read(Input input) { }

    /** Пустая функция выполнения действия записи (нужна для вызова через class.newInstance()) */
    public void performAction() { }
}
