package arena.tovarny;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;

public class TovarnaNaZbrane {

    public static final String FROZEN_SWORD = "FROZEN SWORD";
    public static final String HEALING_SWORD = "HEALING SWORD";


    //NORMALNI ZBRANE
    public ItemStack vyrobTrainingSword() {
        var trainingSword = new ItemStack(Material.WOODEN_SWORD, 1);
        var itemMeta = trainingSword.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Training Sword");
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 4, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        trainingSword.setItemMeta(itemMeta);
        return trainingSword;
    }

    public ItemStack vyrobNormalSword() {
        var normalSword = new ItemStack(Material.IRON_SWORD, 1);
        var itemMeta = normalSword.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Normal Sword");
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 6, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        normalSword.setItemMeta(itemMeta);
        return normalSword;
    }

    public ItemStack vyrobProSword() {
        var proSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        var itemMeta = proSword.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Pro Sword");
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 8, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        proSword.setItemMeta(itemMeta);
        return proSword;
    }

    public ItemStack vyrobGladiatorSword() {
        var gladiatorSword = new ItemStack(Material.GOLDEN_SWORD, 1);
        var itemMeta = gladiatorSword.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Sword");
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 10, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        gladiatorSword.setItemMeta(itemMeta);
        return gladiatorSword;
    }

    public ItemStack vyrobStit() {
        var stit = new ItemStack(Material.SHIELD, 1);
        var itemMeta = stit.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Shield");
        stit.setItemMeta(itemMeta);
        return stit;
    }



    //magicke mece - artefakty
    public ItemStack vyrobFrozenSword() {
        var frozenSword = new ItemStack(Material.DIAMOND_SWORD);
        var itemMeta = frozenSword.getItemMeta();
        itemMeta.setDisplayName(FROZEN_SWORD);
        itemMeta.setUnbreakable(true);
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 6, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        frozenSword.setItemMeta(itemMeta);
        return frozenSword;
    }

    public ItemStack vyrobHealingSword() {
        var healingSword = new ItemStack(Material.IRON_SWORD);
        var itemMeta = healingSword.getItemMeta();
        itemMeta.setDisplayName(HEALING_SWORD);
        itemMeta.setUnbreakable(true);
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 5, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        healingSword.setItemMeta(itemMeta);
        return healingSword;
    }

    //levne artefakty
    public ItemStack vyrobBojovouSekeru() {
        var bojovaSekera = new ItemStack(Material.IRON_AXE, 1);
        var itemMeta = bojovaSekera.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Battle Axe");
        AttributeModifier sila = new AttributeModifier("Damage", 12, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, sila);
        AttributeModifier rychlost = new AttributeModifier("Speed", -3, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, rychlost);
        bojovaSekera.setItemMeta(itemMeta);
        return bojovaSekera;
    }

    public ItemStack vyrobValecnouSekeru() {
        var valecnaSekera = new ItemStack(Material.NETHERITE_AXE, 1);
        var itemMeta = valecnaSekera.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("War Axe");
        AttributeModifier sila = new AttributeModifier("Damage", 30, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, sila);
        AttributeModifier rychlost = new AttributeModifier("Speed", -3.3, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, rychlost);
        valecnaSekera.setItemMeta(itemMeta);
        return valecnaSekera;
    }

    public ItemStack vyrobNuz() {
        var nuz = new ItemStack(Material.IRON_SHOVEL, 1);
        var itemMeta = nuz.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Nuz");
        AttributeModifier sila = new AttributeModifier("Damage", 5, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, sila);
        AttributeModifier rychlost = new AttributeModifier("Speed", 15, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, rychlost);
        nuz.setItemMeta(itemMeta);
        return nuz;
    }
}

