package Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class trashCommand
        implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if ((commandSender instanceof Player)) {
            Player player = (Player) commandSender;
            Inventory inventory = Bukkit.createInventory(null, 54, "Chest");
            if ((player.hasPermission("gtb.trash")) || (player.isOp())) {
                player.openInventory(inventory);
            }
        }
        return false;
    }
}
