package net.Abdymazhit.VimeReplays.recording.dispatchers.packets;

import io.netty.channel.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Обработчик пакетов
 *
 * @version   27.07.2021
 * @author    Islam Abdymazhit
 */
public class PacketsListener {

    /**
     * Добавляет игрока в обработчик, чтобы обрабатывались его пакеты
     */
    public void addPlayer(Player player) {
        ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler() {

            @Override
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {
                super.channelRead(channelHandlerContext, packet);
            }

            @Override
            public void write(ChannelHandlerContext channelHandlerContext, Object packet, ChannelPromise channelPromise) throws Exception {
                super.write(channelHandlerContext, packet, channelPromise);
            }
        };

        ChannelPipeline pipeline = ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel.pipeline();
        pipeline.addBefore("packet_handler", player.getName(), channelDuplexHandler);
    }

    /**
     * Удаляет игрока из обработчика, чтобы перестали обрабатываться его пакеты
     */
    public void removePlayer(Player player) {
        Channel channel = ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel;
        channel.eventLoop().submit(() -> {
            channel.pipeline().remove(player.getName());
            return null;
        });
    }
}
