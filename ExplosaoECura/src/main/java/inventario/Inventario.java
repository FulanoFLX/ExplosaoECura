package inventario;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Inventario implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("inventario")) {

            if(args.length > 0) {
                return false;
            }
            Inventory inventory = Bukkit.createInventory(null,54, "Aula");

            ItemStack Diamante = new ItemStack(Material.DIAMOND_SWORD);
            inventory.setItem(31,Diamante);
            player.openInventory(inventory);
        }
        return false;
    }
}
