package arena.commands;

import arena.tovarny.TovarnaNaZbrane;
import arena.tovarny.TovarnaNaZbroje;
import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public final class Obchodnik implements CommandExecutor {
    private final TovarnaNaZbrane tovarnaNaZbrane;
    private final TovarnaNaZbroje tovarnaNaZbroje;
    public static final String JMENO_OBCHODNIKA = "ObchodnikProHrace";

    public Obchodnik() {
        tovarnaNaZbrane = new TovarnaNaZbrane();
        tovarnaNaZbroje = new TovarnaNaZbroje();
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;
        if (player.isOp()) {
            var trader = (WanderingTrader) player.getWorld().spawnEntity(player.getLocation(), EntityType.WANDERING_TRADER);
            trader.setAI(false);
            trader.setCustomName(JMENO_OBCHODNIKA);
            //trader.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000000, 999999999, true));

            //training
            MerchantRecipe trainingSword = new MerchantRecipe(tovarnaNaZbrane.vyrobTrainingSword(), 999);
            trainingSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 1));

            MerchantRecipe trainingHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingHelmet(), 999);
            trainingHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 10));

            MerchantRecipe trainingChestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingChestPlate(), 999);
            trainingChestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 10));

            MerchantRecipe trainingLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingLeggins(), 999);
            trainingLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 10));

            MerchantRecipe trainingBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingBoots(), 999);
            trainingBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 10));

            //normal
            MerchantRecipe normalSword = new MerchantRecipe(tovarnaNaZbrane.vyrobNormalSword(), 999);
            normalSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 30));

            MerchantRecipe chainMaleHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleHelmet(), 999);
            chainMaleHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

            MerchantRecipe chainMaleChestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleChestPlate(), 999);
            chainMaleChestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

            MerchantRecipe chainMaleLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleLeggins(), 999);
            chainMaleLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

            MerchantRecipe chainMaleBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleBoots(), 999);
            chainMaleBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

            //pro
            MerchantRecipe proSword = new MerchantRecipe(tovarnaNaZbrane.vyrobProSword(), 999);
            proSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 40));

            MerchantRecipe plateHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobPlateHelmet(), 999);
            plateHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 30));

            MerchantRecipe chestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobChestPlate(), 999);
            chestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 30));

            MerchantRecipe plateLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobPlateLeggins(), 999);
            plateLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 30));

            MerchantRecipe plateBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorBoots(), 999);
            plateBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 30));

            //Gladiator
            MerchantRecipe gladiatorSword = new MerchantRecipe(tovarnaNaZbrane.vyrobGladiatorSword(), 999);
            gladiatorSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 60));

            MerchantRecipe gladiatorHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorHelmet(), 999);
            gladiatorHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 50));

            MerchantRecipe gladiatorChestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorChestplate(), 999);
            gladiatorChestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 50));

            MerchantRecipe gladiatorLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorLeggins(), 999);
            gladiatorLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 50));

            MerchantRecipe gladiatorBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorBoots(), 999);
            gladiatorBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 50));


            //items

            MerchantRecipe stit = new MerchantRecipe(tovarnaNaZbrane.vyrobStit(), 9999);
            stit.addIngredient(new ItemStack(Material.GOLD_NUGGET, 5));

            MerchantRecipe lapis = new MerchantRecipe(tovarnaNaZbrane.vyrobLapizLazuli(), 9999);
            lapis.addIngredient(new ItemStack(Material.GOLD_NUGGET, 1));

            MerchantRecipe zlateJabko = new MerchantRecipe(tovarnaNaZbrane.vyrobZlateJabko(), 9999);
            zlateJabko.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

            MerchantRecipe ocarovaneZlateJabko = new MerchantRecipe(tovarnaNaZbrane.vyrobOcarovaneZlateJablko(), 9999);
            ocarovaneZlateJabko.addIngredient(new ItemStack(Material.GOLD_NUGGET, 50));

            //kouzelne zbrane
            MerchantRecipe frozenSword = new MerchantRecipe(tovarnaNaZbrane.vyrobFrozenSword(), 9999);
            frozenSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 100));

            //kouzelne zbrane
            MerchantRecipe healingSword = new MerchantRecipe(tovarnaNaZbrane.vyrobHealingSword(), 9999);
            healingSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 100));

            trader.setRecipes(Lists.newArrayList
                    (trainingSword, trainingHelmet, trainingChestPlate, trainingLeggins, trainingBoots, normalSword, chainMaleHelmet,
                            chainMaleChestPlate, chainMaleLeggins, chainMaleBoots, proSword, plateHelmet, chestPlate, plateLeggins,
                            plateBoots, gladiatorSword, gladiatorHelmet, gladiatorChestPlate, gladiatorLeggins, gladiatorBoots, stit,
                            lapis, zlateJabko, ocarovaneZlateJabko, frozenSword, healingSword));

        }
        return true;
    }

}

