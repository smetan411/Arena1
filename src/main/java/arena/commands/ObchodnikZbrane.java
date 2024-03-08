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
import org.bukkit.entity.Villager;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;


public final class ObchodnikZbrane implements CommandExecutor {
    private final TovarnaNaZbrane tovarnaNaZbrane;
    private final TovarnaNaZbroje tovarnaNaZbroje;
    public static final String JMENO_OBCHODNIKA = "ObchodnikProHrace";

    public ObchodnikZbrane() {
        tovarnaNaZbrane = new TovarnaNaZbrane();
        tovarnaNaZbroje = new TovarnaNaZbroje();
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;
        if (player.isOp()) {
            var trader = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
            trader.setVillagerType(Villager.Type.PLAINS);
            trader.setProfession(Villager.Profession.ARMORER);
            trader.setAI(false);
            trader.setCustomName(JMENO_OBCHODNIKA);
            //trader.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000000, 999999999, true));

            //training
            MerchantRecipe trainingSword = new MerchantRecipe(tovarnaNaZbrane.vyrobTrainingSword(), 999);
            trainingSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 1));

            MerchantRecipe trainingHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingHelmet(), 999);
            trainingHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 5));

            MerchantRecipe trainingChestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingChestPlate(), 999);
            trainingChestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 5));

            MerchantRecipe trainingLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingLeggins(), 999);
            trainingLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 5));

            MerchantRecipe trainingBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobTrainingBoots(), 999);
            trainingBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 5));

            //normal
            MerchantRecipe normalSword = new MerchantRecipe(tovarnaNaZbrane.vyrobNormalSword(), 999);
            normalSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 15));

            MerchantRecipe chainMaleHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleHelmet(), 999);
            chainMaleHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 12));

            MerchantRecipe chainMaleChestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleChestPlate(), 999);
            chainMaleChestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 12));

            MerchantRecipe chainMaleLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleLeggins(), 999);
            chainMaleLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 12));

            MerchantRecipe chainMaleBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobChainmaleBoots(), 999);
            chainMaleBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 12));

            //pro
            MerchantRecipe proSword = new MerchantRecipe(tovarnaNaZbrane.vyrobProSword(), 999);
            proSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 25));

            MerchantRecipe plateHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobPlateHelmet(), 999);
            plateHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

            MerchantRecipe chestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobChestPlate(), 999);
            chestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

            MerchantRecipe plateLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobPlateLeggins(), 999);
            plateLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

            MerchantRecipe plateBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobPlateBoots(), 999);
            plateBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 20));

            //Gladiator
            MerchantRecipe gladiatorSword = new MerchantRecipe(tovarnaNaZbrane.vyrobGladiatorSword(), 999);
            gladiatorSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 50));

            MerchantRecipe gladiatorHelmet = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorHelmet(), 999);
            gladiatorHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 40));

            MerchantRecipe gladiatorChestPlate = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorChestplate(), 999);
            gladiatorChestPlate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 40));

            MerchantRecipe gladiatorLeggins = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorLeggins(), 999);
            gladiatorLeggins.addIngredient(new ItemStack(Material.GOLD_NUGGET, 40));

            MerchantRecipe gladiatorBoots = new MerchantRecipe(tovarnaNaZbroje.vyrobGladiatorBoots(), 999);
            gladiatorBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 40));


            MerchantRecipe stit = new MerchantRecipe(tovarnaNaZbrane.vyrobStit(), 9999);
            stit.addIngredient(new ItemStack(Material.GOLD_NUGGET, 5));


            //kouzelne zbrane
            MerchantRecipe frozenSword = new MerchantRecipe(tovarnaNaZbrane.vyrobFrozenSword(), 9999);
            frozenSword.addIngredient(new ItemStack(Material.GOLD_INGOT, 10));

            //kouzelne zbrane
            MerchantRecipe healingSword = new MerchantRecipe(tovarnaNaZbrane.vyrobHealingSword(), 9999);
            healingSword.addIngredient(new ItemStack(Material.GOLD_INGOT, 12));

            trader.setRecipes(Lists.newArrayList
                    (trainingSword, trainingHelmet, trainingChestPlate, trainingLeggins, trainingBoots, normalSword, chainMaleHelmet,
                            chainMaleChestPlate, chainMaleLeggins, chainMaleBoots, proSword, plateHelmet, chestPlate, plateLeggins,
                            plateBoots, gladiatorSword, gladiatorHelmet, gladiatorChestPlate, gladiatorLeggins, gladiatorBoots, stit,
                            frozenSword, healingSword));

        }
        return true;
    }

}

