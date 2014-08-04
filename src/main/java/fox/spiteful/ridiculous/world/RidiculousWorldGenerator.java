package fox.spiteful.ridiculous.world;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IWorldGenerator;
import fox.spiteful.ridiculous.biomes.UnrealBiomes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.ChestGenHooks;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RidiculousWorldGenerator implements IWorldGenerator {

    private MapGenCyclopean cyclopean;
    //private double[] noiseField;

    public RidiculousWorldGenerator(){
        MapGenStructureIO.registerStructure(MapGenCyclopean.Start.class, "Cyclopean Ruins");
        cyclopean = new MapGenCyclopean();
        StructureCyclopeanShards.registerCyclopeanShards();
        ChestGenHooks.addItem("cyclopeanRuins", new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 5));
        ChestGenHooks.addItem("cyclopeanRuins", new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 5));
        ChestGenHooks.addItem("cyclopeanRuins", new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5));
        ChestGenHooks.addItem("cyclopeanRuins", new WeightedRandomChestContent(Items.ender_eye, 0, 2, 5, 7));
        ChestGenHooks.addItem("cyclopeanRuins", new WeightedRandomChestContent(Items.ender_pearl, 0, 2, 5, 7));
        ChestGenHooks.addItem("cyclopeanRuins", new WeightedRandomChestContent(Items.record_11, 0, 1, 1, 4));
        ChestGenHooks.addItem("cyclopeanRuins", new WeightedRandomChestContent(Items.emerald, 0, 1, 2, 4));
    }

    /**
     * Generate some world
     *
     * @param random the chunk specific {@link java.util.Random}.
     * @param chunkX the chunk X coordinate of this chunk.
     * @param chunkZ the chunk Z coordinate of this chunk.
     * @param world : additionalData[0] The minecraft {@link net.minecraft.world.World} we're generating for.
     * @param chunkGenerator : additionalData[1] The {@link net.minecraft.world.chunk.IChunkProvider} that is generating.
     * @param chunkProvider : additionalData[2] {@link net.minecraft.world.chunk.IChunkProvider} that is requesting the world generation.
     *
     */
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
        if(world.getBiomeGenForCoords(chunkX, chunkZ) == UnrealBiomes.madness) {
            cyclopean.generateStructuresInChunk(world, world.rand, chunkX, chunkZ);
        }
        if(world.getBiomeGenForCoords(chunkX, chunkZ) == UnrealBiomes.madness && chunkX % 8 == 0 && chunkZ % 8 == 0) {
            Block[] ablock = new Block[32768];
            cyclopean.func_151539_a(chunkGenerator, world, chunkX, chunkZ, ablock);
        }
    }

}
