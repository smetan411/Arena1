package arena.commands;

import arena.zarizeni.dvere_areny.DvereAreny;
import arena.zarizeni.uloziste_dat.Uloziste;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static arena.zarizeni.dvere_areny.DvereAreny.DVERE_DO_ARENY_ZNACKA;
import static arena.zarizeni.monster_switch.MonsterSwitchListener.MONSTER_SWITCH_ZNACKA;

public class ResetHry implements CommandExecutor {

    private final DvereAreny dvereAreny;
    private final Uloziste uloziste;

    public ResetHry(DvereAreny dvereAreny, Uloziste uloziste) {
        this.dvereAreny = dvereAreny;
        this.uloziste = uloziste;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;
        if (player.isOp()) {
            dvereAreny.clear();
            uloziste.smaz(MONSTER_SWITCH_ZNACKA);
            uloziste.smaz(DVERE_DO_ARENY_ZNACKA);
        }
        return true;
    }
}