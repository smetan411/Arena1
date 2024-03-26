package arena.zarizeni.uloziste_dat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.bukkit.Location;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.Reference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class UlozisteMap implements Uloziste {
    private final Map<String, Set<Location>> lokaceZarizeni;
    private final String NAZEV_SOUBORU_GSON = "zarizeni.gson";
    private Gson gson = new Gson();

    //  funguje jako mapa - klíčem je např. název dveře, k němu přijde seznam lokací
    public UlozisteMap(File datovyAdresar) {
        // nahrajeme data ze souboru
        Path cestaKSouboruDat
                = Path.of(datovyAdresar.getPath(), NAZEV_SOUBORU_GSON);
        if (Files.notExists(cestaKSouboruDat)) {
            lokaceZarizeni = new HashMap<>();
        } else {
            lokaceZarizeni = nactiDataZeSouboru();
        }
         gson = new GsonBuilder()
                 .registerTypeAdapter(Reference.class, new ReferenceTypeAdapter())
                 .setPrettyPrinting()
                 .create();
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
        try (FileWriter writer = new FileWriter(NAZEV_SOUBORU_GSON)) {
            gson.toJson(lokaceZarizeni, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Set<Location>> nactiDataZeSouboru() {
        try {
            FileReader reader = new FileReader(NAZEV_SOUBORU_GSON);
            return gson.fromJson(reader, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class ReferenceTypeAdapter extends TypeAdapter<Reference<?>> {
        @Override
        public void write(JsonWriter out, Reference<?> value) throws IOException {
            // You may customize the serialization logic here
            // For example, you can serialize the referent or ignore it
            out.nullValue();
        }

        @Override
        public Reference<?> read(JsonReader in) throws IOException {
            // You may customize the deserialization logic here
            // For example, you can read the serialized data and construct the Reference object
            return null;
        }
    }
}
