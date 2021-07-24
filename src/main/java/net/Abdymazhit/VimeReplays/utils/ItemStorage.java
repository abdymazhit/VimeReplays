package net.Abdymazhit.VimeReplays.utils;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class ItemStorage {

    private final Map<Material, Map<Integer, Integer>> items;

    public ItemStorage() {
        items = new HashMap<>();

        addBuildingBlocks();
        addDecorativeBlocks();
        addMechanisms();
        addTransports();
        addMiscellaneous();
    }

    private void addBuildingBlocks() {
        items.put(Material.AIR, new HashMap<Integer, Integer>() {{
            put(0, 0);
        }});

        items.put(Material.STONE, new HashMap<Integer, Integer>() {{
            put(0, 1);
            put(1, 2);
            put(2, 3);
            put(3, 4);
            put(4, 5);
            put(5, 6);
            put(6, 7);
        }});

        items.put(Material.GRASS, new HashMap<Integer, Integer>() {{
            put(0, 8);
        }});

        items.put(Material.DIRT, new HashMap<Integer, Integer>() {{
            put(0, 9);
            put(1, 10);
            put(2, 11);
        }});

        items.put(Material.COBBLESTONE, new HashMap<Integer, Integer>() {{
            put(0, 12);
        }});

        items.put(Material.WOOD, new HashMap<Integer, Integer>() {{
            put(0, 13);
            put(1, 14);
            put(2, 15);
            put(3, 16);
            put(4, 17);
            put(5, 18);
            put(6, 19);
            put(7, 20);
        }});

        items.put(Material.BEDROCK, new HashMap<Integer, Integer>() {{
            put(0, 21);
        }});

        items.put(Material.SAND, new HashMap<Integer, Integer>() {{
            put(0, 22);
            put(1, 23);
        }});

        items.put(Material.GRAVEL, new HashMap<Integer, Integer>() {{
            put(0, 24);
        }});

        items.put(Material.GOLD_ORE, new HashMap<Integer, Integer>() {{
            put(0, 25);
        }});

        items.put(Material.IRON_ORE, new HashMap<Integer, Integer>() {{
            put(0, 26);
        }});

        items.put(Material.COAL_ORE, new HashMap<Integer, Integer>() {{
            put(0, 27);
        }});

        items.put(Material.LOG, new HashMap<Integer, Integer>() {{
            put(0, 28);
            put(1, 29);
            put(2, 30);
            put(3, 31);
        }});

        items.put(Material.SPONGE, new HashMap<Integer, Integer>() {{
            put(0, 32);
            put(1, 33);
        }});

        items.put(Material.GLASS, new HashMap<Integer, Integer>() {{
            put(0, 34);
        }});

        items.put(Material.LAPIS_ORE, new HashMap<Integer, Integer>() {{
            put(0, 35);
        }});

        items.put(Material.LAPIS_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 36);
        }});

        items.put(Material.SANDSTONE, new HashMap<Integer, Integer>() {{
            put(0, 37);
            put(1, 38);
            put(2, 39);
        }});

        items.put(Material.WOOL, new HashMap<Integer, Integer>() {{
            put(0, 40);
            put(1, 41);
            put(2, 42);
            put(3, 43);
            put(4, 44);
            put(5, 45);
            put(6, 46);
            put(7, 47);
            put(8, 48);
            put(9, 49);
            put(10, 50);
            put(11, 51);
            put(12, 52);
            put(13, 53);
            put(14, 54);
            put(15, 55);
        }});

        items.put(Material.GOLD_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 56);
        }});

        items.put(Material.IRON_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 57);
        }});

        items.put(Material.STEP, new HashMap<Integer, Integer>() {{
            put(0, 58);
            put(1, 59);
            put(2, 60);
            put(3, 61);
            put(4, 62);
            put(5, 63);
            put(6, 64);
            put(7, 65);
        }});

        items.put(Material.BRICK, new HashMap<Integer, Integer>() {{
            put(0, 66);
        }});

        items.put(Material.BOOKSHELF, new HashMap<Integer, Integer>() {{
            put(0, 67);
        }});

        items.put(Material.MOSSY_COBBLESTONE, new HashMap<Integer, Integer>() {{
            put(0, 68);
        }});

        items.put(Material.OBSIDIAN, new HashMap<Integer, Integer>() {{
            put(0, 69);
        }});

        items.put(Material.WOOD_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 70);
        }});

        items.put(Material.DIAMOND_ORE, new HashMap<Integer, Integer>() {{
            put(0, 71);
        }});

        items.put(Material.DIAMOND_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 72);
        }});

        items.put(Material.COBBLESTONE_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 73);
        }});

        items.put(Material.REDSTONE_ORE, new HashMap<Integer, Integer>() {{
            put(0, 74);
        }});

        items.put(Material.ICE, new HashMap<Integer, Integer>() {{
            put(0, 75);
        }});

        items.put(Material.SNOW_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 76);
        }});

        items.put(Material.CLAY, new HashMap<Integer, Integer>() {{
            put(0, 77);
        }});

        items.put(Material.PUMPKIN, new HashMap<Integer, Integer>() {{
            put(0, 78);
        }});

        items.put(Material.NETHERRACK, new HashMap<Integer, Integer>() {{
            put(0, 79);
        }});

        items.put(Material.SOUL_SAND, new HashMap<Integer, Integer>() {{
            put(0, 80);
        }});

        items.put(Material.GLOWSTONE, new HashMap<Integer, Integer>() {{
            put(0, 81);
        }});

        items.put(Material.JACK_O_LANTERN, new HashMap<Integer, Integer>() {{
            put(0, 82);
        }});

        items.put(Material.STAINED_GLASS, new HashMap<Integer, Integer>() {{
            put(0, 83);
            put(1, 84);
            put(2, 85);
            put(3, 86);
            put(4, 87);
            put(5, 88);
            put(6, 89);
            put(7, 90);
            put(8, 91);
            put(9, 92);
            put(10, 93);
            put(11, 94);
            put(12, 95);
            put(13, 96);
            put(14, 97);
            put(15, 98);
        }});

        items.put(Material.SMOOTH_BRICK, new HashMap<Integer, Integer>() {{
            put(0, 99);
            put(1, 100);
            put(2, 101);
            put(3, 102);
        }});

        items.put(Material.MELON_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 103);
        }});

        items.put(Material.BRICK_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 104);
        }});

        items.put(Material.SMOOTH_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 105);
        }});

        items.put(Material.MYCEL, new HashMap<Integer, Integer>() {{
            put(0, 106);
        }});

        items.put(Material.NETHER_BRICK, new HashMap<Integer, Integer>() {{
            put(0, 107);
        }});

        items.put(Material.NETHER_BRICK_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 108);
        }});

        items.put(Material.ENDER_STONE, new HashMap<Integer, Integer>() {{
            put(0, 109);
        }});

        items.put(Material.WOOD_STEP, new HashMap<Integer, Integer>() {{
            put(0, 110);
            put(1, 111);
            put(2, 112);
            put(3, 113);
            put(4, 114);
            put(5, 115);
            put(6, 116);
            put(7, 117);
        }});

        items.put(Material.SANDSTONE_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 118);
        }});

        items.put(Material.EMERALD_ORE, new HashMap<Integer, Integer>() {{
            put(0, 119);
        }});

        items.put(Material.EMERALD_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 120);
        }});

        items.put(Material.SPRUCE_WOOD_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 121);
        }});

        items.put(Material.BIRCH_WOOD_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 122);
        }});

        items.put(Material.JUNGLE_WOOD_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 123);
        }});

        items.put(Material.COBBLE_WALL, new HashMap<Integer, Integer>() {{
            put(0, 124);
            put(1, 125);
        }});

        items.put(Material.QUARTZ_ORE, new HashMap<Integer, Integer>() {{
            put(0, 126);
        }});

        items.put(Material.QUARTZ_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 127);
            put(1, 128);
            put(2, 129);
        }});

        items.put(Material.QUARTZ_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 130);
        }});

        items.put(Material.STAINED_CLAY, new HashMap<Integer, Integer>() {{
            put(0, 131);
            put(1, 132);
            put(2, 133);
            put(3, 134);
            put(4, 135);
            put(5, 136);
            put(6, 137);
            put(7, 138);
            put(8, 139);
            put(9, 140);
            put(10, 141);
            put(11, 142);
            put(12, 143);
            put(13, 144);
            put(14, 145);
            put(15, 146);
        }});

        items.put(Material.LOG_2, new HashMap<Integer, Integer>() {{
            put(0, 147);
            put(1, 148);
            put(2, 149);
            put(3, 150);
        }});

        items.put(Material.ACACIA_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 151);
        }});

        items.put(Material.DARK_OAK_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 152);
        }});

        items.put(Material.PRISMARINE, new HashMap<Integer, Integer>() {{
            put(0, 153);
            put(1, 154);
            put(2, 155);
        }});

        items.put(Material.SEA_LANTERN, new HashMap<Integer, Integer>() {{
            put(0, 156);
        }});

        items.put(Material.HAY_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 157);
        }});

        items.put(Material.HARD_CLAY, new HashMap<Integer, Integer>() {{
            put(0, 158);
        }});

        items.put(Material.COAL_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 159);
        }});

        items.put(Material.PACKED_ICE, new HashMap<Integer, Integer>() {{
            put(0, 160);
        }});

        items.put(Material.RED_SANDSTONE, new HashMap<Integer, Integer>() {{
            put(0, 161);
            put(1, 162);
            put(2, 163);
        }});

        items.put(Material.RED_SANDSTONE_STAIRS, new HashMap<Integer, Integer>() {{
            put(0, 164);
        }});

        items.put(Material.STONE_SLAB2, new HashMap<Integer, Integer>() {{
            put(0, 165);
        }});

