package arena.zarizeni.monster_switch;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MonsterSwitchCommand implements CommandExecutor {

    public final static String MONSTER_SWITCH_NAME = "Monster switch";

    @Override
    public boolean onCommand( CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;
        if (player.isOp()) {
            var monsterSwitch = new ItemStack(Material.LEVER, 1);
            var itemMeta = monsterSwitch.getItemMeta();
            itemMeta.setDisplayName(MONSTER_SWITCH_NAME);
            monsterSwitch.setItemMeta(itemMeta);
            player.getInventory().addItem(monsterSwitch);
        }
        return true;
    }
}
