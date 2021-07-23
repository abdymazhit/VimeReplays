package net.Abdymazhit.VimeReplays.utils;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class ItemStorage {

    private Map<Material, Map<Integer, Integer>> items;

    public ItemStorage() {
        items = new HashMap<>();

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

    public int getItemId(Material material, int data) {
        return items.get(material).get(data);
    }

}
