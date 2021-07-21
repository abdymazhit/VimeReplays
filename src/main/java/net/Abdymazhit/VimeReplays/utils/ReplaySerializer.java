package net.Abdymazhit.VimeReplays.utils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.replay.Replay;
import net.Abdymazhit.VimeReplays.replay.data.MovingData;
import net.Abdymazhit.VimeReplays.replay.data.RecordingData;
import net.Abdymazhit.VimeReplays.replay.data.SneakingData;
import net.Abdymazhit.VimeReplays.replay.data.UnsneakingData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaySerializer extends Serializer<Replay> {

    public void write(Kryo kryo, Output output, Replay replay) {
        output.writeByte(replay.gameName);
        output.writeByte(replay.gameType);
        output.writeByte(replay.mapName);

        Map<Integer, List<RecordingData>> records = replay.records;

        int recordsSize = records.size();
        output.writeVarInt(recordsSize, true);

        for(int tick = 0; tick < recordsSize; tick++) {
            List<RecordingData> tickRecords = records.get(tick);

            int tickRecordsSize = tickRecords.size();
            output.writeVarInt(tickRecordsSize, true);

            for(RecordingData tickRecord : tickRecords) {
                if(tickRecord instanceof MovingData) {
                    MovingData movingData = (MovingData) tickRecord;
                    output.writeByte((byte) 0);
                    output.writeVarInt(movingData.getEntityId(), true);
                    output.writeVarInt(movingData.getX(), true);
                    output.writeVarInt(movingData.getY(), true);
                    output.writeVarInt(movingData.getZ(), true);
                    output.writeVarInt(movingData.getPitch(), true);
                    output.writeVarInt(movingData.getYaw(), true);
                } else if(tickRecord instanceof SneakingData) {
                    SneakingData sneakingData = (SneakingData) tickRecord;
                    output.writeByte((byte) 1);
                    output.writeVarInt(sneakingData.getEntityId(), true);
                } else if(tickRecord instanceof UnsneakingData) {
                    UnsneakingData unsneakingData = (UnsneakingData) tickRecord;
                    output.writeByte((byte) 2);
                    output.writeVarInt(unsneakingData.getEntityId(), true);
                }
            }
        }

        output.flush();
        output.close();
    }

    public Replay read(Kryo kryo, Input input, Class<? extends Replay> type) {
        byte gameName = input.readByte();
        byte gameType = input.readByte();
        byte mapName = input.readByte();

        Map<Integer, List<RecordingData>> records = new HashMap<>();

        int recordsSize = input.readVarInt(true);

        for(int tick = 0; tick < recordsSize; tick++) {
            int tickRecordsSize = input.readVarInt(true);

            List<RecordingData> tickRecords = new ArrayList<>();
            for(int i=0; i<tickRecordsSize; i++) {
                byte dataType = input.readByte();
                if (dataType == (byte) 0) {
                    int entityId = input.readVarInt(true);
                    int x = input.readVarInt(true);
                    int y = input.readVarInt(true);
                    int z = input.readVarInt(true);
                    int pitch = input.readVarInt(true);
                    int yaw = input.readVarInt(true);

                    tickRecords.add(new MovingData(entityId, x, y, z, pitch, yaw));
                } else if (dataType == (byte) 1) {
                    int entityId = input.readVarInt(true);

                    tickRecords.add(new SneakingData(entityId));
                } else if (dataType == (byte) 2) {
                    int entityId = input.readVarInt(true);

                    tickRecords.add(new UnsneakingData(entityId));
                }
            }

            records.put(tick, tickRecords);
        }
        input.close();

        return new Replay(gameName, gameType, mapName, null, records);
    }
}