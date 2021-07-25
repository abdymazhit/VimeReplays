package net.Abdymazhit.VimeReplays.utils;

import net.Abdymazhit.VimeReplays.customs.Item;
import net.Abdymazhit.VimeReplays.customs.PotionItem;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;

import java.util.HashMap;
import java.util.Map;

public class ItemUtils {

    private final Map<Material, Map<Item, Integer>> items;

    public ItemUtils() {
        items = new HashMap<>();

        items.put(Material.AIR, new HashMap<Item, Integer>() {{
            put(new Item(-1), 0);
        }});

        items.put(Material.STONE, new HashMap<Item, Integer>() {{
            put(new Item(0), 1);
            put(new Item(1), 2);
            put(new Item(2), 3);
            put(new Item(3), 4);
            put(new Item(4), 5);
            put(new Item(5), 6);
            put(new Item(6), 7);
        }});

        items.put(Material.GRASS, new HashMap<Item, Integer>() {{
            put(new Item(0), 8);
        }});

        items.put(Material.DIRT, new HashMap<Item, Integer>() {{
            put(new Item(0), 9);
            put(new Item(1), 10);
            put(new Item(2), 11);
        }});

        items.put(Material.COBBLESTONE, new HashMap<Item, Integer>() {{
            put(new Item(0), 12);
        }});

        items.put(Material.WOOD, new HashMap<Item, Integer>() {{
            put(new Item(0), 13);
            put(new Item(1), 14);
            put(new Item(2), 15);
            put(new Item(3), 16);
            put(new Item(4), 17);
            put(new Item(5), 18);
            put(new Item(6), 19);
            put(new Item(7), 20);
        }});

        items.put(Material.SAPLING, new HashMap<Item, Integer>() {{
            put(new Item(0), 21);
            put(new Item(1), 22);
            put(new Item(2), 23);
            put(new Item(3), 24);
            put(new Item(4), 25);
            put(new Item(5), 26);
        }});

        items.put(Material.BEDROCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 27);
        }});

        items.put(Material.SAND, new HashMap<Item, Integer>() {{
            put(new Item(0), 28);
            put(new Item(1), 29);
        }});

        items.put(Material.GRAVEL, new HashMap<Item, Integer>() {{
            put(new Item(0), 30);
        }});

        items.put(Material.GOLD_ORE, new HashMap<Item, Integer>() {{
            put(new Item(0), 31);
        }});

        items.put(Material.IRON_ORE, new HashMap<Item, Integer>() {{
            put(new Item(0), 32);
        }});

        items.put(Material.COAL_ORE, new HashMap<Item, Integer>() {{
            put(new Item(0), 33);
        }});

        items.put(Material.LOG, new HashMap<Item, Integer>() {{
            put(new Item(0), 34);
            put(new Item(1), 35);
            put(new Item(2), 36);
            put(new Item(3), 37);
        }});

        items.put(Material.LEAVES, new HashMap<Item, Integer>() {{
            put(new Item(0), 38);
            put(new Item(1), 39);
            put(new Item(2), 40);
            put(new Item(3), 41);
        }});

        items.put(Material.SPONGE, new HashMap<Item, Integer>() {{
            put(new Item(0), 42);
            put(new Item(1), 43);
        }});

        items.put(Material.GLASS, new HashMap<Item, Integer>() {{
            put(new Item(0), 44);
        }});

        items.put(Material.LAPIS_ORE, new HashMap<Item, Integer>() {{
            put(new Item(0), 45);
        }});

        items.put(Material.LAPIS_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 46);
        }});

        items.put(Material.DISPENSER, new HashMap<Item, Integer>() {{
            put(new Item(0), 47);
        }});

        items.put(Material.SANDSTONE, new HashMap<Item, Integer>() {{
            put(new Item(0), 48);
            put(new Item(1), 49);
            put(new Item(2), 50);
        }});

        items.put(Material.NOTE_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 51);
        }});

        items.put(Material.POWERED_RAIL, new HashMap<Item, Integer>() {{
            put(new Item(0), 52);
        }});

        items.put(Material.DETECTOR_RAIL, new HashMap<Item, Integer>() {{
            put(new Item(0), 53);
        }});

        items.put(Material.PISTON_STICKY_BASE, new HashMap<Item, Integer>() {{
            put(new Item(0), 54);
        }});

        items.put(Material.WEB, new HashMap<Item, Integer>() {{
            put(new Item(0), 55);
        }});

        items.put(Material.LONG_GRASS, new HashMap<Item, Integer>() {{
            put(new Item(1), 56);
            put(new Item(2), 57);
        }});

        items.put(Material.DEAD_BUSH, new HashMap<Item, Integer>() {{
            put(new Item(0), 58);
        }});

        items.put(Material.PISTON_BASE, new HashMap<Item, Integer>() {{
            put(new Item(0), 59);
        }});

        items.put(Material.WOOL, new HashMap<Item, Integer>() {{
            put(new Item(0), 60);
            put(new Item(1), 61);
            put(new Item(2), 62);
            put(new Item(3), 63);
            put(new Item(4), 64);
            put(new Item(5), 65);
            put(new Item(6), 66);
            put(new Item(7), 67);
            put(new Item(8), 68);
            put(new Item(9), 69);
            put(new Item(10), 70);
            put(new Item(11), 71);
            put(new Item(12), 72);
            put(new Item(13), 73);
            put(new Item(14), 74);
            put(new Item(15), 75);
        }});

        items.put(Material.YELLOW_FLOWER, new HashMap<Item, Integer>() {{
            put(new Item(0), 76);
        }});

        items.put(Material.RED_ROSE, new HashMap<Item, Integer>() {{
            put(new Item(0), 77);
            put(new Item(1), 78);
            put(new Item(2), 79);
            put(new Item(3), 80);
            put(new Item(4), 81);
            put(new Item(5), 82);
            put(new Item(6), 83);
            put(new Item(7), 84);
            put(new Item(8), 85);
        }});

        items.put(Material.BROWN_MUSHROOM, new HashMap<Item, Integer>() {{
            put(new Item(0), 86);
        }});

        items.put(Material.RED_MUSHROOM, new HashMap<Item, Integer>() {{
            put(new Item(0), 87);
        }});

        items.put(Material.GOLD_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 88);
        }});

        items.put(Material.IRON_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 89);
        }});

        items.put(Material.STEP, new HashMap<Item, Integer>() {{
            put(new Item(0), 90);
            put(new Item(1), 91);
            put(new Item(2), 92);
            put(new Item(3), 93);
            put(new Item(4), 94);
            put(new Item(5), 95);
            put(new Item(6), 96);
            put(new Item(7), 97);
        }});

        items.put(Material.BRICK, new HashMap<Item, Integer>() {{
            put(new Item(0), 98);
        }});

        items.put(Material.TNT, new HashMap<Item, Integer>() {{
            put(new Item(0), 99);
        }});

        items.put(Material.BOOKSHELF, new HashMap<Item, Integer>() {{
            put(new Item(0), 100);
        }});

        items.put(Material.MOSSY_COBBLESTONE, new HashMap<Item, Integer>() {{
            put(new Item(0), 101);
        }});

        items.put(Material.OBSIDIAN, new HashMap<Item, Integer>() {{
            put(new Item(0), 102);
        }});

        items.put(Material.TORCH, new HashMap<Item, Integer>() {{
            put(new Item(0), 103);
        }});

        items.put(Material.WOOD_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 104);
        }});

        items.put(Material.CHEST, new HashMap<Item, Integer>() {{
            put(new Item(0), 105);
        }});

        items.put(Material.DIAMOND_ORE, new HashMap<Item, Integer>() {{
            put(new Item(0), 106);
        }});

        items.put(Material.DIAMOND_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 107);
        }});

        items.put(Material.WORKBENCH, new HashMap<Item, Integer>() {{
            put(new Item(0), 108);
        }});

        items.put(Material.FURNACE, new HashMap<Item, Integer>() {{
            put(new Item(0), 109);
        }});

        items.put(Material.LADDER, new HashMap<Item, Integer>() {{
            put(new Item(0), 110);
        }});

        items.put(Material.RAILS, new HashMap<Item, Integer>() {{
            put(new Item(0), 111);
        }});

        items.put(Material.COBBLESTONE_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 112);
        }});

        items.put(Material.LEVER, new HashMap<Item, Integer>() {{
            put(new Item(0), 113);
        }});

        items.put(Material.STONE_PLATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 114);
        }});

        items.put(Material.WOOD_PLATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 115);
        }});

        items.put(Material.REDSTONE_ORE, new HashMap<Item, Integer>() {{
            put(new Item(0), 116);
        }});

        items.put(Material.REDSTONE_TORCH_ON, new HashMap<Item, Integer>() {{
            put(new Item(0), 117);
        }});

        items.put(Material.STONE_BUTTON, new HashMap<Item, Integer>() {{
            put(new Item(0), 118);
        }});

        items.put(Material.SNOW, new HashMap<Item, Integer>() {{
            put(new Item(0), 119);
        }});

        items.put(Material.ICE, new HashMap<Item, Integer>() {{
            put(new Item(0), 120);
        }});

        items.put(Material.SNOW_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 121);
        }});

        items.put(Material.CACTUS, new HashMap<Item, Integer>() {{
            put(new Item(0), 122);
        }});

        items.put(Material.CLAY, new HashMap<Item, Integer>() {{
            put(new Item(0), 123);
        }});

        items.put(Material.JUKEBOX, new HashMap<Item, Integer>() {{
            put(new Item(0), 124);
        }});

        items.put(Material.FENCE, new HashMap<Item, Integer>() {{
            put(new Item(0), 125);
        }});

        items.put(Material.PUMPKIN, new HashMap<Item, Integer>() {{
            put(new Item(0), 126);
        }});

        items.put(Material.NETHERRACK, new HashMap<Item, Integer>() {{
            put(new Item(0), 127);
        }});

        items.put(Material.SOUL_SAND, new HashMap<Item, Integer>() {{
            put(new Item(0), 128);
        }});

        items.put(Material.GLOWSTONE, new HashMap<Item, Integer>() {{
            put(new Item(0), 129);
        }});

        items.put(Material.JACK_O_LANTERN, new HashMap<Item, Integer>() {{
            put(new Item(0), 130);
        }});

        items.put(Material.STAINED_GLASS, new HashMap<Item, Integer>() {{
            put(new Item(0), 131);
            put(new Item(1), 132);
            put(new Item(2), 133);
            put(new Item(3), 134);
            put(new Item(4), 135);
            put(new Item(5), 136);
            put(new Item(6), 137);
            put(new Item(7), 138);
            put(new Item(8), 139);
            put(new Item(9), 140);
            put(new Item(10), 141);
            put(new Item(11), 142);
            put(new Item(12), 143);
            put(new Item(13), 144);
            put(new Item(14), 145);
            put(new Item(15), 146);
        }});

        items.put(Material.TRAP_DOOR, new HashMap<Item, Integer>() {{
            put(new Item(0), 147);
        }});

        items.put(Material.MONSTER_EGGS, new HashMap<Item, Integer>() {{
            put(new Item(0), 148);
            put(new Item(1), 149);
            put(new Item(2), 150);
            put(new Item(3), 151);
            put(new Item(4), 152);
            put(new Item(5), 153);
        }});

        items.put(Material.SMOOTH_BRICK, new HashMap<Item, Integer>() {{
            put(new Item(0), 154);
            put(new Item(1), 155);
            put(new Item(2), 156);
            put(new Item(3), 157);
        }});

        items.put(Material.IRON_FENCE, new HashMap<Item, Integer>() {{
            put(new Item(0), 158);
        }});

        items.put(Material.THIN_GLASS, new HashMap<Item, Integer>() {{
            put(new Item(0), 159);
        }});

        items.put(Material.MELON_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 160);
        }});

        items.put(Material.VINE, new HashMap<Item, Integer>() {{
            put(new Item(0), 161);
        }});

        items.put(Material.FENCE_GATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 162);
        }});

        items.put(Material.BRICK_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 163);
        }});

        items.put(Material.SMOOTH_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 164);
        }});

        items.put(Material.MYCEL, new HashMap<Item, Integer>() {{
            put(new Item(0), 165);
        }});

        items.put(Material.WATER_LILY, new HashMap<Item, Integer>() {{
            put(new Item(0), 166);
        }});

        items.put(Material.NETHER_BRICK, new HashMap<Item, Integer>() {{
            put(new Item(0), 167);
        }});

        items.put(Material.NETHER_FENCE, new HashMap<Item, Integer>() {{
            put(new Item(0), 168);
        }});

        items.put(Material.NETHER_BRICK_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 169);
        }});

        items.put(Material.ENCHANTMENT_TABLE, new HashMap<Item, Integer>() {{
            put(new Item(0), 170);
        }});

        items.put(Material.ENDER_PORTAL_FRAME, new HashMap<Item, Integer>() {{
            put(new Item(0), 171);
        }});

        items.put(Material.ENDER_STONE, new HashMap<Item, Integer>() {{
            put(new Item(0), 172);
        }});

        items.put(Material.REDSTONE_LAMP_OFF, new HashMap<Item, Integer>() {{
            put(new Item(0), 173);
        }});

        items.put(Material.WOOD_STEP, new HashMap<Item, Integer>() {{
            put(new Item(0), 174);
            put(new Item(1), 175);
            put(new Item(2), 176);
            put(new Item(3), 177);
            put(new Item(4), 178);
            put(new Item(5), 179);
            put(new Item(6), 180);
            put(new Item(7), 181);
        }});

        items.put(Material.SANDSTONE_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 182);
        }});

        items.put(Material.EMERALD_ORE, new HashMap<Item, Integer>() {{
            put(new Item(0), 183);
        }});

        items.put(Material.ENDER_CHEST, new HashMap<Item, Integer>() {{
            put(new Item(0), 184);
        }});

        items.put(Material.TRIPWIRE_HOOK, new HashMap<Item, Integer>() {{
            put(new Item(0), 185);
        }});

        items.put(Material.EMERALD_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 186);
        }});

        items.put(Material.SPRUCE_WOOD_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 187);
        }});

        items.put(Material.BIRCH_WOOD_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 188);
        }});

        items.put(Material.JUNGLE_WOOD_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 189);
        }});

        items.put(Material.BEACON, new HashMap<Item, Integer>() {{
            put(new Item(0), 190);
        }});

        items.put(Material.COBBLE_WALL, new HashMap<Item, Integer>() {{
            put(new Item(0), 191);
            put(new Item(1), 192);
        }});

        items.put(Material.WOOD_BUTTON, new HashMap<Item, Integer>() {{
            put(new Item(0), 193);
        }});

        items.put(Material.ANVIL, new HashMap<Item, Integer>() {{
            put(new Item(0), 194);
            put(new Item(1), 195);
            put(new Item(2), 196);
        }});

        items.put(Material.TRAPPED_CHEST, new HashMap<Item, Integer>() {{
            put(new Item(0), 197);
        }});

        items.put(Material.GOLD_PLATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 198);
        }});

        items.put(Material.IRON_PLATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 199);
        }});

        items.put(Material.DAYLIGHT_DETECTOR, new HashMap<Item, Integer>() {{
            put(new Item(0), 200);
        }});

        items.put(Material.REDSTONE_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 201);
        }});

        items.put(Material.QUARTZ_ORE, new HashMap<Item, Integer>() {{
            put(new Item(0), 202);
        }});

        items.put(Material.HOPPER, new HashMap<Item, Integer>() {{
            put(new Item(0), 203);
        }});

        items.put(Material.QUARTZ_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 204);
            put(new Item(1), 205);
            put(new Item(2), 206);
        }});

        items.put(Material.QUARTZ_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 207);
        }});

        items.put(Material.ACTIVATOR_RAIL, new HashMap<Item, Integer>() {{
            put(new Item(0), 208);
        }});

        items.put(Material.DROPPER, new HashMap<Item, Integer>() {{
            put(new Item(0), 209);
        }});

        items.put(Material.STAINED_CLAY, new HashMap<Item, Integer>() {{
            put(new Item(0), 210);
            put(new Item(1), 211);
            put(new Item(2), 212);
            put(new Item(3), 213);
            put(new Item(4), 214);
            put(new Item(5), 215);
            put(new Item(6), 216);
            put(new Item(7), 217);
            put(new Item(8), 218);
            put(new Item(9), 219);
            put(new Item(10), 220);
            put(new Item(11), 221);
            put(new Item(12), 222);
            put(new Item(13), 223);
            put(new Item(14), 224);
            put(new Item(15), 225);
        }});

        items.put(Material.STAINED_GLASS_PANE, new HashMap<Item, Integer>() {{
            put(new Item(0), 226);
            put(new Item(1), 227);
            put(new Item(2), 228);
            put(new Item(3), 229);
            put(new Item(4), 230);
            put(new Item(5), 231);
            put(new Item(6), 232);
            put(new Item(7), 233);
            put(new Item(8), 234);
            put(new Item(9), 235);
            put(new Item(10), 236);
            put(new Item(11), 237);
            put(new Item(12), 238);
            put(new Item(13), 239);
            put(new Item(14), 240);
            put(new Item(15), 241);
        }});

        items.put(Material.LEAVES_2, new HashMap<Item, Integer>() {{
            put(new Item(0), 242);
            put(new Item(1), 243);
        }});

        items.put(Material.LOG_2, new HashMap<Item, Integer>() {{
            put(new Item(0), 244);
            put(new Item(1), 245);
            put(new Item(2), 246);
            put(new Item(3), 247);
        }});

        items.put(Material.ACACIA_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 248);
        }});

        items.put(Material.DARK_OAK_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 249);
        }});

        items.put(Material.SLIME_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 250);
        }});

        items.put(Material.IRON_TRAPDOOR, new HashMap<Item, Integer>() {{
            put(new Item(0), 251);
        }});

        items.put(Material.PRISMARINE, new HashMap<Item, Integer>() {{
            put(new Item(0), 252);
            put(new Item(1), 253);
            put(new Item(2), 254);
        }});

        items.put(Material.SEA_LANTERN, new HashMap<Item, Integer>() {{
            put(new Item(0), 255);
        }});

        items.put(Material.HAY_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 256);
        }});

        items.put(Material.CARPET, new HashMap<Item, Integer>() {{
            put(new Item(0), 257);
            put(new Item(1), 258);
            put(new Item(2), 259);
            put(new Item(3), 260);
            put(new Item(4), 261);
            put(new Item(5), 262);
            put(new Item(6), 263);
            put(new Item(7), 264);
            put(new Item(8), 265);
            put(new Item(9), 266);
            put(new Item(10), 267);
            put(new Item(11), 268);
            put(new Item(12), 269);
            put(new Item(13), 270);
            put(new Item(14), 271);
            put(new Item(15), 272);
        }});

        items.put(Material.HARD_CLAY, new HashMap<Item, Integer>() {{
            put(new Item(0), 273);
        }});

        items.put(Material.COAL_BLOCK, new HashMap<Item, Integer>() {{
            put(new Item(0), 274);
        }});

        items.put(Material.PACKED_ICE, new HashMap<Item, Integer>() {{
            put(new Item(0), 275);
        }});

        items.put(Material.DOUBLE_PLANT, new HashMap<Item, Integer>() {{
            put(new Item(0), 276);
            put(new Item(1), 277);
            put(new Item(2), 278);
            put(new Item(3), 279);
            put(new Item(4), 280);
            put(new Item(5), 281);
        }});

        items.put(Material.RED_SANDSTONE, new HashMap<Item, Integer>() {{
            put(new Item(0), 282);
            put(new Item(1), 283);
            put(new Item(2), 284);
        }});

        items.put(Material.RED_SANDSTONE_STAIRS, new HashMap<Item, Integer>() {{
            put(new Item(0), 285);
        }});

        items.put(Material.STONE_SLAB2, new HashMap<Item, Integer>() {{
            put(new Item(0), 286);
        }});

        items.put(Material.SPRUCE_FENCE_GATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 287);
        }});

        items.put(Material.BIRCH_FENCE_GATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 288);
        }});

        items.put(Material.JUNGLE_FENCE_GATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 289);
        }});

        items.put(Material.DARK_OAK_FENCE_GATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 290);
        }});

        items.put(Material.ACACIA_FENCE_GATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 291);
        }});

        items.put(Material.SPRUCE_FENCE, new HashMap<Item, Integer>() {{
            put(new Item(0), 292);
        }});

        items.put(Material.BIRCH_FENCE, new HashMap<Item, Integer>() {{
            put(new Item(0), 293);
        }});

        items.put(Material.JUNGLE_FENCE, new HashMap<Item, Integer>() {{
            put(new Item(0), 294);
        }});

        items.put(Material.DARK_OAK_FENCE, new HashMap<Item, Integer>() {{
            put(new Item(0), 295);
        }});

        items.put(Material.ACACIA_FENCE, new HashMap<Item, Integer>() {{
            put(new Item(0), 296);
        }});

