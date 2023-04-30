package arena.listenery;


import arena.commands.Obchodnik;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static arena.commands.MecNaObchodnika.MEC_NA_OBCHODNIKA;


public class ObchodnikNesmrtelnost implements Listener {

    @EventHandler
    public void nastavNesmrtelnost(EntityDamageByEntityEvent udalost) {

        var utocnik = (Player) udalost.getDamager();

        if ((Obchodnik.JMENO_OBCHODNIKA.equals(udalost.getEntity().getCustomName())) &&
                (!(MEC_NA_OBCHODNIKA.equals(utocnik.getInventory().getItemInMainHand().getItemMeta().getDisplayName())))) {
            udalost.setCancelled(true);
        }

    }
}