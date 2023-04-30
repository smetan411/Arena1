package arena.zarizeni.monster_switch;

import arena.monstra.VlnyMonster;
import arena.uloziste_dat.Uloziste;
import arena.zarizeni.dvere_areny.DvereAreny;
import com.google.common.collect.Sets;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

import static arena.zarizeni.monster_switch.MonsterSwitchCommand.MONSTER_SWITCH_NAME;


public final class MonsterSwitchListener implements Listener {

    final static String MONSTER_SWITCH_ZNACKA = "MONSTER_SWITCH_ZNACKA";

    private final Plugin plugin;
    private final DvereAreny dvere;
    private final VlnyMonster vlnyMonster;
    private final Uloziste uloziste;

    public MonsterSwitchListener(DvereAreny dvere, VlnyMonster vlnyMonster, Uloziste uloziste, Plugin plugin) {
        this.plugin = plugin;
        this.dvere = dvere;
        this.vlnyMonster = vlnyMonster;
        this.uloziste = uloziste;
    }

    @EventHandler
    public void spawnMonsters(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return; //udalost PlayerInteractEvent se pusti i pri zniceni a polozeni bloku, timto zabranime vygenerovani monster pro zniceni
        if (e.getClickedBlock().getType() != Material.LEVER) return; // zabranime pokracovani pri olozeni blocku

        var block = e.getClickedBlock();
        if (block == null) return;
        var blockMetadata = block.getMetadata(MONSTER_SWITCH_ZNACKA);
        if (!blockMetadata.isEmpty()) {
            dvere.zavriDvere();
            vlnyMonster.dalsiVlna(block.getLocation());
        }
    }

    @EventHandler
    public void placeMonsterSwitch(BlockPlaceEvent e) {
        if (MONSTER_SWITCH_NAME.equals(e.getItemInHand().getItemMeta().getDisplayName())) {
            var block = e.getBlockPlaced();
            block.setMetadata(MONSTER_SWITCH_ZNACKA, new FixedMetadataValue(plugin, true));
            uloziste.pridej(MONSTER_SWITCH_ZNACKA, block.getLocation());
        }
    }

    @EventHandler
    public void znicMonsterSwitch(BlockBreakEvent e) {
        var blockMetadata = e.getBlock().getMetadata(MONSTER_SWITCH_ZNACKA);
        if (!blockMetadata.isEmpty()) {
            e.getBlock().removeMetadata(MONSTER_SWITCH_ZNACKA, plugin);
            uloziste.odeber(MONSTER_SWITCH_ZNACKA, e.getBlock().getLocation());
            opravUloziste();
        }
    }

    private void opravUloziste() {
        var lokaceSpinacu = Sets.newHashSet(uloziste.nacti(MONSTER_SWITCH_ZNACKA));
        for (var lokaceSpinace : lokaceSpinacu) {
            var metadataSpinace = lokaceSpinace.getBlock().getMetadata(MONSTER_SWITCH_ZNACKA);
            if (metadataSpinace.isEmpty()) {
                lokaceSpinacu.remove(lokaceSpinace);
            }
        }
        uloziste.uloz(MONSTER_SWITCH_ZNACKA, lokaceSpinacu);
    }
}
