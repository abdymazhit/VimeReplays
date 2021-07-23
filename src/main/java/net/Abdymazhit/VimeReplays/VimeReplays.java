package net.Abdymazhit.VimeReplays;

import net.Abdymazhit.VimeReplays.customs.Mode;
import net.Abdymazhit.VimeReplays.managers.RecordingManager;
import net.Abdymazhit.VimeReplays.utils.FileUtils;
import net.Abdymazhit.VimeReplays.utils.ItemStorage;
import net.Abdymazhit.VimeReplays.utils.RecordingTools;
import org.bukkit.plugin.java.JavaPlugin;

public class VimeReplays extends JavaPlugin {

    private static VimeReplays instance;

    private static RecordingManager recordingManager;
    private static RecordingTools recordingTools;
    private static FileUtils fileUtils;
    private static ItemStorage itemStorage;

    @Override
    public void onEnable() {
        instance = this;
        Config.load();

        if(Config.mode.equals(Mode.RECORDER)) {
            recordingManager = new RecordingManager();
            recordingTools = new RecordingTools();
            fileUtils = new FileUtils();
            itemStorage = new ItemStorage();
        } else if(Config.mode.equals(Mode.PLAYER)) {

        }
    }

    @Override
    public void onDisable() {

    }

    public static VimeReplays getInstance() {
        return instance;
    }

    public static RecordingManager getRecordingManager() { return recordingManager; }

    public static RecordingTools getRecordingTools() { return recordingTools; }

    public static FileUtils getFileUtils() { return fileUtils; }

    public static ItemStorage getItemStorage() { return itemStorage; }
}