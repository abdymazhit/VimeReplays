package net.Abdymazhit.VimeReplays.replay;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.RecordingData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaySerializer extends Serializer<Replay> {

    public void write(Kryo kryo, Output output, Replay replay) {
        output.writeByte(replay.gameName);
        output.writeByte(replay.gameType);
        output.writeByte(replay.mapName);

        List<String> players = replay.players;
        output.writeByte(players.size());
        for(String playerName : players) {
            output.writeString(playerName);
        }

        Map<Integer, List<RecordingData>> records = replay.records;

        int recordsSize = records.size();
        output.writeVarInt(recordsSize, true);

        for(int tick = 0; tick < recordsSize; tick++) {
            List<RecordingData> tickRecords = records.get(tick);

            int tickRecordsSize = tickRecords.size();
            output.writeVarInt(tickRecordsSize, true);

            for(RecordingData tickRecord : tickRecords) {
                tickRecord.write(output);
            }
        }

        output.flush();
        output.close();
    }

    public Replay read(Kryo kryo, Input input, Class<? extends Replay> type) {
        byte gameName = input.readByte();
        byte gameType = input.readByte();
        byte mapName = input.readByte();

        List<String> players = new ArrayList<>();
        byte playersSize = input.readByte();

        for(int id = 0; id < playersSize; id++) {
            String playerName = input.readString();
            players.add(playerName);
        }

        Map<Integer, List<RecordingData>> records = new HashMap<>();

        int recordsSize = input.readVarInt(true);

        for(int tick = 0; tick < recordsSize; tick++) {
            int tickRecordsSize = input.readVarInt(true);

            List<RecordingData> tickRecords = new ArrayList<>();
            for(int i=0; i<tickRecordsSize; i++) {
                byte dataType = input.readByte();
                try {
                    RecordingData recordingData = (RecordingData) VimeReplays.getSerializationUtils().getData(dataType).newInstance();
                    recordingData.read(input);
                    tickRecords.add(recordingData);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            records.put(tick, tickRecords);
        }
        input.close();

        return new Replay(gameName, gameType, mapName, players, records);
    }
}
