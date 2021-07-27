package net.Abdymazhit.VimeReplays.utils;

import net.minecraft.server.v1_8_R3.MathHelper;

/**
 * Отвечает за конвертацию значении местоположения
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class LocationUtils {

    /**
     * Возвращает значения x, y, z в типе short для сжатой сериализации
     */
    public short getLocationShort(double value) {
        return Short.parseShort(String.format("%.2f", value).replace(",", ""));
    }

    /**
     * Возвращает значения yaw и pitch в типе short для сжатой сериализации
     */
    public short getLocationShort(float value) {
        double radian = Math.toRadians(value);
        return  (short) (radian * 160);
    }

    /**
     * Возвращает значения x, y, z в типе double для работы с местоположениями
     * @param value значения x, y, z в типе short
     */
    public double getLocationDouble(short value) {
        return (double) value / 100;
    }

    /**
     * Возвращает значения yaw и pitch в типе float для работы с местоположениями
     * @param value значения yaw и pitch в типе short
     */
    public float getLocationFloat(short value) {
        return (float) Math.toDegrees((float) value / 160);
    }

    /**
     * Возвращает конвертированные значения x, y, z для работы с местоположениями NPC
     */
    public int getFixLocation(double d) {
        return MathHelper.floor(d * 32.0D);
    }

    /**
     * Возвращает конвертированные значения yaw и pitch для работы с местоположениями NPC
     */
    public byte getFixRotation(float f) {
        return (byte) ((int) (f * 256.0F / 360.0F));
    }
}
