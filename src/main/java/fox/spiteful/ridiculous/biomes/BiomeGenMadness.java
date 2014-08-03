package fox.spiteful.ridiculous.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.util.Random;

public class BiomeGenMadness extends BiomeGenBase {

    public BiomeGenMadness(int id)
    {
        super(id);
        this.spawnableCreatureList.clear();
        this.theBiomeDecorator.treesPerChunk = -1;
        this.theBiomeDecorator.grassPerChunk = -1;
        this.theBiomeDecorator.mushroomsPerChunk = -1;
        this.topBlock = Blocks.packed_ice;
        this.fillerBlock = Blocks.packed_ice;
        this.spawnableCreatureList.clear();
        BiomeManager.coolBiomes.add(new BiomeManager.BiomeEntry(this, 9000));
        BiomeManager.warmBiomes.add(new BiomeManager.BiomeEntry(this, 9000));
        BiomeManager.addSpawnBiome(this);
        //BiomeManager.addStrongholdBiome(this);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.SNOWY);
        setBiomeName("Mountain of Madness");
        setTemperatureRainfall(0.05F, 0.5F);
        this.setHeight(BiomeGenBase.height_HighPlateaus);
        this.setColor(0x0E875B);
        this.waterColorMultiplier = 0x004A07;
    }

    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
        return 0x64553C;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return 0x64553C;
    }

    /**
     * takes temperature, returns color
     */
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float wat)
    {
        return 0x059100;
    }

    public void decorate(World world, Random rand, int chunkX, int chunkZ)
    {
        this.theBiomeDecorator.decorateChunk(world, rand, this, chunkX, chunkZ);
    }

}
