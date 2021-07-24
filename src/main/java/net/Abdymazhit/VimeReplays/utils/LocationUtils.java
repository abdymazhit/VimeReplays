package net.Abdymazhit.VimeReplays.utils;

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
}
