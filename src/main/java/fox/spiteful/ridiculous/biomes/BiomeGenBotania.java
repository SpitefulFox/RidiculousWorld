package fox.spiteful.ridiculous.biomes;

import fox.spiteful.ridiculous.Config;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeGenBotania extends Biome {

    //WorldGenAbstractTree livingwood = new WorldGenTsundereTree(false);
    WorldGenMinable livingrock;

    public BiomeGenBotania(){
        super(new BiomeProperties("Botanical Garden").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.4F));
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.grassPerChunk = 2;
        this.theBiomeDecorator.mushroomsPerChunk = 0;

        //this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityUnicorn.class, 8, 4, 4));
        //if(Compat.botania)
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(this, Config.botaniaWeight));
        BiomeManager.addSpawnBiome(this);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos)
    {
        return 0x00CA07;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 0x00E107;
    }

    /**
     * takes temperature, returns color
     */
    @Override
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float wat)
    {
        return 0xFF76C4;
    }

    /*public void decorate(World world, Random rand, int chunkX, int chunkZ)
    {
        this.theBiomeDecorator.decorateChunk(world, rand, this, chunkX, chunkZ);

        if(!Compat.botania)
            return;

        for(int i = 0; i < 8; i++) {
            int x = chunkX + rand.nextInt(16) + 8;
            int z = chunkZ + rand.nextInt(16) + 8;
            int y = world.getTopSolidOrLiquidBlock(x, z);
            int color = rand.nextInt(16);
            for(int j = 0; j < 30; j++) {
                int x1 = x + rand.nextInt(8) - rand.nextInt(8);
                int y1 = y + rand.nextInt(4) - rand.nextInt(4);
                int z1 = z + rand.nextInt(8) - rand.nextInt(8);
                if (world.isAirBlock(x1, y1, z1) && (!world.provider.hasNoSky || y1 < 127) && Compat.flower.canBlockStay(world, x1, y1, z1))
                    world.setBlock(x1, y1, z1, Compat.flower, color, 2);
            }
        }

        if(livingrock == null)
            livingrock = new WorldGenMinable(Compat.livingrock, 7);

        for(int l = 0; l < 32; ++l)
        {
            int i1 = chunkX + rand.nextInt(16);
            int j1 = 20 + rand.nextInt(108);
            int k1 = chunkZ + rand.nextInt(16);
            livingrock.generate(world, rand, i1, j1, k1);
        }
    }

    public WorldGenAbstractTree func_150567_a(Random rand)
    {
        if(rand.nextInt(3) == 1)
            return livingwood;
        else
            return worldGeneratorTrees;
    }*/

}