package net.Abdymazhit.VimeReplays.playing.events.cancelled;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.StructureGrowEvent;

public class WorldEventsListener implements Listener {

    // Событие создания портала
    @EventHandler
    public void onPortalCreate(PortalCreateEvent event) {
        event.setCancelled(true);
    }

    // Событие роста саженца, дерева и т.д.
    @EventHandler
    public void onStructureGrow(StructureGrowEvent event) {
        event.setCancelled(true);
    }
}
