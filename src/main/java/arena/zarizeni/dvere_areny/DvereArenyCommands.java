package arena.zarizeni.dvere_areny;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class DvereArenyCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;
        if(player.isOp()) {
            ItemStack dvere = new ItemStack(Material.OAK_DOOR, 1);
            var itemMeta = dvere.getItemMeta();
            if (itemMeta == null) return false;
            itemMeta.setDisplayName(DvereAreny.JMENO_DVERI_DO_ARENY);
            dvere.setItemMeta(itemMeta);
            player.getInventory().addItem(dvere);
        }
        return true;
    }
}
