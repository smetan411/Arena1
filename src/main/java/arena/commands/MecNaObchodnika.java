package arena.commands;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MecNaObchodnika implements CommandExecutor {

    public static final String MEC_NA_OBCHODNIKA = "MEC NA OBCHODNIKA";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;

        var mecNaObchodnika = new ItemStack(Material.GOLDEN_SWORD);
        var itemMeta = mecNaObchodnika.getItemMeta();
        itemMeta.setDisplayName(MEC_NA_OBCHODNIKA);
        itemMeta.setUnbreakable(true);
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 5, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        mecNaObchodnika.setItemMeta(itemMeta);
        player.getInventory().addItem(mecNaObchodnika);
        return true;
    }
}