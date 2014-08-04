package fox.spiteful.ridiculous.world;

import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.compat.Compat;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.common.ChestGenHooks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StructureCyclopeanShards {
    private static final StructureCyclopeanShards.PieceWeight[] primaryComponents = new StructureCyclopeanShards.PieceWeight[] {
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Straight.class, 30, 0, true),
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Crossing3.class, 10, 4),
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Crossing.class, 10, 4),
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Stairs.class, 10, 3),
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Throne.class, 5, 2),
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Entrance.class, 5, 1)};
    private static final StructureCyclopeanShards.PieceWeight[] secondaryComponents = new StructureCyclopeanShards.PieceWeight[] {
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Corridor5.class, 25, 0, true),
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Crossing2.class, 15, 5),
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Corridor2.class, 5, 10),
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Corridor.class, 5, 10),
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Corridor3.class, 10, 3, true),
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.Corridor4.class, 7, 2),
        new StructureCyclopeanShards.PieceWeight(StructureCyclopeanShards.NetherStalkRoom.class, 5, 2)
    };

    private static Random randy = new Random();

    public static void registerCyclopeanShards()
    {
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Crossing3.class, "CyBCr");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.End.class, "CyBEF");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Straight.class, "CyBS");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Corridor3.class, "CyCCS");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Corridor4.class, "CyCTB");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Entrance.class, "CyCE");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Crossing2.class, "CySCSC");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Corridor.class, "CySCLT");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Corridor5.class, "CySC");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Corridor2.class, "CySCRT");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.NetherStalkRoom.class, "CyCSR");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Throne.class, "CyMT");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Crossing.class, "CyRC");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Stairs.class, "CySR");
        MapGenStructureIO.func_143031_a(StructureCyclopeanShards.Start.class, "CyStart");
    }

    public static Block getMaterial()
    {
        if(randy.nextInt(100) < 3)
            return RidiculousBlocks.serpentRune;
        else
            return RidiculousBlocks.serpent;
    }

    private static StructureCyclopeanShards.Piece createNextComponentRandom(StructureCyclopeanShards.PieceWeight weight, List list, Random rand, int wat1, int wat2, int wat3, int wat4, int wat5)
    {
        Class oclass = weight.weightClass;
        Object object = null;

        if (oclass == StructureCyclopeanShards.Straight.class)
        {
            object = StructureCyclopeanShards.Straight.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.Crossing3.class)
        {
            object = StructureCyclopeanShards.Crossing3.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.Crossing.class)
        {
            object = StructureCyclopeanShards.Crossing.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.Stairs.class)
        {
            object = StructureCyclopeanShards.Stairs.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.Throne.class)
        {
            object = StructureCyclopeanShards.Throne.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.Entrance.class)
        {
            object = StructureCyclopeanShards.Entrance.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.Corridor5.class)
        {
            object = StructureCyclopeanShards.Corridor5.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.Corridor2.class)
        {
            object = StructureCyclopeanShards.Corridor2.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.Corridor.class)
        {
            object = StructureCyclopeanShards.Corridor.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.Corridor3.class)
        {
            object = StructureCyclopeanShards.Corridor3.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.Corridor4.class)
        {
            object = StructureCyclopeanShards.Corridor4.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.Crossing2.class)
        {
            object = StructureCyclopeanShards.Crossing2.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }
        else if (oclass == StructureCyclopeanShards.NetherStalkRoom.class)
        {
            object = StructureCyclopeanShards.NetherStalkRoom.createValidComponent(list, rand, wat1, wat2, wat3, wat4, wat5);
        }

        return (StructureCyclopeanShards.Piece)object;
    }

    public static class Corridor extends StructureCyclopeanShards.Piece
    {
        private boolean field_111021_b;

        public Corridor() {}

        public Corridor(int p_i2049_1_, Random p_i2049_2_, StructureBoundingBox p_i2049_3_, int p_i2049_4_)
        {
            super(p_i2049_1_);
            this.coordBaseMode = p_i2049_4_;
            this.boundingBox = p_i2049_3_;
            this.field_111021_b = p_i2049_2_.nextInt(3) == 0;
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.field_111021_b = p_143011_1_.getBoolean("Chest");
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Chest", this.field_111021_b);
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentX((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Corridor createValidComponent(List p_74978_0_, Random p_74978_1_, int p_74978_2_, int p_74978_3_, int p_74978_4_, int p_74978_5_, int p_74978_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74978_2_, p_74978_3_, p_74978_4_, -1, 0, 0, 5, 7, 5, p_74978_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74978_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Corridor(p_74978_6_, p_74978_1_, structureboundingbox, p_74978_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 2, 0, 4, 5, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 3, 1, 4, 4, 1, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 3, 3, 4, 4, 3, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 5, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 4, 3, 5, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 3, 4, 1, 4, 4, RidiculousBlocks.serpentRune, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 3, 4, 3, 4, 4, RidiculousBlocks.serpentRune, RidiculousBlocks.serpent, false);
            int i;
            int j;

            if (this.field_111021_b)
            {
                i = this.getYWithOffset(2);
                j = this.getXWithOffset(3, 3);
                int k = this.getZWithOffset(3, 3);

                if (p_74875_3_.isVecInside(j, i, k))
                {
                    this.field_111021_b = false;
                    this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 3, 2, 3, ChestGenHooks.getInfo("cyclopeanRuins").getItems(randy), 3 + p_74875_2_.nextInt(5));
                }
            }

            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 6, 0, 4, 6, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);

            for (i = 0; i <= 4; ++i)
            {
                for (j = 0; j <= 4; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Corridor2 extends StructureCyclopeanShards.Piece
    {
        private boolean field_111020_b;

        public Corridor2() {}

        public Corridor2(int p_i2051_1_, Random p_i2051_2_, StructureBoundingBox p_i2051_3_, int p_i2051_4_)
        {
            super(p_i2051_1_);
            this.coordBaseMode = p_i2051_4_;
            this.boundingBox = p_i2051_3_;
            this.field_111020_b = p_i2051_2_.nextInt(3) == 0;
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.field_111020_b = p_143011_1_.getBoolean("Chest");
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Chest", this.field_111020_b);
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentZ((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Corridor2 createValidComponent(List p_74980_0_, Random p_74980_1_, int p_74980_2_, int p_74980_3_, int p_74980_4_, int p_74980_5_, int p_74980_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74980_2_, p_74980_3_, p_74980_4_, -1, 0, 0, 5, 7, 5, p_74980_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74980_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Corridor2(p_74980_6_, p_74980_1_, structureboundingbox, p_74980_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 5, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 1, 0, 4, 1, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 3, 0, 4, 3, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 2, 0, 4, 5, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 4, 4, 5, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 3, 4, 1, 4, 4, RidiculousBlocks.serpentRune, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 3, 4, 3, 4, 4, RidiculousBlocks.serpentRune, RidiculousBlocks.serpent, false);
            int i;
            int j;

            if (this.field_111020_b)
            {
                i = this.getYWithOffset(2);
                j = this.getXWithOffset(1, 3);
                int k = this.getZWithOffset(1, 3);

                if (p_74875_3_.isVecInside(j, i, k))
                {
                    this.field_111020_b = false;
                    this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 1, 2, 3, ChestGenHooks.getInfo("cyclopeanRuins").getItems(randy), 3 + p_74875_2_.nextInt(5));
                }
            }

            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 6, 0, 4, 6, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);

            for (i = 0; i <= 4; ++i)
            {
                for (j = 0; j <= 4; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Corridor3 extends StructureCyclopeanShards.Piece
    {

        public Corridor3() {}

        public Corridor3(int p_i2045_1_, Random p_i2045_2_, StructureBoundingBox p_i2045_3_, int p_i2045_4_)
        {
            super(p_i2045_1_);
            this.coordBaseMode = p_i2045_4_;
            this.boundingBox = p_i2045_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Corridor3 createValidComponent(List p_74982_0_, Random p_74982_1_, int p_74982_2_, int p_74982_3_, int p_74982_4_, int p_74982_5_, int p_74982_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74982_2_, p_74982_3_, p_74982_4_, -1, -7, 0, 5, 14, 10, p_74982_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74982_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Corridor3(p_74982_6_, p_74982_1_, structureboundingbox, p_74982_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            int i = this.getMetadataWithOffset(RidiculousBlocks.serpent, 2);

            for (int j = 0; j <= 9; ++j)
            {
                int k = Math.max(1, 7 - j);
                int l = Math.min(Math.max(k + 5, 14 - j), 13);
                int i1 = j;
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, j, 4, k, j, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, k + 1, j, 3, l - 1, j, Blocks.air, Blocks.air, false);

                if (j <= 6)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, i, 1, k + 1, j, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, i, 2, k + 1, j, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, i, 3, k + 1, j, p_74875_3_);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, l, j, 4, l, j, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, k + 1, j, 0, l - 1, j, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, k + 1, j, 4, l - 1, j, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);

                if ((j & 1) == 0)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, k + 2, j, 0, k + 3, j, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, k + 2, j, 4, k + 3, j, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                }

                for (int j1 = 0; j1 <= 4; ++j1)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, j1, -1, i1, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Corridor4 extends StructureCyclopeanShards.Piece
    {

        public Corridor4() {}

        public Corridor4(int p_i2046_1_, Random p_i2046_2_, StructureBoundingBox p_i2046_3_, int p_i2046_4_)
        {
            super(p_i2046_1_);
            this.coordBaseMode = p_i2046_4_;
            this.boundingBox = p_i2046_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            byte b0 = 1;

            if (this.coordBaseMode == 1 || this.coordBaseMode == 2)
            {
                b0 = 5;
            }

            this.getNextComponentX((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, b0, p_74861_3_.nextInt(8) > 0);
            this.getNextComponentZ((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, b0, p_74861_3_.nextInt(8) > 0);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Corridor4 createValidComponent(List p_74985_0_, Random p_74985_1_, int p_74985_2_, int p_74985_3_, int p_74985_4_, int p_74985_5_, int p_74985_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74985_2_, p_74985_3_, p_74985_4_, -3, 0, 0, 9, 7, 9, p_74985_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74985_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Corridor4(p_74985_6_, p_74985_1_, structureboundingbox, p_74985_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 1, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 8, 5, 8, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 6, 0, 8, 6, 5, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 2, 5, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 2, 0, 8, 5, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 3, 0, 1, 4, 0, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 3, 0, 7, 4, 0, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 4, 8, 2, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 4, 2, 2, 4, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 1, 4, 7, 2, 4, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 8, 8, 3, 8, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 6, 0, 3, 7, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 3, 6, 8, 3, 7, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 4, 0, 5, 5, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 3, 4, 8, 5, 5, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 3, 5, 2, 5, 5, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 3, 5, 7, 5, 5, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 4, 5, 1, 5, 5, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 4, 5, 7, 5, 5, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);

            for (int i = 0; i <= 5; ++i)
            {
                for (int j = 0; j <= 8; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, j, -1, i, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Corridor5 extends StructureCyclopeanShards.Piece
    {

        public Corridor5() {}

        public Corridor5(int p_i2050_1_, Random p_i2050_2_, StructureBoundingBox p_i2050_3_, int p_i2050_4_)
        {
            super(p_i2050_1_);
            this.coordBaseMode = p_i2050_4_;
            this.boundingBox = p_i2050_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Corridor5 createValidComponent(List p_74981_0_, Random p_74981_1_, int p_74981_2_, int p_74981_3_, int p_74981_4_, int p_74981_5_, int p_74981_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74981_2_, p_74981_3_, p_74981_4_, -1, 0, 0, 5, 7, 5, p_74981_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74981_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Corridor5(p_74981_6_, p_74981_1_, structureboundingbox, p_74981_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 5, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 2, 0, 4, 5, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 1, 0, 4, 1, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 3, 0, 4, 3, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 3, 1, 4, 4, 1, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 3, 3, 4, 4, 3, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 6, 0, 4, 6, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 4; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Crossing extends StructureCyclopeanShards.Piece
    {

        public Crossing() {}

        public Crossing(int p_i2057_1_, Random p_i2057_2_, StructureBoundingBox p_i2057_3_, int p_i2057_4_)
        {
            super(p_i2057_1_);
            this.coordBaseMode = p_i2057_4_;
            this.boundingBox = p_i2057_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 2, 0, false);
            this.getNextComponentX((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 2, false);
            this.getNextComponentZ((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 2, false);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Crossing createValidComponent(List p_74974_0_, Random p_74974_1_, int p_74974_2_, int p_74974_3_, int p_74974_4_, int p_74974_5_, int p_74974_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74974_2_, p_74974_3_, p_74974_4_, -2, 0, 0, 7, 9, 7, p_74974_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74974_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Crossing(p_74974_6_, p_74974_1_, structureboundingbox, p_74974_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 6, 1, 6, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 6, 7, 6, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 1, 6, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 6, 1, 6, 6, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 2, 0, 6, 6, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 2, 6, 6, 6, 6, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 6, 1, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 5, 0, 6, 6, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 2, 0, 6, 6, 1, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 2, 5, 6, 6, 6, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 6, 0, 4, 6, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 5, 0, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 6, 6, 4, 6, 6, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 5, 6, 4, 5, 6, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 6, 2, 0, 6, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 2, 0, 5, 4, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 6, 2, 6, 6, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 5, 2, 6, 5, 4, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);

            for (int i = 0; i <= 6; ++i)
            {
                for (int j = 0; j <= 6; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Crossing2 extends StructureCyclopeanShards.Piece
    {

        public Crossing2() {}

        public Crossing2(int p_i2048_1_, Random p_i2048_2_, StructureBoundingBox p_i2048_3_, int p_i2048_4_)
        {
            super(p_i2048_1_);
            this.coordBaseMode = p_i2048_4_;
            this.boundingBox = p_i2048_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
            this.getNextComponentX((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
            this.getNextComponentZ((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Crossing2 createValidComponent(List p_74979_0_, Random p_74979_1_, int p_74979_2_, int p_74979_3_, int p_74979_4_, int p_74979_5_, int p_74979_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74979_2_, p_74979_3_, p_74979_4_, -1, 0, 0, 5, 7, 5, p_74979_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74979_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Crossing2(p_74979_6_, p_74979_1_, structureboundingbox, p_74979_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 5, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 2, 0, 4, 5, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 4, 0, 5, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 2, 4, 4, 5, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 6, 0, 4, 6, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 4; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Crossing3 extends StructureCyclopeanShards.Piece
    {

        public Crossing3() {}

        public Crossing3(int p_i2041_1_, Random p_i2041_2_, StructureBoundingBox p_i2041_3_, int p_i2041_4_)
        {
            super(p_i2041_1_);
            this.coordBaseMode = p_i2041_4_;
            this.boundingBox = p_i2041_3_;
        }

        protected Crossing3(Random p_i2042_1_, int p_i2042_2_, int p_i2042_3_)
        {
            super(0);
            this.coordBaseMode = p_i2042_1_.nextInt(4);

            switch (this.coordBaseMode)
            {
                case 0:
                case 2:
                    this.boundingBox = new StructureBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
                    break;
                default:
                    this.boundingBox = new StructureBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
            }
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 8, 3, false);
            this.getNextComponentX((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 3, 8, false);
            this.getNextComponentZ((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 3, 8, false);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Crossing3 createValidComponent(List p_74966_0_, Random p_74966_1_, int p_74966_2_, int p_74966_3_, int p_74966_4_, int p_74966_5_, int p_74966_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74966_2_, p_74966_3_, p_74966_4_, -8, -3, 0, 19, 10, 19, p_74966_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74966_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Crossing3(p_74966_6_, p_74966_1_, structureboundingbox, p_74966_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 3, 0, 11, 4, 18, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 7, 18, 4, 11, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 5, 0, 10, 7, 18, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 8, 18, 7, 10, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 5, 0, 7, 5, 7, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 5, 11, 7, 5, 18, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 11, 5, 0, 11, 5, 7, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 11, 5, 11, 11, 5, 18, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 7, 7, 5, 7, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 11, 5, 7, 18, 5, 7, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 11, 7, 5, 11, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 11, 5, 11, 18, 5, 11, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 2, 0, 11, 2, 5, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 2, 13, 11, 2, 18, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 0, 0, 11, 1, 3, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 0, 15, 11, 1, 18, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            int i;
            int j;

            for (i = 7; i <= 11; ++i)
            {
                for (j = 0; j <= 2; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, j, p_74875_3_);
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, 18 - j, p_74875_3_);
                }
            }

            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 7, 5, 2, 11, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 13, 2, 7, 18, 2, 11, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 7, 3, 1, 11, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 15, 0, 7, 18, 1, 11, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);

            for (i = 0; i <= 2; ++i)
            {
                for (j = 7; j <= 11; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, j, p_74875_3_);
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, 18 - i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class End extends StructureCyclopeanShards.Piece
    {
        private int fillSeed;

        public End() {}

        public End(int p_i2043_1_, Random p_i2043_2_, StructureBoundingBox p_i2043_3_, int p_i2043_4_)
        {
            super(p_i2043_1_);
            this.coordBaseMode = p_i2043_4_;
            this.boundingBox = p_i2043_3_;
            this.fillSeed = p_i2043_2_.nextInt();
        }

        public static StructureCyclopeanShards.End func_74971_a(List p_74971_0_, Random p_74971_1_, int p_74971_2_, int p_74971_3_, int p_74971_4_, int p_74971_5_, int p_74971_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74971_2_, p_74971_3_, p_74971_4_, -1, -3, 0, 5, 10, 8, p_74971_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74971_0_, structureboundingbox) == null ? new StructureCyclopeanShards.End(p_74971_6_, p_74971_1_, structureboundingbox, p_74971_5_) : null;
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.fillSeed = p_143011_1_.getInteger("Seed");
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setInteger("Seed", this.fillSeed);
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            Random random1 = new Random((long)this.fillSeed);
            int i;
            int j;
            int k;

            for (i = 0; i <= 4; ++i)
            {
                for (j = 3; j <= 4; ++j)
                {
                    k = random1.nextInt(8);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, i, j, 0, i, j, k, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
                }
            }

            i = random1.nextInt(8);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 0, 0, 5, i, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            i = random1.nextInt(8);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 5, 0, 4, 5, i, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);

            for (i = 0; i <= 4; ++i)
            {
                j = random1.nextInt(5);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, i, 2, 0, i, 2, j, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            }

            for (i = 0; i <= 4; ++i)
            {
                for (j = 0; j <= 1; ++j)
                {
                    k = random1.nextInt(3);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, i, j, 0, i, j, k, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
                }
            }

            return true;
        }
    }

    public static class Entrance extends StructureCyclopeanShards.Piece
    {
        public Entrance() {}

        public Entrance(int p_i2047_1_, Random p_i2047_2_, StructureBoundingBox p_i2047_3_, int p_i2047_4_)
        {
            super(p_i2047_1_);
            this.coordBaseMode = p_i2047_4_;
            this.boundingBox = p_i2047_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 5, 3, true);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Entrance createValidComponent(List p_74984_0_, Random p_74984_1_, int p_74984_2_, int p_74984_3_, int p_74984_4_, int p_74984_5_, int p_74984_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74984_2_, p_74984_3_, p_74984_4_, -5, -3, 0, 13, 14, 13, p_74984_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74984_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Entrance(p_74984_6_, p_74984_1_, structureboundingbox, p_74984_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 0, 12, 4, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 0, 12, 13, 12, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 0, 1, 12, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 11, 5, 0, 12, 12, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 5, 11, 4, 12, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 5, 11, 10, 12, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 9, 11, 7, 12, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 12, 1, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 5, 0, 10, 12, 1, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 9, 0, 7, 12, 1, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 11, 2, 10, 12, 10, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 8, 0, 7, 8, 0, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            int i;

            for (i = 1; i <= 11; i += 2)
            {
                this.fillWithBlocks(p_74875_1_, p_74875_3_, i, 10, 0, i, 11, 0, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, i, 10, 12, i, 11, 12, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 10, i, 0, 11, i, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 10, i, 12, 11, i, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, 0, i, 13, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, 0, i, 13, 12, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, 0, 0, 13, i, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, 0, 12, 13, i, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, i + 1, 13, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, i + 1, 13, 12, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 0, 13, i + 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 12, 13, i + 1, p_74875_3_);
            }

            this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 0, 13, 0, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 0, 13, 12, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 0, 13, 0, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 12, 13, 0, p_74875_3_);

            for (i = 3; i <= 9; i += 2)
            {
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 7, i, 1, 8, i, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 11, 7, i, 11, 8, i, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            }

            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 2, 0, 8, 2, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 4, 12, 2, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 0, 0, 8, 1, 3, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 0, 9, 8, 1, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 4, 3, 1, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 9, 0, 4, 12, 1, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            int j;

            for (i = 4; i <= 8; ++i)
            {
                for (j = 0; j <= 2; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, j, p_74875_3_);
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, 12 - j, p_74875_3_);
                }
            }

            for (i = 0; i <= 2; ++i)
            {
                for (j = 4; j <= 8; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, j, p_74875_3_);
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, 12 - i, -1, j, p_74875_3_);
                }
            }

            this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 5, 5, 7, 5, 7, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 1, 6, 6, 4, 6, Blocks.air, Blocks.air, false);
            this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, 0, 6, 0, 6, p_74875_3_);
            if(Compat.teehee)
                this.placeBlockAtCurrentPosition(p_74875_1_, Compat.enderGoo, 0, 6, 5, 6, p_74875_3_);
            else
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_stone, 0, 6, 5, 6, p_74875_3_);
            i = this.getXWithOffset(6, 6);
            j = this.getYWithOffset(5);
            int k = this.getZWithOffset(6, 6);

            if (Compat.teehee && p_74875_3_.isVecInside(i, j, k))
            {
                p_74875_1_.scheduledUpdatesAreImmediate = true;
                Compat.enderGoo.updateTick(p_74875_1_, i, j, k, p_74875_2_);
                p_74875_1_.scheduledUpdatesAreImmediate = false;
            }

            return true;
        }
    }

    public static class NetherStalkRoom extends StructureCyclopeanShards.Piece
    {

        public NetherStalkRoom() {}

        public NetherStalkRoom(int p_i2052_1_, Random p_i2052_2_, StructureBoundingBox p_i2052_3_, int p_i2052_4_)
        {
            super(p_i2052_1_);
            this.coordBaseMode = p_i2052_4_;
            this.boundingBox = p_i2052_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 5, 3, true);
            this.getNextComponentNormal((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 5, 11, true);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.NetherStalkRoom createValidComponent(List p_74977_0_, Random p_74977_1_, int p_74977_2_, int p_74977_3_, int p_74977_4_, int p_74977_5_, int p_74977_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74977_2_, p_74977_3_, p_74977_4_, -5, -3, 0, 13, 14, 13, p_74977_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74977_0_, structureboundingbox) == null ? new StructureCyclopeanShards.NetherStalkRoom(p_74977_6_, p_74977_1_, structureboundingbox, p_74977_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 0, 12, 4, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 0, 12, 13, 12, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 0, 1, 12, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 11, 5, 0, 12, 12, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 5, 11, 4, 12, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 5, 11, 10, 12, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 9, 11, 7, 12, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 12, 1, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 5, 0, 10, 12, 1, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 9, 0, 7, 12, 1, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 11, 2, 10, 12, 10, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            int i;

            for (i = 1; i <= 11; i += 2)
            {
                this.fillWithBlocks(p_74875_1_, p_74875_3_, i, 10, 0, i, 11, 0, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, i, 10, 12, i, 11, 12, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 10, i, 0, 11, i, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 10, i, 12, 11, i, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, 0, i, 13, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, 0, i, 13, 12, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, 0, 0, 13, i, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, 0, 12, 13, i, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, i + 1, 13, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, i + 1, 13, 12, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 0, 13, i + 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 12, 13, i + 1, p_74875_3_);
            }

            this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 0, 13, 0, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 0, 13, 12, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 0, 13, 0, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpentRune, 0, 12, 13, 0, p_74875_3_);

            for (i = 3; i <= 9; i += 2)
            {
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 7, i, 1, 8, i, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 11, 7, i, 11, 8, i, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            }

            i = this.getMetadataWithOffset(RidiculousBlocks.serpent, 3);
            int j;
            int k;
            int l;

            for (j = 0; j <= 6; ++j)
            {
                k = j + 4;

                for (l = 5; l <= 7; ++l)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, i, l, 5 + j, k, p_74875_3_);
                }

                if (k >= 5 && k <= 8)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 5, k, 7, j + 4, k, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
                }
                else if (k >= 9 && k <= 10)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 8, k, 7, j + 4, k, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
                }

                if (j >= 1)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 6 + j, k, 7, 9 + j, k, Blocks.air, Blocks.air, false);
                }
            }

            for (j = 5; j <= 7; ++j)
            {
                this.placeBlockAtCurrentPosition(p_74875_1_, RidiculousBlocks.serpent, i, j, 12, 11, p_74875_3_);
            }

            this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 6, 7, 5, 7, 7, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 6, 7, 7, 7, 7, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 13, 12, 7, 13, 12, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 5, 2, 3, 5, 3, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 5, 9, 3, 5, 10, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 5, 4, 2, 5, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 9, 5, 2, 10, 5, 3, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 9, 5, 9, 10, 5, 10, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 10, 5, 4, 10, 5, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            j = this.getMetadataWithOffset(RidiculousBlocks.serpent, 0);
            k = this.getMetadataWithOffset(RidiculousBlocks.serpent, 1);
            this.placeBlockAtCurrentPosition(p_74875_1_, getMaterial(), k, 4, 5, 2, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, getMaterial(), k, 4, 5, 3, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, getMaterial(), k, 4, 5, 9, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, getMaterial(), k, 4, 5, 10, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, getMaterial(), j, 8, 5, 2, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, getMaterial(), j, 8, 5, 3, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, getMaterial(), j, 8, 5, 9, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, getMaterial(), j, 8, 5, 10, p_74875_3_);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 4, 4, 4, 4, 8, Blocks.end_stone, Blocks.end_stone, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 4, 4, 9, 4, 8, Blocks.end_stone, Blocks.end_stone, false);
            //this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 5, 4, 4, 5, 8, Blocks.nether_wart, Blocks.nether_wart, false);
            //this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 5, 4, 9, 5, 8, Blocks.nether_wart, Blocks.nether_wart, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 2, 0, 8, 2, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 4, 12, 2, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 0, 0, 8, 1, 3, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 0, 9, 8, 1, 12, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 4, 3, 1, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 9, 0, 4, 12, 1, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            int i1;

            for (l = 4; l <= 8; ++l)
            {
                for (i1 = 0; i1 <= 2; ++i1)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, l, -1, i1, p_74875_3_);
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, l, -1, 12 - i1, p_74875_3_);
                }
            }

            for (l = 0; l <= 2; ++l)
            {
                for (i1 = 4; i1 <= 8; ++i1)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, l, -1, i1, p_74875_3_);
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, 12 - l, -1, i1, p_74875_3_);
                }
            }

            return true;
        }
    }

    abstract static class Piece extends StructureComponent
    {
        public Piece() {}

        protected Piece(int p_i2054_1_)
        {
            super(p_i2054_1_);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_) {}

        protected void func_143012_a(NBTTagCompound p_143012_1_) {}

        private int getTotalWeight(List p_74960_1_)
        {
            boolean flag = false;
            int i = 0;
            StructureCyclopeanShards.PieceWeight pieceweight;

            for (Iterator iterator = p_74960_1_.iterator(); iterator.hasNext(); i += pieceweight.field_78826_b)
            {
                pieceweight = (StructureCyclopeanShards.PieceWeight)iterator.next();

                if (pieceweight.field_78824_d > 0 && pieceweight.field_78827_c < pieceweight.field_78824_d)
                {
                    flag = true;
                }
            }

            return flag ? i : -1;
        }

        private StructureCyclopeanShards.Piece getNextComponent(StructureCyclopeanShards.Start p_74959_1_, List p_74959_2_, List p_74959_3_, Random p_74959_4_, int p_74959_5_, int p_74959_6_, int p_74959_7_, int p_74959_8_, int p_74959_9_)
        {
            int j1 = this.getTotalWeight(p_74959_2_);
            boolean flag = j1 > 0 && p_74959_9_ <= 30;
            int k1 = 0;

            while (k1 < 5 && flag)
            {
                ++k1;
                int l1 = p_74959_4_.nextInt(j1);
                Iterator iterator = p_74959_2_.iterator();

                while (iterator.hasNext())
                {
                    StructureCyclopeanShards.PieceWeight pieceweight = (StructureCyclopeanShards.PieceWeight)iterator.next();
                    l1 -= pieceweight.field_78826_b;

                    if (l1 < 0)
                    {
                        if (!pieceweight.func_78822_a(p_74959_9_) || pieceweight == p_74959_1_.theCyclopeanRuinsWeight && !pieceweight.field_78825_e)
                        {
                            break;
                        }

                        StructureCyclopeanShards.Piece piece = StructureCyclopeanShards.createNextComponentRandom(pieceweight, p_74959_3_, p_74959_4_, p_74959_5_, p_74959_6_, p_74959_7_, p_74959_8_, p_74959_9_);

                        if (piece != null)
                        {
                            ++pieceweight.field_78827_c;
                            p_74959_1_.theCyclopeanRuinsWeight = pieceweight;

                            if (!pieceweight.func_78823_a())
                            {
                                p_74959_2_.remove(pieceweight);
                            }

                            return piece;
                        }
                    }
                }
            }

            return StructureCyclopeanShards.End.func_74971_a(p_74959_3_, p_74959_4_, p_74959_5_, p_74959_6_, p_74959_7_, p_74959_8_, p_74959_9_);
        }

        /**
         * Finds a random component to tack on to the bridge. Or builds the end.
         */
        private StructureComponent getNextComponent(StructureCyclopeanShards.Start p_74962_1_, List p_74962_2_, Random p_74962_3_, int p_74962_4_, int p_74962_5_, int p_74962_6_, int p_74962_7_, int p_74962_8_, boolean p_74962_9_)
        {
            if (Math.abs(p_74962_4_ - p_74962_1_.getBoundingBox().minX) <= 112 && Math.abs(p_74962_6_ - p_74962_1_.getBoundingBox().minZ) <= 112)
            {
                List list1 = p_74962_1_.primaryWeights;

                if (p_74962_9_)
                {
                    list1 = p_74962_1_.secondaryWeights;
                }

                StructureCyclopeanShards.Piece piece = this.getNextComponent(p_74962_1_, list1, p_74962_2_, p_74962_3_, p_74962_4_, p_74962_5_, p_74962_6_, p_74962_7_, p_74962_8_ + 1);

                if (piece != null)
                {
                    p_74962_2_.add(piece);
                    p_74962_1_.field_74967_d.add(piece);
                }

                return piece;
            }
            else
            {
                return StructureCyclopeanShards.End.func_74971_a(p_74962_2_, p_74962_3_, p_74962_4_, p_74962_5_, p_74962_6_, p_74962_7_, p_74962_8_);
            }
        }

        /**
         * Gets the next component in any cardinal direction
         */
        protected StructureComponent getNextComponentNormal(StructureCyclopeanShards.Start p_74963_1_, List p_74963_2_, Random p_74963_3_, int p_74963_4_, int p_74963_5_, boolean p_74963_6_)
        {
            switch (this.coordBaseMode)
            {
                case 0:
                    return this.getNextComponent(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX + p_74963_4_, this.boundingBox.minY + p_74963_5_, this.boundingBox.maxZ + 1, this.coordBaseMode, this.getComponentType(), p_74963_6_);
                case 1:
                    return this.getNextComponent(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ + p_74963_4_, this.coordBaseMode, this.getComponentType(), p_74963_6_);
                case 2:
                    return this.getNextComponent(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX + p_74963_4_, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ - 1, this.coordBaseMode, this.getComponentType(), p_74963_6_);
                case 3:
                    return this.getNextComponent(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ + p_74963_4_, this.coordBaseMode, this.getComponentType(), p_74963_6_);
                default:
                    return null;
            }
        }

        /**
         * Gets the next component in the +/- X direction
         */
        protected StructureComponent getNextComponentX(StructureCyclopeanShards.Start p_74961_1_, List p_74961_2_, Random p_74961_3_, int p_74961_4_, int p_74961_5_, boolean p_74961_6_)
        {
            switch (this.coordBaseMode)
            {
                case 0:
                    return this.getNextComponent(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ + p_74961_5_, 1, this.getComponentType(), p_74961_6_);
                case 1:
                    return this.getNextComponent(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX + p_74961_5_, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ - 1, 2, this.getComponentType(), p_74961_6_);
                case 2:
                    return this.getNextComponent(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ + p_74961_5_, 1, this.getComponentType(), p_74961_6_);
                case 3:
                    return this.getNextComponent(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX + p_74961_5_, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ - 1, 2, this.getComponentType(), p_74961_6_);
                default:
                    return null;
            }
        }

        /**
         * Gets the next component in the +/- Z direction
         */
        protected StructureComponent getNextComponentZ(StructureCyclopeanShards.Start p_74965_1_, List p_74965_2_, Random p_74965_3_, int p_74965_4_, int p_74965_5_, boolean p_74965_6_)
        {
            switch (this.coordBaseMode)
            {
                case 0:
                    return this.getNextComponent(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74965_4_, this.boundingBox.minZ + p_74965_5_, 3, this.getComponentType(), p_74965_6_);
                case 1:
                    return this.getNextComponent(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.minX + p_74965_5_, this.boundingBox.minY + p_74965_4_, this.boundingBox.maxZ + 1, 0, this.getComponentType(), p_74965_6_);
                case 2:
                    return this.getNextComponent(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74965_4_, this.boundingBox.minZ + p_74965_5_, 3, this.getComponentType(), p_74965_6_);
                case 3:
                    return this.getNextComponent(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.minX + p_74965_5_, this.boundingBox.minY + p_74965_4_, this.boundingBox.maxZ + 1, 0, this.getComponentType(), p_74965_6_);
                default:
                    return null;
            }
        }

        /**
         * Checks if the bounding box's minY is > 10
         */
        protected static boolean isAboveGround(StructureBoundingBox p_74964_0_)
        {
            return p_74964_0_ != null && p_74964_0_.minY > 10;
        }

        /**
         * arguments: (World worldObj, StructureBoundingBox structBB, int minX, int minY, int minZ, int maxX, int maxY, int
         * maxZ, int placeBlock, int replaceBlock, boolean alwaysreplace)
         */
        protected void fillWithBlocks(World world, StructureBoundingBox structBB, int minX, int minY, int minZ, int maxX, int maxY, int maxZ, Block block, Block block2, boolean alwaysReplace)
        {
            for (int k1 = minY; k1 <= maxY; ++k1)
            {
                for (int l1 = minX; l1 <= maxX; ++l1)
                {
                    for (int i2 = minZ; i2 <= maxZ; ++i2)
                    {
                        if (!alwaysReplace || this.getBlockAtCurrentPosition(world, l1, k1, i2, structBB).getMaterial() != Material.air)
                        {
                            if (k1 != minY && k1 != maxY && l1 != minX && l1 != maxX && i2 != minZ && i2 != maxZ)
                            {
                                if(block2 == RidiculousBlocks.serpent)
                                    this.placeBlockAtCurrentPosition(world, getMaterial(), 0, l1, k1, i2, structBB);
                                else
                                    this.placeBlockAtCurrentPosition(world, block2, 0, l1, k1, i2, structBB);
                            }
                            else
                            {
                                if(block == RidiculousBlocks.serpent)
                                    this.placeBlockAtCurrentPosition(world, getMaterial(), 0, l1, k1, i2, structBB);
                                else
                                    this.placeBlockAtCurrentPosition(world, block, 0, l1, k1, i2, structBB);
                            }
                        }
                    }
                }
            }
        }

        @Override
        protected void func_151554_b(World world, Block block, int p_151554_3_, int p_151554_4_, int p_151554_5_, int p_151554_6_, StructureBoundingBox box)
        {
            int i1 = this.getXWithOffset(p_151554_4_, p_151554_6_);
            int j1 = this.getYWithOffset(p_151554_5_);
            int k1 = this.getZWithOffset(p_151554_4_, p_151554_6_);

            if (box.isVecInside(i1, j1, k1))
            {
                while ((world.isAirBlock(i1, j1, k1) || world.getBlock(i1, j1, k1).getMaterial().isLiquid()) && j1 > 1)
                {
                    if(block == RidiculousBlocks.serpent)
                        world.setBlock(i1, j1, k1, getMaterial(), p_151554_3_, 2);
                    else
                        world.setBlock(i1, j1, k1, block, p_151554_3_, 2);
                    --j1;
                }
            }
        }
    }

    static class PieceWeight
    {
        /** The class of the StructureComponent to which this weight corresponds. */
        public Class weightClass;
        public final int field_78826_b;
        public int field_78827_c;
        public int field_78824_d;
        public boolean field_78825_e;

        public PieceWeight(Class p_i2055_1_, int p_i2055_2_, int p_i2055_3_, boolean p_i2055_4_)
        {
            this.weightClass = p_i2055_1_;
            this.field_78826_b = p_i2055_2_;
            this.field_78824_d = p_i2055_3_;
            this.field_78825_e = p_i2055_4_;
        }

        public PieceWeight(Class p_i2056_1_, int p_i2056_2_, int p_i2056_3_)
        {
            this(p_i2056_1_, p_i2056_2_, p_i2056_3_, false);
        }

        public boolean func_78822_a(int p_78822_1_)
        {
            return this.field_78824_d == 0 || this.field_78827_c < this.field_78824_d;
        }

        public boolean func_78823_a()
        {
            return this.field_78824_d == 0 || this.field_78827_c < this.field_78824_d;
        }
    }

    public static class Stairs extends StructureCyclopeanShards.Piece
    {

        public Stairs() {}

        public Stairs(int p_i2058_1_, Random p_i2058_2_, StructureBoundingBox p_i2058_3_, int p_i2058_4_)
        {
            super(p_i2058_1_);
            this.coordBaseMode = p_i2058_4_;
            this.boundingBox = p_i2058_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentZ((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 6, 2, false);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Stairs createValidComponent(List p_74973_0_, Random p_74973_1_, int p_74973_2_, int p_74973_3_, int p_74973_4_, int p_74973_5_, int p_74973_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74973_2_, p_74973_3_, p_74973_4_, -2, 0, 0, 7, 11, 7, p_74973_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74973_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Stairs(p_74973_6_, p_74973_1_, structureboundingbox, p_74973_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 6, 1, 6, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 6, 10, 6, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 1, 8, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 2, 0, 6, 8, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 1, 0, 8, 6, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 2, 1, 6, 8, 6, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 6, 5, 8, 6, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 2, 0, 5, 4, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 3, 2, 6, 5, 2, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 3, 4, 6, 5, 4, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.placeBlockAtCurrentPosition(p_74875_1_, getMaterial(), 0, 5, 2, 5, p_74875_3_);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 2, 5, 4, 3, 5, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 2, 5, 3, 4, 5, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 2, 5, 2, 5, 5, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 5, 1, 6, 5, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 7, 1, 5, 7, 4, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 8, 2, 6, 8, 4, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 6, 0, 4, 8, 0, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 5, 0, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);

            for (int i = 0; i <= 6; ++i)
            {
                for (int j = 0; j <= 6; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, j, p_74875_3_);
                }
            }

            return true;
        }
    }

    public static class Start extends StructureCyclopeanShards.Crossing3
    {
        /** Instance of StructureNetherBridgePieceWeight. */
        public StructureCyclopeanShards.PieceWeight theCyclopeanRuinsWeight;
        /**
         * Contains the list of valid piece weights for the set of nether bridge structure pieces.
         */
        public List primaryWeights;
        /**
         * Contains the list of valid piece weights for the secondary set of nether bridge structure pieces.
         */
        public List secondaryWeights;
        public ArrayList field_74967_d = new ArrayList();

        public Start() {}

        public Start(Random p_i2059_1_, int p_i2059_2_, int p_i2059_3_)
        {
            super(p_i2059_1_, p_i2059_2_, p_i2059_3_);
            this.primaryWeights = new ArrayList();
            StructureCyclopeanShards.PieceWeight[] apieceweight = StructureCyclopeanShards.primaryComponents;
            int k = apieceweight.length;
            int l;
            StructureCyclopeanShards.PieceWeight pieceweight;

            for (l = 0; l < k; ++l)
            {
                pieceweight = apieceweight[l];
                pieceweight.field_78827_c = 0;
                this.primaryWeights.add(pieceweight);
            }

            this.secondaryWeights = new ArrayList();
            apieceweight = StructureCyclopeanShards.secondaryComponents;
            k = apieceweight.length;

            for (l = 0; l < k; ++l)
            {
                pieceweight = apieceweight[l];
                pieceweight.field_78827_c = 0;
                this.secondaryWeights.add(pieceweight);
            }
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
        }
    }

    public static class Straight extends StructureCyclopeanShards.Piece
    {

        public Straight() {}

        public Straight(int p_i2044_1_, Random p_i2044_2_, StructureBoundingBox p_i2044_3_, int p_i2044_4_)
        {
            super(p_i2044_1_);
            this.coordBaseMode = p_i2044_4_;
            this.boundingBox = p_i2044_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureCyclopeanShards.Start)p_74861_1_, p_74861_2_, p_74861_3_, 1, 3, false);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Straight createValidComponent(List p_74983_0_, Random p_74983_1_, int p_74983_2_, int p_74983_3_, int p_74983_4_, int p_74983_5_, int p_74983_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74983_2_, p_74983_3_, p_74983_4_, -1, -3, 0, 5, 10, 19, p_74983_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74983_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Straight(p_74983_6_, p_74983_1_, structureboundingbox, p_74983_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 0, 4, 4, 18, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 5, 0, 3, 7, 18, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 0, 0, 5, 18, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 5, 0, 4, 5, 18, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 2, 5, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 13, 4, 2, 18, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 3, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 15, 4, 1, 18, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 2; ++j)
                {
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, j, p_74875_3_);
                    this.func_151554_b(p_74875_1_, RidiculousBlocks.serpent, 0, i, -1, 18 - j, p_74875_3_);
                }
            }

            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 4, 1, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 4, 0, 4, 4, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 14, 0, 4, 14, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 17, 0, 4, 17, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 4, 1, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 3, 4, 4, 4, 4, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 3, 14, 4, 4, 14, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 17, 4, 4, 17, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            return true;
        }
    }

    public static class Throne extends StructureCyclopeanShards.Piece
    {
        private boolean hasSpawner;

        public Throne() {}

        public Throne(int p_i2053_1_, Random p_i2053_2_, StructureBoundingBox p_i2053_3_, int p_i2053_4_)
        {
            super(p_i2053_1_);
            this.coordBaseMode = p_i2053_4_;
            this.boundingBox = p_i2053_3_;
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.hasSpawner = p_143011_1_.getBoolean("Mob");
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Mob", this.hasSpawner);
        }

        /**
         * Creates and returns a new component piece. Or null if it could not find enough room to place it.
         */
        public static StructureCyclopeanShards.Throne createValidComponent(List p_74975_0_, Random p_74975_1_, int p_74975_2_, int p_74975_3_, int p_74975_4_, int p_74975_5_, int p_74975_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74975_2_, p_74975_3_, p_74975_4_, -2, 0, 0, 7, 8, 9, p_74975_5_);
            /**
             * Checks if the bounding box's minY is > 10
             */
            return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_74975_0_, structureboundingbox) == null ? new StructureCyclopeanShards.Throne(p_74975_6_, p_74975_1_, structureboundingbox, p_74975_5_) : null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World world, Random p_74875_2_, StructureBoundingBox structBB)
        {
            this.fillWithBlocks(world, structBB, 0, 2, 0, 6, 7, 7, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structBB, 1, 0, 0, 5, 1, 7, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(world, structBB, 1, 2, 1, 5, 2, 7, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(world, structBB, 1, 3, 2, 5, 3, 7, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(world, structBB, 1, 4, 3, 5, 4, 7, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(world, structBB, 1, 2, 0, 1, 4, 2, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(world, structBB, 5, 2, 0, 5, 4, 2, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(world, structBB, 1, 5, 2, 1, 5, 3, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(world, structBB, 5, 5, 2, 5, 5, 3, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(world, structBB, 0, 5, 3, 0, 5, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(world, structBB, 6, 5, 3, 6, 5, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.fillWithBlocks(world, structBB, 1, 5, 8, 5, 5, 8, RidiculousBlocks.serpent, RidiculousBlocks.serpent, false);
            this.placeBlockAtCurrentPosition(world, RidiculousBlocks.serpentRune, 0, 1, 6, 3, structBB);
            this.placeBlockAtCurrentPosition(world, RidiculousBlocks.serpentRune, 0, 5, 6, 3, structBB);
            this.fillWithBlocks(world, structBB, 0, 6, 3, 0, 6, 8, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(world, structBB, 6, 6, 3, 6, 6, 8, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(world, structBB, 1, 6, 8, 5, 7, 8, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            this.fillWithBlocks(world, structBB, 2, 8, 8, 4, 8, 8, RidiculousBlocks.serpentRune, RidiculousBlocks.serpentRune, false);
            int i;
            int j;

            if(Compat.pb){
                this.fillWithBlocks(world, structBB, 2, 5, 4, 4, 5, 6, Compat.defiled, Compat.defiled, false);
                i = this.getYWithOffset(6);
                j = this.getXWithOffset(3, 5);
                int k = this.getZWithOffset(3, 5);

                if (structBB.isVecInside(j, i, k))
                {
                    this.hasSpawner = true;
                    world.setBlock(j, i, k, Blocks.mob_spawner, 0, 2);
                    TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(j, i, k);

                    if (tileentitymobspawner != null)
                    {
                        tileentitymobspawner.func_145881_a().setEntityName("Enderman");
                    }
                }
            }

            else if (!this.hasSpawner)
            {
                i = this.getYWithOffset(5);
                j = this.getXWithOffset(3, 5);
                int k = this.getZWithOffset(3, 5);

                if (structBB.isVecInside(j, i, k))
                {
                    this.hasSpawner = true;
                    world.setBlock(j, i, k, Blocks.mob_spawner, 0, 2);
                    TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(j, i, k);

                    if (tileentitymobspawner != null)
                    {
                        tileentitymobspawner.func_145881_a().setEntityName("Enderman");
                    }
                }
            }

            for (i = 0; i <= 6; ++i)
            {
                for (j = 0; j <= 6; ++j)
                {
                    this.func_151554_b(world, RidiculousBlocks.serpent, 0, i, -1, j, structBB);
                }
            }

            return true;
        }
    }
}
