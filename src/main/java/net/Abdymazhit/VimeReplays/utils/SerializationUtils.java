package net.Abdymazhit.VimeReplays.utils;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.replay.data.*;

import java.util.HashMap;
import java.util.Map;

public class SerializationUtils {

    private final Map<Class<?>, Integer> dataTypeId;

    public SerializationUtils() {
        dataTypeId = new HashMap<>();

        dataTypeId.put(AddPlayerData.class, 1);
        dataTypeId.put(RemovePlayerData.class, 2);
        dataTypeId.put(MovingData.class, 3);
        dataTypeId.put(ArmSwingData.class, 4);
        dataTypeId.put(DamageData.class, 5);
        dataTypeId.put(SneakingData.class, 6);
        dataTypeId.put(UnsneakingData.class, 7);
        dataTypeId.put(BlockBreakData.class, 8);
        dataTypeId.put(BlockPlaceData.class, 9);
        dataTypeId.put(EnchantedItemHeldData.class, 10);
        dataTypeId.put(ItemHeldData.class, 11);
        dataTypeId.put(EnchantedHelmetData.class, 12);
        dataTypeId.put(HelmetData.class, 13);
        dataTypeId.put(EnchantedChestplateData.class, 14);
        dataTypeId.put(ChestplateData.class, 15);
        dataTypeId.put(EnchantedLeggingsData.class, 16);
        dataTypeId.put(LeggingsData.class, 17);
        dataTypeId.put(EnchantedBootsData.class, 18);
        dataTypeId.put(BootsData.class, 19);
    }

    public void writeData(RecordingData recordingData, Output output) {
        if(recordingData instanceof AddPlayerData) {
            AddPlayerData data = (AddPlayerData) recordingData;
            data.write(output);
        } else if(recordingData instanceof RemovePlayerData) {
            RemovePlayerData data = (RemovePlayerData) recordingData;
            data.write(output);
        } else if(recordingData instanceof MovingData) {
            MovingData data = (MovingData) recordingData;
            data.write(output);
        } else if(recordingData instanceof ArmSwingData) {
            ArmSwingData data = (ArmSwingData) recordingData;
            data.write(output);
        } else if(recordingData instanceof DamageData) {
            DamageData data = (DamageData) recordingData;
            data.write(output);
        } else if(recordingData instanceof SneakingData) {
            SneakingData data = (SneakingData) recordingData;
            data.write(output);
        } else if(recordingData instanceof UnsneakingData) {
            UnsneakingData data = (UnsneakingData) recordingData;
            data.write(output);
        } else if(recordingData instanceof BlockBreakData) {
            BlockBreakData data = (BlockBreakData) recordingData;
            data.write(output);
        } else if(recordingData instanceof BlockPlaceData) {
            BlockPlaceData data = (BlockPlaceData) recordingData;
            data.write(output);
        } else if(recordingData instanceof EnchantedItemHeldData) {
            EnchantedItemHeldData data = (EnchantedItemHeldData) recordingData;
            data.write(output);
        } else if(recordingData instanceof ItemHeldData) {
            ItemHeldData data = (ItemHeldData) recordingData;
            data.write(output);
        } else if(recordingData instanceof EnchantedHelmetData) {
            EnchantedHelmetData data = (EnchantedHelmetData) recordingData;
            data.write(output);
        } else if(recordingData instanceof HelmetData) {
            HelmetData data = (HelmetData) recordingData;
            data.write(output);
        } else if(recordingData instanceof EnchantedChestplateData) {
            EnchantedChestplateData data = (EnchantedChestplateData) recordingData;
            data.write(output);
        } else if(recordingData instanceof ChestplateData) {
            ChestplateData data = (ChestplateData) recordingData;
            data.write(output);
        } else if(recordingData instanceof EnchantedLeggingsData) {
            EnchantedLeggingsData data = (EnchantedLeggingsData) recordingData;
            data.write(output);
        } else if(recordingData instanceof LeggingsData) {
            LeggingsData data = (LeggingsData) recordingData;
            data.write(output);
        } else if(recordingData instanceof EnchantedBootsData) {
            EnchantedBootsData data = (EnchantedBootsData) recordingData;
            data.write(output);
        } else if(recordingData instanceof BootsData) {
            BootsData data = (BootsData) recordingData;
            data.write(output);
        }
    }

    public RecordingData readData(byte dataType, Input input) {
        Class<?> data = getData(dataType);

        if(data == AddPlayerData.class) {
            return new AddPlayerData(input);
        } else if(data == RemovePlayerData.class) {
            return new RemovePlayerData(input);
        } else if(data == MovingData.class) {
            return new MovingData(input);
        } else if(data == ArmSwingData.class) {
            return new ArmSwingData(input);
        } else if(data == DamageData.class) {
            return new DamageData(input);
        } else if(data == SneakingData.class) {
            return new SneakingData(input);
        } else if(data == UnsneakingData.class) {
            return new UnsneakingData(input);
        } else if(data == BlockBreakData.class) {
            return new BlockBreakData(input);
        } else if(data == BlockPlaceData.class) {
            return new BlockPlaceData(input);
        } else if(data == EnchantedItemHeldData.class) {
            return new EnchantedItemHeldData(input);
        } else if(data == ItemHeldData.class) {
            return new ItemHeldData(input);
        } else if(data == EnchantedHelmetData.class) {
            return new EnchantedHelmetData(input);
        } else if(data == HelmetData.class) {
            return new HelmetData(input);
        } else if(data == EnchantedChestplateData.class) {
            return new EnchantedChestplateData(input);
        } else if(data == ChestplateData.class) {
            return new ChestplateData(input);
        } else if(data == EnchantedLeggingsData.class) {
            return new EnchantedLeggingsData(input);
        } else if(data == LeggingsData.class) {
            return new LeggingsData(input);
        } else if(data == EnchantedBootsData.class) {
            return new EnchantedBootsData(input);
        } else if(data == BootsData.class) {
            return new BootsData(input);
        }

        return null;
    }

    public Integer getId(Class<?> data) {
        return dataTypeId.get(data);
    }

    public Class<?> getData(int id) {
        for(Class<?> c : dataTypeId.keySet()) {
            if(dataTypeId.get(c) == id) {
                return c;
            }
        }
        return null;
    }
}
