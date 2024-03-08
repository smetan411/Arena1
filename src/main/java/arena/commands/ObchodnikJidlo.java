package arena.commands;

import arena.tovarny.TovarnaNaJidlo;
import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;


public final class ObchodnikJidlo implements CommandExecutor {
    private final TovarnaNaJidlo tovarnaNaJidlo;
    public static final String JMENO_OBCHODNIKA = "ObchodnikProHrace";

    public ObchodnikJidlo() {
        tovarnaNaJidlo = new TovarnaNaJidlo();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;
        if (player.isOp()) {
            var trader = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
            trader.setVillagerType(Villager.Type.PLAINS);
            trader.setProfession(Villager.Profession.FARMER);
            trader.setAI(false);
            trader.setCustomName(JMENO_OBCHODNIKA);
            //trader.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000000, 999999999, true));


            MerchantRecipe chleba = new MerchantRecipe(tovarnaNaJidlo.vyrobChleba(), 9999);
            chleba.addIngredient(new ItemStack(Material.GOLD_NUGGET, 5));

            MerchantRecipe jablko = new MerchantRecipe(tovarnaNaJidlo.vyrobJablko(), 9999);
            jablko.addIngredient(new ItemStack(Material.GOLD_NUGGET, 3));

            MerchantRecipe steak = new MerchantRecipe(tovarnaNaJidlo.vyrobSteak(), 9999);
            steak.addIngredient(new ItemStack(Material.GOLD_NUGGET, 8));

            MerchantRecipe zlateJabko = new MerchantRecipe(tovarnaNaJidlo.vyrobZlateJabko(), 9999);
            zlateJabko.addIngredient(new ItemStack(Material.GOLD_NUGGET, 10));

            MerchantRecipe ocarovaneZlateJabko = new MerchantRecipe(tovarnaNaJidlo.vyrobOcarovaneZlateJablko(), 9999);
            ocarovaneZlateJabko.addIngredient(new ItemStack(Material.GOLD_NUGGET, 15));

            MerchantRecipe meloun = new MerchantRecipe(tovarnaNaJidlo.vyrobMeloun(), 9999);
            meloun.addIngredient(new ItemStack(Material.GOLD_NUGGET, 1));

            MerchantRecipe lektvarZivotu = new MerchantRecipe(tovarnaNaJidlo.vyrobLektvarPridanychZivotu(), 9999);
            lektvarZivotu.addIngredient(new ItemStack(Material.GOLD_NUGGET, 60));

            MerchantRecipe lektvarRychlosti = new MerchantRecipe(tovarnaNaJidlo.vyrobLektvarRychlosti(), 9999);
            lektvarRychlosti.addIngredient(new ItemStack(Material.GOLD_NUGGET, 40));

            MerchantRecipe lektvarNajezenosti = new MerchantRecipe(tovarnaNaJidlo.vyrobLektvarNajezenosti(), 9999);
            lektvarNajezenosti.addIngredient(new ItemStack(Material.GOLD_INGOT, 10));

            MerchantRecipe lapis = new MerchantRecipe(tovarnaNaJidlo.vyrobLapis(), 9999);
            lapis.addIngredient(new ItemStack(Material.GOLD_NUGGET, 5));

            MerchantRecipe lektvarLeceni = new MerchantRecipe(tovarnaNaJidlo.vyrobLektvarLeceni(), 9999);
            lektvarLeceni.addIngredient(new ItemStack(Material.GOLD_NUGGET, 8));

            trader.setRecipes(Lists.newArrayList
                    (meloun, jablko, chleba, steak, zlateJabko, ocarovaneZlateJabko, lapis, lektvarZivotu,
                            lektvarNajezenosti, lektvarRychlosti, lektvarLeceni ));

        }
        return true;
    }

}

