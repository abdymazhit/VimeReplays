package net.Abdymazhit.VimeReplays.playing.events;

import net.Abdymazhit.VimeReplays.VimeReplays;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PlayerJoinEventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(Bukkit.getOnlinePlayers().size() > 1) {
            player.kickPlayer("Ошибка подключения! Сервер занят другим игроком!");
        } else {
            VimeReplays.getPlayingManager().getPlayingHandler().setPlayer(player);

            Location spawn = Bukkit.getWorld("replayMap").getSpawnLocation();
            player.teleport(spawn);

            player.setExp(0);
            player.setLevel(0);
            player.setFireTicks(0);
            player.setMaxHealth(20.0);
            player.setHealth(20.0);
            player.setFoodLevel(20);
            player.setSaturation(10);

            player.setGameMode(GameMode.ADVENTURE);

            player.setAllowFlight(true);
            player.setFlying(true);
            player.setFlySpeed(0.1f);

            addToTabList(player);

            VimeReplays.getPlayingManager().getPlayingItems().giveItems(player);

            VimeReplays.getPlayingManager().getPlayingHandler().performFirstTickActions();
        }
    }

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
