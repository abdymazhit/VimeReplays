package net.Abdymazhit.VimeReplays.customs;

/**
 * Конструктор создания предмета для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class Item {

    /** Значение data предмета */
    private final int data;

    /**
     * Создает предмет по его data
     */
    public Item(int data) {
        this.data = data;
    }

    /**
     * Возвращает значение data предмета
     */
    public int getData() {
        return data;
    }
}
