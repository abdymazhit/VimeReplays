package net.Abdymazhit.VimeReplays;

import org.bukkit.entity.Player;

import java.util.List;

public class VimeReplaysAPI {

    public static void startRecording(String gameName, String gameType, String mapName, List<Player> players) {
        VimeReplays.getRecordingManager().startRecording(gameName, gameType, mapName, players);
    }

    public static void stopRecording() {
        VimeReplays.getRecordingManager().stopRecording();
    }

    public static void removeRecordablePlayer(Player player) {
        VimeReplays.getRecordingManager().removeRecordablePlayer(player);
    }
}
