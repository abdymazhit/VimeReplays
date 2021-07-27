package net.Abdymazhit.VimeReplays.playing.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Отвечает за взаимодействие игрока с предметами воспроизведения
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class PlayerInteractEventListener implements Listener {

    /**
     * Событие взаимодействия игрока с предметом
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Проверка, является ли взаимодействие правым кликом по блоку или воздуху
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            // Проверка, существует ли предмет в руке игрока
            if (event.getItem() != null) {
                // Выполнить действия связанные с предметом воспроизведения
                VimeReplays.getPlayingManager().getPlayingItems().performClickAction(event.getItem());
            }
        }
    }
}
