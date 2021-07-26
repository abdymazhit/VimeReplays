package net.Abdymazhit.VimeReplays.recording.dispatchers;

import net.Abdymazhit.VimeReplays.VimeReplays;
import net.Abdymazhit.VimeReplays.replay.data.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class MainDispatcher {

    private final Map<Short, MovingData> playerLastLocation;
    private final Map<Short, ItemHeldData> playerLastItemInHand;
    private final Map<Short, HelmetData> playerLastHelmet;
    private final Map<Short, ChestplateData> playerLastChestplate;
    private final Map<Short, LeggingsData> playerLastLeggings;
    private final Map<Short, BootsData> playerLastBoots;

    public MainDispatcher() {
        playerLastLocation = new HashMap<>();
        playerLastItemInHand = new HashMap<>();
        playerLastHelmet = new HashMap<>();
        playerLastChestplate = new HashMap<>();
        playerLastLeggings = new HashMap<>();
        playerLastBoots = new HashMap<>();
    }

    public void sendAddPlayerData(AddPlayerData data) {
        MovingData movingData = new MovingData(data.getEntityId(), data.getX(), data.getY(), data.getZ(), data.getYaw(), data.getPitch());
        playerLastLocation.put(data.getEntityId(), movingData);
        VimeReplays.getRecordingManager().addRecordingData(data);
    }

    public void sendMovingData(MovingData data) {
        if(playerLastLocation.containsKey(data.getEntityId())) {
            MovingData lastMovingData = playerLastLocation.get(data.getEntityId());

            if(lastMovingData.getX() != data.getX() || lastMovingData.getY() != data.getY() || lastMovingData.getZ() != data.getZ()
                    || lastMovingData.getYaw() != data.getYaw() || lastMovingData.getPitch() != data.getPitch()) {
                playerLastLocation.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        } else {
            playerLastLocation.put(data.getEntityId(), data);
            VimeReplays.getRecordingManager().addRecordingData(data);
        }
    }

    public void sendItemHeldData(Player player, ItemStack itemStack) {
        short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
        short itemId = (short) VimeReplays.getItemUtils().getItemId(itemStack);

        if(!itemStack.getEnchantments().isEmpty()) {
            EnchantedItemHeldData data = new EnchantedItemHeldData(playerId, itemId, itemStack.getEnchantments());

            if(playerLastItemInHand.containsKey(data.getEntityId())) {
                if(playerLastItemInHand.get(data.getEntityId()) instanceof EnchantedItemHeldData) {
                    EnchantedItemHeldData enchantedItemHeldData = (EnchantedItemHeldData) playerLastItemInHand.get(data.getEntityId());

                    if(enchantedItemHeldData.getItemId() == data.getItemId()) {
                        if(!enchantedItemHeldData.getEnchantments().equals(data.getEnchantments())) {
                            playerLastItemInHand.put(data.getEntityId(), data);
                            VimeReplays.getRecordingManager().addRecordingData(data);
                        }
                    } else {
                        playerLastItemInHand.put(data.getEntityId(), data);
                        VimeReplays.getRecordingManager().addRecordingData(data);
                    }
                } else {
                    playerLastItemInHand.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastItemInHand.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        } else {
            ItemHeldData data = new ItemHeldData(playerId, itemId);

            if(playerLastItemInHand.containsKey(data.getEntityId())) {
                ItemHeldData itemHeldData = playerLastItemInHand.get(data.getEntityId());

                if(itemHeldData.getItemId() != data.getItemId()) {
                    playerLastItemInHand.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastItemInHand.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        }
    }

    public void sendHelmetData(Player player, ItemStack itemStack) {
        short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
        short itemId = (short) VimeReplays.getItemUtils().getItemId(itemStack);

        if(!itemStack.getEnchantments().isEmpty()) {
            EnchantedHelmetData data = new EnchantedHelmetData(playerId, itemId, itemStack.getEnchantments());

            if(playerLastHelmet.containsKey(data.getEntityId())) {
                if(playerLastHelmet.get(data.getEntityId()) instanceof EnchantedHelmetData) {
                    EnchantedHelmetData enchantedHelmetData = (EnchantedHelmetData) playerLastHelmet.get(data.getEntityId());

                    if(enchantedHelmetData.getItemId() == data.getItemId()) {
                        if(!enchantedHelmetData.getEnchantments().equals(data.getEnchantments())) {
                            playerLastHelmet.put(data.getEntityId(), data);
                            VimeReplays.getRecordingManager().addRecordingData(data);
                        }
                    } else {
                        playerLastHelmet.put(data.getEntityId(), data);
                        VimeReplays.getRecordingManager().addRecordingData(data);
                    }
                } else {
                    playerLastHelmet.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastHelmet.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        } else {
            HelmetData data = new HelmetData(playerId, itemId);

            if(playerLastHelmet.containsKey(data.getEntityId())) {
                HelmetData HelmetData = playerLastHelmet.get(data.getEntityId());

                if(HelmetData.getItemId() != data.getItemId()) {
                    playerLastHelmet.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastHelmet.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        }
    }

    public void sendChestplateData(Player player, ItemStack itemStack) {
        short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
        short itemId = (short) VimeReplays.getItemUtils().getItemId(itemStack);

        if(!itemStack.getEnchantments().isEmpty()) {
            EnchantedChestplateData data = new EnchantedChestplateData(playerId, itemId, itemStack.getEnchantments());

            if(playerLastChestplate.containsKey(data.getEntityId())) {
                if(playerLastChestplate.get(data.getEntityId()) instanceof EnchantedChestplateData) {
                    EnchantedChestplateData enchantedChestplateData = (EnchantedChestplateData) playerLastChestplate.get(data.getEntityId());

                    if(enchantedChestplateData.getItemId() == data.getItemId()) {
                        if(!enchantedChestplateData.getEnchantments().equals(data.getEnchantments())) {
                            playerLastChestplate.put(data.getEntityId(), data);
                            VimeReplays.getRecordingManager().addRecordingData(data);
                        }
                    } else {
                        playerLastChestplate.put(data.getEntityId(), data);
                        VimeReplays.getRecordingManager().addRecordingData(data);
                    }
                } else {
                    playerLastChestplate.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastChestplate.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        } else {
            ChestplateData data = new ChestplateData(playerId, itemId);

            if(playerLastChestplate.containsKey(data.getEntityId())) {
                ChestplateData ChestplateData = playerLastChestplate.get(data.getEntityId());

                if(ChestplateData.getItemId() != data.getItemId()) {
                    playerLastChestplate.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastChestplate.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        }
    }

    public void sendLeggingsData(Player player, ItemStack itemStack) {
        short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
        short itemId = (short) VimeReplays.getItemUtils().getItemId(itemStack);

        if(!itemStack.getEnchantments().isEmpty()) {
            EnchantedLeggingsData data = new EnchantedLeggingsData(playerId, itemId, itemStack.getEnchantments());

            if(playerLastLeggings.containsKey(data.getEntityId())) {
                if(playerLastLeggings.get(data.getEntityId()) instanceof EnchantedLeggingsData) {
                    EnchantedLeggingsData enchantedLeggingsData = (EnchantedLeggingsData) playerLastLeggings.get(data.getEntityId());

                    if(enchantedLeggingsData.getItemId() == data.getItemId()) {
                        if(!enchantedLeggingsData.getEnchantments().equals(data.getEnchantments())) {
                            playerLastLeggings.put(data.getEntityId(), data);
                            VimeReplays.getRecordingManager().addRecordingData(data);
                        }
                    } else {
                        playerLastLeggings.put(data.getEntityId(), data);
                        VimeReplays.getRecordingManager().addRecordingData(data);
                    }
                } else {
                    playerLastLeggings.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastLeggings.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        } else {
            LeggingsData data = new LeggingsData(playerId, itemId);

            if(playerLastLeggings.containsKey(data.getEntityId())) {
                LeggingsData LeggingsData = playerLastLeggings.get(data.getEntityId());

                if(LeggingsData.getItemId() != data.getItemId()) {
                    playerLastLeggings.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastLeggings.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        }
    }

    public void sendBootsData(Player player, ItemStack itemStack) {
        short playerId = VimeReplays.getRecordingManager().getPlayerId(player.getName());
        short itemId = (short) VimeReplays.getItemUtils().getItemId(itemStack);

        if(!itemStack.getEnchantments().isEmpty()) {
            EnchantedBootsData data = new EnchantedBootsData(playerId, itemId, itemStack.getEnchantments());

            if(playerLastBoots.containsKey(data.getEntityId())) {
                if(playerLastBoots.get(data.getEntityId()) instanceof EnchantedBootsData) {
                    EnchantedBootsData enchantedBootsData = (EnchantedBootsData) playerLastBoots.get(data.getEntityId());

                    if(enchantedBootsData.getItemId() == data.getItemId()) {
                        if(!enchantedBootsData.getEnchantments().equals(data.getEnchantments())) {
                            playerLastBoots.put(data.getEntityId(), data);
                            VimeReplays.getRecordingManager().addRecordingData(data);
                        }
                    } else {
                        playerLastBoots.put(data.getEntityId(), data);
                        VimeReplays.getRecordingManager().addRecordingData(data);
                    }
                } else {
                    playerLastBoots.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastBoots.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        } else {
            BootsData data = new BootsData(playerId, itemId);

            if(playerLastBoots.containsKey(data.getEntityId())) {
                BootsData BootsData = playerLastBoots.get(data.getEntityId());

                if(BootsData.getItemId() != data.getItemId()) {
                    playerLastBoots.put(data.getEntityId(), data);
                    VimeReplays.getRecordingManager().addRecordingData(data);
                }
            } else {
                playerLastBoots.put(data.getEntityId(), data);
                VimeReplays.getRecordingManager().addRecordingData(data);
            }
        }
    }
}
