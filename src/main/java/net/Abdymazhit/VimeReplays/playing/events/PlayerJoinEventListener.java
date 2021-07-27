package net.Abdymazhit.VimeReplays.playing.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/**
 * Отвечает за присоединение зрителя к воспроизведению игры
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class PlayerJoinEventListener implements Listener {

    /**
     * Событие присоединения игрока
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Выгнать игрока с сервера, если уже есть зритель, который уже пересматривает игру
        if(Bukkit.getOnlinePlayers().size() > 1) {
            player.kickPlayer("Ошибка подключения! Сервер занят другим игроком!");
        } else {
            // Установить игрока зрителем воспроизведения игры
            VimeReplays.getPlayingManager().getPlayingHandler().setViewer(player);

            // Телепортировать игрока в мир воспроизведения
            player.teleport(Bukkit.getWorld("replayMap").getSpawnLocation());

            // Очистить все негативные эффекты, установить здоровье и сытость игрока на максимум
            player.setExp(0);
            player.setLevel(0);
            player.setFireTicks(0);
            player.setMaxHealth(20.0);
            player.setHealth(20.0);
            player.setFoodLevel(20);
            player.setSaturation(10);

            // Установить режим игрока на ADVENTURE
            player.setGameMode(GameMode.ADVENTURE);

            // Выдать игроку доступ к полету
            player.setAllowFlight(true);
            player.setFlying(true);
            player.setFlySpeed(0.1f);

            // Добавить игрока в список таба зрителем
            addToTabList(player);

            // Выдать игроку предметы для воспроизведения игры
            VimeReplays.getPlayingManager().getPlayingItems().giveItems(player);

            // Выполнить действия первого тика (добавить NPC, чтобы игрок сразу видел их)
            VimeReplays.getPlayingManager().getPlayingHandler().performFirstTickActions();
        }
    }

    /**
     * Добавляет игрока в список таба зрителем
     */
    private void addToTabList(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team team = scoreboard.getTeam(player.getName());
        if(team == null) {
            team = scoreboard.registerNewTeam(player.getName());
        }
        team.setPrefix("§7");
        team.setSuffix(" [ЗРИТЕЛЬ]");
        team.addPlayer(player);
    }
}
