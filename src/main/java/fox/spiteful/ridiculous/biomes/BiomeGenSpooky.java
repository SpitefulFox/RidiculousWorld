package fox.spiteful.ridiculous.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.entities.EntityFrankenstein;
import fox.spiteful.ridiculous.world.WorldGenBigSpookyTree;
import fox.spiteful.ridiculous.world.WorldGenSpookyTree;
import net.minecraft.entity.monster.EntityWitch;
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

import java.util.Random;

public class BiomeGenSpooky extends BiomeGenBase {

    protected final WorldGenCanopyTree darkTree = new WorldGenCanopyTree(false);
    protected final WorldGenSpookyTree spookyTree = new WorldGenSpookyTree(false, true);
    protected final WorldGenBigSpookyTree bigSpookyTree = new WorldGenBigSpookyTree(false);

    public BiomeGenSpooky(int id)
    {
        super(id);
        this.spawnableCreatureList.clear();
        this.theBiomeDecorator.treesPerChunk = 10;
        this.theBiomeDecorator.grassPerChunk = 2;
        this.theBiomeDecorator.mushroomsPerChunk = 1;
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityFrankenstein.class, 90, 4, 4));
        BiomeManager.coolBiomes.add(new BiomeEntry(this, 8));
        BiomeDictionary.registerBiomeType(this, Type.SPOOKY, Type.MAGICAL, Type.FOREST);
        setBiomeName("Spooky Woods");
        setTemperatureRainfall(0.25F, 0.5F);
        setColor(0xF2A100);
        this.waterColorMultiplier = 0x970E0E;
    }

    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
        return 0x926200;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return 0xF2A100;
    }

    /**
     * takes temperature, returns color
     */
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float wat)
    {
        return 0x858585;
    }

    public void decorate(World world, Random rand, int chunkX, int chunkZ)
    {
         if(rand.nextInt(3) == 0) {
             for(int j = 0; j < 6;j++) {
                 int x = chunkX + rand.nextInt(16) + 8;
                 int z = chunkZ + rand.nextInt(16) + 8;
                 int y = rand.nextInt(world.getHeightValue(x, z) * 2);
                 for (int l = 0; l < 64; ++l) {
                     int i1 = x + rand.nextInt(8) - rand.nextInt(8);
                     int j1 = y + rand.nextInt(4) - rand.nextInt(4);
                     int k1 = z + rand.nextInt(8) - rand.nextInt(8);

                     if (world.isAirBlock(i1, j1, k1) && world.getBlock(i1, j1 - 1, k1) == Blocks.grass && Blocks.pumpkin.canPlaceBlockAt(world, i1, j1, k1)) {
                         world.setBlock(i1, j1, k1, rand.nextInt(5) <= 1 ? Blocks.lit_pumpkin : Blocks.pumpkin, rand.nextInt(4), 2);
                     }
                 }
             }
         }

        this.theBiomeDecorator.decorateChunk(world, rand, this, chunkX, chunkZ);
    }

    public WorldGenAbstractTree func_150567_a(Random rand)
    {
        return (WorldGenAbstractTree)(rand.nextInt(10) == 0 ? this.bigSpookyTree : rand.nextInt(5) != 0 ? this.spookyTree : this.darkTree);
    }

}
