package net.Abdymazhit.VimeReplays;

import net.Abdymazhit.VimeReplays.enums.Mode;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Отвечает за работу с config файлом
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class Config {

    /** Базовый класс для работы с config файлом */
    private static FileConfiguration config;

    /** Режим работы плагина */
    public static Mode mode;

    /**
     * Загружает данные с config файла
     */
    public static void load() {
        config = VimeReplays.getInstance().getConfig();
        config.options().copyDefaults(true);
        VimeReplays.getInstance().saveConfig();

        String mode = config.getString("mode");
        if(mode.equals("RECORDER")) {
            Config.mode = Mode.RECORDER;
        } else if(mode.equals("PLAYER")) {
            Config.mode = Mode.PLAYER;
        } else {
            throw new IllegalArgumentException("Ошибка режима плагина. Установите mode на RECORDER или PLAYER в config.yml");
        }
    }

    /**
     * Возвращает id игры по названию игры
     */
    public static byte getGameNameIdByString(String gameName) {
        return (byte) config.getInt("games." + gameName);
    }

    /**
     * Возвращает id типа игры по названию типа игры
     */
    public static byte getGameTypeIdByString(String gameType) {
        return (byte) config.getInt("modes." + gameType);
    }

    /**
     * Возвращает id карты по названию карты
     */
    public static byte getMapNameIdByString(String mapName) {
        return (byte) config.getInt("maps." + mapName);
    }
}
