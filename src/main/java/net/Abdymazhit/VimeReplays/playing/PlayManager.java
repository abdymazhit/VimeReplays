package net.Abdymazhit.VimeReplays.playing;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.File;

public class PlayManager {

    public PlayManager() {
        File worldFolder = new File(Bukkit.getWorldContainer() + "/replayMap/");
        deleteDir(worldFolder);

        WorldCreator wc = new WorldCreator("replayMap");
        wc.environment(World.Environment.NORMAL);
        Bukkit.createWorld(wc);
    }

    private void deleteDir(File dirFile) {
        if (dirFile.isDirectory()) {
            File[] dirs = dirFile.listFiles();
            if(dirs != null) {
                for (File dir: dirs) {
                    deleteDir(dir);
                }
            }
        }

        if(dirFile.delete()) {
            System.out.println(Bukkit.getWorldContainer() + "/replayMap/ был успешно удален");
        }
    }
}
