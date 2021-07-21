package net.Abdymazhit.VimeReplays.dispatcher.ticks;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.MovingData;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class MovingDispatcher extends BukkitRunnable {

    private Map<Integer, MovingData> playerLastLocation;

    @Override
    public void run() {
        for(Player player : VimeReplays.getRecordingManager().getRecordablePlayers()) {
            int x = Integer.parseInt(String.format("%.2f", player.getLocation().getX()).replace(",", ""));
            int y = Integer.parseInt(String.format("%.2f", player.getLocation().getY()).replace(",", ""));
            int z = Integer.parseInt(String.format("%.2f", player.getLocation().getZ()).replace(",", ""));
            int pitch = Integer.parseInt(String.format("%.2f", player.getLocation().getPitch()).replace(",", ""));
            int yaw = Integer.parseInt(String.format("%.2f", player.getLocation().getYaw()).replace(",", ""));

            int playerId = VimeReplays.getRecordingTools().getPlayerId(player.getName());
            MovingData movingData = new MovingData(playerId, x, y, z, pitch, yaw);

            if(playerLastLocation == null) {
                playerLastLocation = new HashMap<>();
            }

            if(playerLastLocation.containsKey(playerId)) {
                MovingData lastMovingData = playerLastLocation.get(playerId);

                if(lastMovingData.getX() != x || lastMovingData.getY() != y || lastMovingData.getZ() != z || lastMovingData.getPitch() != pitch || lastMovingData.getYaw() != yaw) {
                    playerLastLocation.put(playerId, movingData);
                    VimeReplays.getRecordingTools().addRecordingData(movingData);
                }
            } else {
                playerLastLocation.put(playerId, movingData);
                VimeReplays.getRecordingTools().addRecordingData(movingData);
            }
        }
    }
}