package arena.monstra;

import org.bukkit.Location;

import java.io.File;

public final class VlnyMonster {

    private final TovarnaNaZombiky tovarnaNaZombiky;
    private int pocitadlo = 1;

    public VlnyMonster(TovarnaNaZombiky tovarnaNaZombiky) {
        this.tovarnaNaZombiky = tovarnaNaZombiky;
    }

    public void dalsiVlna(Location location) {
        switch (pocitadlo) {
            case 1:
                tovarnaNaZombiky.createZombie(location, 1, 6);
                tovarnaNaZombiky.createZombie(location, 2, 3);
                tovarnaNaZombiky.createZombie(location, 3, 1);
                break;
            case 2:
                tovarnaNaZombiky.createZombie(location, 1, 8);
                tovarnaNaZombiky.createZombie(location, 2, 4);
                tovarnaNaZombiky.createZombie(location, 3, 2);
                tovarnaNaZombiky.createZombie(location, 4, 1);
                break;
            case 3:
                tovarnaNaZombiky.createZombie(location, 1, 12);
                tovarnaNaZombiky.createZombie(location, 2, 3);
                tovarnaNaZombiky.createZombie(location, 3, 5);
                tovarnaNaZombiky.createZombie(location, 4, 3);
                tovarnaNaZombiky.createZombie(location, 5, 1);
                break;
            case 4:
                tovarnaNaZombiky.createZombie(location, 1, 10);
                tovarnaNaZombiky.createZombie(location, 2, 6);
                tovarnaNaZombiky.createZombie(location, 3, 4);
                tovarnaNaZombiky.createZombie(location, 4, 3);
                tovarnaNaZombiky.createZombie(location, 5, 2);
                tovarnaNaZombiky.createZombie(location, 6, 1);
                break;
        }
        pocitadlo++;
    }

    public void reset() {
        pocitadlo = 1;
    }
}
