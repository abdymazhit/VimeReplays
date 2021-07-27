package net.Abdymazhit.VimeReplays.recording.dispatchers.ticks;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.MovingData;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Диспетчер обработки движений игрока
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class MovingDispatcher extends BukkitRunnable {

    /**
     * Каждый тик проверяет движения игроков и отправляет запись о движений
     */
    @Override
    public void run() {
        for(Player player : VimeReplays.getRecordingManager().getRecordablePlayers()) {
            short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());

            short x = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getX());
            short y = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getY());
            short z = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getZ());
            short yaw = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getYaw());
            short pitch = VimeReplays.getLocationUtils().getLocationShort(player.getLocation().getPitch());

            VimeReplays.getRecordingManager().getMainDispatcher().sendMovingData(new MovingData(playerId, x, y, z, yaw, pitch));
        }
    }
}
