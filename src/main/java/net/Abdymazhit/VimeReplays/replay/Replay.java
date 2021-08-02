package net.Abdymazhit.VimeReplays.replay;

import net.Abdymazhit.VimeReplays.replay.data.customs.RecordingData;

import java.util.List;
import java.util.Map;

/**
 * Конструктор создания записи игры для сериализации
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class Replay {

    /** Id названия игры */
    public byte gameName;

    /** Id названия режима игры */
    public byte gameType;

    /** Id названия карты */
    public byte mapName;

    /** Хранит информацию о тике и записях в тике */
    public Map<Integer, List<RecordingData>> records;

    /** Хранит информацию о имени игрока по id */
    public Map<Short, String> players;

    /**
     * Инициализирует запись игры
     */
    public Replay(byte gameName, byte gameType, byte mapName, Map<Integer, List<RecordingData>> records, Map<Short, String> players) {
        this.gameName = gameName;
        this.gameType = gameType;
        this.mapName = mapName;
        this.records = records;
        this.players = players;
    }
}
