package net.Abdymazhit.VimeReplays;

import net.Abdymazhit.VimeReplays.customs.StatusCode;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Отвечает за работу с API
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class VimeReplaysAPI {

    /**
     * Начинает запись игры и возвращает статус кода записи
     * @param gameName название игры
     * @param gameType название типа игры
     * @param mapName название карты
     * @param players начальный список записываемых игроков
     */
    public static StatusCode startRecording(String gameName, String gameType, String mapName, List<Player> players) {
        return VimeReplays.getRecordingManager().startRecording(gameName, gameType, mapName, players);
    }

    /**
     * Останавливает запись игры
     */
    public static void stopRecording() {
        VimeReplays.getRecordingManager().stopRecording();
    }

    /**
     * Удаляет записываемого игрока
     * @param player записываемый игрок
     */
    public static void removeRecordablePlayer(Player player) {
        VimeReplays.getRecordingManager().removeRecordablePlayer(player);
    }
}
