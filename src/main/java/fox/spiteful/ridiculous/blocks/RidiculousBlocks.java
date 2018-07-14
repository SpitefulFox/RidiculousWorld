package fox.spiteful.ridiculous.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class RidiculousBlocks {

    /*public static Block treeLog;
    public static Block treeLeaves;*/

    public static Block spookyLog;

    public static Block extraSpookyLog;
    public static Block treeSaplings;
    public static Block treePlanks;
    public static Block[] treeStairs;
    public static Block craftBench;
    public static Block boneDust;
    public static Block rockCandy;
    public static Block candyCane;
    public static Block gingerbread;
    public static Block serpent;
    public static Block serpentRune;
    public static Block gloom;
    public static Block chest;
    public static Block flower;

    public static Fluid liquidTime;
    public static Block liquidTimeBlock;

    public static void blockBlockity(){
        spookyLog = new BlockFantasyLog().setRegistryName("spooky_log").setUnlocalizedName("spooky_log");
        ForgeRegistries.BLOCKS.register(spookyLog);
        ForgeRegistries.ITEMS.register(new ItemBlock(spookyLog).setRegistryName("spooky_log"));
        /*treeLeaves = GameRegistry.registerBlock(new BlockFantasyLeaves(), ItemBlockLeaves.class, "RidiculousLeaves");
        spookyLog = GameRegistry.registerBlock(new BlockSpookyLog(), "SpookyLog");
        treeSaplings = GameRegistry.registerBlock(new BlockFantasySapling(), ItemBlockSapling.class,"RidiculousSapling");
        treePlanks = GameRegistry.registerBlock(new BlockFantasyPlanks(), ItemBlockPlanks.class, "RidiculousPlanks");
        craftBench = GameRegistry.registerBlock(new BlockFancyCrafting(), ItemBlockCrafting.class, "RidiculousCrafting");
        treeStairs = new Block[BlockFantasyPlanks.types.length];
        for(int x = 0;x < treeStairs.length;x++){
            treeStairs[x] = GameRegistry.registerBlock(new BlockModdedStairs(treePlanks, x).setBlockName("stairs_" + BlockFantasyPlanks.types[x]), "stairs" + BlockFantasyPlanks.types[x]);
        }
        boneDust = GameRegistry.registerBlock(new BlockBoneDust(), "BoneDust");
        rockCandy = GameRegistry.registerBlock(new BlockRockCandy(), "RockCandy");
        candyCane = GameRegistry.registerBlock(new BlockCandyCane(), "CandyCane");
        gingerbread = GameRegistry.registerBlock(new BlockGingerbread(), "Gingerbread");
        serpent = GameRegistry.registerBlock(new BlockSerpent(), "Serpent");
        serpentRune = GameRegistry.registerBlock(new BlockSerpentRune(), "SerpentRune");
        gloom = GameRegistry.registerBlock(new BlockGloom(), "Gloom");
        chest = GameRegistry.registerBlock(new BlockChestRidiculous(), "Chest");
        GameRegistry.registerTileEntity(TileEntityChestRidiculous.class, "ChestRidiculous");
        flower = GameRegistry.registerBlock(new BlockTimeFlower(), ItemBlockTimeFlower.class, "RidiculousFlower");

        liquidTime = new Fluid("temporal_anomaly").setLuminosity(6);
        FluidRegistry.registerFluid(liquidTime);
        liquidTimeBlock = GameRegistry.registerBlock(new BlockTimeFluid(liquidTime), "Temporal_Anomaly");
        FluidContainerRegistry.registerFluidContainer(new FluidStack(liquidTime, 1000), new ItemStack(RidiculousItems.timeBucket), new ItemStack(Items.bucket));*/
    }
}
