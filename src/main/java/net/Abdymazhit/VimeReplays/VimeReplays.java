package net.Abdymazhit.VimeReplays;

import net.Abdymazhit.VimeReplays.customs.Mode;
import net.Abdymazhit.VimeReplays.playing.PlayingManager;
import net.Abdymazhit.VimeReplays.recording.RecordingManager;
import net.Abdymazhit.VimeReplays.utils.EnchantmentUtils;
import net.Abdymazhit.VimeReplays.utils.FileUtils;
import net.Abdymazhit.VimeReplays.utils.ItemUtils;
import net.Abdymazhit.VimeReplays.utils.LocationUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class VimeReplays extends JavaPlugin {

    private static VimeReplays instance;

    private static PlayingManager playingManager;
    private static RecordingManager recordingManager;

    private static FileUtils fileUtils;
    private static LocationUtils locationUtils;
    private static ItemUtils itemUtils;
    private static EnchantmentUtils enchantmentUtils;

    @Override
    public void onEnable() {
        instance = this;
        Config.load();

        fileUtils = new FileUtils();
        locationUtils = new LocationUtils();
        itemUtils = new ItemUtils();
        enchantmentUtils = new EnchantmentUtils();

        if(Config.mode.equals(Mode.RECORDER)) {
            recordingManager = new RecordingManager();
        } else if(Config.mode.equals(Mode.PLAYER)) {
            playingManager = new PlayingManager("Duels", "Арена");
        }
    }

    @Override
    public void onDisable() {

    }

    public static VimeReplays getInstance() {
        return instance;
    }

    public static RecordingManager getRecordingManager() { return recordingManager; }

    public static PlayingManager getPlayingManager() { return playingManager; }

    public static FileUtils getFileUtils() { return fileUtils; }

    public static LocationUtils getLocationUtils() { return locationUtils; }

    public static ItemUtils getItemUtils() { return itemUtils; }

    public static EnchantmentUtils getEnchantmentUtils() { return enchantmentUtils; }
}
