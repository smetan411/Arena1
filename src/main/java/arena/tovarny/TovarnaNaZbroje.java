package arena.tovarny;


import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class TovarnaNaZbroje {

    public ItemStack vyrobTrainingChestPlate() {
        var trainingChestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        var itemMeta = trainingChestplate.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Training Chestplate");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 1, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        trainingChestplate.setItemMeta(itemMeta);
        return trainingChestplate;
    }

    public ItemStack vyrobTrainingHelmet() {
        var trainingHelmet = new ItemStack(Material.LEATHER_HELMET, 1);
        var itemMeta = trainingHelmet.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Training Helmet");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 1, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        trainingHelmet.setItemMeta(itemMeta);
        return trainingHelmet;
    }

    public ItemStack vyrobTrainingLeggins() {
        var trainingLegins = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        var itemMeta = trainingLegins.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Training Legins");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 1, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        trainingLegins.setItemMeta(itemMeta);
        return trainingLegins;
    }

    public ItemStack vyrobTrainingBoots() {
        var trainingBoots = new ItemStack(Material.LEATHER_BOOTS, 1);
        var itemMeta = trainingBoots.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Training Boots");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 1, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        trainingBoots.setItemMeta(itemMeta);
        return trainingBoots;
    }

    public ItemStack vyrobChainmaleChestPlate() {
        var chainMaleChestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        var itemMeta = chainMaleChestplate.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Chainmale Chestplate");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 2, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        chainMaleChestplate.setItemMeta(itemMeta);
        return chainMaleChestplate;
    }

    public ItemStack vyrobChainmaleHelmet() {
        var chainMaleHelmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        var itemMeta = chainMaleHelmet.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Chainmale Helmet");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 2, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        chainMaleHelmet.setItemMeta(itemMeta);
        return chainMaleHelmet;
    }

    public ItemStack vyrobChainmaleLeggins() {
        var chainMaleHelmet = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        var itemMeta = chainMaleHelmet.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Chainmale Legins");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 2, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        chainMaleHelmet.setItemMeta(itemMeta);
        return chainMaleHelmet;
    }

    public ItemStack vyrobChainmaleBoots() {
        var chainMaleBoots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        var itemMeta = chainMaleBoots.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Chainmale Boots");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 2, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        chainMaleBoots.setItemMeta(itemMeta);
        return chainMaleBoots;
    }

    public ItemStack vyrobChestPlate() {
        var chainMaleChestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        var itemMeta = chainMaleChestplate.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Chestplate");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 3, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        chainMaleChestplate.setItemMeta(itemMeta);
        return chainMaleChestplate;
    }

    public ItemStack vyrobPlateHelmet() {
        var chainMaleHelmet = new ItemStack(Material.IRON_HELMET, 1);
        var itemMeta = chainMaleHelmet.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Plate Helmet");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 3, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        chainMaleHelmet.setItemMeta(itemMeta);
        return chainMaleHelmet;
    }

    public ItemStack vyrobPlateLeggins() {
        var chainMaleHelmet = new ItemStack(Material.IRON_LEGGINGS, 1);
        var itemMeta = chainMaleHelmet.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Plate Legins");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 2, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        chainMaleHelmet.setItemMeta(itemMeta);
        return chainMaleHelmet;
    }



    public ItemStack vyrobGladiatorChestplate() {
        var gladiatorMaleChestplate = new ItemStack(Material.GOLDEN_CHESTPLATE, 1);
        var itemMeta = gladiatorMaleChestplate.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Chestplate");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 4, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        gladiatorMaleChestplate.setItemMeta(itemMeta);
        return gladiatorMaleChestplate;
    }

    public ItemStack vyrobGladiatorHelmet() {
        var gladiatorHelmet = new ItemStack(Material.GOLDEN_HELMET, 1);
        var itemMeta = gladiatorHelmet.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Helmet");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 4, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        gladiatorHelmet.setItemMeta(itemMeta);
        return gladiatorHelmet;
    }

    public ItemStack vyrobGladiatorLeggins() {
        var gladiatorHelmet = new ItemStack(Material.GOLDEN_LEGGINGS, 1);
        var itemMeta = gladiatorHelmet.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Legins");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 4, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        gladiatorHelmet.setItemMeta(itemMeta);
        return gladiatorHelmet;
    }

    public ItemStack vyrobGladiatorBoots() {
        var gladiatorBoots = new ItemStack(Material.GOLDEN_BOOTS, 1);
        var itemMeta = gladiatorBoots.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Boots");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 4, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        gladiatorBoots.setItemMeta(itemMeta);
        return gladiatorBoots;
    }
}