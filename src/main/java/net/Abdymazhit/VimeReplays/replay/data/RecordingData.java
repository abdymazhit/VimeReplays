package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.Serializable;

/**
 * Конструктор создания записи для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class RecordingData implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    /** Пустой инициализатор (нужен для создания через class.newInstance()) */
    public RecordingData() { }

    /** Пустая функция записи в файл (нужна для вызова через class) */
    public void write(Output output) { }

    /** Пустая функция чтения записи из файла (нужна для вызова через class) */
    public void read(Input input) { }

    /** Пустая функция выполнения действия записи (нужна для вызова через class) */
    public void performAction() { }
}
