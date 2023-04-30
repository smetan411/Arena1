package arena.listenery;

import arena.monstra.MonstraStav;
import arena.zarizeni.dvere_areny.DvereAreny;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class SmrtMonstra implements Listener {

    private final DvereAreny dvere;
    private final MonstraStav monstraStav;

    public SmrtMonstra(DvereAreny dvere, MonstraStav monstraStav) {
        this.dvere = dvere;
        this.monstraStav = monstraStav;
    }

    @EventHandler
    public void deathOfMonsters(EntityDeathEvent deathEvent) {
        if (monstraStav.jeMonstrum(deathEvent.getEntity()))
            if (monstraStav.jsouMonstraMrtva()) {
                dvere.otevriDvere();
            }
    }
}
