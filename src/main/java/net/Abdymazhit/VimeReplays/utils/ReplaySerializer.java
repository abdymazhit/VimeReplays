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
                    output.writeShort(movingData.getEntityId());
                    output.writeShort(movingData.getX());
                    output.writeShort(movingData.getY());
                    output.writeShort(movingData.getZ());
                    output.writeShort(movingData.getPitch());
                    output.writeShort(movingData.getYaw());
                } else if(tickRecord instanceof SneakingData) {
                    SneakingData sneakingData = (SneakingData) tickRecord;
                    output.writeByte((byte) 1);
                    output.writeShort(sneakingData.getEntityId());
                } else if(tickRecord instanceof UnsneakingData) {
                    UnsneakingData unsneakingData = (UnsneakingData) tickRecord;
                    output.writeByte((byte) 2);
                    output.writeShort(unsneakingData.getEntityId());
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
                    short entityId = input.readShort();
                    short x = input.readShort();
                    short y = input.readShort();
                    short z = input.readShort();
                    short pitch = input.readShort();
                    short yaw = input.readShort();

                    tickRecords.add(new MovingData(entityId, x, y, z, pitch, yaw));
                } else if (dataType == (byte) 1) {
                    short entityId = input.readShort();

                    tickRecords.add(new SneakingData(entityId));
                } else if (dataType == (byte) 2) {
                    short entityId = input.readShort();

                    tickRecords.add(new UnsneakingData(entityId));
                }
            }

            records.put(tick, tickRecords);
        }
        input.close();

        return new Replay(gameName, gameType, mapName, null, records);
    }
}