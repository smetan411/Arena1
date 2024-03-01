package arena.commands;


import arena.monstra.MonstraStav;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ZabijVsechnaMonstra implements CommandExecutor {

    private final MonstraStav monstraStav;

    public ZabijVsechnaMonstra(MonstraStav monstraStav) {
        this.monstraStav = monstraStav;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        var monstra = monstraStav.getMonsters();
        if (commandSender.isOp()) {
            monstra.forEach(monstrum -> monstrum.damage(2000));
        }
        return true;
    }
}
