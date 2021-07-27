package net.Abdymazhit.VimeReplays.customs;

/**
 * Конструктор создания зелья для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class PotionItem extends Item {

    /** Значение, является ли зелье взрывным */
    private final boolean isSplash;

    /**
     * Создает зелье по его data и значению
     */
    public PotionItem(int data, boolean isSplash) {
        super(data);
        this.isSplash = isSplash;
    }

    /**
     * Возвращает значение, является ли зелье взрывным
     */
    public boolean isSplash() {
        return isSplash;
    }
}
