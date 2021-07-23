package net.Abdymazhit.VimeReplays;

import net.Abdymazhit.VimeReplays.customs.Mode;
import net.Abdymazhit.VimeReplays.playing.PlayManager;
import net.Abdymazhit.VimeReplays.recording.RecordingManager;
import net.Abdymazhit.VimeReplays.utils.FileUtils;
import net.Abdymazhit.VimeReplays.utils.ItemStorage;
import org.bukkit.plugin.java.JavaPlugin;

public class VimeReplays extends JavaPlugin {

    private static VimeReplays instance;

    private static PlayManager playManager;
    private static RecordingManager recordingManager;
    private static FileUtils fileUtils;
    private static ItemStorage itemStorage;

    @Override
    public void onEnable() {
        instance = this;
        Config.load();

        fileUtils = new FileUtils();
        itemStorage = new ItemStorage();

        if(Config.mode.equals(Mode.RECORDER)) {
            recordingManager = new RecordingManager();
        } else if(Config.mode.equals(Mode.PLAYER)) {
            playManager = new PlayManager();
        }
    }

    @Override
    public void onDisable() {

    }

    public static VimeReplays getInstance() {
        return instance;
    }

    public static RecordingManager getRecordingManager() { return recordingManager; }

    public static PlayManager getPlayManager() { return playManager; }

    public static FileUtils getFileUtils() { return fileUtils; }

    public static ItemStorage getItemStorage() { return itemStorage; }
}