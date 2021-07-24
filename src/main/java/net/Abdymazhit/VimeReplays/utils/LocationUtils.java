package net.Abdymazhit.VimeReplays.utils;

import net.minecraft.server.v1_8_R3.MathHelper;

public class LocationUtils {

    public double getLocationDouble(short value) {
        return (double) value / 100;
    }

    public float getLocationFloat(short value) {
        return (float) Math.toDegrees((float) value / 160);
    }

    public short getLocationShort(double value) {
        return Short.parseShort(String.format("%.2f", value).replace(",", ""));
    }

    public short getLocationShort(float value) {
        double radian = Math.toRadians(value);
        return  (short) (radian * 160);
    }

    public int getFixLocation(double d) {
        return MathHelper.floor(d * 32.0D);
    }

    public byte getFixRotation(float f) {
        return (byte) ((int) (f * 256.0F / 360.0F));
    }
}
