package arena.listenery;

import arena.monstra.MonstraStav;
import arena.monstra.TovarnaNaZombiky;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class OdmenaZaZabitiMonstra implements Listener {

    private final MonstraStav monstraStav;
    private final TovarnaNaZombiky tovarnaNaZombiky;

    public OdmenaZaZabitiMonstra(MonstraStav monstraStav, TovarnaNaZombiky tovarnaNaZombiky) {
        this.monstraStav = monstraStav;
        this.tovarnaNaZombiky = tovarnaNaZombiky;
    }

    @EventHandler
    public void deathOfMonsters(EntityDeathEvent event) {

        if (monstraStav.jeMonstrum(event.getEntity())) {
            event.getDrops().clear();

            String jmenoMonstra = event.getEntity().getName();
            switch (jmenoMonstra) {
                case "Zombie LVL 1":
                    event.getDrops().add(new ItemStack(Material.GOLD_NUGGET));
                    break;
                case "Zombie LVL 2":
                    event.getDrops().add(new ItemStack(Material.GOLD_NUGGET, 2));
                    break;
                case "Zombie LVL 3":
                    event.getDrops().add(new ItemStack(Material.GOLD_NUGGET, 4));
                    break;
                case "Zombie LVL 4":
                    event.getDrops().add(new ItemStack(Material.GOLD_NUGGET, 6));
                    break;
                case "Zombie LVL 5":
                    event.getDrops().add(new ItemStack(Material.GOLD_NUGGET, 8));
                    break;
                case "Zombie LVL 6":
                    event.getDrops().add(new ItemStack(Material.GOLD_NUGGET, 10));
                    break;
                case "Zombie LVL 7":
                    event.getDrops().add(new ItemStack(Material.GOLD_NUGGET, 12));
                    break;
                case "Zombie LVL 8":
                    event.getDrops().add(new ItemStack(Material.GOLD_NUGGET, 20));
                    break;
                case "Zombie LVL 9":
                    event.getDrops().add(new ItemStack(Material.GOLD_NUGGET, 40));
                    break;
                case "Zombie LVL 10":
                    event.getDrops().add(new ItemStack(Material.GOLD_BLOCK, 5));
                    break;
            }
        }
    }
}