//        items.put(Material.CRYMSON_NYLIUM, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 297);
//        }});
//
//        items.put(Material.WARPED_NYLIUM, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 298);
//        }});
//
//        items.put(Material.PURPUR_BLOCK, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 299);
//        }});
//
//        items.put(Material.PURPUR_PILLAR, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 300);
//        }});
//
//        items.put(Material.PURPUR_STAIRS, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 301);
//        }});
//
//        items.put(Material.PURPUR_SLAB, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 302);
//        }});
//
//        items.put(Material.END_BRICKS, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 303);
//        }});
//
//        items.put(Material.CRIMSON_STAIRS, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 304);
//        }});
//
//        items.put(Material.WARPED_STAIRS, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 305);
//        }});
//
//        items.put(Material.LOG_STRIPPED1, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 306);
//            put(new ItemMeta(1), 307);
//            put(new ItemMeta(2), 308);
//            put(new ItemMeta(3), 309);
//        }});
//
//        items.put(Material.LOG_STRIPPED2, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 310);
//            put(new ItemMeta(1), 311);
//            put(new ItemMeta(2), 312);
//            put(new ItemMeta(3), 313);
//        }});
//
//        items.put(Material.MAGMA, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 314);
//        }});
//
//        items.put(Material.NETHER_WART_BLOCK, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 315);
//        }});
//
//        items.put(Material.RED_NETHER_BRICK, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 316);
//        }});
//
//        items.put(Material.BONE_BLOCK, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 317);
//        }});
//
//        items.put(Material.CONCRETE, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 318);
//            put(new ItemMeta(1), 319);
//            put(new ItemMeta(2), 320);
//            put(new ItemMeta(3), 321);
//            put(new ItemMeta(4), 322);
//            put(new ItemMeta(5), 323);
//            put(new ItemMeta(6), 324);
//            put(new ItemMeta(7), 325);
//            put(new ItemMeta(8), 326);
//            put(new ItemMeta(9), 327);
//            put(new ItemMeta(10), 328);
//            put(new ItemMeta(11), 329);
//            put(new ItemMeta(12), 330);
//            put(new ItemMeta(13), 331);
//            put(new ItemMeta(14), 332);
//            put(new ItemMeta(15), 333);
//        }});
//
//        items.put(Material.CONCRETE_POWDER, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 334);
//            put(new ItemMeta(1), 335);
//            put(new ItemMeta(2), 336);
//            put(new ItemMeta(3), 337);
//            put(new ItemMeta(4), 338);
//            put(new ItemMeta(5), 339);
//            put(new ItemMeta(6), 340);
//            put(new ItemMeta(7), 341);
//            put(new ItemMeta(8), 342);
//            put(new ItemMeta(9), 343);
//            put(new ItemMeta(10), 344);
//            put(new ItemMeta(11), 345);
//            put(new ItemMeta(12), 346);
//            put(new ItemMeta(13), 347);
//            put(new ItemMeta(14), 348);
//            put(new ItemMeta(15), 349);
//        }});
//
//        items.put(Material.LUCKY_BLOCK, new HashMap<ItemMeta, Integer>() {{
//            put(new ItemMeta(0), 350);
//        }});

        items.put(Material.IRON_SPADE, new HashMap<Item, Integer>() {{
            put(new Item(0), 351);
        }});

        items.put(Material.IRON_PICKAXE, new HashMap<Item, Integer>() {{
            put(new Item(0), 352);
        }});

        items.put(Material.IRON_AXE, new HashMap<Item, Integer>() {{
            put(new Item(0), 353);
        }});

        items.put(Material.FLINT_AND_STEEL, new HashMap<Item, Integer>() {{
            put(new Item(0), 354);
        }});

        items.put(Material.APPLE, new HashMap<Item, Integer>() {{
            put(new Item(0), 355);
        }});

        items.put(Material.BOW, new HashMap<Item, Integer>() {{
            put(new Item(0), 356);
        }});

        items.put(Material.ARROW, new HashMap<Item, Integer>() {{
            put(new Item(0), 357);
        }});

        items.put(Material.COAL, new HashMap<Item, Integer>() {{
            put(new Item(0), 358);
            put(new Item(1), 359);
        }});

        items.put(Material.DIAMOND, new HashMap<Item, Integer>() {{
            put(new Item(0), 360);
        }});

        items.put(Material.IRON_INGOT, new HashMap<Item, Integer>() {{
            put(new Item(0), 361);
        }});

        items.put(Material.GOLD_INGOT, new HashMap<Item, Integer>() {{
            put(new Item(0), 362);
        }});

        items.put(Material.IRON_SWORD, new HashMap<Item, Integer>() {{
            put(new Item(0), 363);
        }});

        items.put(Material.WOOD_SWORD, new HashMap<Item, Integer>() {{
            put(new Item(0), 364);
        }});

        items.put(Material.WOOD_SPADE, new HashMap<Item, Integer>() {{
            put(new Item(0), 365);
        }});

        items.put(Material.WOOD_PICKAXE, new HashMap<Item, Integer>() {{
            put(new Item(0), 366);
        }});

        items.put(Material.WOOD_AXE, new HashMap<Item, Integer>() {{
            put(new Item(0), 367);
        }});

        items.put(Material.STONE_SWORD, new HashMap<Item, Integer>() {{
            put(new Item(0), 368);
        }});

        items.put(Material.STONE_SPADE, new HashMap<Item, Integer>() {{
            put(new Item(0), 369);
        }});

        items.put(Material.STONE_PICKAXE, new HashMap<Item, Integer>() {{
            put(new Item(0), 370);
        }});

        items.put(Material.STONE_AXE, new HashMap<Item, Integer>() {{
            put(new Item(0), 371);
        }});

        items.put(Material.DIAMOND_SWORD, new HashMap<Item, Integer>() {{
            put(new Item(0), 372);
        }});

        items.put(Material.DIAMOND_SPADE, new HashMap<Item, Integer>() {{
            put(new Item(0), 373);
        }});

        items.put(Material.DIAMOND_PICKAXE, new HashMap<Item, Integer>() {{
            put(new Item(0), 374);
        }});

        items.put(Material.DIAMOND_AXE, new HashMap<Item, Integer>() {{
            put(new Item(0), 375);
        }});

        items.put(Material.STICK, new HashMap<Item, Integer>() {{
            put(new Item(0), 376);
        }});

        items.put(Material.BOWL, new HashMap<Item, Integer>() {{
            put(new Item(0), 377);
        }});

        items.put(Material.MUSHROOM_SOUP, new HashMap<Item, Integer>() {{
            put(new Item(0), 378);
        }});

        items.put(Material.GOLD_SWORD, new HashMap<Item, Integer>() {{
            put(new Item(0), 379);
        }});

        items.put(Material.GOLD_SPADE, new HashMap<Item, Integer>() {{
            put(new Item(0), 380);
        }});

        items.put(Material.GOLD_PICKAXE, new HashMap<Item, Integer>() {{
            put(new Item(0), 381);
        }});

        items.put(Material.GOLD_AXE, new HashMap<Item, Integer>() {{
            put(new Item(0), 382);
        }});

        items.put(Material.STRING, new HashMap<Item, Integer>() {{
            put(new Item(0), 383);
        }});

        items.put(Material.FEATHER, new HashMap<Item, Integer>() {{
            put(new Item(0), 384);
        }});

        items.put(Material.SULPHUR, new HashMap<Item, Integer>() {{
            put(new Item(0), 385);
        }});

        items.put(Material.WOOD_HOE, new HashMap<Item, Integer>() {{
            put(new Item(0), 386);
        }});

        items.put(Material.STONE_HOE, new HashMap<Item, Integer>() {{
            put(new Item(0), 387);
        }});

        items.put(Material.IRON_HOE, new HashMap<Item, Integer>() {{
            put(new Item(0), 388);
        }});

        items.put(Material.DIAMOND_HOE, new HashMap<Item, Integer>() {{
            put(new Item(0), 389);
        }});

        items.put(Material.GOLD_HOE, new HashMap<Item, Integer>() {{
            put(new Item(0), 390);
        }});

        items.put(Material.SEEDS, new HashMap<Item, Integer>() {{
            put(new Item(0), 391);
        }});

        items.put(Material.WHEAT, new HashMap<Item, Integer>() {{
            put(new Item(0), 392);
        }});

        items.put(Material.BREAD, new HashMap<Item, Integer>() {{
            put(new Item(0), 393);
        }});

        items.put(Material.LEATHER_HELMET, new HashMap<Item, Integer>() {{
            put(new Item(0), 394);
        }});

        items.put(Material.LEATHER_CHESTPLATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 395);
        }});

        items.put(Material.LEATHER_LEGGINGS, new HashMap<Item, Integer>() {{
            put(new Item(0), 396);
        }});

        items.put(Material.LEATHER_BOOTS, new HashMap<Item, Integer>() {{
            put(new Item(0), 397);
        }});

        items.put(Material.CHAINMAIL_HELMET, new HashMap<Item, Integer>() {{
            put(new Item(0), 398);
        }});

        items.put(Material.CHAINMAIL_CHESTPLATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 399);
        }});

        items.put(Material.CHAINMAIL_LEGGINGS, new HashMap<Item, Integer>() {{
            put(new Item(0), 400);
        }});

        items.put(Material.CHAINMAIL_BOOTS, new HashMap<Item, Integer>() {{
            put(new Item(0), 401);
        }});

        items.put(Material.IRON_HELMET, new HashMap<Item, Integer>() {{
            put(new Item(0), 402);
        }});

        items.put(Material.IRON_CHESTPLATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 403);
        }});

        items.put(Material.IRON_LEGGINGS, new HashMap<Item, Integer>() {{
            put(new Item(0), 404);
        }});

        items.put(Material.IRON_BOOTS, new HashMap<Item, Integer>() {{
            put(new Item(0), 405);
        }});

        items.put(Material.DIAMOND_HELMET, new HashMap<Item, Integer>() {{
            put(new Item(0), 406);
        }});

        items.put(Material.DIAMOND_CHESTPLATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 407);
        }});

        items.put(Material.DIAMOND_LEGGINGS, new HashMap<Item, Integer>() {{
            put(new Item(0), 408);
        }});

        items.put(Material.DIAMOND_BOOTS, new HashMap<Item, Integer>() {{
            put(new Item(0), 409);
        }});

        items.put(Material.GOLD_HELMET, new HashMap<Item, Integer>() {{
            put(new Item(0), 410);
        }});

        items.put(Material.GOLD_CHESTPLATE, new HashMap<Item, Integer>() {{
            put(new Item(0), 411);
        }});

        items.put(Material.GOLD_LEGGINGS, new HashMap<Item, Integer>() {{
            put(new Item(0), 412);
        }});

        items.put(Material.GOLD_BOOTS, new HashMap<Item, Integer>() {{
            put(new Item(0), 413);
        }});

        items.put(Material.FLINT, new HashMap<Item, Integer>() {{
            put(new Item(0), 414);
        }});

        items.put(Material.PORK, new HashMap<Item, Integer>() {{
            put(new Item(0), 415);
        }});

        items.put(Material.GRILLED_PORK, new HashMap<Item, Integer>() {{
            put(new Item(0), 416);
        }});

        items.put(Material.PAINTING, new HashMap<Item, Integer>() {{
            put(new Item(0), 417);
        }});

        items.put(Material.GOLDEN_APPLE, new HashMap<Item, Integer>() {{
            put(new Item(0), 418);
            put(new Item(1), 419);
        }});

        items.put(Material.SIGN, new HashMap<Item, Integer>() {{
            put(new Item(0), 420);
        }});

        items.put(Material.WOOD_DOOR, new HashMap<Item, Integer>() {{
            put(new Item(0), 421);
        }});

        items.put(Material.BUCKET, new HashMap<Item, Integer>() {{
            put(new Item(0), 422);
        }});

        items.put(Material.WATER_BUCKET, new HashMap<Item, Integer>() {{
            put(new Item(0), 423);
        }});

        items.put(Material.LAVA_BUCKET, new HashMap<Item, Integer>() {{
            put(new Item(0), 424);
        }});

        items.put(Material.MINECART, new HashMap<Item, Integer>() {{
            put(new Item(0), 425);
        }});

        items.put(Material.SADDLE, new HashMap<Item, Integer>() {{
            put(new Item(0), 426);
        }});

        items.put(Material.IRON_DOOR, new HashMap<Item, Integer>() {{
            put(new Item(0), 427);
        }});

        items.put(Material.REDSTONE, new HashMap<Item, Integer>() {{
            put(new Item(0), 428);
        }});

        items.put(Material.SNOW_BALL, new HashMap<Item, Integer>() {{
            put(new Item(0), 429);
        }});

        items.put(Material.BOAT, new HashMap<Item, Integer>() {{
            put(new Item(0), 430);
        }});

        items.put(Material.LEATHER, new HashMap<Item, Integer>() {{
            put(new Item(0), 431);
        }});

        items.put(Material.MILK_BUCKET, new HashMap<Item, Integer>() {{
            put(new Item(0), 432);
        }});

        items.put(Material.CLAY_BRICK, new HashMap<Item, Integer>() {{
            put(new Item(0), 433);
        }});

        items.put(Material.CLAY_BALL, new HashMap<Item, Integer>() {{
            put(new Item(0), 434);
        }});

        items.put(Material.SUGAR_CANE, new HashMap<Item, Integer>() {{
            put(new Item(0), 435);
        }});

        items.put(Material.PAPER, new HashMap<Item, Integer>() {{
            put(new Item(0), 436);
        }});

        items.put(Material.BOOK, new HashMap<Item, Integer>() {{
            put(new Item(0), 437);
        }});

        items.put(Material.SLIME_BALL, new HashMap<Item, Integer>() {{
            put(new Item(0), 438);
        }});

        items.put(Material.STORAGE_MINECART, new HashMap<Item, Integer>() {{
            put(new Item(0), 439);
        }});

        items.put(Material.POWERED_MINECART, new HashMap<Item, Integer>() {{
            put(new Item(0), 440);
        }});

        items.put(Material.EGG, new HashMap<Item, Integer>() {{
            put(new Item(0), 441);
        }});

        items.put(Material.COMPASS, new HashMap<Item, Integer>() {{
            put(new Item(0), 442);
        }});

        items.put(Material.FISHING_ROD, new HashMap<Item, Integer>() {{
            put(new Item(0), 443);
        }});

        items.put(Material.WATCH, new HashMap<Item, Integer>() {{
            put(new Item(0), 444);
        }});

        items.put(Material.GLOWSTONE_DUST, new HashMap<Item, Integer>() {{
            put(new Item(0), 445);
        }});

        items.put(Material.RAW_FISH, new HashMap<Item, Integer>() {{
            put(new Item(0), 446);
            put(new Item(1), 447);
            put(new Item(2), 448);
            put(new Item(3), 449);
        }});

        items.put(Material.COOKED_FISH, new HashMap<Item, Integer>() {{
            put(new Item(0), 450);
            put(new Item(1), 451);
        }});

        items.put(Material.INK_SACK, new HashMap<Item, Integer>() {{
            put(new Item(0), 452);
            put(new Item(1), 453);
            put(new Item(2), 454);
            put(new Item(3), 455);
            put(new Item(4), 456);
            put(new Item(5), 457);
            put(new Item(6), 458);
            put(new Item(7), 459);
            put(new Item(8), 460);
            put(new Item(9), 461);
            put(new Item(10), 462);
            put(new Item(11), 463);
            put(new Item(12), 464);
            put(new Item(13), 465);
            put(new Item(14), 466);
            put(new Item(15), 467);
        }});

        items.put(Material.BONE, new HashMap<Item, Integer>() {{
            put(new Item(0), 468);
        }});

        items.put(Material.SUGAR, new HashMap<Item, Integer>() {{
            put(new Item(0), 469);
        }});

        items.put(Material.CAKE, new HashMap<Item, Integer>() {{
            put(new Item(0), 470);
        }});

        items.put(Material.BED, new HashMap<Item, Integer>() {{
            put(new Item(0), 471);
        }});

        items.put(Material.DIODE, new HashMap<Item, Integer>() {{
            put(new Item(0), 472);
        }});

        items.put(Material.COOKIE, new HashMap<Item, Integer>() {{
            put(new Item(0), 473);
        }});

        items.put(Material.SHEARS, new HashMap<Item, Integer>() {{
            put(new Item(0), 474);
        }});

        items.put(Material.MELON, new HashMap<Item, Integer>() {{
            put(new Item(0), 475);
        }});

        items.put(Material.PUMPKIN_SEEDS, new HashMap<Item, Integer>() {{
            put(new Item(0), 476);
        }});

        items.put(Material.MELON_SEEDS, new HashMap<Item, Integer>() {{
            put(new Item(0), 477);
        }});

        items.put(Material.RAW_BEEF, new HashMap<Item, Integer>() {{
            put(new Item(0), 478);
        }});

        items.put(Material.COOKED_BEEF, new HashMap<Item, Integer>() {{
            put(new Item(0), 479);
        }});

        items.put(Material.RAW_CHICKEN, new HashMap<Item, Integer>() {{
            put(new Item(0), 480);
        }});

        items.put(Material.COOKED_CHICKEN, new HashMap<Item, Integer>() {{
            put(new Item(0), 481);
        }});

        items.put(Material.ROTTEN_FLESH, new HashMap<Item, Integer>() {{
            put(new Item(0), 482);
        }});

        items.put(Material.ENDER_PEARL, new HashMap<Item, Integer>() {{
            put(new Item(0), 483);
        }});

        items.put(Material.BLAZE_ROD, new HashMap<Item, Integer>() {{
            put(new Item(0), 484);
        }});

        items.put(Material.GHAST_TEAR, new HashMap<Item, Integer>() {{
            put(new Item(0), 485);
        }});

        items.put(Material.GOLD_NUGGET, new HashMap<Item, Integer>() {{
            put(new Item(0), 486);
        }});

        items.put(Material.NETHER_STALK, new HashMap<Item, Integer>() {{
            put(new Item(0), 487);
        }});

        items.put(Material.POTION, new HashMap<Item, Integer>() {{
            put(new Item(0), 488);

            put(new Item(1), 489);
            put(new Item(33), 490);
            put(new Item(65), 491);
            put(new PotionItem(1, true), 492);
            put(new PotionItem(33, true), 493);
            put(new PotionItem(65, true), 494);

            put(new Item(2), 495);
            put(new Item(34), 496);
            put(new Item(66), 497);
            put(new PotionItem(2, true), 498);
            put(new PotionItem(34, true), 499);
            put(new PotionItem(66, true), 500);

            put(new Item(35), 501);
            put(new Item(67), 502);
            put(new PotionItem(35, true), 503);
            put(new PotionItem(67, true), 504);

            put(new Item(4), 505);
            put(new Item(36), 506);
            put(new Item(68), 507);
            put(new PotionItem(4, true), 508);
            put(new PotionItem(36, true), 509);
            put(new PotionItem(68, true), 510);

            put(new Item(69), 511);
            put(new Item(37), 512);
            put(new PotionItem(69, true), 513);
            put(new PotionItem(37, true), 514);

            put(new Item(38), 515);
            put(new Item(70), 516);
            put(new PotionItem(38, true), 517);
            put(new PotionItem(70, true), 518);

            put(new Item(40), 519);
            put(new Item(72), 520);
            put(new PotionItem(40, true), 521);
            put(new PotionItem(72, true), 522);

            put(new Item(9), 523);
            put(new Item(41), 524);
            put(new Item(73), 525);
            put(new PotionItem(9, true), 526);
            put(new PotionItem(41, true), 527);
            put(new PotionItem(73, true), 528);

            put(new Item(42), 529);
            put(new Item(74), 530);
            put(new PotionItem(42, true), 531);
            put(new PotionItem(74, true), 532);

            put(new Item(11), 533);
            put(new Item(43), 534);
            put(new Item(75), 535);
            put(new PotionItem(11, true), 536);
            put(new PotionItem(43, true), 537);
            put(new PotionItem(75, true), 538);

            put(new Item(76), 539);
            put(new Item(44), 540);
            put(new PotionItem(76, true), 541);
            put(new PotionItem(44, true), 542);

            put(new Item(45), 543);
            put(new Item(77), 544);
            put(new PotionItem(45, true), 545);
            put(new PotionItem(77, true), 546);

            put(new Item(46), 547);
            put(new Item(78), 548);
            put(new PotionItem(46, true), 549);
            put(new PotionItem(78, true), 550);
        }});

        items.put(Material.GLASS_BOTTLE, new HashMap<Item, Integer>() {{
            put(new Item(0), 551);
        }});

        items.put(Material.SPIDER_EYE, new HashMap<Item, Integer>() {{
            put(new Item(0), 552);
        }});

        items.put(Material.FERMENTED_SPIDER_EYE, new HashMap<Item, Integer>() {{
            put(new Item(0), 553);
        }});

        items.put(Material.BLAZE_POWDER, new HashMap<Item, Integer>() {{
            put(new Item(0), 554);
        }});

        items.put(Material.MAGMA_CREAM, new HashMap<Item, Integer>() {{
            put(new Item(0), 555);
        }});

        items.put(Material.BREWING_STAND_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 556);
        }});

        items.put(Material.CAULDRON_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 557);
        }});

        items.put(Material.EYE_OF_ENDER, new HashMap<Item, Integer>() {{
            put(new Item(0), 558);
        }});

        items.put(Material.SPECKLED_MELON, new HashMap<Item, Integer>() {{
            put(new Item(0), 559);
        }});

        items.put(Material.MONSTER_EGG, new HashMap<Item, Integer>() {{
            put(new Item(50), 560);
            put(new Item(51), 561);
            put(new Item(52), 562);
            put(new Item(54), 563);
            put(new Item(55), 564);
            put(new Item(56), 565);
            put(new Item(57), 566);
            put(new Item(58), 567);
            put(new Item(59), 568);
            put(new Item(60), 569);
            put(new Item(61), 570);
            put(new Item(62), 571);
            put(new Item(65), 572);
            put(new Item(66), 573);
            put(new Item(67), 574);
            put(new Item(68), 575);
            put(new Item(90), 576);
            put(new Item(91), 577);
            put(new Item(92), 578);
            put(new Item(93), 579);
            put(new Item(94), 580);
            put(new Item(95), 581);
            put(new Item(96), 582);
            put(new Item(98), 583);
            put(new Item(100), 584);
            put(new Item(101), 585);
            put(new Item(120), 586);
        }});

        items.put(Material.EXP_BOTTLE, new HashMap<Item, Integer>() {{
            put(new Item(0), 587);
        }});

        items.put(Material.FIREBALL, new HashMap<Item, Integer>() {{
            put(new Item(0), 588);
        }});

        items.put(Material.BOOK_AND_QUILL, new HashMap<Item, Integer>() {{
            put(new Item(0), 589);
        }});

        items.put(Material.EMERALD, new HashMap<Item, Integer>() {{
            put(new Item(0), 590);
        }});

        items.put(Material.ITEM_FRAME, new HashMap<Item, Integer>() {{
            put(new Item(0), 591);
        }});

        items.put(Material.FLOWER_POT_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 592);
        }});

        items.put(Material.CARROT_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 593);
        }});

        items.put(Material.POTATO_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 594);
        }});

        items.put(Material.BAKED_POTATO, new HashMap<Item, Integer>() {{
            put(new Item(0), 595);
        }});

        items.put(Material.POISONOUS_POTATO, new HashMap<Item, Integer>() {{
            put(new Item(0), 596);
        }});

        items.put(Material.EMPTY_MAP, new HashMap<Item, Integer>() {{
            put(new Item(0), 597);
        }});

        items.put(Material.GOLDEN_CARROT, new HashMap<Item, Integer>() {{
            put(new Item(0), 598);
        }});

        items.put(Material.SKULL_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 599);
            put(new Item(1), 600);
            put(new Item(2), 601);
            put(new Item(3), 602);
            put(new Item(4), 603);
        }});

        items.put(Material.CARROT_STICK, new HashMap<Item, Integer>() {{
            put(new Item(0), 604);
        }});

        items.put(Material.NETHER_STAR, new HashMap<Item, Integer>() {{
            put(new Item(0), 605);
        }});

        items.put(Material.PUMPKIN_PIE, new HashMap<Item, Integer>() {{
            put(new Item(0), 606);
        }});

        items.put(Material.FIREWORK_CHARGE, new HashMap<Item, Integer>() {{
            put(new Item(0), 607);
        }});

        items.put(Material.REDSTONE_COMPARATOR, new HashMap<Item, Integer>() {{
            put(new Item(0), 608);
        }});

        items.put(Material.NETHER_BRICK_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 609);
        }});

        items.put(Material.QUARTZ, new HashMap<Item, Integer>() {{
            put(new Item(0), 610);
        }});

        items.put(Material.EXPLOSIVE_MINECART, new HashMap<Item, Integer>() {{
            put(new Item(0), 611);
        }});

        items.put(Material.HOPPER_MINECART, new HashMap<Item, Integer>() {{
            put(new Item(0), 612);
        }});

        items.put(Material.PRISMARINE_SHARD, new HashMap<Item, Integer>() {{
            put(new Item(0), 613);
        }});

        items.put(Material.PRISMARINE_CRYSTALS, new HashMap<Item, Integer>() {{
            put(new Item(0), 614);
        }});

        items.put(Material.RABBIT, new HashMap<Item, Integer>() {{
            put(new Item(0), 615);
        }});

        items.put(Material.COOKED_RABBIT, new HashMap<Item, Integer>() {{
            put(new Item(0), 616);
        }});

        items.put(Material.RABBIT_STEW, new HashMap<Item, Integer>() {{
            put(new Item(0), 617);
        }});

        items.put(Material.RABBIT_FOOT, new HashMap<Item, Integer>() {{
            put(new Item(0), 618);
        }});

        items.put(Material.RABBIT_HIDE, new HashMap<Item, Integer>() {{
            put(new Item(0), 619);
        }});

        items.put(Material.ARMOR_STAND, new HashMap<Item, Integer>() {{
            put(new Item(0), 620);
        }});

        items.put(Material.IRON_BARDING, new HashMap<Item, Integer>() {{
            put(new Item(0), 621);
        }});

        items.put(Material.GOLD_BARDING, new HashMap<Item, Integer>() {{
            put(new Item(0), 622);
        }});

        items.put(Material.DIAMOND_BARDING, new HashMap<Item, Integer>() {{
            put(new Item(0), 623);
        }});

        items.put(Material.LEASH, new HashMap<Item, Integer>() {{
            put(new Item(0), 624);
        }});

        items.put(Material.NAME_TAG, new HashMap<Item, Integer>() {{
            put(new Item(0), 625);
        }});

        items.put(Material.MUTTON, new HashMap<Item, Integer>() {{
            put(new Item(0), 626);
        }});

        items.put(Material.COOKED_MUTTON, new HashMap<Item, Integer>() {{
            put(new Item(0), 627);
        }});

        items.put(Material.BANNER, new HashMap<Item, Integer>() {{
            put(new Item(0), 628);
            put(new Item(1), 629);
            put(new Item(2), 630);
            put(new Item(3), 631);
            put(new Item(4), 632);
            put(new Item(5), 633);
            put(new Item(6), 634);
            put(new Item(7), 635);
            put(new Item(8), 636);
            put(new Item(9), 637);
            put(new Item(10), 638);
            put(new Item(11), 639);
            put(new Item(12), 640);
            put(new Item(13), 641);
            put(new Item(14), 642);
            put(new Item(15), 643);
        }});

        items.put(Material.SPRUCE_DOOR_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 644);
        }});

        items.put(Material.BIRCH_DOOR_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 645);
        }});

        items.put(Material.JUNGLE_DOOR_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 646);
        }});

        items.put(Material.ACACIA_DOOR_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 647);
        }});

        items.put(Material.DARK_OAK_DOOR_ITEM, new HashMap<Item, Integer>() {{
            put(new Item(0), 648);
        }});

        items.put(Material.GOLD_RECORD, new HashMap<Item, Integer>() {{
            put(new Item(0), 649);
        }});

        items.put(Material.GREEN_RECORD, new HashMap<Item, Integer>() {{
            put(new Item(0), 650);
        }});

        items.put(Material.RECORD_3, new HashMap<Item, Integer>() {{
            put(new Item(0), 651);
        }});

        items.put(Material.RECORD_4, new HashMap<Item, Integer>() {{
            put(new Item(0), 652);
        }});

        items.put(Material.RECORD_5, new HashMap<Item, Integer>() {{
            put(new Item(0), 653);
        }});

        items.put(Material.RECORD_6, new HashMap<Item, Integer>() {{
            put(new Item(0), 653);
        }});

        items.put(Material.RECORD_7, new HashMap<Item, Integer>() {{
            put(new Item(0), 654);
        }});

        items.put(Material.RECORD_8, new HashMap<Item, Integer>() {{
            put(new Item(0), 655);
        }});

        items.put(Material.RECORD_9, new HashMap<Item, Integer>() {{
            put(new Item(0), 656);
        }});

        items.put(Material.RECORD_10, new HashMap<Item, Integer>() {{
            put(new Item(0), 657);
        }});

        items.put(Material.RECORD_11, new HashMap<Item, Integer>() {{
            put(new Item(0), 658);
        }});

        items.put(Material.RECORD_12, new HashMap<Item, Integer>() {{
            put(new Item(0), 659);
        }});

        items.put(Material.ENCHANTED_BOOK, new HashMap<Item, Integer>() {{
            put(new Item(0), 660);
        }});
    }

    public int getItemId(ItemStack itemStack) {
        if(itemStack.getType() != Material.POTION) {
            Map<Item, Integer> value = items.get(itemStack.getType());
            for(Item item : value.keySet()) {
                if(item.getData() == itemStack.getData().getData()) {
                    return value.get(item);
                }
            }
        } else {
            Potion potion = Potion.fromItemStack(itemStack);

            if(potion.isSplash()) {
                Map<Item, Integer> value = items.get(itemStack.getType());
                for(Item item : value.keySet()) {
                    if(item instanceof PotionItem) {
                        PotionItem potionItem = (PotionItem) item;
                        if(potionItem.getData() == itemStack.getData().getData()) {
                            return value.get(item);
                        }
                    }
                }
            } else {
                Map<Item, Integer> value = items.get(itemStack.getType());
                for(Item item : value.keySet()) {
                    if(item.getData() == itemStack.getData().getData()) {
                        return value.get(item);
                    }
                }
            }
        }
        return -1;
    }

    public net.minecraft.server.v1_8_R3.ItemStack getItemStack(int itemId, Map<Enchantment, Integer> enchantments) {
        net.minecraft.server.v1_8_R3.ItemStack itemStack = null;

        for(Material material : items.keySet()) {
            Map<Item, Integer> values = items.get(material);

            for(Item value : values.keySet()) {
                int data = value.getData();
                int id = values.get(value);

                if(id == itemId) {
                    ItemStack item = new ItemStack(material, 1, (byte) data);
                    if(enchantments != null) {
                        item.addEnchantments(enchantments);
                    }

                    itemStack = CraftItemStack.asNMSCopy(item);
                }
            }
        }
        return itemStack;
    }
}
