package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.customs.EquipmentType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class EquipmentDispatcher implements Listener {

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();

        if(VimeReplays.getRecordingManager().getRecordablePlayers().contains(player)) {
            VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.HAND, player.getInventory().getItem(event.getNewSlot()));
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            checkEquipment(player);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        checkEquipment(player);
    }

    @EventHandler
    public void onPlayerItemBreak(PlayerItemBreakEvent event) {
        Player player = event.getPlayer();
        checkEquipment(player);
    }

    private void checkEquipment(Player player) {
        VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.HELMET, player.getInventory().getHelmet());
        VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.CHESTPLATE, player.getInventory().getChestplate());
        VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.LEGGINGS, player.getInventory().getLeggings());
        VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.BOOTS, player.getInventory().getBoots());
    }
}
