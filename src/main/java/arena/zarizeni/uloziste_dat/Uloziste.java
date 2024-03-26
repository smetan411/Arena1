package arena.zarizeni.uloziste_dat;

import org.bukkit.Location;

import java.util.Set;

public interface Uloziste {

    //  z "uloziste" se vytvoří "container", který obsahuje data
    //  funguje jako mapa - klíčem je např. název dveře, k němu přijde seznam lokací
    void uloz(String key, Set<Location> locations);

    // mapa - smaže např. dveře, klíč plus lokace všech dveří (mapa)
    void smaz(String key);

    // z bloku kam jsme uložili set lokací, načte podle klíče lokace
    Set<Location> nacti(String key);

    // přidá lokaci místa, kam jsme položili např. dveře
    void pridej(String key, Location location);


    // odebere lokaci jednoho místa, kde byly např. dveře
    void odeber(String key, Location location);

}
