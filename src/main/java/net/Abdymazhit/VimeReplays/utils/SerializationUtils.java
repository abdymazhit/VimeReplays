package net.Abdymazhit.VimeReplays.utils;

import net.Abdymazhit.VimeReplays.replay.data.animations.ArmSwingData;
import net.Abdymazhit.VimeReplays.replay.data.animations.DamageData;
import net.Abdymazhit.VimeReplays.replay.data.animations.SneakingData;
import net.Abdymazhit.VimeReplays.replay.data.animations.UnsneakingData;
import net.Abdymazhit.VimeReplays.replay.data.entities.MovementData;
import net.Abdymazhit.VimeReplays.replay.data.entities.death.EntityDeathData;
import net.Abdymazhit.VimeReplays.replay.data.entities.death.PlayerDeathData;
import net.Abdymazhit.VimeReplays.replay.data.entities.spawn.ProjectileSpawnData;
import net.Abdymazhit.VimeReplays.replay.data.entities.spawn.PlayerSpawnData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.boots.BootsData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.boots.EnchantedBootsData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.chestplate.ChestplateData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.chestplate.EnchantedChestplateData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.helmet.EnchantedHelmetData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.helmet.HelmetData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.itemheld.EnchantedItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.itemheld.ItemHeldData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.leggings.EnchantedLeggingsData;
import net.Abdymazhit.VimeReplays.replay.data.equipments.leggings.LeggingsData;

import java.util.HashMap;
import java.util.Map;

/**
 * Отвечает за хранение id записываемых данных для сериализации
 *
 * @version   02.08.2021
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

        dataTypeId.put(ProjectileSpawnData.class, 1);
        dataTypeId.put(PlayerSpawnData.class, 2);
        dataTypeId.put(EntityDeathData.class, 3);
        dataTypeId.put(PlayerDeathData.class, 4);

        dataTypeId.put(MovementData.class, 5);

        dataTypeId.put(ArmSwingData.class, 6);
        dataTypeId.put(DamageData.class, 7);
        dataTypeId.put(SneakingData.class, 8);
        dataTypeId.put(UnsneakingData.class, 9);

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
