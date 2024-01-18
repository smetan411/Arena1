package arena.zarizeni.monster_switch;

import arena.zarizeni.uloziste_dat.Uloziste;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import java.util.Set;

import static arena.zarizeni.monster_switch.MonsterSwitchListener.MONSTER_SWITCH_ZNACKA;


public final class InicializaceMonsterSwitche {

    private final Uloziste uloziste;
    private final World world;
    private final Plugin plugin;

    public InicializaceMonsterSwitche(Uloziste uloziste, World world, Plugin plugin) {
        this.uloziste = uloziste;
        this.world = world;
        this.plugin = plugin;
    }

    public void inicializace() {
        Set<Location> locations = uloziste.nacti(MONSTER_SWITCH_ZNACKA);
        for (var location : locations) {
            world.getBlockAt(location).setMetadata(MONSTER_SWITCH_ZNACKA, new FixedMetadataValue(plugin, true));
        }
    }
}
