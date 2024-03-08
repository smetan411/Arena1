package arena.tovarny;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TovarnaNaJidlo {

    public ItemStack vyrobZlateJabko() {
        return new ItemStack(Material.GOLDEN_APPLE, 1);
    }

    public ItemStack vyrobOcarovaneZlateJablko() {
        return new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
    }

    public ItemStack vyrobChleba() {
        return new ItemStack(Material.BREAD, 8);
    }

    public ItemStack vyrobJablko() {
        return new ItemStack(Material.APPLE, 10);
    }

    public ItemStack vyrobMeloun() {
        return new ItemStack(Material.MELON_SLICE, 20);
    }

    public ItemStack vyrobSteak() {
        return new ItemStack(Material.COOKED_PORKCHOP, 4);
    }

    public ItemStack vyrobLapis() {
        return new ItemStack(Material.LAPIS_LAZULI);
    }

    public ItemStack vyrobLektvarPridanychZivotu() {
       var lektvar = new ItemStack(Material.POTION);
       PotionMeta meta = (PotionMeta) lektvar.getItemMeta();
       meta.setColor(Color.FUCHSIA);
       meta.setDisplayName(ChatColor.DARK_RED + "Lektvar pridanych zivotu");
       meta.addCustomEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 6000, 6,true, false), true);
       lektvar.setItemMeta(meta);
       return lektvar;
    }

    public ItemStack vyrobLektvarNajezenosti() {
        var lektvar = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) lektvar.getItemMeta();
        meta.setColor(Color.ORANGE);
        meta.setDisplayName(ChatColor.GOLD + "Lektvar najezenosti");
        meta.addCustomEffect(new PotionEffect(PotionEffectType.SATURATION, 12000, 1,true, false), true);
        lektvar.setItemMeta(meta);
        return lektvar;
    }

    public ItemStack vyrobLektvarRychlosti() {
        var lektvar = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) lektvar.getItemMeta();
        meta.setColor(Color.AQUA);
        meta.setDisplayName(ChatColor.AQUA + "Lektvar rychlosti");
        meta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 2000, 2,true, false), true);
        lektvar.setItemMeta(meta);
        return lektvar;
    }

// dava damage zombikum a umoznuje lecit kamarady
    public ItemStack vyrobLektvarLeceni() {
        var lektvar = new ItemStack(Material.SPLASH_POTION);
        PotionMeta meta = (PotionMeta) lektvar.getItemMeta();
        meta.setColor(Color.RED);
        meta.setDisplayName(ChatColor.RED + "Lektvar leceni");
        meta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4,true, false), true);
        lektvar.setItemMeta(meta);
        return lektvar;
    }



}
