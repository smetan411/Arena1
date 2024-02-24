package arena.monstra;

import com.google.common.base.Strings;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import java.util.List;
import java.util.stream.Collectors;
import static arena.monstra.TovarnaNaZombiky.ZOMBIE_NAME;


public final class MonstraStav {

    private final World world;

    public MonstraStav(World world) {
        this.world = world;
    }

    public boolean jeMonstrum(LivingEntity monstrum) {
        var jmeno = monstrum.getCustomName();
        if (Strings.isNullOrEmpty(jmeno)) return false;
        return jmeno.startsWith(ZOMBIE_NAME);
    }
    public List<LivingEntity> getMonsters() {
        return world.getLivingEntities().stream().filter(entity -> jeMonstrum(entity)).collect(Collectors.toList());
    }

    public boolean jsouMonstraMrtva() {
        return getMonsters().isEmpty();
    }
}