package fox.spiteful.ridiculous.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.entities.EntityPeep;
import fox.spiteful.ridiculous.entities.EntityUnicorn;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.util.Random;

public class BiomeGenCandy extends BiomeGenBase{
    private WorldGenAbstractTree pineTree = new WorldGenTaiga2(false);

    public BiomeGenCandy(int id){
        super(id);
        this.spawnableCreatureList.clear();
        this.theBiomeDecorator.treesPerChunk = 6;
        this.theBiomeDecorator.grassPerChunk = 2;
        this.theBiomeDecorator.mushroomsPerChunk = 1;
        setDisableRain();
        setHeight(new BiomeGenBase.Height(1.5F, 0.5F));
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPeep.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityUnicorn.class, 10, 4, 4));
        BiomeManager.warmBiomes.add(new BiomeManager.BiomeEntry(this, 900));
        BiomeManager.addSpawnBiome(this);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.MOUNTAIN);
        setBiomeName("Rock Candy Mountain");
        setColor(0x8AFFF0);
        this.waterColorMultiplier = 0x899CFF;
    }

    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
        return 0x29DEC6;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return 0x29DEC6;
    }

    /**
     * takes temperature, returns color
     */
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float wat)
    {
        return 0x4EFAFF;
    }

    public void decorate(World world, Random rand, int chunkX, int chunkZ)
    {
        this.theBiomeDecorator.decorateChunk(world, rand, this, chunkX, chunkZ);
    }

    public WorldGenAbstractTree func_150567_a(Random rand)
    {
        return pineTree;
    }

}
