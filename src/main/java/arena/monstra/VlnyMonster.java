package arena.monstra;

import org.bukkit.Location;

public final class VlnyMonster {

    private final TovarnaNaZombiky tovarnaNaZombiky;
    private int pocitadlo = 1;
    private int maxPocitadlo = 10;

    public VlnyMonster(TovarnaNaZombiky tovarnaNaZombiky) {
        this.tovarnaNaZombiky = tovarnaNaZombiky;
    }

    public void dalsiVlna(Location location) {

        switch (pocitadlo) {
            case 1:
                tovarnaNaZombiky.createZombie(location, 1, 4);
                tovarnaNaZombiky.createZombie(location, 2, 1);
                break;
            case 2:
                tovarnaNaZombiky.createZombie(location, 1, 4);
                tovarnaNaZombiky.createZombie(location, 2, 3);
                break;
            case 3:
                tovarnaNaZombiky.createZombie(location, 1, 6);
                tovarnaNaZombiky.createZombie(location, 2, 4);
                tovarnaNaZombiky.createZombie(location, 3, 2);
                break;
            case 4:
                tovarnaNaZombiky.createZombie(location, 1, 4);
                tovarnaNaZombiky.createZombie(location, 2, 3);
                tovarnaNaZombiky.createZombie(location, 3, 3);
                tovarnaNaZombiky.createZombie(location, 4, 1);
                break;
            case 5:
                tovarnaNaZombiky.createZombie(location, 2, 6);
                tovarnaNaZombiky.createZombie(location, 3, 4);
                tovarnaNaZombiky.createZombie(location, 4, 2);
                break;
            case 6:
                tovarnaNaZombiky.createZombie(location, 2, 4);
                tovarnaNaZombiky.createZombie(location, 3, 3);
                tovarnaNaZombiky.createZombie(location, 4, 2);
                tovarnaNaZombiky.createZombie(location, 5, 1);
                break;
            case 7:
                tovarnaNaZombiky.createZombie(location, 2, 5);
                tovarnaNaZombiky.createZombie(location, 3, 3);
                tovarnaNaZombiky.createZombie(location, 4, 2);
                tovarnaNaZombiky.createZombie(location, 5, 2);
                tovarnaNaZombiky.createZombie(location, 6, 1);
                break;
            case 8:
                tovarnaNaZombiky.createZombie(location, 1, 20);
                break;
            case 9:
                tovarnaNaZombiky.createZombie(location, 8, 2);
                tovarnaNaZombiky.createZombie(location, 9, 2);
                break;
            case 10:
                tovarnaNaZombiky.createZombie(location, 1, 5);
                tovarnaNaZombiky.createZombie(location, 2, 4);
                tovarnaNaZombiky.createZombie(location, 4, 3);
                tovarnaNaZombiky.createZombie(location, 10, 1);
                break;
        }
        pocitadlo++;
        if (pocitadlo == maxPocitadlo) {
            pocitadlo = 1;
        }
    }


    public void reset() {
       pocitadlo = 1;
    }

}
