package fox.spiteful.ridiculous.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Config;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.entities.EntityCalavera;
import fox.spiteful.ridiculous.entities.EntityGingerbread;
import fox.spiteful.ridiculous.entities.EntityPeep;
import fox.spiteful.ridiculous.entities.EntityUnicorn;
import fox.spiteful.ridiculous.world.WorldGenBubblegumTree;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class BiomeGenCandy extends BiomeGenBase{
    private WorldGenAbstractTree pineTree = new WorldGenTaiga2(false);
    private WorldGenAbstractTree bubblegum = new WorldGenBubblegumTree(false);

    public BiomeGenCandy(int id){
        super(id);
        this.theBiomeDecorator.treesPerChunk = 6;
        this.theBiomeDecorator.grassPerChunk = 2;
        this.theBiomeDecorator.mushroomsPerChunk = 1;
        setDisableRain();
        setHeight(new BiomeGenBase.Height(1.5F, 0.5F));
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPeep.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityUnicorn.class, 10, 4, 4));
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCalavera.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityGingerbread.class, 100, 4, 6));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 10, 4, 4));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(this, Config.candyWeight));
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.LUSH);
        setBiomeName("Rock Candy Mountain");
        setColor(0x8AFFF0);
        this.waterColorMultiplier = 0x899CFF;
        //this.waterColorMultiplier = 0x95E7BF;
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
        int m = rand.nextInt(4) + 1;
        for(int j = 0; j < m;j++) {
            int x = chunkX + rand.nextInt(16) + 8;
            int z = chunkZ + rand.nextInt(16) + 8;
            int y = rand.nextInt(world.getHeightValue(x, z) * 2);
            for (int l = 0; l < 64; ++l) {
                int i1 = x + rand.nextInt(16) - rand.nextInt(16);
                int j1 = y + rand.nextInt(4) - rand.nextInt(4);
                int k1 = z + rand.nextInt(16) - rand.nextInt(16);

                if (world.isAirBlock(i1, j1, k1) && world.isSideSolid(i1, j1 - 1, k1, ForgeDirection.UP)) {
                    int start = j1;
                    int max = j1 + rand.nextInt(5);
                    for(;j1 < max;j1++) {
                        world.setBlock(i1, j1, k1, RidiculousBlocks.rockCandy, 0, 2);
                        if(world.isAirBlock(i1 + 1, j1, k1) && world.isSideSolid(i1 + 1, j1 - 1, k1, ForgeDirection.UP)
                                && rand.nextInt(max - 1) + start > j1 && rand.nextBoolean()){
                            world.setBlock(i1 + 1, j1, k1, RidiculousBlocks.rockCandy, 0, 2);
                        }
                        if(world.isAirBlock(i1 - 1, j1, k1) && world.isSideSolid(i1 - 1, j1 - 1, k1, ForgeDirection.UP)
                                && rand.nextInt(max - 1) + start > j1 && rand.nextBoolean()){
                            world.setBlock(i1 - 1, j1, k1, RidiculousBlocks.rockCandy, 0, 2);
                        }
                        if(world.isAirBlock(i1, j1, k1 + 1) && world.isSideSolid(i1, j1 - 1, k1 + 1, ForgeDirection.UP)
                                && rand.nextInt(max - 1) + start > j1 && rand.nextBoolean()){
                            world.setBlock(i1, j1, k1 + 1, RidiculousBlocks.rockCandy, 0, 2);
                        }
                        if(world.isAirBlock(i1, j1, k1 - 1) && world.isSideSolid(i1, j1 - 1, k1 - 1, ForgeDirection.UP)
                                && rand.nextInt(max - 1) + start > j1 && rand.nextBoolean()){
                            world.setBlock(i1, j1, k1 - 1, RidiculousBlocks.rockCandy, 0, 2);
                        }
                    }
                }
            }
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

    public WorldGenAbstractTree func_150567_a(Random rand)
    {
        if(rand.nextBoolean())
            return pineTree;
        else
            return bubblegum;
    }

}