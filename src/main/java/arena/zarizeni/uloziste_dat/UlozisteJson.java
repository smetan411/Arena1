package arena.zarizeni.uloziste_dat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bukkit.Location;
import org.bukkit.World;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class UlozisteJson implements Uloziste {
    private final static String NAZEV_SOUBORU_GSON = "zarizeni.gson";
    private final Map<String, Set<Location>> lokaceZarizeni;
    private Gson gson = new Gson();
    private final World world;

    private final File datovyAdresar;

    //  funguje jako mapa - klíčem je např. název dveře, k němu přijde seznam lokací
    public UlozisteJson(File datovyAdresar, World world) {
        this.datovyAdresar = datovyAdresar;
        this.lokaceZarizeni = new HashMap<>();
        this.world = world;
        nactiDataZeSouboru();
    }

    // mapa - přidá lokaci ke klíči - např. umístěním dveří na konkrétní místo
    @Override
    public void uloz(String key, Set<Location> locations) {
        lokaceZarizeni.put(key, new HashSet<>(locations));
        ulozDataDoSouboru();
    }

    // mapa - smaže např. dveře, klíč plus lokace všech dveří (mapa)
    @Override
    public void smaz(String key) {
        lokaceZarizeni.remove(key);
        ulozDataDoSouboru();
    }

    // z bloku kam jsme uložili set lokací, načte podle klíče lokace
    @Override
    public Set<Location> nacti(String key) {
        return lokaceZarizeni.getOrDefault(key, new HashSet<>());
    }

    // přidá lokaci místa, kam jsme položili např. dveře
    @Override
    public void pridej(String key, Location location) {
        lokaceZarizeni.computeIfAbsent(key, k -> new HashSet<>()).add(location);
        ulozDataDoSouboru();
    }

    // odebere lokaci jednoho místa, kde byly např. dveře
    @Override
    public void odeber(String key, Location location) {
        lokaceZarizeni.computeIfPresent(key, (k, locations) -> {
            locations.remove(location);
            return locations;
        });
        ulozDataDoSouboru();
    }

    private void ulozDataDoSouboru() {
        try (FileWriter writer = new FileWriter(Path.of(datovyAdresar.getPath(), NAZEV_SOUBORU_GSON).toFile())) {
            gson.toJson(transformBeforeWrite(lokaceZarizeni), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void nactiDataZeSouboru() {
        Path cestaKSouboruSUlozistem = Path.of(datovyAdresar.getPath(), NAZEV_SOUBORU_GSON);
        try {
            if (Files.notExists(cestaKSouboruSUlozistem)) {
                Files.createFile(cestaKSouboruSUlozistem);
            }
            String ulozisteString = Files.readString(cestaKSouboruSUlozistem);
            TypeToken<HashMap<String, Set<LocationUloziste>>> typeToken = new TypeToken<>() {
            };
            Map<String, Set<LocationUloziste>> data = gson.fromJson(ulozisteString, typeToken.getType());
            lokaceZarizeni.putAll(transformAfterRead(data));
        }
        catch (IOException e){
            throw new RuntimeException("soubor s ulozistem nelze nacist", e);
        }
    }

    private Map<String, Set<Location>> transformAfterRead(Map<String, Set<LocationUloziste>> nactenaDataZUloziste)
    {
        if (nactenaDataZUloziste == null) {
            return Map.of();
        }
        Map<String, Set<Location>> result = new HashMap<>();
        for (var entry : nactenaDataZUloziste.entrySet()) {
            Set<LocationUloziste> locations = entry.getValue();
            Set<Location> resultLocations = locations.stream()
                    .map(loc -> new Location(world, loc.x(), loc.y(), loc.z()))
                    .collect(Collectors.toSet());
            result.put(entry.getKey(), resultLocations);
        }
        return result;
    }

    private Map<String, Set<LocationUloziste>> transformBeforeWrite(Map<String, Set<Location>> dataZUloziste)
    {
        Map<String, Set<LocationUloziste>> result = new HashMap<>();
        for (var entry : dataZUloziste.entrySet()) {
            Set<Location> locations = entry.getValue();
            Set<LocationUloziste> resultLocations = locations.stream()
                    .map(loc -> new LocationUloziste(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()))
                    .collect(Collectors.toSet());
            result.put(entry.getKey(), resultLocations);
        }
        return result;
    }

    private record LocationUloziste(long x, long y, long z) {

    }
}


