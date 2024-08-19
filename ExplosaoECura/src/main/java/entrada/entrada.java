package entrada;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class entrada implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(event.getPlayer().getName() + " entrou no servidor");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(event.getPlayer().getName() + " saiu do servidor");

    }
    @EventHandler
    public void breakBlockEvent (BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        World world = player.getWorld();
        if (block.getType() == Material.DIRT) {
            world.strikeLightningEffect(block.getLocation());
            player.playSound(player.getLocation(), Sound.ENTITY_WOLF_WHINE, 100,100);

        } else {
            world.createExplosion(block.getLocation(), 5.0f, false);

        }
        }
    }