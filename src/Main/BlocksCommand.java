package Main;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

public class BlocksCommand
        implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if ((commandSender instanceof Player)) {
            Player player = (Player) commandSender;
            if ((player.hasPermission("gtb.blocks")) || (player.isOp())) {
                int amountOfDiamonds = 0;
                int amountOfEmeralds = 0;
                int amountOfIron = 0;
                int amountOfGold = 0;
                int amountOfGlowstone = 0;
                int coal = 0;
                int redstone = 0;
                int lapis = 0;
                int clay = 0;
                int itemsChanged = 0;
                int amountOfString = 0;
                ItemStack[] arrayOfItemStack;
                int j = (arrayOfItemStack = player.getInventory().getContents()).length;
                for (int i = 0; i < j; i++) {
                    ItemStack is = arrayOfItemStack[i];
                    if (is != null) {
                        if (is.getType() == Material.DIAMOND) {
                            player.getInventory().remove(is);
                            amountOfDiamonds += is.getAmount();
                        }
                        if (is.getType() == Material.EMERALD) {
                            amountOfEmeralds += is.getAmount();
                            player.getInventory().remove(is);
                        }
                        if (is.getType() == Material.IRON_INGOT) {
                            player.getInventory().remove(is);
                            amountOfIron += is.getAmount();
                        }
                        if (is.getType() == Material.GLOWSTONE_DUST) {
                            amountOfGlowstone += is.getAmount();
                            player.getInventory().remove(is);
                        }
                        if (is.getType() == Material.GOLD_INGOT) {
                            player.getInventory().remove(is);
                            amountOfGold += is.getAmount();
                        }
                        if (is.getType() == Material.COAL) {
                            player.getInventory().remove(is);
                            coal += is.getAmount();
                        }
                        if (is.getType() == Material.REDSTONE) {
                            redstone += is.getAmount();
                            player.getInventory().remove(is);
                        }
                        if ((is.getType() == Material.INK_SACK) && (((Dye) is.getData()).getColor() == DyeColor.BLUE)) {
                            player.getInventory().remove(is);
                            lapis += is.getAmount();
                        }
                        if (is.getType() == Material.CLAY_BALL) {
                            clay += is.getAmount();
                            player.getInventory().remove(is);
                        }
                        if (is.getType() == Material.STRING) {
                            player.getInventory().remove(is);
                            amountOfString += is.getAmount();
                        }
                    }
                }
                player.updateInventory();
                itemsChanged = amountOfDiamonds + amountOfEmeralds + amountOfGlowstone + amountOfGold + amountOfIron + coal + redstone + lapis + clay;

                int diamondsToTransform = amountOfDiamonds / 9;
                int diamondOverflow = amountOfDiamonds % 9;
                int emeraldsToTransform = amountOfEmeralds / 9;
                int emeraldsOverflow = amountOfEmeralds % 9;
                int ironToTransform = amountOfIron / 9;
                int ironOverflow = amountOfIron % 9;
                int goldToTransform = amountOfGold / 9;
                int goldOverflow = amountOfGold % 9;
                int glowstoneToTransform = amountOfGlowstone / 4;
                int glowstoneOverflow = amountOfGlowstone % 4;
                int stringToTransform = amountOfString / 4;
                int stringOverflow = amountOfString % 4;
                int rT = redstone / 9;
                int rO = redstone % 9;
                int lT = lapis / 9;
                int lO = lapis % 9;
                int cT = coal / 9;
                int cO = coal % 9;
                int pL = clay / 4;
                int pT = clay % 4;

                itemsChanged -= diamondOverflow + emeraldsOverflow + ironOverflow + goldOverflow + glowstoneOverflow + stringOverflow + rO + cO + lO + pT;

                player.getInventory().addItem(new ItemStack[]{new ItemStack(diamondsToTransform > 0 ? Material.DIAMOND_BLOCK : Material.AIR, diamondsToTransform), new ItemStack(emeraldsToTransform > 0 ? Material.EMERALD_BLOCK : Material.AIR, emeraldsToTransform), new ItemStack(diamondOverflow > 0 ? Material.DIAMOND : Material.AIR, diamondOverflow), new ItemStack(emeraldsOverflow > 0 ? Material.EMERALD : Material.AIR, emeraldsOverflow), new ItemStack(ironToTransform > 0 ? Material.IRON_BLOCK : Material.AIR, ironToTransform), new ItemStack(goldToTransform > 0 ? Material.GOLD_BLOCK : Material.AIR, goldToTransform), new ItemStack(glowstoneToTransform > 0 ? Material.GLOWSTONE : Material.AIR, glowstoneToTransform), new ItemStack(ironOverflow > 0 ? Material.IRON_INGOT : Material.AIR, ironOverflow), new ItemStack(goldOverflow > 0 ? Material.GOLD_INGOT : Material.AIR, goldOverflow), new ItemStack(glowstoneOverflow > 0 ? Material.GLOWSTONE_DUST : Material.AIR, glowstoneOverflow), new ItemStack(stringOverflow > 0 ? Material.STRING : Material.AIR, stringOverflow), new ItemStack(stringToTransform > 0 ? Material.WOOL : Material.AIR, stringToTransform)});

                player.getInventory().addItem(new ItemStack[]{new ItemStack(rT > 0 ? Material.REDSTONE_BLOCK : Material.AIR, rT)});

                player.getInventory().addItem(new ItemStack[]{new ItemStack(lT > 0 ? Material.LAPIS_BLOCK : Material.AIR, lT)});

                player.getInventory().addItem(new ItemStack[]{new ItemStack(cT > 0 ? Material.COAL_BLOCK : Material.AIR, cT)});

                player.getInventory().addItem(new ItemStack[]{new ItemStack(rO > 0 ? Material.REDSTONE : Material.AIR, rO)});

                player.getInventory().addItem(new ItemStack[]{new ItemStack(pL > 0 ? Material.CLAY : Material.AIR, pL)});

                player.getInventory().addItem(new ItemStack[]{new ItemStack(cO > 0 ? Material.COAL : Material.AIR, cO)});

                player.sendMessage(ChatColor.DARK_GREEN + "All possible items changed into " + itemsChanged / 9 + " blocks!");
                player.updateInventory();
            }
            return false;
        }
        return false;
    }
}
