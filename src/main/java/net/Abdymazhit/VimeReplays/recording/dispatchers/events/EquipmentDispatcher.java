package net.Abdymazhit.VimeReplays.recording.dispatchers.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.enums.EquipmentType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;

/**
 * Диспетчер обработки экипировки entity
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class EquipmentDispatcher implements Listener {

    /**
     * Событие изменения предмета в руке игрока
     */
    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();

        if(VimeReplays.getRecordingManager().getRecordableEntities().contains(player)) {
            VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.HAND, player.getInventory().getItem(event.getNewSlot()));
        }
    }

    /**
     * Событие нажатия по слоту инвентаря
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            sendEquipmentData(player);
        }
    }

    /**
     * Событие взаимодействия игрока с предметом
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        sendEquipmentData(player);
    }

    /**
     * Событие ломания предмета игрока
     */
    @EventHandler
    public void onPlayerItemBreak(PlayerItemBreakEvent event) {
        Player player = event.getPlayer();
        sendEquipmentData(player);
    }

    /**
     * Отправляет запись о экипировке entity
     */
    private void sendEquipmentData(Player player) {
        VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.HELMET, player.getInventory().getHelmet());
        VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.CHESTPLATE, player.getInventory().getChestplate());
        VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.LEGGINGS, player.getInventory().getLeggings());
        VimeReplays.getRecordingManager().getMainDispatcher().addItemData(player, EquipmentType.BOOTS, player.getInventory().getBoots());
    }
}
