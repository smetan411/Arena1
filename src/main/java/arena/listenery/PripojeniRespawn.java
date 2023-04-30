package arena.listenery;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PripojeniRespawn implements Listener {

    @EventHandler
    public static void pripojeni(PlayerJoinEvent event) {
        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), -110, 64, -33));

    }

    @EventHandler
    public static void respawnovani(PlayerRespawnEvent event) {
        event.setRespawnLocation(new Location(event.getPlayer().getWorld(), -110, 64, -33));
    }
}