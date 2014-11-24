package fox.spiteful.ridiculous.biomes;

import com.mojang.authlib.GameProfile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Config;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.entities.EntityDaySkeleton;
import fox.spiteful.ridiculous.entities.EntityDayZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;
import java.util.UUID;

public class BiomeGenOssuary extends BiomeGenBase {
    private final String[] heads = new String[] {"SpitefulFox", "Kihira", "LycaonX", "joshiejack", "Vazkii",
        "nekosune", "tyguy21g", "Traxus_Co", "killajoke", "apuent", "Pokefenn", "direwolf20", "Mrvideogame101", "Azanor",
        "WayofFlowingTime", "Morvelaira", "Xephos", "Honeydew", "Israphel", "Herobrine", "Emoniph", "mDiyo", "KirinDave",
        "haighyorkie", "Drullkus", "Mikeemoo", "bluedartpro", "KingLemmingCoFH", "SOTMead", "saice", "ako_the_builder",
        "sirsengir", "florastar", "Sacheverell", "DanielleStarr", "Jabyvogux", "boliver77", "ApSciLiara", "corjaantje",
        "chylex", "Mithion", "MHF_Villager", "Pahimar", "iEdyn", "RoffleToys", "DylanGK", "Othlon", "Rorax", "tlovetech",
        "OndraSter", "eyamaz", "TTFTCUTS", "bspkrs", "MysteriousAges", "PurpleMentat", "StoneWaves", "VikeStep"
    };

    public BiomeGenOssuary(int id)
    {
        super(id);
        setDisableRain();
        setHeight(height_LowPlains);
        this.topBlock = RidiculousBlocks.boneDust;
        this.fillerBlock = RidiculousBlocks.boneDust;
        this.spawnableCreatureList.clear();
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.grassPerChunk = -999;
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityDaySkeleton.class, 100, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 100, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityDayZombie.class, 100, 4, 4));
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(this, Config.ossuaryWeight));
        BiomeManager.addStrongholdBiome(this);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.WASTELAND,
                BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT);
        setBiomeName("Ossuary");
        setTemperatureRainfall(1.0F, 0.0F);
        setColor(0xF4F5E6);
        this.waterColorMultiplier = 0x155A00;
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
    public int getSkyColorByTemp(float wat){
        return 0x921400;
    }

    public void decorate(World world, Random rand, int chunkX, int chunkZ)
    {
        if(rand.nextInt(4) == 0) {
            int m = rand.nextInt(5) + 1;
            for(int j = 0; j < m;j++) {
                int x = chunkX + rand.nextInt(16) + 8;
                int z = chunkZ + rand.nextInt(16) + 8;
                int y = rand.nextInt(world.getHeightValue(x, z) * 2);
                for (int l = 0; l < 64; ++l) {
                    int i1 = x + rand.nextInt(12) - rand.nextInt(12);
                    int j1 = y + rand.nextInt(4) - rand.nextInt(4);
                    int k1 = z + rand.nextInt(12) - rand.nextInt(12);

                    if (world.isAirBlock(i1, j1, k1) && world.isAirBlock(i1, j1 + 1, k1) && world.isAirBlock(i1, j1 + 2, k1)
                            && world.isAirBlock(i1 + 1, j1, k1) && world.isAirBlock(i1 - 1, j1, k1) && world.isAirBlock(i1, j1, k1 + 1)
                            && world.isAirBlock(i1, j1, k1 - 1) && world.isAirBlock(i1 + 1, j1 + 1, k1) && world.isAirBlock(i1 - 1, j1 + 1, k1)
                            && world.isAirBlock(i1, j1 + 1, k1 + 1) && world.isAirBlock(i1, j1 + 1, k1 - 1) && world.isSideSolid(i1, j1 - 1, k1, ForgeDirection.UP)) {
                        world.setBlock(i1, j1, k1, Blocks.fence, 0, 2);
                        world.setBlock(i1, j1 + 1, k1, Blocks.fence, 0, 2);
                        world.setBlock(i1, j1 + 2, k1, Blocks.skull, 1, 2);

                        if(world.getTileEntity(i1, j1 + 2, k1) != null && world.getTileEntity(i1, j1 + 2, k1) instanceof TileEntitySkull){
                            TileEntitySkull skull = (TileEntitySkull)(world.getTileEntity(i1, j1 + 2, k1));
                            if(rand.nextInt(9) == 0)
                                skull.func_152106_a(new GameProfile((UUID)null, heads[rand.nextInt(heads.length)]));
                            skull.func_145903_a(rand.nextInt(16));
                        }
                    }
                }
            }
        }

        this.theBiomeDecorator.decorateChunk(world, rand, this, chunkX, chunkZ);
    }

}