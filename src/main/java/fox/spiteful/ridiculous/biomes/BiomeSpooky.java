package fox.spiteful.ridiculous.biomes;

import fox.spiteful.ridiculous.Config;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeSpooky extends Biome {

    protected final WorldGenCanopyTree darkTree = new WorldGenCanopyTree(false);
    protected final WorldGenTrees normyTree = new WorldGenTrees(false);
    //protected final WorldGenSpookyTree spookyTree = new WorldGenSpookyTree(false, true);
    //protected final WorldGenBigSpookyTree bigSpookyTree = new WorldGenBigSpookyTree(false);

    public BiomeSpooky()
    {
        super(new Biome.BiomeProperties("Spooky Woods").setTemperature(0.7F).setRainfall(0.8F).setWaterColor(0x970E0E));
        setRegistryName("spooky_woods");
        ForgeRegistries.BIOMES.register(this);
        //registerBiome(Config.spookyID, "spooky_woods", this);
        this.spawnableCreatureList.clear();
        this.decorator.treesPerChunk = 10;
        this.decorator.grassPerChunk = 2;
        this.decorator.mushroomsPerChunk = 1;
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 10, 4, 4));
        //this.spawnableMonsterList.add(new SpawnListEntry(EntityFrankenstein.class, 90, 4, 4));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeEntry(this, Config.spookyWeight));
        BiomeManager.addStrongholdBiome(this);
        BiomeManager.addSpawnBiome(this);
        BiomeDictionary.addTypes(this, Type.SPOOKY, Type.MAGICAL, Type.FOREST, Type.DENSE, Type.RARE);
        //setColor(0xF2A100);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos)
    {
        return 0x926200;
        //return 0x6B4700;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos)
    {
        //return 0xF2A100;
        return 0xFF8400;

    }

    /**
     * takes temperature, returns color
     */
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float wat)
    {
        return 0x858585;
    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos)
    {
         if(rand.nextInt(3) == 0) {
             int i5 = rand.nextInt(16) + 8;
             int k9 = rand.nextInt(16) + 8;
             int j13 = world.getHeight(pos.add(i5, 0, k9)).getY() * 2;

             if (j13 > 0)
             {
                 int k16 = rand.nextInt(j13);
                 BlockPos position = pos.add(i5, k16, k9);
                 for (int i = 0; i < 96; ++i)
                 {
                     BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

                     if (world.isAirBlock(blockpos) && world.getBlockState(blockpos.down()).getBlock() == Blocks.GRASS && Blocks.PUMPKIN.canPlaceBlockAt(world, blockpos))
                     {
                         if(rand.nextBoolean())
                             world.setBlockState(blockpos, Blocks.PUMPKIN.getDefaultState().withProperty(BlockPumpkin.FACING, EnumFacing.Plane.HORIZONTAL.random(rand)), 2);
                         else
                             world.setBlockState(blockpos, Blocks.LIT_PUMPKIN.getDefaultState().withProperty(BlockPumpkin.FACING, EnumFacing.Plane.HORIZONTAL.random(rand)), 2);
                     }
                 }
             }
         }

        this.decorator.decorate(world, rand, this, pos);
    }

    /**
     *
     * Returns tree for the BiomeDecorator to use
     */
    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        //return rand.nextInt(10) == 0 ? this.bigSpookyTree : rand.nextInt(5) != 0 ? this.spookyTree : this.darkTree;
        return rand.nextBoolean() ? this.darkTree : this.normyTree;
    }

}
