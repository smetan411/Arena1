package arena.zarizeni.dvere_areny;

import arena.zarizeni.uloziste_dat.Uloziste;
import com.google.common.collect.Lists;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Door;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import java.util.List;

public final class DvereAreny {
    public static final String JMENO_DVERI_DO_ARENY = "Dvere do areny";
    public static final String DVERE_DO_ARENY_ZNACKA = "DVERE_DO_ARENY_ZNACKA";
    private final List<Block> dvere = Lists.newArrayList();
    private final Plugin plugin;
    private final Uloziste uloziste;

    public DvereAreny(Plugin plugin, Uloziste uloziste) {
        this.plugin = plugin;
        this.uloziste = uloziste;
    }

    private void zmenStavDveri(boolean stav) {
        for (Block blokDveri : dvere) {
            Door dvere = (Door) blokDveri.getBlockData();
            dvere.setOpen(stav);
            blokDveri.setBlockData(dvere);
        }
    }

    public void otevriDvere() {
        zmenStavDveri(true);
    }

    public void zavriDvere() {
        zmenStavDveri(false);
    }

    public void pridejDvere(Block block) {
        block.setMetadata(JMENO_DVERI_DO_ARENY, new FixedMetadataValue(plugin, true));
        dvere.add(block);
        uloziste.pridej(DVERE_DO_ARENY_ZNACKA, block.getLocation());
    }

    public void odeberDvere(Block block) {
        uloziste.odeber(DVERE_DO_ARENY_ZNACKA, block.getLocation());
        dvere.remove(block);
        block.removeMetadata(DVERE_DO_ARENY_ZNACKA, plugin);
    }

    public void clear() {
        dvere.clear();
    }
}
