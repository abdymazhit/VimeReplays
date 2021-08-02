package net.Abdymazhit.VimeReplays;

import net.Abdymazhit.VimeReplays.enums.RecordingStatus;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Отвечает за работу с API
 *
 * @version   02.08.2021
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
    public static RecordingStatus startRecording(String gameName, String gameType, String mapName, List<Player> players) {
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
        VimeReplays.getRecordingManager().getRecordableEntities().remove(player);
    }
}
