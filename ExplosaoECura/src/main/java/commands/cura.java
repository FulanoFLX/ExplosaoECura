package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cura implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String aliases, String[] args) {

        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("curar")) {

            if(args.length != 2) {
                player.sendMessage(ChatColor.RED + "Uso: /curar <Player> <quantidade>");
                return false;
            }

            Player Target = Bukkit.getServer().getPlayer(args[0]);

            if(Target == null){
                player.sendMessage(ChatColor.RED + "Jogador não encontrado.");
                return false;
            }

            int quantity = Integer.parseInt(args[1]);
            if(quantity <= 0) {
                player.sendMessage(ChatColor.RED + "A quantidade deve ser positiva.");
                return false;
            }

            double newHealth = Math.min(Target.getHealth() + quantity, Target.getMaxHealth());
            Target.setHealth(newHealth);
            Target.sendMessage(ChatColor.GREEN + "Você foi curado em " + quantity + " corações <3");
            Target.playSound(Target.getLocation(), Sound.ENTITY_CAT_DEATH, 5, 5);
        }
        return true;
    }
}
