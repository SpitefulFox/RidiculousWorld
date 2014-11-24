package fox.spiteful.ridiculous.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Config;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.entities.EntityShadowSlime;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.util.Random;

public class BiomeGenShadow extends BiomeGenBase {

    BiomeGenShadow(int id){
        super(id);
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.theBiomeDecorator.deadBushPerChunk = 4;
        this.theBiomeDecorator.mushroomsPerChunk = 8;
        this.theBiomeDecorator.reedsPerChunk = 0;
        this.theBiomeDecorator.clayPerChunk = 1;
        this.theBiomeDecorator.waterlilyPerChunk = 0;
        this.theBiomeDecorator.sandPerChunk2 = 0;
        this.theBiomeDecorator.sandPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 8;
        this.waterColorMultiplier = 0x00002F;
        this.flowers.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityShadowSlime.class, 60, 1, 1));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(this, Config.shadowWeight));
        BiomeManager.addStrongholdBiome(this);
        BiomeManager.addSpawnBiome(this);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.WET, BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.COLD, BiomeDictionary.Type.MAGICAL);
        setBiomeName("Shadow Fen");
        setColor(0x3D3D3D);
        setHeight(height_PartiallySubmerged);
        setTemperatureRainfall(0.4F, 0.9F);
    }

    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
        return 0x200061;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return 0x200061;
    }

    /**
     * takes temperature, returns color
     */
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float wat){
        return 0x000064;
    }

    public void decorate(World world, Random rand, int chunkX, int chunkZ)
    {
        this.theBiomeDecorator.decorateChunk(world, rand, this, chunkX, chunkZ);
        for (int j = 0; j < 2; ++j)
        {
            int x = chunkX + rand.nextInt(16) + 8;
            int z = chunkZ + rand.nextInt(16) + 8;
            int y = 70;
            for(int wy = 80;wy > 30;wy--){
                if(world.getBlock(x, wy, z) != Blocks.air){
                    y = wy;
                    break;
                }
            }
            //Lumberjack.log(Level.INFO, "X:" + x + " Y:" + y + " Z:" + z);
            WorldGenAbstractTree worldgenabstracttree = func_150567_a(rand);
            worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);

            if (worldgenabstracttree.generate(world, rand, x, y, z))
            {
                worldgenabstracttree.func_150524_b(world, rand, x, y, z);
            }
        }
    }

    /**
     *
     * Returns tree for the BiomeDecorator to use
     */
    public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
    {
        return this.worldGeneratorSwamp;
    }

    public void genTerrainBlocks(World world, Random rand, Block[] chunk, byte[] metadatamaybe, int xMaybe, int zMaybe, double wat)
    {
        for (int wut = 130; wut < chunk.length; wut+=256) {
            chunk[wut] = RidiculousBlocks.gloom;
            metadatamaybe[wut] = 0;
        }

        this.genBiomeTerrain(world, rand, chunk, metadatamaybe, xMaybe, zMaybe, wat);
    }
}