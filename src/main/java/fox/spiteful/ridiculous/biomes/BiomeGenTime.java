package fox.spiteful.ridiculous.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Config;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.entities.EntityFrankenstein;
import fox.spiteful.ridiculous.entities.EntityOldEnderman;
import fox.spiteful.ridiculous.world.WorldGenBigSpookyTree;
import fox.spiteful.ridiculous.world.WorldGenSpookyTree;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class BiomeGenTime extends BiomeGenBase {

    private Random randy = new Random();

    public BiomeGenTime(int id)
    {
        super(id);
        /*this.spawnableCreatureList.clear();
        this.theBiomeDecorator.treesPerChunk = 10;
        this.theBiomeDecorator.grassPerChunk = 2;
        this.theBiomeDecorator.mushroomsPerChunk = 1;
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityFrankenstein.class, 90, 4, 4));*/
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySpider.class, 100, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 100, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityCreeper.class, 100, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 100, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityOldEnderman.class, 10, 1, 4));
        this.setHeight(height_LowPlains);
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = -1;
        this.theBiomeDecorator.grassPerChunk = 5;
        this.flowers.clear();
        this.flowers.add(new FlowerEntry(Blocks.yellow_flower, 0, 10));
        this.flowers.add(new FlowerEntry(RidiculousBlocks.flower, 0, 10));
        this.flowers.add(new FlowerEntry(RidiculousBlocks.flower, 1, 1));
        this.flowers.add(new FlowerEntry(RidiculousBlocks.flower, 2, 1));
        BiomeManager.addSpawnBiome(this);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeEntry(this, Config.timeWeight));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeEntry(this, Config.timeWeight));
        //BiomeManager.addStrongholdBiome(this);
        BiomeDictionary.registerBiomeType(this, Type.PLAINS, Type.MAGICAL);
        setBiomeName("Timeslip Fields");
        setTemperatureRainfall(0.25F, 0.5F);
        setColor(0x7FBBFF);
        //this.waterColorMultiplier = 0x970E0E;
    }

    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
        if(randy.nextInt(30) == 1)
            return 0x3399FF;
        else
            return 0xA2FF5F;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return 0x3AFF00;
    }

    /**
     * takes temperature, returns color
     */
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float wat)
    {
        return 0x778AFF;
    }

    public void decorate(World world, Random rand, int chunkX, int chunkZ)
    {
        if(rand.nextInt(3) == 0) {
            int m = rand.nextInt(5) + 1;
            for(int j = 0; j < m;j++) {
                int x = chunkX + rand.nextInt(16) + 8;
                int z = chunkZ + rand.nextInt(16) + 8;
                int y = rand.nextInt(world.getHeightValue(x, z) * 2);
                for (int l = 0; l < 64; ++l) {
                    int i1 = x + rand.nextInt(12) - rand.nextInt(12);
                    int j1 = y + rand.nextInt(4) - rand.nextInt(4);
                    int k1 = z + rand.nextInt(12) - rand.nextInt(12);

                    if(world.getBlock(i1, j1 -1, k1).getMaterial() == Material.grass && world.getBlock(i1, j1 -2, k1).getMaterial() == Material.ground && world.isAirBlock(i1, j1, k1)
                            && world.getBlock(i1 - 1, j1 -1, k1).getMaterial() == Material.grass && world.getBlock(i1 + 1, j1 -1, k1).getMaterial() == Material.grass
                            && world.getBlock(i1, j1 -1, k1 - 1).getMaterial() == Material.grass && world.getBlock(i1, j1 -1, k1 + 1).getMaterial() == Material.grass){
                        world.setBlock(i1, j1-1, k1, RidiculousBlocks.liquidTimeBlock, 0, 2);
                    }

                }
            }
        }

        for (int j = 0; j < 4; ++j)
        {
            int k = chunkX + rand.nextInt(16) + 8;
            int l = chunkZ + rand.nextInt(16) + 8;
            int i1 = rand.nextInt(world.getHeightValue(k, l) + 32);

            if(rand.nextInt(20) == 1)
                theBiomeDecorator.yellowFlowerGen.func_150550_a(RidiculousBlocks.flower, 1);
            else if(randy.nextBoolean())
                theBiomeDecorator.yellowFlowerGen.func_150550_a(Blocks.yellow_flower, 0);
            else
                theBiomeDecorator.yellowFlowerGen.func_150550_a(RidiculousBlocks.flower, 0);
            theBiomeDecorator.yellowFlowerGen.generate(world, rand, k, i1, l);
        }

        this.theBiomeDecorator.decorateChunk(world, rand, this, chunkX, chunkZ);
    }

    /**
     *
     * Returns tree for the BiomeDecorator to use
     */
    public WorldGenAbstractTree func_150567_a(Random rand)
    {
        return this.worldGeneratorTrees;
    }

}
