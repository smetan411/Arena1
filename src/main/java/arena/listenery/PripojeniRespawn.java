package arena.listenery;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PripojeniRespawn implements Listener {

    @EventHandler
    public static void pripojeni(PlayerJoinEvent event) {
        event.getPlayer().getInventory().clear();
        event.getPlayer().getInventory().addItem(new ItemStack(Material.WOODEN_SHOVEL));
        event.getPlayer().getInventory().addItem(new ItemStack(Material.POTATO, 8));
        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), -110, 64, -33));

    }

    @EventHandler
    public static void respawnovani(PlayerRespawnEvent event) {
        event.getPlayer().getInventory().clear();
        event.getPlayer().getInventory().addItem(new ItemStack(Material.WOODEN_SHOVEL));
        event.getPlayer().getInventory().addItem(new ItemStack(Material.POTATO, 8));
        event.setRespawnLocation(new Location(event.getPlayer().getWorld(), -110, 64, -33));
    }
}