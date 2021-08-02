package net.Abdymazhit.VimeReplays;

import net.Abdymazhit.VimeReplays.enums.Mode;
import net.Abdymazhit.VimeReplays.playing.PlayingManager;
import net.Abdymazhit.VimeReplays.recording.RecordingManager;
import net.Abdymazhit.VimeReplays.utils.FileUtils;
import net.Abdymazhit.VimeReplays.utils.LocationUtils;
import net.Abdymazhit.VimeReplays.utils.SerializationUtils;
import net.Abdymazhit.VimeReplays.utils.storage.EnchantmentUtils;
import net.Abdymazhit.VimeReplays.utils.storage.EntityUtils;
import net.Abdymazhit.VimeReplays.utils.storage.ItemUtils;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Главный класс, отвечает за весь плагин
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class VimeReplays extends JavaPlugin {

    /** Экземпляр плагина */
    private static VimeReplays instance;

    /** Менеджер, отвечает за запись игры */
    private static RecordingManager recordingManager;

    /** Менеджер, отвечает за воспроизведение игры */
    private static PlayingManager playingManager;

    /** Утилита для работы с файлами плагина */
    private static FileUtils fileUtils;

    /** Утилита для работы с сериализируемыми данными */
    private static SerializationUtils serializationUtils;

    /** Утилита для работы с местоположениями */
    private static LocationUtils locationUtils;

    /** Хранилище id предметов */
    private static ItemUtils itemUtils;

    /** Хранилище id entity */
    private static EntityUtils entityUtils;

    /** Хранилище id зачарований */
    private static EnchantmentUtils enchantmentUtils;

    /**
     * Событие включения плагина
     * Инициализирует нужные объекты для работы плагина
     */
    @Override
    public void onEnable() {
        instance = this;
        Config.load();

        fileUtils = new FileUtils();
        serializationUtils = new SerializationUtils();
        locationUtils = new LocationUtils();
        itemUtils = new ItemUtils();
        entityUtils = new EntityUtils();
        enchantmentUtils = new EnchantmentUtils();

        if(Config.mode.equals(Mode.RECORDER)) {
            recordingManager = new RecordingManager();
        } else if(Config.mode.equals(Mode.PLAYER)) {
            playingManager = new PlayingManager("Duels", "Арена");
        }
    }

    /**
     * Событие выключения плагина
     */
    @Override
    public void onDisable() {

    }

    /**
     * Возвращает экземпляр плагина
     */
    public static VimeReplays getInstance() {
        return instance;
    }

    /**
     * Возвращает менеджер, отвечающий за запись игры
     */
    public static RecordingManager getRecordingManager() {
        return recordingManager;
    }

    /**
     * Возвращает менеджер, отвечающий за воспроизведение игры
     */
    public static PlayingManager getPlayingManager() {
        return playingManager;
    }

    /**
     * Возвращает утилиту для работы с файлами плагина
     */
    public static FileUtils getFileUtils() {
        return fileUtils;
    }

    /**
     * Возвращает утилиту для работы с сериализируемыми данными
     */
    public static SerializationUtils getSerializationUtils() {
        return serializationUtils;
    }

    /**
     * Возвращает утилиту для работы с местоположениями
     */
    public static LocationUtils getLocationUtils() {
        return locationUtils;
    }

    /**
     * Возвращает хранилище id предметов
     */
    public static ItemUtils getItemUtils() {
        return itemUtils;
    }

    /**
     * Возвращает хранилище id entity
     */
    public static EntityUtils getEntityUtils() {
        return entityUtils;
    }

    /**
     * Возвращает хранилище id зачарований
     */
    public static EnchantmentUtils getEnchantmentUtils() {
        return enchantmentUtils;
    }
}
