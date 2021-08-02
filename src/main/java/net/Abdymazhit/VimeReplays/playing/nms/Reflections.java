package net.Abdymazhit.VimeReplays.playing.nms;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

import java.lang.reflect.Field;

/**
 * Отвечает за работу с NMS
 *
 * @version   02.08.2021
 * @author    Islam Abdymazhit
 */
public class Reflections {

    /**
     * Устанавливает значение пакета
     */
    public void setValue(Object object, String name, Object value) {
        try {
            Field field = object.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(object, value);
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Возвращает значение пакета
     */
    public Object getValue(Object obj, String name) {
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field.get(obj);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Отправляет пакет зрителю
     */
    public void sendPacket(Packet<?> packet) {
        ((CraftPlayer) VimeReplays.getPlayingManager().getPlayingHandler().getViewer()).getHandle().playerConnection.sendPacket(packet);
    }
}
