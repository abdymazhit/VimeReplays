package net.Abdymazhit.VimeReplays.playing.events.cancelled;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;

public class BlockEventsListener implements Listener {

    // Событие ломания блока игроком
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(true);
    }

    // Событие разрушения блока в результате сожжения огнем
    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        event.setCancelled(true);
    }

    // Событие получения информации можно ли ставить блок
    @EventHandler
    public void onBlockCanBuild(BlockCanBuildEvent event) {
        event.setBuildable(false);
    }

    // Событие на повреждение блока игроком
    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        event.setCancelled(true);
    }

    // Событие выдачи предмета блоком
    @EventHandler
    public void onBlockDispense(BlockDispenseEvent event) {
        event.setCancelled(true);
    }

    // Событие получения опыта блоком
    @EventHandler
    public void onBlockExp(BlockExpEvent event) {
        event.setExpToDrop(0);
    }

    // Событие взрыва блока
    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {
        event.setCancelled(true);
    }

    // Событие исчезения блока мировым условием
    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        event.setCancelled(true);
    }

    // Событие формирования блока мировым условием
    @EventHandler
    public void onBlockForm(BlockFormEvent event) {
        event.setCancelled(true);
    }

    // Событие формирования блока природными событиями
    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {
        event.setCancelled(true);
    }

    // Событие роста блока (пшеница и т.д.)
    @EventHandler
    public void onBlockGrow(BlockGrowEvent event) {
        event.setCancelled(true);
    }

    // Событие воспламенения блока
    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event) {
        event.setCancelled(true);
    }

    // Событие поставки двойного блока (кровать и т.д.)
    @EventHandler
    public void onBlockMultiPlace(BlockMultiPlaceEvent event) {
        event.setCancelled(true);
    }

    // Событие проверки физики блока
    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event) {
        event.setCancelled(true);
    }

    // Событие процесса расширения поршня
    @EventHandler
    public void onBlockPistonExtend(BlockPistonExtendEvent event) {
        event.setCancelled(true);
    }

    // Событие процесса втягивания поршня
    @EventHandler
    public void onBlockPistonRetract(BlockPistonRetractEvent event) {
        event.setCancelled(true);
    }

    // Событие поставки блока игроком
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        event.setCancelled(true);
    }

    // Событие изменения тока redstone
    @EventHandler
    public void onBlockRedstone(BlockRedstoneEvent event) {
        event.setNewCurrent(0);
    }

    // Событие распространения блока на основе мировых условий
    @EventHandler
    public void onBlockSpread(BlockSpreadEvent event) {
        event.setCancelled(true);
    }

    // Событие формирования блока сущностями
    @EventHandler
    public void onEntityBlockForm(EntityBlockFormEvent event) {
        event.setCancelled(true);
    }

    // Событие выпадения листьев
    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent event) {
        event.setCancelled(true);
    }

    // Событие изменения текста в табличке
    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        event.setCancelled(true);
    }
}
