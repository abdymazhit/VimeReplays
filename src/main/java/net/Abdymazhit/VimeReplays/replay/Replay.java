package net.Abdymazhit.VimeReplays.replay;

import net.Abdymazhit.VimeReplays.replay.data.RecordingData;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Конструктор создания записи игры для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class Replay implements Serializable {

    /** Uid сериализации */
    private static final long serialVersionUID = 1L;

    /** Id названия игры */
    public byte gameName;

    /** Id названия режима игры */
    public byte gameType;

    /** Id названия карты */
    public byte mapName;

    /** Список записываемых игроков */
    public List<String> players;

    /** Хранит информацию о тике и записях в тике */
    public Map<Integer, List<RecordingData>> records;

    /**
     * Инициализирует запись игры
     */
    public Replay(byte gameName, byte gameType, byte mapName, List<String> players, Map<Integer, List<RecordingData>> records) {
        this.gameName = gameName;
        this.gameType = gameType;
        this.mapName = mapName;
        this.players = players;
        this.records = records;
    }
}
