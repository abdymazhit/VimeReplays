package net.Abdymazhit.VimeReplays.dispatcher.ticks;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.MovingData;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class MovingDispatcher extends BukkitRunnable {

    private Map<Short, MovingData> playerLastLocation;

    @Override
    public void run() {
        for(Player player : VimeReplays.getRecordingManager().getRecordablePlayers()) {
            short playerId = VimeReplays.getRecordingTools().getPlayerId(player.getName());

            short x = Short.parseShort(String.format("%.2f", player.getLocation().getX()).replace(",", ""));
            short y = Short.parseShort(String.format("%.2f", player.getLocation().getY()).replace(",", ""));
            short z = Short.parseShort(String.format("%.2f", player.getLocation().getZ()).replace(",", ""));

            double pitchRadian = Math.toRadians(player.getLocation().getPitch());
            short pitch = (short) (pitchRadian * 160);

            double yawRadian = Math.toRadians(player.getLocation().getYaw());
            short yaw = (short) (yawRadian * 160);

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