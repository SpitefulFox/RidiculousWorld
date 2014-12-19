package fox.spiteful.ridiculous.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Config;
import fox.spiteful.ridiculous.compat.Compat;
import fox.spiteful.ridiculous.entities.EntityUnicorn;
import fox.spiteful.ridiculous.world.WorldGenTsundereTree;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.util.Random;

public class BiomeGenBotania extends BiomeGenBase {

    WorldGenAbstractTree livingwood = new WorldGenTsundereTree(false);

    public BiomeGenBotania(int id){
        super(id);
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.grassPerChunk = 2;
        this.theBiomeDecorator.mushroomsPerChunk = 0;
        setHeight(height_MidPlains);
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityUnicorn.class, 8, 4, 4));
        if(Compat.botania)
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(this, Config.botaniaWeight));
        BiomeManager.addSpawnBiome(this);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH);
        setBiomeName("Botanical Garden");
        setColor(0xFF70F7);
    }

    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
        return 0x00CA07;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return 0x00E107;
    }

    /**
     * takes temperature, returns color
     */
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float wat)
    {
        return 0xFF76C4;
    }

    public void decorate(World world, Random rand, int chunkX, int chunkZ)
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
    }

    public WorldGenAbstractTree func_150567_a(Random rand)
    {
        if(rand.nextInt(3) == 1)
            return livingwood;
        else
            return worldGeneratorTrees;
    }

}