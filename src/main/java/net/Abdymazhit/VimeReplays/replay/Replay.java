package net.Abdymazhit.VimeReplays.replay;

import net.Abdymazhit.VimeReplays.replay.data.RecordingData;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Replay implements Serializable {

    private static final long serialVersionUID = 1L;

    public byte gameName;
    public byte gameType;
    public byte mapName;

    public List<String> players;
    public Map<Integer, List<RecordingData>> records;

    public Replay(byte gameName, byte gameType, byte mapName, List<String> players, Map<Integer, List<RecordingData>> records) {
        this.gameName = gameName;
        this.gameType = gameType;
        this.mapName = mapName;
        this.players = players;
        this.records = records;
    }
}
