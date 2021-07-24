package net.Abdymazhit.VimeReplays.playing;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class PlayingItems {

    private ItemStack teleportItem;
    private ItemStack minusItem;
    private ItemStack backItem;
    private ItemStack playItem;
    private ItemStack pauseItem;
    private ItemStack finishItem;
    private ItemStack forwardItem;
    private ItemStack plusItem;
    private ItemStack settingsItem;

    public PlayingItems() {
        createItems();
    }

    private void createItems() {
        List<String> lore = Collections.singletonList("§5§oVimeWorld.ru");

        teleportItem = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        ItemMeta teleportItemMeta = teleportItem.getItemMeta();
        teleportItemMeta.setDisplayName("§r>> §e§lТелепортация к игрокам §r<<");
        teleportItemMeta.setLore(lore);
        teleportItem.setItemMeta(teleportItemMeta);

        minusItem = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzNlNGI1MzNlNGJhMmRmZjdjMGZhOTBmNjdlOGJlZjM2NDI4YjZjYjA2YzQ1MjYyNjMxYjBiMjVkYjg1YiJ9fX0=");
        ItemMeta minusItemMeta = minusItem.getItemMeta();
        minusItemMeta.setDisplayName("§r>> §e§lУменьшить скорость воспроизведения §r<<");
        minusItemMeta.setLore(lore);
        minusItem.setItemMeta(minusItemMeta);

        backItem = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzRlNDkwZTE2NThiZmRlNGQ0ZWYxZWE3Y2Q2NDZjNTM1MzM3NzkwNWExMzY5Yjg2ZWU5NjY3NDZhZTI1Y2E3In19fQ==");
        ItemMeta backItemMeta = backItem.getItemMeta();
        backItemMeta.setDisplayName("§r>> §e§lНа 10с назад §r<<");
        backItemMeta.setLore(lore);
        backItem.setItemMeta(backItemMeta);

        playItem = new ItemStack(Material.INK_SACK, 1, (byte) 10);
        ItemMeta playItemMeta = playItem.getItemMeta();
        playItemMeta.setDisplayName("§r>> §e§lНажмите, чтобы остановить воспроизведение §r<<");
        playItemMeta.setLore(lore);
        playItem.setItemMeta(playItemMeta);

        pauseItem = new ItemStack(Material.INK_SACK, 1, (byte) 8);
        ItemMeta pauseItemMeta = pauseItem.getItemMeta();
        pauseItemMeta.setDisplayName("§r>> §e§lНажмите, чтобы начать воспроизведение §r<<");
        pauseItemMeta.setLore(lore);
        pauseItem.setItemMeta(pauseItemMeta);

        finishItem = new ItemStack(Material.INK_SACK, 1, (byte) 12);
        ItemMeta finishItemMeta = finishItem.getItemMeta();
        finishItemMeta.setDisplayName("§r>> §e§lНажмите, чтобы начать заново воспроизведение §r<<");
        finishItemMeta.setLore(lore);
        finishItem.setItemMeta(finishItemMeta);

        forwardItem = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOThmMjkzZjI5NDk4MGQ3MzJmNTIzMzIxYzM0YTRjZGNjM2U2ZjllMzZjOTMyMGUxNTBmMWNjZTMxYWE1In19fQ====");
        ItemMeta forwardItemMeta = forwardItem.getItemMeta();
        forwardItemMeta.setDisplayName("§r>> §e§lНа 10с вперед §r<<");
        forwardItemMeta.setLore(lore);
        forwardItem.setItemMeta(forwardItemMeta);

        plusItem = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjBiNTVmNzQ2ODFjNjgyODNhMWMxY2U1MWYxYzgzYjUyZTI5NzFjOTFlZTM0ZWZjYjU5OGRmMzk5MGE3ZTcifX19");
        ItemMeta plusItemMeta = plusItem.getItemMeta();
        plusItemMeta.setDisplayName("§r>> §e§lУвеличить скорость воспроизведения §r<<");
        plusItemMeta.setLore(lore);
        plusItem.setItemMeta(plusItemMeta);

        settingsItem = new ItemStack(Material.NETHER_STAR);
        ItemMeta settingsItemMeta = settingsItem.getItemMeta();
        settingsItemMeta.setDisplayName("§r>> §e§lНастройки §r<<");
        settingsItemMeta.setLore(lore);
        settingsItem.setItemMeta(settingsItemMeta);
    }

    public void giveItems(Player player) {
        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);
        player.getInventory().clear();
        player.getInventory().setItem(0, teleportItem);
        player.getInventory().setItem(2, minusItem);
        player.getInventory().setItem(3, backItem);
        player.getInventory().setItem(4, pauseItem);
        player.getInventory().setItem(5, forwardItem);
        player.getInventory().setItem(6, plusItem);
        player.getInventory().setItem(8, settingsItem);
    }

    private ItemStack getSkull(String value) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", value));

        try {
            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
            e.printStackTrace();
        }

        skull.setItemMeta(skullMeta);
        return skull;
    }

    public void givePlayItem(Player player) {
        player.getInventory().setItem(4, playItem);
    }

    public void givePauseItem(Player player) {
        player.getInventory().setItem(4, pauseItem);
    }

    public void giveFinishItem(Player player) {
        player.getInventory().setItem(4, finishItem);
    }

    public ItemStack getTeleportItem() {
        return teleportItem;
    }

    public ItemStack getMinusItem() {
        return minusItem;
    }

    public ItemStack getBackItem() {
        return backItem;
    }

    public ItemStack getPlayItem() {
        return playItem;
    }

    public ItemStack getPauseItem() {
        return pauseItem;
    }

    public ItemStack getFinishItem() {
        return finishItem;
    }

    public ItemStack getForwardItem() {
        return forwardItem;
    }

    public ItemStack getPlusItem() {
        return plusItem;
    }

    public ItemStack getSettingsItem() {
        return settingsItem;
    }
}