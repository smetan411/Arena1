package arena;


import arena.commands.MecNaObchodnika;
import arena.commands.Obchodnik;
import arena.commands.ZabijVsechnaMonstra;
import arena.listenery.*;
import arena.monstra.MonstraStav;
import arena.monstra.TovarnaNaZombiky;
import arena.monstra.VlnyMonster;
import arena.uloziste_dat.Uloziste;
import arena.zarizeni.dvere_areny.DvereAreny;
import arena.zarizeni.dvere_areny.DvereArenyCommands;
import arena.zarizeni.dvere_areny.DvereArenyListener;
import arena.zarizeni.dvere_areny.InicializaceDveriDoAreny;
import arena.zarizeni.monster_switch.InicializaceMonsterSwitche;
import arena.zarizeni.monster_switch.MonsterSwitchCommand;
import arena.zarizeni.monster_switch.MonsterSwitchListener;
import arena.zarizeni.monster_switch.ResetSwitchCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class MainArena extends JavaPlugin {

    @Override
    public void onEnable() {

        var world = getServer().getWorlds().get(0);
        var  tovarnaNaZombiky = new TovarnaNaZombiky(getDataFolder());
        var tovarnaNaVlny = new VlnyMonster(tovarnaNaZombiky);
        var uloziste = new Uloziste(world, this);
        var dvereAreny = new DvereAreny(this, uloziste);
        var dvereArenyListener = new DvereArenyListener(dvereAreny, this);
        var monsterSwitch = new MonsterSwitchListener(dvereAreny, tovarnaNaVlny, uloziste, this);
        new InicializaceMonsterSwitche(uloziste, world, this).inicializace();
        new InicializaceDveriDoAreny(dvereAreny, uloziste).inicializace();
        var monstraStav = new MonstraStav(world);

        //listenery
        getServer().getPluginManager().registerEvents(monsterSwitch, this);
        getServer().getPluginManager().registerEvents(new OdmenaZaZabitiMonstra(monstraStav), this);
        getServer().getPluginManager().registerEvents(new SmrtMonstra(dvereAreny, monstraStav), this);
        getServer().getPluginManager().registerEvents(new PripojeniRespawn(), this);
        getServer().getPluginManager().registerEvents(dvereArenyListener, this);
        getServer().getPluginManager().registerEvents(new ObchodnikNesmrtelnost(), this);
        getServer().getPluginManager().registerEvents(new Zbrane(), this);

        //commandy
        getCommand("+obchodnik").setExecutor(new Obchodnik());
        getCommand("+monsterSwitch").setExecutor(new MonsterSwitchCommand());
        getCommand("+resetMonsterSwitch").setExecutor(new ResetSwitchCommand(tovarnaNaVlny));
        getCommand("+dvere").setExecutor(new DvereArenyCommands());
        getCommand("+znicMonstra").setExecutor(new ZabijVsechnaMonstra(monstraStav));
        getCommand("+mecNaObchodnika").setExecutor(new MecNaObchodnika());

    }
}