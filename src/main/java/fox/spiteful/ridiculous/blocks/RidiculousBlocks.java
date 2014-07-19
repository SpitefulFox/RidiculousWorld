package fox.spiteful.ridiculous.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class RidiculousBlocks {

    public static Block treeLogs;
    public static Block treeLeaves;
    public static Block spookyLog;
    public static Block treeSaplings;
    public static Block treePlanks;
    public static Block boneDust;
    public static Block rockCandy;

    public static void blockBlockity(){
        treeLogs = new BlockFantasyLog();
        GameRegistry.registerBlock(treeLogs, ItemBlockLog.class, "RidiculousLog");
        treeLeaves = new BlockFantasyLeaves();
        GameRegistry.registerBlock(treeLeaves, ItemBlockLeaves.class, "RidiculousLeaves");
        spookyLog = new BlockSpookyLog();
        GameRegistry.registerBlock(spookyLog, "SpookyLog");
        treeSaplings = new BlockFantasySapling();
        GameRegistry.registerBlock(treeSaplings, ItemBlockSapling.class,"RidiculousSapling");
        treePlanks = new BlockFantasyPlanks();
        GameRegistry.registerBlock(treePlanks, ItemBlockPlanks.class, "RidiculousPlanks");
        boneDust = new BlockBoneDust();
        GameRegistry.registerBlock(boneDust, "BoneDust");
        rockCandy = new BlockRockCandy();
        GameRegistry.registerBlock(rockCandy, "RockCandy");
    }
}
