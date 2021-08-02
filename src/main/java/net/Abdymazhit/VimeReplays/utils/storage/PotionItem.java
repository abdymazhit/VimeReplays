package net.Abdymazhit.VimeReplays.utils.storage;

/**
 * Конструктор создания зелья для сериализации
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
class PotionItem extends Item {

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