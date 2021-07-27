package net.Abdymazhit.VimeReplays.playing.events.cancelled;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

/**
 * Отменяет события связанные с игроком
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class PlayerEventsListener implements Listener {

    /**
     * Событие получения достижения
     */
    @EventHandler
    public void onPlayerAchievementAwarded(PlayerAchievementAwardedEvent event) {
        event.setCancelled(true);
    }

    /**
     * Событие взаимодействия с подставкой для брони
     */
    @EventHandler
    public void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent event) {
        event.setCancelled(true);
    }

    /**
     * Событие взаимодействия с кроватью
     */
    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        event.setCancelled(true);
    }

    /**
     * Событие выкидывания предмета
     */
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    /**
     * Событие изменения уровня
     */
    @EventHandler
    public void PlayerExpChangeEvent(PlayerExpChangeEvent event) {
        event.setAmount(0);
    }

    /**
     * Событие поднятия предмета
     */
    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        event.setCancelled(true);
    }

    /**
     * Событие телепортации через портал
     */
    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent event) {
        event.setCancelled(true);
    }

    /**
     * Событие увеличения статистики игрока
     */
    @EventHandler
    public void PlayerStatisticIncrementEvent(PlayerStatisticIncrementEvent event) {
        event.setCancelled(true);
    }
}
