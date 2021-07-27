package net.Abdymazhit.VimeReplays.utils;

import net.Abdymazhit.VimeReplays.replay.data.*;
import net.Abdymazhit.VimeReplays.replay.data.equipment.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Отвечает за хранение id записываемых данных для сериализации
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class SerializationUtils {

    /** Хранит id класса записываемых данных */
    private final Map<Class<?>, Integer> dataTypeId;

    /**
     * Добавляет записываемые данные с их id
     */
    public SerializationUtils() {
        dataTypeId = new HashMap<>();

        dataTypeId.put(AddPlayerData.class, 1);
        dataTypeId.put(RemovePlayerData.class, 2);
        dataTypeId.put(MovingData.class, 3);
        dataTypeId.put(ArmSwingData.class, 4);
        dataTypeId.put(DamageData.class, 5);
        dataTypeId.put(SneakingData.class, 6);
        dataTypeId.put(UnsneakingData.class, 7);
        dataTypeId.put(EnchantedItemHeldData.class, 8);
        dataTypeId.put(ItemHeldData.class, 9);
        dataTypeId.put(EnchantedHelmetData.class, 10);
        dataTypeId.put(HelmetData.class, 11);
        dataTypeId.put(EnchantedChestplateData.class, 12);
        dataTypeId.put(ChestplateData.class, 13);
        dataTypeId.put(EnchantedLeggingsData.class, 14);
        dataTypeId.put(LeggingsData.class, 15);
        dataTypeId.put(EnchantedBootsData.class, 16);
        dataTypeId.put(BootsData.class, 17);
    }

    /**
     * Возвращает id класса записываемых данных
     * @param data класс записываемых данных
     */
    public Integer getId(Class<?> data) {
        return dataTypeId.get(data);
    }

    /**
     * Возвращает класс записываемых данных
     * @param id id класса записываемых данных
     */
    public Class<?> getData(int id) {
        for(Class<?> c : dataTypeId.keySet()) {
            if(dataTypeId.get(c) == id) {
                return c;
            }
        }
        return null;
    }
}
