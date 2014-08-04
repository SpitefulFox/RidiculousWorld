package fox.spiteful.ridiculous.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenDullSpikes extends WorldGenerator {
    private Block base;

    public WorldGenDullSpikes(Block ground)
    {
        this.base = ground;
    }

    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        if (world.isAirBlock(x, y, z) && world.getBlock(x, y - 1, z) == this.base)
        {
            int l = rand.nextInt(32) + 6;
            int i1 = rand.nextInt(4) + 1;
            int j1;
            int k1;
            int l1;
            int i2;

            for (j1 = x - i1; j1 <= x + i1; ++j1)
            {
                for (k1 = z - i1; k1 <= z + i1; ++k1)
                {
                    l1 = j1 - x;
                    i2 = k1 - z;

                    if (l1 * l1 + i2 * i2 <= i1 * i1 + 1 && world.getBlock(j1, y - 1, k1) != this.base)
                    {
                        return false;
                    }
                }
            }

            for (j1 = y; j1 < y + l && j1 < 256; ++j1)
            {
                for (k1 = x - i1; k1 <= x + i1; ++k1)
                {
                    for (l1 = z - i1; l1 <= z + i1; ++l1)
                    {
                        i2 = k1 - x;
                        int j2 = l1 - z;

                        if (i2 * i2 + j2 * j2 <= i1 * i1 + 1)
                        {
                            world.setBlock(k1, j1, l1, Blocks.obsidian, 0, 2);
                        }
                    }
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}