package arena.zarizeni.dvere_areny;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import static arena.zarizeni.dvere_areny.DvereAreny.DVERE_DO_ARENY_ZNACKA;
import static arena.zarizeni.dvere_areny.DvereAreny.JMENO_DVERI_DO_ARENY;

public final class DvereArenyListener implements Listener {

    private Plugin plugin;
    private DvereAreny dvereAreny;

    public DvereArenyListener(DvereAreny dvereAreny, Plugin plugin) {
        this.dvereAreny = dvereAreny;
        this.plugin = plugin;
    }

    /* Rusi otevirani dveri, aby se oteviraly pouze v zavislosti na monstrech v arene */
    @EventHandler
    public void neotevriDvere(PlayerInteractEvent event) {
        var block = event.getClickedBlock();
        if (block == null || event.getAction() == Action.LEFT_CLICK_BLOCK) return;
        var blockMetadata = block.getMetadata(JMENO_DVERI_DO_ARENY);
        if (!blockMetadata.isEmpty()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void polozDvere(BlockPlaceEvent e) {
        if (JMENO_DVERI_DO_ARENY.equals(e.getItemInHand().getItemMeta().getDisplayName())) {
            Block dolniCastDveri = e.getBlockPlaced();
            Block horniCastDveri = dolniCastDveri.getWorld().getBlockAt(dolniCastDveri.getLocation().add(0, 1, 0));
            dvereAreny.pridejDvere(dolniCastDveri);
            dvereAreny.pridejDvere(horniCastDveri);
            dvereAreny.otevriDvere();
        }
    }

    @EventHandler
    public void rozbijDvere(BlockBreakEvent e) {
        var blockMetadata = e.getBlock().getMetadata(DVERE_DO_ARENY_ZNACKA);
        if (!blockMetadata.isEmpty()) {
            var dolniCast = e.getBlock();
            var horniCast = dolniCast.getWorld().getBlockAt(dolniCast.getLocation().add(0, 1, 0));
            dvereAreny.odeberDvere(dolniCast);
            dvereAreny.odeberDvere(horniCast);
        }
    }
}
