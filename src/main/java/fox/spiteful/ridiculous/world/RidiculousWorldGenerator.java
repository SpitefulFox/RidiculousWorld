package fox.spiteful.ridiculous.world;


import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;


import java.util.Random;

public class RidiculousWorldGenerator implements IWorldGenerator {

    public RidiculousWorldGenerator(){

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
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
        /*if(world.getBiomeGenForCoords(chunkX, chunkZ) == UnrealBiomes.madness) {
            cyclopean.generateStructuresInChunk(world, world.rand, chunkX, chunkZ);
        }
        if(world.getBiomeGenForCoords(chunkX, chunkZ) == UnrealBiomes.madness && chunkX % 8 == 0 && chunkZ % 8 == 0) {
            Block[] ablock = new Block[32768];
            cyclopean.func_151539_a(chunkGenerator, world, chunkX, chunkZ, ablock);
        }*/
    }

}
