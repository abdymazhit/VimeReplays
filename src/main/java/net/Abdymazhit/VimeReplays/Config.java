package net.Abdymazhit.VimeReplays;

import net.Abdymazhit.VimeReplays.customs.Mode;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private static FileConfiguration config;

    public static Mode mode;

    public static void load() {
        config = VimeReplays.getInstance().getConfig();
        config.options().copyDefaults(true);
        VimeReplays.getInstance().saveConfig();

        String mode = config.getString("mode");
        if(mode.equals("RECORDER")) {
            Config.mode = Mode.RECORDER;
        } else if(mode.equals("PLAYER]")) {
            Config.mode = Mode.PLAYER;
        } else {
            throw new IllegalArgumentException("Ошибка режима плагина. Установите mode на RECORDER или PLAYER режим в plugin.yml");
        }
    }

    public static byte getGameNameIdByString(String gameName) {
        return (byte) config.getInt("games." + gameName);
    }

    public static byte getGameTypeIdByString(String gameType) {
        return (byte) config.getInt("modes." + gameType);
    }

    public static byte getMapNameIdByString(String mapName) {
        return (byte) config.getInt("maps." + mapName);
    }
}