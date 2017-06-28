package fox.spiteful.ridiculous.entities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.UUID;

public class EntityOldEnderman extends EntityEnderman {

    protected static final UUID attackingSpeedBoostModifierUUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
    protected static final AttributeModifier attackingSpeedBoostModifier = (new AttributeModifier(attackingSpeedBoostModifierUUID, "Attacking speed boost", 6.199999809265137D, 0)).setSaved(false);
    /** Counter to delay the teleportation of an enderman towards the currently attacked target */
    protected int teleportDelay;
    /** A player must stare at an enderman for 5 ticks before it becomes aggressive. This field counts those ticks. */
    protected int stareTimer;
    protected Entity lastEntityToAttack;
    protected boolean isAggressive;
    protected int jumpTicks;
    
    public EntityOldEnderman(World world){
        super(world);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.isWet())
        {
            this.attackEntityFrom(DamageSource.drown, 1.0F);
        }

        if (this.lastEntityToAttack != this.entityToAttack)
        {
            IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
            iattributeinstance.removeModifier(attackingSpeedBoostModifier);

            if (this.entityToAttack != null)
            {
                iattributeinstance.applyModifier(attackingSpeedBoostModifier);
            }
        }

        this.lastEntityToAttack = this.entityToAttack;
        int k;

        if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"))
        {
            int i;
            int j;
            Block block;

            if (this.func_146080_bZ().getMaterial() == Material.air)
            {
                if (this.rand.nextInt(20) == 0)
                {
                    k = MathHelper.floor_double(this.posX - 2.0D + this.rand.nextDouble() * 4.0D);
                    i = MathHelper.floor_double(this.posY + this.rand.nextDouble() * 3.0D);
                    j = MathHelper.floor_double(this.posZ - 2.0D + this.rand.nextDouble() * 4.0D);
                    block = this.worldObj.getBlock(k, i, j);

                    if (EntityEnderman.getCarriable(block))
                    {
                        this.func_146081_a(block);
                        this.setCarryingData(this.worldObj.getBlockMetadata(k, i, j));
                        this.worldObj.setBlock(k, i, j, Blocks.air);
                    }
                }
            }
            else if (this.rand.nextInt(2000) == 0)
            {
                k = MathHelper.floor_double(this.posX - 1.0D + this.rand.nextDouble() * 2.0D);
                i = MathHelper.floor_double(this.posY + this.rand.nextDouble() * 2.0D);
                j = MathHelper.floor_double(this.posZ - 1.0D + this.rand.nextDouble() * 2.0D);
                block = this.worldObj.getBlock(k, i, j);
                Block block1 = this.worldObj.getBlock(k, i - 1, j);

                if (block.getMaterial() == Material.air && block1.getMaterial() != Material.air && block1.renderAsNormalBlock())
                {
                    this.worldObj.setBlock(k, i, j, this.func_146080_bZ(), this.getCarryingData(), 3);
                    this.func_146081_a(Blocks.air);
                }
            }
        }

