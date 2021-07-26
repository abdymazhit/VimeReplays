package net.Abdymazhit.VimeReplays.playing.events.cancelled;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;

public class InventoryEventsListener implements Listener {

    // Событие плавления предмета в печке
    @EventHandler
    public void onFurnaceBurn(FurnaceBurnEvent event) {
        event.setCancelled(true);
    }

    // Событие извлечения предмета с печки
    @EventHandler
    public void onFurnaceExtract(FurnaceExtractEvent event) {
        event.setExpToDrop(0);
    }

    // Событие плавки предмета в печке
    @EventHandler
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {
        event.setCancelled(true);
    }

    // Событие перетаскивания предмета в инвентаре
    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        event.setCancelled(true);
    }

    // Событие клика по инвентарю
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    // Событие поднятия предмета инвентарём (хоппер)
    @EventHandler
    public void onInventoryPickupItem(InventoryPickupItemEvent event) {
        event.setCancelled(true);
    }
}
