package arena.zarizeni.monster_switch;

import arena.monstra.VlnyMonster;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ResetSwitchCommand implements CommandExecutor {

    private final VlnyMonster vlnyMonster;

    public ResetSwitchCommand(VlnyMonster vlnyMonster) {
        this.vlnyMonster = vlnyMonster;
    }

    @Override
    public boolean onCommand( CommandSender commandSender,  Command command, String s,  String[] strings) {
        if (commandSender.isOp()) {
            vlnyMonster.reset();
        }
        return true;
    }
}