        for (k = 0; k < 2; ++k)
        {
            this.worldObj.spawnParticle("smoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0f, 0.05f, 0f);
        }

        if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
        {
            float f = this.getBrightness(1.0F);

            if (f > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F)
            {
                this.entityToAttack = null;
                this.setScreaming(false);
                this.isAggressive = false;
                this.teleportRandomly();
            }
        }

        if (this.isWet() || this.isBurning())
        {
            this.entityToAttack = null;
            this.setScreaming(false);
            this.isAggressive = false;
            this.teleportRandomly();
        }

        if (this.isScreaming() && !this.isAggressive && this.rand.nextInt(100) == 0)
        {
            this.setScreaming(false);
        }

        this.isJumping = false;

        if (this.entityToAttack != null)
        {
            this.faceEntity(this.entityToAttack, 100.0F, 100.0F);
        }

        if (!this.worldObj.isRemote && this.isEntityAlive())
        {
            if (this.entityToAttack != null)
            {
                if (this.entityToAttack instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer)this.entityToAttack))
                {
                    if (this.entityToAttack.getDistanceSqToEntity(this) < 16.0D)
                    {
                        this.teleportRandomly();
                    }

                    this.teleportDelay = 0;
                }
                else if (this.entityToAttack.getDistanceSqToEntity(this) > 256.0D && this.teleportDelay++ >= 30 && this.teleportToEntity(this.entityToAttack))
                {
                    this.teleportDelay = 0;
                }
            }
            else
            {
                this.setScreaming(false);
                this.teleportDelay = 0;
            }
        }

        this.updateArmSwingProgress();
        float f = this.getBrightness(1.0F);

        if (f > 0.5F)
        {
            this.entityAge += 2;
        }

        if (this.jumpTicks > 0)
        {
            --this.jumpTicks;
        }

        if (this.newPosRotationIncrements > 0)
        {
            double d0 = this.posX + (this.newPosX - this.posX) / (double)this.newPosRotationIncrements;
            double d1 = this.posY + (this.newPosY - this.posY) / (double)this.newPosRotationIncrements;
            double d2 = this.posZ + (this.newPosZ - this.posZ) / (double)this.newPosRotationIncrements;
            double d3 = MathHelper.wrapAngleTo180_double(this.newRotationYaw - (double)this.rotationYaw);
            this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.newPosRotationIncrements);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.newRotationPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.setPosition(d0, d1, d2);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        else if (!this.isClientWorld())
        {
            this.motionX *= 0.98D;
            this.motionY *= 0.98D;
            this.motionZ *= 0.98D;
        }

        if (Math.abs(this.motionX) < 0.005D)
        {
            this.motionX = 0.0D;
        }

        if (Math.abs(this.motionY) < 0.005D)
        {
            this.motionY = 0.0D;
        }

        if (Math.abs(this.motionZ) < 0.005D)
        {
            this.motionZ = 0.0D;
        }

        this.worldObj.theProfiler.startSection("ai");

        if (this.isMovementBlocked())
        {
            this.isJumping = false;
            this.moveStrafing = 0.0F;
            this.moveForward = 0.0F;
            this.randomYawVelocity = 0.0F;
        }
        else if (this.isClientWorld())
        {
            if (this.isAIEnabled())
            {
                this.worldObj.theProfiler.startSection("newAi");
                this.updateAITasks();
                this.worldObj.theProfiler.endSection();
            }
            else
            {
                this.worldObj.theProfiler.startSection("oldAi");
                this.updateEntityActionState();
                this.worldObj.theProfiler.endSection();
                this.rotationYawHead = this.rotationYaw;
            }
        }

        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("jump");

        if (this.isJumping)
        {
            if (!this.isInWater() && !this.handleLavaMovement())
            {
                if (this.onGround && this.jumpTicks == 0)
                {
                    this.jump();
                    this.jumpTicks = 10;
                }
            }
            else
            {
                this.motionY += 0.03999999910593033D;
            }
        }
        else
        {
            this.jumpTicks = 0;
        }

        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("travel");
        this.moveStrafing *= 0.98F;
        this.moveForward *= 0.98F;
        this.randomYawVelocity *= 0.9F;
        this.moveEntityWithHeading(this.moveStrafing, this.moveForward);
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("push");

        if (!this.worldObj.isRemote)
        {
            this.collideWithNearbyEntities();
        }

        this.worldObj.theProfiler.endSection();


    }

    /**
     * Checks to see if this enderman should be attacking this player
     */
    protected boolean shouldAttackPlayer(EntityPlayer p_70821_1_)
    {
        ItemStack itemstack = p_70821_1_.inventory.armorInventory[3];

        if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.pumpkin))
        {
            return false;
        }
        else
        {
            Vec3 vec3 = p_70821_1_.getLook(1.0F).normalize();
            Vec3 vec31 = Vec3.createVectorHelper(this.posX - p_70821_1_.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (p_70821_1_.posY + (double)p_70821_1_.getEyeHeight()), this.posZ - p_70821_1_.posZ);
            double d0 = vec31.lengthVector();
            vec31 = vec31.normalize();
            double d1 = vec3.dotProduct(vec31);
            return d1 > 1.0D - 0.025D / d0 && p_70821_1_.canEntityBeSeen(this);
        }
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);

        if (entityplayer != null)
        {
            if (this.shouldAttackPlayer(entityplayer))
            {
                this.isAggressive = true;

                if (this.stareTimer == 0)
                {
                    this.worldObj.playSoundEffect(entityplayer.posX, entityplayer.posY, entityplayer.posZ, "mob.endermen.stare", 1.0F, 1.0F);
                }

                if (this.stareTimer++ == 5)
                {
                    this.stareTimer = 0;
                    this.setScreaming(true);
                    return entityplayer;
                }
            }
            else
            {
                this.stareTimer = 0;
            }
        }

        return null;
    }

}
