package fox.spiteful.ridiculous.world;

import java.util.Random;

import fox.spiteful.ridiculous.Ridiculous;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenSpookyTree extends WorldGenAbstractTree
{
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** The metadata value of the wood to use in tree generation. */
    private final int metaWood;
    /** The metadata value of the leaves to use in tree generation. */
    private final int metaLeaves;
    /* True if the tree should have cobwebs */
    private final boolean cobwebs;

    public WorldGenSpookyTree(boolean blockNotify)
    {
        this(blockNotify, 4, 0, 0, false);
    }

    public WorldGenSpookyTree(boolean blockNotify, boolean webbed)
    {
        this(blockNotify, 4, 0, 0, webbed);
    }

    public WorldGenSpookyTree(boolean blockNotify, int height, int metadata, int leafdamage, boolean webbed)
    {
        super(blockNotify);
        this.minTreeHeight = height;
        this.metaWood = metadata;
        this.metaLeaves = leafdamage;
        this.cobwebs = webbed;
    }

    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        int l = rand.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        if (y >= 1 && y + l + 1 <= 256)
        {
            byte b0;
            int k1;
            Block block;

            for (int i1 = y; i1 <= y + 1 + l; ++i1)
            {
                b0 = 1;

                if (i1 == y)
                {
                    b0 = 0;
                }

                if (i1 >= y + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (int j1 = x - b0; j1 <= x + b0 && flag; ++j1)
                {
                    for (k1 = z - b0; k1 <= z + b0 && flag; ++k1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            block = world.getBlock(j1, i1, k1);

                            if (!this.isReplaceable(world, j1, i1, k1))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block2 = world.getBlock(x, y - 1, z);

                boolean isSoil = block2.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockSapling)Blocks.sapling);
                if (isSoil && y < 256 - l - 1)
                {
                    block2.onPlantGrow(world, x, y - 1, z, x, y, z);
                    b0 = 3;
                    byte b1 = 0;
                    int l1;
                    int i2;
                    int j2;
                    int i3;

                    for (k1 = y - b0 + l; k1 <= y + l; ++k1)
                    {
                        i3 = k1 - (y + l);
                        l1 = b1 + 1 - i3 / 2;

                        for (i2 = x - l1; i2 <= x + l1; ++i2)
                        {
                            j2 = i2 - x;

                            for (int k2 = z - l1; k2 <= z + l1; ++k2)
                            {
                                int l2 = k2 - z;

                                if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || rand.nextInt(2) != 0 && i3 != 0)
                                {
                                    Block block1 = world.getBlock(i2, k1, k2);

                                    if (block1.isAir(world, i2, k1, k2) || block1.isLeaves(world, i2, k1, k2))
                                    {
                                        this.setBlockAndNotifyAdequately(world, i2, k1, k2, RidiculousBlocks.treeLeaves, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for (k1 = 0; k1 < l; ++k1)
                    {
                        block = world.getBlock(x, y + k1, z);

                        if (block.isAir(world, x, y + k1, z) || block.isLeaves(world, x, y + k1, z))
                        {
                            if(k1 == 1 && rand.nextInt(5) == 0)
                                this.setBlockAndNotifyAdequately(world, x, y + k1, z, RidiculousBlocks.spookyLog, rand.nextInt(4));
                            else
                                this.setBlockAndNotifyAdequately(world, x, y + k1, z, RidiculousBlocks.treeLogs, this.metaWood);

                            if (this.cobwebs && k1 > 0)
                            {
                                if (rand.nextInt(3) > 0 && world.isAirBlock(x - 1, y + k1, z))
                                {
                                    this.setBlockAndNotifyAdequately(world, x - 1, y + k1, z, Blocks.web, 0);
                                }
                                else if (rand.nextInt(3) > 0 && world.isAirBlock(x + 1, y + k1, z))
                                {
                                    this.setBlockAndNotifyAdequately(world, x + 1, y + k1, z, Blocks.web, 0);
                                }
                                else if (rand.nextInt(3) > 0 && world.isAirBlock(x, y + k1, z - 1))
                                {
                                    this.setBlockAndNotifyAdequately(world, x, y + k1, z - 1, Blocks.web, 0);
                                }
                                else if (rand.nextInt(3) > 0 && world.isAirBlock(x, y + k1, z + 1))
                                {
                                    this.setBlockAndNotifyAdequately(world, x, y + k1, z + 1, Blocks.web, 0);
                                }
                            }
                        }
                    }

                    if (this.cobwebs)
                    {
                        for (k1 = y - 3 + l; k1 <= y + l; ++k1)
                        {
                            i3 = k1 - (y + l);
                            l1 = 2 - i3 / 2;

                            for (i2 = x - l1; i2 <= x + l1; ++i2)
                            {
                                for (j2 = z - l1; j2 <= z + l1; ++j2)
                                {
                                    if (world.getBlock(i2, k1, j2).isLeaves(world, i2, k1, j2))
                                    {
                                        if (rand.nextInt(12) == 0 && world.getBlock(i2, k1 - 1, j2).isAir(world, i2, k1 - 1, j2))
                                        {
                                            this.setBlockAndNotifyAdequately(world, i2, k1 - 1, j2, Blocks.web, 0);
                                        }
                                    }
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
        else
        {
            return false;
        }
    }

}