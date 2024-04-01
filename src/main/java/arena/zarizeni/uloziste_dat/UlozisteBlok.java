package arena.zarizeni.uloziste_dat;

import com.google.common.primitives.Ints;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.TileState;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class UlozisteBlok implements Uloziste {

    private final World world;
    // uloziste - druh bloku
    private final Block ukladaciBlok;
    private final Plugin plugin;

    public UlozisteBlok(World world, Plugin plugin) {
        this.world = world;
        this.plugin = plugin;

        ukladaciBlok = world.getBlockAt(0, 0, 0);
        if (!(ukladaciBlok.getState() instanceof Chest)) {
            ukladaciBlok.setType(Material.CHEST);
        }
    }

    private PersistentDataContainer vratUloziste() {
        //ziska uloziste pro dany blok
        return ((TileState) ukladaciBlok.getState()).getPersistentDataContainer();
    }

    private void updateUloziste() {
        //updatuje stav bloku na disku aby se ulozily zmeny do nej zapsane natrvalo
        ukladaciBlok.getState().update(true, false);
    }

    //  z "uloziste" se vytvoří "container", který obsahuje data
    //  funguje jako mapa - klíčem je např. název dveře, k němu přijde seznam lokací
    public void uloz(String key, Set<Location> locations) {
        NamespacedKey namespaceKey = new NamespacedKey(plugin, key);
        List<Integer> seznam = new ArrayList<>();
        for (Location location : locations) {
            seznam.add(location.getBlockX());
            seznam.add(location.getBlockY());
            seznam.add(location.getBlockZ());
        }
        vratUloziste().set(namespaceKey, PersistentDataType.INTEGER_ARRAY, Ints.toArray(seznam));
        updateUloziste();
    }

    // mapa - smaže např. dveře, klíč plus lokace všech dveří (mapa)
    public void smaz(String key) {
        vratUloziste().remove(new NamespacedKey(plugin, key));
        updateUloziste();
    }

    // z bloku kam jsme uložili set lokací, načte podle klíče lokace
    public Set<Location> nacti(String key) {
        int[] souradnice = vratUloziste().get(new NamespacedKey(plugin, key), PersistentDataType.INTEGER_ARRAY);
        Set<Location> locations = new HashSet<>();
        if (souradnice == null) return locations;
        for (int i = 0; i < souradnice.length; i = i + 3) {
            locations.add(new Location(world, souradnice[i], souradnice[i + 1], souradnice[i + 2]));
        }
        return locations;
    }

    // přidá lokaci místa, kam jsme položili např. dveře
    public void pridej(String key, Location location) {
        Set<Location> locations = nacti(key);
        locations.add(location);
        uloz(key, locations);
    }

    // odebere lokaci jednoho místa, kde byly např. dveře
    public void odeber(String key, Location location) {
        Set<Location> locations = nacti(key);
        locations.remove(location);
        uloz(key, locations);
    }
}
