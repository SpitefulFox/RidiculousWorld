package fox.spiteful.ridiculous.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Config;
import fox.spiteful.ridiculous.entities.EntityShoggoth;
import fox.spiteful.ridiculous.world.WorldGenDullSpikes;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.util.Random;

public class BiomeGenMadness extends BiomeGenBase {

    protected WorldGenerator spikeGen = new WorldGenDullSpikes(Blocks.packed_ice);

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
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 100, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityShoggoth.class, 90, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 30, 1, 4));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(this, Config.madnessWeight));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(this, Config.madnessWeight));
        BiomeManager.addStrongholdBiome(this);
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
        return 0x6B00D7;
    }

    public void decorate(World world, Random rand, int chunkX, int chunkZ)
    {
        if (rand.nextInt(5) == 0)
        {
            int i = chunkX + rand.nextInt(16) + 8;
            int j = chunkZ + rand.nextInt(16) + 8;
            int k = world.getTopSolidOrLiquidBlock(i, j);
            this.spikeGen.generate(world, rand, i, k, j);
        }


        int k = 3 + rand.nextInt(6);
        for (int l = 0; l < k; ++l)
        {
            int i1 = chunkX + rand.nextInt(16);
            int j1 = rand.nextInt(28) + 4;
            int k1 = chunkZ + rand.nextInt(16);

            if (world.getBlock(i1, j1, k1).isReplaceableOreGen(world, i1, j1, k1, Blocks.stone))
            {
                world.setBlock(i1, j1, k1, Blocks.emerald_ore, 0, 2);
            }
        }

        this.theBiomeDecorator.decorateChunk(world, rand, this, chunkX, chunkZ);
    }

}
