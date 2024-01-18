package arena.zarizeni.dvere_areny;

import arena.zarizeni.uloziste_dat.Uloziste;
import org.bukkit.Location;

import java.util.Set;

import static arena.zarizeni.dvere_areny.DvereAreny.DVERE_DO_ARENY_ZNACKA;


public class InicializaceDveriDoAreny {
    private final Uloziste uloziste;
    private final DvereAreny dvereAreny;

    public InicializaceDveriDoAreny(DvereAreny dvereAreny, Uloziste uloziste) {
        this.uloziste = uloziste;
        this.dvereAreny = dvereAreny;
    }

    public void inicializace() {
        Set<Location> lokaceBlokuDveri = uloziste.nacti(DVERE_DO_ARENY_ZNACKA);
        for (Location lokace : lokaceBlokuDveri) {
            dvereAreny.pridejDvere(lokace.getBlock());
        }
    }

}
