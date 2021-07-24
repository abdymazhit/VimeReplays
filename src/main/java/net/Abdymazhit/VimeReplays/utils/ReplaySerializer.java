package net.Abdymazhit.VimeReplays.utils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.replay.Replay;
import net.Abdymazhit.VimeReplays.replay.data.*;

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
                if(tickRecord instanceof MovingData) {
                    MovingData data = (MovingData) tickRecord;
                    output.writeByte( 0);
                    output.writeShort(data.getEntityId());
                    output.writeShort(data.getX());
                    output.writeShort(data.getY());
                    output.writeShort(data.getZ());
                    output.writeShort(data.getYaw());
                    output.writeShort(data.getPitch());
                } else if(tickRecord instanceof SneakingData) {
                    SneakingData data = (SneakingData) tickRecord;
                    output.writeByte( 1);
                    output.writeShort(data.getEntityId());
                } else if(tickRecord instanceof UnsneakingData) {
                    UnsneakingData data = (UnsneakingData) tickRecord;
                    output.writeByte( 2);
                    output.writeShort(data.getEntityId());
                } else if(tickRecord instanceof ItemHeldData) {
                    ItemHeldData data = (ItemHeldData) tickRecord;
                    output.writeByte( 3);
                    output.writeShort(data.getEntityId());
                    output.writeByte(data.getItemId());
                } else if(tickRecord instanceof BlockPlaceData) {
                    BlockPlaceData data = (BlockPlaceData) tickRecord;
                    output.writeByte( 4);
                    output.writeByte(data.getBlockId());
                    output.writeShort(data.getX());
                    output.writeShort(data.getY());
                    output.writeShort(data.getZ());
                } else if(tickRecord instanceof BlockBreakData) {
                    BlockBreakData data = (BlockBreakData) tickRecord;
                    output.writeByte( 5);
                    output.writeByte(data.getBlockId());
                    output.writeShort(data.getX());
                    output.writeShort(data.getY());
                    output.writeShort(data.getZ());
                } else if(tickRecord instanceof ArmSwingData) {
                    ArmSwingData data = (ArmSwingData) tickRecord;
                    output.writeByte( 6);
                    output.writeShort(data.getEntityId());
                } else if(tickRecord instanceof AddPlayerData) {
                    AddPlayerData data = (AddPlayerData) tickRecord;
                    output.writeByte( 7);
                    output.writeShort(data.getEntityId());
                    output.writeShort(data.getX());
                    output.writeShort(data.getY());
                    output.writeShort(data.getZ());
                    output.writeShort(data.getYaw());
                    output.writeShort(data.getPitch());
                } else if(tickRecord instanceof RemovePlayerData) {
                    RemovePlayerData data = (RemovePlayerData) tickRecord;
                    output.writeByte( 8);
                    output.writeShort(data.getEntityId());
                } else if(tickRecord instanceof DamageData) {
                    DamageData data = (DamageData) tickRecord;
                    output.writeByte( 9);
                    output.writeShort(data.getEntityId());
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
                if (dataType ==  0) {
                    short entityId = input.readShort();
                    short x = input.readShort();
                    short y = input.readShort();
                    short z = input.readShort();
                    short yaw = input.readShort();
                    short pitch = input.readShort();

                    tickRecords.add(new MovingData(entityId, x, y, z, yaw, pitch));
                } else if (dataType ==  1) {
                    short entityId = input.readShort();

                    tickRecords.add(new SneakingData(entityId));
                } else if (dataType ==  2) {
                    short entityId = input.readShort();

                    tickRecords.add(new UnsneakingData(entityId));
                } else if (dataType ==  3) {
                    short entityId = input.readShort();
                    byte itemId = input.readByte();

                    tickRecords.add(new ItemHeldData(entityId, itemId));
                } else if (dataType ==  4) {
                    byte blockId = input.readByte();
                    short x = input.readByte();
                    short y = input.readByte();
                    short z = input.readByte();

                    tickRecords.add(new BlockPlaceData(blockId, x, y, z));
                } else if (dataType ==  5) {
                    byte blockId = input.readByte();
                    short x = input.readByte();
                    short y = input.readByte();
                    short z = input.readByte();

                    tickRecords.add(new BlockBreakData(blockId, x, y, z));
                } else if (dataType ==  6) {
                    short entityId = input.readShort();

                    tickRecords.add(new ArmSwingData(entityId));
                } else if (dataType ==  7) {
                    short entityId = input.readShort();
                    short x = input.readShort();
                    short y = input.readShort();
                    short z = input.readShort();
                    short yaw = input.readShort();
                    short pitch = input.readShort();

                    tickRecords.add(new AddPlayerData(entityId, x, y, z, yaw, pitch));
                } else if (dataType ==  8) {
                    short entityId = input.readShort();

                    tickRecords.add(new RemovePlayerData(entityId));
                } else if (dataType ==  9) {
                    short entityId = input.readShort();

                    tickRecords.add(new DamageData(entityId));
                }
            }

            records.put(tick, tickRecords);
        }
        input.close();

        return new Replay(gameName, gameType, mapName, players, records);
    }
}
