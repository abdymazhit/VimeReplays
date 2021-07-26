package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

public class EquipmentDispatcher implements Listener {

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
        ItemStack helmet = player.getInventory().getHelmet();
        if(helmet != null) {
            VimeReplays.getRecordingManager().getMainDispatcher().sendHelmetData(player, helmet);
        } else {
            VimeReplays.getRecordingManager().getMainDispatcher().sendHelmetData(player, new ItemStack(Material.AIR));
        }

        ItemStack chestplate = player.getInventory().getChestplate();
        if(chestplate != null) {
            VimeReplays.getRecordingManager().getMainDispatcher().sendChestplateData(player, chestplate);
        } else {
            VimeReplays.getRecordingManager().getMainDispatcher().sendChestplateData(player, new ItemStack(Material.AIR));
        }

        ItemStack leggings = player.getInventory().getLeggings();
        if(leggings != null) {
            VimeReplays.getRecordingManager().getMainDispatcher().sendLeggingsData(player, leggings);
        } else {
            VimeReplays.getRecordingManager().getMainDispatcher().sendLeggingsData(player, new ItemStack(Material.AIR));
        }

        ItemStack boots = player.getInventory().getBoots();
        if(boots != null) {
            VimeReplays.getRecordingManager().getMainDispatcher().sendBootsData(player, boots);
        } else {
            VimeReplays.getRecordingManager().getMainDispatcher().sendBootsData(player, new ItemStack(Material.AIR));
        }
    }
}
