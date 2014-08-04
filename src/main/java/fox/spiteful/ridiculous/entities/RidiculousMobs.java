package fox.spiteful.ridiculous.entities;

import cpw.mods.fml.common.registry.EntityRegistry;
import fox.spiteful.ridiculous.Ridiculous;
import fox.spiteful.ridiculous.entities.EntityFrankenstein;
import fox.spiteful.ridiculous.entities.EntityWarhorse;
import net.minecraftforge.common.DungeonHooks;

public class RidiculousMobs {
    public static void mobify(){
        EntityRegistry.registerModEntity(EntityFrankenstein.class, "Frankenstein", 1, Ridiculous.instance, 64, 3, true);
        EntityRegistry.registerModEntity(EntityWarhorse.class, "Warhorse", 2, Ridiculous.instance, 64, 3, true);
        EntityRegistry.registerModEntity(EntityPeep.class, "Peep", 3, Ridiculous.instance, 64, 3, true);
        EntityRegistry.registerModEntity(EntityUnicorn.class, "Unicorn", 4, Ridiculous.instance, 64, 3, true);
        EntityRegistry.registerModEntity(EntityCalavera.class, "Calavera", 5, Ridiculous.instance, 64, 3, true);
        EntityRegistry.registerModEntity(EntityGingerbread.class, "Gingerbread", 6, Ridiculous.instance, 64, 3, true);
        EntityRegistry.registerModEntity(EntityStarspawn.class, "Starspawn", 7, Ridiculous.instance, 64, 3, true);
    }
}
