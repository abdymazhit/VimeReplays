package net.Abdymazhit.VimeReplays.recording.dispatchers.ticks;

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
            short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());

            short x = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getX());
            short y = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getY());
            short z = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getZ());
            short yaw = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getYaw());
            short pitch = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getPitch());

            MovingData movingData = new MovingData(playerId, x, y, z, yaw, pitch);

            if(playerLastLocation == null) {
                playerLastLocation = new HashMap<>();
            }

            if(playerLastLocation.containsKey(playerId)) {
                MovingData lastMovingData = playerLastLocation.get(playerId);

                if(lastMovingData.getX() != x || lastMovingData.getY() != y || lastMovingData.getZ() != z || lastMovingData.getYaw() != yaw || lastMovingData.getPitch() != pitch) {
                    playerLastLocation.put(playerId, movingData);
                    VimeReplays.getRecordingManager().addRecordingData(movingData);
                }
            } else {
                playerLastLocation.put(playerId, movingData);
                VimeReplays.getRecordingManager().addRecordingData(movingData);
            }
        }
    }
}
