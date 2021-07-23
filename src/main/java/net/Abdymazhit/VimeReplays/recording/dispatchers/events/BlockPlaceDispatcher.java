package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.BlockPlaceData;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceDispatcher implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
            if(!event.isCancelled()) {
                Block block = event.getBlock();
                VimeReplays.getRecordingManager().addRecordingData(new BlockPlaceData((byte) block.getTypeId(), (short) block.getX(), (short) block.getY(), (short) block.getZ()));
            }
        }
    }
}
