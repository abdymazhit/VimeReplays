package net.Abdymazhit.VimeReplays.dispatcher.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.BlockBreakData;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakDispatcher implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
            if(!event.isCancelled()) {
                Block block = event.getBlock();
                VimeReplays.getRecordingTools().addRecordingData(new BlockBreakData((byte) block.getTypeId(), (short) block.getX(), (short) block.getY(), (short) block.getZ()));
            }
        }
    }
}