//        items.put(Material.CRYMSON_NYLIUM, new HashMap<Integer, Integer>() {{
//            put(0, 166);
//        }});
//
//        items.put(Material.WARPED_NYLIUM, new HashMap<Integer, Integer>() {{
//            put(0, 167);
//        }});
//
//        items.put(Material.PURPUR_BLOCK, new HashMap<Integer, Integer>() {{
//            put(0, 168);
//        }});
//
//        items.put(Material.PURPUR_PILLAR, new HashMap<Integer, Integer>() {{
//            put(0, 169);
//        }});
//
//        items.put(Material.PURPUR_STAIRS, new HashMap<Integer, Integer>() {{
//            put(0, 170);
//        }});
//
//        items.put(Material.PURPUR_SLAB, new HashMap<Integer, Integer>() {{
//            put(0, 171);
//        }});
//
//        items.put(Material.RED_SANDSTONE_STAIRS, new HashMap<Integer, Integer>() {{
//            put(0, 173);
//        }});
//
//        items.put(Material.STONE_SLAB2, new HashMap<Integer, Integer>() {{
//            put(0, 174);
//        }});
//
//        items.put(Material.LOG_STRIPPED1, new HashMap<Integer, Integer>() {{
//            put(0, 175);
//            put(1, 176);
//            put(2, 177);
//            put(3, 178);
//        }});
//
//        items.put(Material.LOG_STRIPPED2, new HashMap<Integer, Integer>() {{
//            put(0, 179);
//            put(1, 180);
//            put(2, 181);
//            put(3, 182);
//        }});
//
//        items.put(Material.MAGMA, new HashMap<Integer, Integer>() {{
//            put(0, 183);
//        }});
//
//        items.put(Material.NETHER_WART_BLOCK, new HashMap<Integer, Integer>() {{
//            put(0, 184);
//        }});
//
//        items.put(Material.RED_NETHER_BRICK, new HashMap<Integer, Integer>() {{
//            put(0, 185);
//        }});
//
//        items.put(Material.BONE_BLOCK, new HashMap<Integer, Integer>() {{
//            put(0, 186);
//        }});
//
//        items.put(Material.BONE_BLOCK, new HashMap<Integer, Integer>() {{
//            put(0, 186);
//        }});
//
//        items.put(Material.CONCRETE, new HashMap<Integer, Integer>() {{
//            put(0, 187);
//            put(1, 188);
//            put(2, 189);
//            put(3, 190);
//            put(4, 191);
//            put(5, 192);
//            put(6, 193);
//            put(7, 194);
//            put(8, 195);
//            put(9, 196);
//            put(10, 197);
//            put(11, 198);
//            put(12, 199);
//            put(13, 200);
//            put(14, 201);
//            put(15, 202);
//        }});
//
//        items.put(Material.CONCRETE_POWDER, new HashMap<Integer, Integer>() {{
//            put(0, 203);
//            put(1, 204);
//            put(2, 205);
//            put(3, 206);
//            put(4, 207);
//            put(5, 208);
//            put(6, 209);
//            put(7, 210);
//            put(8, 211);
//            put(9, 212);
//            put(10, 213);
//            put(11, 214);
//            put(12, 215);
//            put(13, 216);
//            put(14, 217);
//            put(15, 218);
//        }});
//
//        items.put(Material.LUCKY_BLOCK, new HashMap<Integer, Integer>() {{
//            put(0, 219);
//        }});
    }

    private void addDecorativeBlocks() {
        items.put(Material.SAPLING, new HashMap<Integer, Integer>() {{
            put(0, 220);
            put(1, 221);
            put(2, 222);
            put(3, 223);
            put(4, 224);
            put(5, 225);
        }});

        items.put(Material.LEAVES, new HashMap<Integer, Integer>() {{
            put(0, 226);
            put(1, 227);
            put(2, 228);
            put(3, 229);
        }});

        items.put(Material.WEB, new HashMap<Integer, Integer>() {{
            put(0, 230);
        }});

        items.put(Material.LONG_GRASS, new HashMap<Integer, Integer>() {{
            put(1, 231);
            put(2, 232);
        }});

        items.put(Material.DEAD_BUSH, new HashMap<Integer, Integer>() {{
            put(0, 233);
        }});

        items.put(Material.YELLOW_FLOWER, new HashMap<Integer, Integer>() {{
            put(0, 234);
        }});

        items.put(Material.RED_ROSE, new HashMap<Integer, Integer>() {{
            put(0, 235);
            put(1, 236);
            put(2, 237);
            put(3, 238);
            put(4, 239);
            put(5, 240);
            put(6, 241);
            put(7, 242);
            put(8, 243);
        }});

        items.put(Material.BROWN_MUSHROOM, new HashMap<Integer, Integer>() {{
            put(0, 244);
        }});

        items.put(Material.RED_MUSHROOM, new HashMap<Integer, Integer>() {{
            put(0, 245);
        }});

        items.put(Material.TORCH, new HashMap<Integer, Integer>() {{
            put(0, 246);
        }});

        items.put(Material.CHEST, new HashMap<Integer, Integer>() {{
            put(0, 247);
        }});

        items.put(Material.WORKBENCH, new HashMap<Integer, Integer>() {{
            put(0, 248);
        }});

        items.put(Material.FURNACE, new HashMap<Integer, Integer>() {{
            put(0, 249);
        }});

        items.put(Material.LADDER, new HashMap<Integer, Integer>() {{
            put(0, 250);
        }});

        items.put(Material.SNOW, new HashMap<Integer, Integer>() {{
            put(0, 251);
        }});

        items.put(Material.CACTUS, new HashMap<Integer, Integer>() {{
            put(0, 252);
        }});

        items.put(Material.JUKEBOX, new HashMap<Integer, Integer>() {{
            put(0, 253);
        }});

        items.put(Material.FENCE, new HashMap<Integer, Integer>() {{
            put(0, 254);
        }});

        items.put(Material.MONSTER_EGGS, new HashMap<Integer, Integer>() {{
            put(0, 255);
            put(1, 256);
            put(2, 257);
            put(3, 258);
            put(4, 259);
            put(5, 260);
        }});

        items.put(Material.IRON_FENCE, new HashMap<Integer, Integer>() {{
            put(0, 261);
        }});

        items.put(Material.THIN_GLASS, new HashMap<Integer, Integer>() {{
            put(0, 262);
        }});

        items.put(Material.VINE, new HashMap<Integer, Integer>() {{
            put(0, 263);
        }});

        items.put(Material.WATER_LILY, new HashMap<Integer, Integer>() {{
            put(0, 264);
        }});

        items.put(Material.NETHER_FENCE, new HashMap<Integer, Integer>() {{
            put(0, 265);
        }});

        items.put(Material.ENCHANTMENT_TABLE, new HashMap<Integer, Integer>() {{
            put(0, 266);
        }});

        items.put(Material.ENDER_PORTAL_FRAME, new HashMap<Integer, Integer>() {{
            put(0, 267);
        }});

        items.put(Material.ENDER_CHEST, new HashMap<Integer, Integer>() {{
            put(0, 268);
        }});

        items.put(Material.ANVIL, new HashMap<Integer, Integer>() {{
            put(0, 269);
            put(1, 270);
            put(2, 271);
        }});

        items.put(Material.TRAPPED_CHEST, new HashMap<Integer, Integer>() {{
            put(0, 272);
        }});

        items.put(Material.STAINED_GLASS_PANE, new HashMap<Integer, Integer>() {{
            put(0, 273);
            put(1, 274);
            put(2, 275);
            put(3, 276);
            put(4, 277);
            put(5, 278);
            put(6, 279);
            put(7, 280);
            put(8, 281);
            put(9, 282);
            put(10, 283);
            put(11, 284);
            put(12, 285);
            put(13, 286);
            put(14, 287);
            put(15, 288);
        }});

        items.put(Material.LEAVES_2, new HashMap<Integer, Integer>() {{
            put(0, 289);
            put(1, 290);
        }});

        items.put(Material.SLIME_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 291);
        }});

        items.put(Material.CARPET, new HashMap<Integer, Integer>() {{
            put(0, 292);
            put(1, 293);
            put(2, 294);
            put(3, 295);
            put(4, 296);
            put(5, 297);
            put(6, 298);
            put(7, 299);
            put(8, 300);
            put(9, 301);
            put(10, 302);
            put(11, 303);
            put(12, 304);
            put(13, 305);
            put(14, 306);
            put(15, 307);
        }});

        items.put(Material.DOUBLE_PLANT, new HashMap<Integer, Integer>() {{
            put(0, 308);
            put(1, 309);
            put(2, 310);
            put(3, 311);
            put(4, 312);
            put(5, 313);
        }});

        items.put(Material.SPRUCE_FENCE, new HashMap<Integer, Integer>() {{
            put(0, 314);
        }});

        items.put(Material.BIRCH_FENCE, new HashMap<Integer, Integer>() {{
            put(0, 315);
        }});

        items.put(Material.JUNGLE_FENCE, new HashMap<Integer, Integer>() {{
            put(0, 316);
        }});

        items.put(Material.DARK_OAK_FENCE, new HashMap<Integer, Integer>() {{
            put(0, 317);
        }});

        items.put(Material.ACACIA_FENCE, new HashMap<Integer, Integer>() {{
            put(0, 318);
        }});

        items.put(Material.PAINTING, new HashMap<Integer, Integer>() {{
            put(0, 319);
        }});

        items.put(Material.SIGN, new HashMap<Integer, Integer>() {{
            put(0, 320);
        }});

        items.put(Material.BED, new HashMap<Integer, Integer>() {{
            put(0, 321);
        }});

        items.put(Material.ITEM_FRAME, new HashMap<Integer, Integer>() {{
            put(0, 322);
        }});

        items.put(Material.FLOWER_POT_ITEM, new HashMap<Integer, Integer>() {{
            put(0, 323);
        }});

        items.put(Material.SKULL_ITEM, new HashMap<Integer, Integer>() {{
            put(0, 324);
            put(1, 325);
            put(2, 326);
            put(3, 327);
            put(4, 328);
        }});

        items.put(Material.ARMOR_STAND, new HashMap<Integer, Integer>() {{
            put(0, 329);
        }});

        items.put(Material.BANNER, new HashMap<Integer, Integer>() {{
            put(0, 330);
            put(1, 331);
            put(2, 332);
            put(3, 333);
            put(4, 334);
            put(5, 335);
            put(6, 336);
            put(7, 337);
            put(8, 338);
            put(9, 339);
            put(10, 340);
            put(11, 341);
            put(12, 342);
            put(13, 343);
            put(14, 344);
            put(15, 345);
        }});
    }

    private void addMechanisms() {
        items.put(Material.DISPENSER, new HashMap<Integer, Integer>() {{
            put(0, 346);
        }});

        items.put(Material.NOTE_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 347);
        }});

        items.put(Material.PISTON_STICKY_BASE, new HashMap<Integer, Integer>() {{
            put(0, 349);
        }});

        items.put(Material.PISTON_BASE, new HashMap<Integer, Integer>() {{
            put(0, 350);
        }});

        items.put(Material.TNT, new HashMap<Integer, Integer>() {{
            put(0, 351);
        }});

        items.put(Material.LEVER, new HashMap<Integer, Integer>() {{
            put(0, 352);
        }});

        items.put(Material.STONE_PLATE, new HashMap<Integer, Integer>() {{
            put(0, 353);
        }});

        items.put(Material.WOOD_PLATE, new HashMap<Integer, Integer>() {{
            put(0, 354);
        }});

        items.put(Material.REDSTONE_TORCH_ON, new HashMap<Integer, Integer>() {{
            put(0, 355);
        }});

        items.put(Material.STONE_BUTTON, new HashMap<Integer, Integer>() {{
            put(0, 356);
        }});

        items.put(Material.TRAP_DOOR, new HashMap<Integer, Integer>() {{
            put(0, 357);
        }});

        items.put(Material.FENCE_GATE, new HashMap<Integer, Integer>() {{
            put(0, 358);
        }});

        items.put(Material.REDSTONE_LAMP_OFF, new HashMap<Integer, Integer>() {{
            put(0, 359);
        }});

        items.put(Material.TRIPWIRE_HOOK, new HashMap<Integer, Integer>() {{
            put(0, 360);
        }});

        items.put(Material.WOOD_BUTTON, new HashMap<Integer, Integer>() {{
            put(0, 361);
        }});

        items.put(Material.GOLD_PLATE, new HashMap<Integer, Integer>() {{
            put(0, 362);
        }});

        items.put(Material.IRON_PLATE, new HashMap<Integer, Integer>() {{
            put(0, 363);
        }});

        items.put(Material.DAYLIGHT_DETECTOR, new HashMap<Integer, Integer>() {{
            put(0, 364);
        }});

        items.put(Material.REDSTONE_BLOCK, new HashMap<Integer, Integer>() {{
            put(0, 365);
        }});

        items.put(Material.HOPPER, new HashMap<Integer, Integer>() {{
            put(0, 366);
        }});

        items.put(Material.DROPPER, new HashMap<Integer, Integer>() {{
            put(0, 367);
        }});

        items.put(Material.IRON_TRAPDOOR, new HashMap<Integer, Integer>() {{
            put(0, 368);
        }});

        items.put(Material.SPRUCE_FENCE_GATE, new HashMap<Integer, Integer>() {{
            put(0, 369);
        }});

        items.put(Material.BIRCH_FENCE_GATE, new HashMap<Integer, Integer>() {{
            put(0, 370);
        }});

        items.put(Material.JUNGLE_FENCE_GATE, new HashMap<Integer, Integer>() {{
            put(0, 371);
        }});

        items.put(Material.DARK_OAK_FENCE_GATE, new HashMap<Integer, Integer>() {{
            put(0, 372);
        }});

        items.put(Material.ACACIA_FENCE_GATE, new HashMap<Integer, Integer>() {{
            put(0, 373);
        }});

        items.put(Material.WOOD_DOOR, new HashMap<Integer, Integer>() {{
            put(0, 374);
        }});

        items.put(Material.IRON_DOOR, new HashMap<Integer, Integer>() {{
            put(0, 375);
        }});

        items.put(Material.REDSTONE, new HashMap<Integer, Integer>() {{
            put(0, 376);
        }});

        items.put(Material.DIODE, new HashMap<Integer, Integer>() {{
            put(0, 377);
        }});

        items.put(Material.REDSTONE_COMPARATOR, new HashMap<Integer, Integer>() {{
            put(0, 378);
        }});

        items.put(Material.SPRUCE_DOOR_ITEM, new HashMap<Integer, Integer>() {{
            put(0, 379);
        }});

        items.put(Material.BIRCH_DOOR_ITEM, new HashMap<Integer, Integer>() {{
            put(0, 380);
        }});

        items.put(Material.JUNGLE_DOOR_ITEM, new HashMap<Integer, Integer>() {{
            put(0, 381);
        }});

        items.put(Material.ACACIA_DOOR_ITEM, new HashMap<Integer, Integer>() {{
            put(0, 382);
        }});

        items.put(Material.DARK_OAK_DOOR_ITEM, new HashMap<Integer, Integer>() {{
            put(0, 383);
        }});
    }

    private void addTransports() {
        items.put(Material.POWERED_RAIL, new HashMap<Integer, Integer>() {{
            put(0, 384);
        }});

        items.put(Material.DETECTOR_RAIL, new HashMap<Integer, Integer>() {{
            put(0, 385);
        }});

        items.put(Material.RAILS, new HashMap<Integer, Integer>() {{
            put(0, 386);
        }});

        items.put(Material.ACTIVATOR_RAIL, new HashMap<Integer, Integer>() {{
            put(0, 387);
        }});

        items.put(Material.MINECART, new HashMap<Integer, Integer>() {{
            put(0, 388);
        }});

        items.put(Material.SADDLE, new HashMap<Integer, Integer>() {{
            put(0, 389);
        }});

        items.put(Material.BOAT, new HashMap<Integer, Integer>() {{
            put(0, 390);
        }});

        items.put(Material.STORAGE_MINECART, new HashMap<Integer, Integer>() {{
            put(0, 391);
        }});

        items.put(Material.POWERED_MINECART, new HashMap<Integer, Integer>() {{
            put(0, 392);
        }});

        items.put(Material.CARROT_STICK, new HashMap<Integer, Integer>() {{
            put(0, 393);
        }});

        items.put(Material.EXPLOSIVE_MINECART, new HashMap<Integer, Integer>() {{
            put(0, 394);
        }});

        items.put(Material.HOPPER_MINECART, new HashMap<Integer, Integer>() {{
            put(0, 395);
        }});
    }

    private void addMiscellaneous() {
        items.put(Material.BEACON, new HashMap<Integer, Integer>() {{
            put(0, 396);
        }});

        items.put(Material.BUCKET, new HashMap<Integer, Integer>() {{
            put(0, 397);
        }});

        items.put(Material.WATER_BUCKET, new HashMap<Integer, Integer>() {{
            put(0, 398);
        }});

        items.put(Material.LAVA_BUCKET, new HashMap<Integer, Integer>() {{
            put(0, 399);
        }});

        items.put(Material.SNOW_BALL, new HashMap<Integer, Integer>() {{
            put(0, 400);
        }});

        items.put(Material.MILK_BUCKET, new HashMap<Integer, Integer>() {{
            put(0, 401);
        }});

        items.put(Material.PAPER, new HashMap<Integer, Integer>() {{
            put(0, 402);
        }});

        items.put(Material.BOOK, new HashMap<Integer, Integer>() {{
            put(0, 403);
        }});

        items.put(Material.SLIME_BALL, new HashMap<Integer, Integer>() {{
            put(0, 404);
        }});

        items.put(Material.BONE, new HashMap<Integer, Integer>() {{
            put(0, 405);
        }});

        items.put(Material.ENDER_PEARL, new HashMap<Integer, Integer>() {{
            put(0, 406);
        }});

        items.put(Material.EYE_OF_ENDER, new HashMap<Integer, Integer>() {{
            put(0, 407);
        }});

        items.put(Material.MONSTER_EGG, new HashMap<Integer, Integer>() {{
            put(50, 408);
            put(51, 409);
            put(52, 410);
            put(54, 411);
            put(55, 412);
            put(56, 413);
            put(57, 414);
            put(58, 415);
            put(59, 416);
            put(60, 417);
            put(61, 418);
            put(62, 419);
            put(65, 420);
            put(66, 421);
            put(67, 422);
            put(68, 423);
            put(90, 424);
            put(91, 425);
            put(92, 426);
            put(93, 427);
            put(94, 428);
            put(95, 429);
            put(96, 430);
            put(98, 431);
            put(100, 432);
            put(101, 433);
            put(120, 434);
        }});

        items.put(Material.EXP_BOTTLE, new HashMap<Integer, Integer>() {{
            put(0, 435);
        }});

        items.put(Material.FIREBALL, new HashMap<Integer, Integer>() {{
            put(0, 436);
        }});

        items.put(Material.BOOK_AND_QUILL, new HashMap<Integer, Integer>() {{
            put(0, 437);
        }});

        items.put(Material.EMPTY_MAP, new HashMap<Integer, Integer>() {{
            put(0, 438);
        }});

        items.put(Material.FIREWORK_CHARGE, new HashMap<Integer, Integer>() {{
            put(0, 439);
        }});

        items.put(Material.IRON_BARDING, new HashMap<Integer, Integer>() {{
            put(0, 440);
        }});

        items.put(Material.GOLD_BARDING, new HashMap<Integer, Integer>() {{
            put(0, 441);
        }});

        items.put(Material.DIAMOND_BARDING, new HashMap<Integer, Integer>() {{
            put(0, 442);
        }});

        items.put(Material.GOLD_RECORD, new HashMap<Integer, Integer>() {{
            put(0, 443);
        }});

        items.put(Material.GREEN_RECORD, new HashMap<Integer, Integer>() {{
            put(0, 444);
        }});

        items.put(Material.RECORD_3, new HashMap<Integer, Integer>() {{
            put(0, 445);
        }});

        items.put(Material.RECORD_4, new HashMap<Integer, Integer>() {{
            put(0, 446);
        }});

        items.put(Material.RECORD_5, new HashMap<Integer, Integer>() {{
            put(0, 447);
        }});

        items.put(Material.RECORD_6, new HashMap<Integer, Integer>() {{
            put(0, 448);
        }});

        items.put(Material.RECORD_7, new HashMap<Integer, Integer>() {{
            put(0, 449);
        }});

        items.put(Material.RECORD_8, new HashMap<Integer, Integer>() {{
            put(0, 450);
        }});

        items.put(Material.RECORD_9, new HashMap<Integer, Integer>() {{
            put(0, 451);
        }});

        items.put(Material.RECORD_10, new HashMap<Integer, Integer>() {{
            put(0, 452);
        }});

        items.put(Material.RECORD_11, new HashMap<Integer, Integer>() {{
            put(0, 453);
        }});

        items.put(Material.RECORD_12, new HashMap<Integer, Integer>() {{
            put(0, 454);
        }});
    }

    public int getItemId(Material material, int data) {
        return items.get(material).get(data);
    }
}
