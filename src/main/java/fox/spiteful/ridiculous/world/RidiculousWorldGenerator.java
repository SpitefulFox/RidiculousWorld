package fox.spiteful.ridiculous.world;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IWorldGenerator;
import fox.spiteful.ridiculous.biomes.UnrealBiomes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.MapGenStructureIO;

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
            Block[] ablock = new Block[32768];
            cyclopean.func_151539_a(chunkGenerator, world, chunkX, chunkZ, ablock);
            cyclopean.generateStructuresInChunk(world, world.rand, chunkX, chunkZ);
        }
        if(world.getBiomeGenForCoords(chunkX, chunkZ) == UnrealBiomes.madness && chunkX % 5 == 0 && chunkZ % 3 == 0) {

        }
    }

}
