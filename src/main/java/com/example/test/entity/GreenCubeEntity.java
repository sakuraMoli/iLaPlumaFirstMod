package com.example.test.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GreenCubeEntity extends HostileEntity {
    private static final float REFLECT_RATIO = 0.30f;
    private static final double CHASE_ACCEL = 0.10;
    private static final double VEL_DAMPING = 0.80;
    private static final double CONTACT_RANGE_SQ = 1.2 * 1.2;

    private int contactAttackCooldown = 0;

    public GreenCubeEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 20, true);
        this.setNoGravity(true);
        this.experiencePoints = 5;
    }

    public static DefaultAttributeContainer.Builder createGreenCubeAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void tick() {
        super.tick();
        this.setNoGravity(true);

        if (this.getWorld().isClient()) {
            return;
        }

        if (contactAttackCooldown > 0) {
            contactAttackCooldown--;
        }

        LivingEntity target = this.getTarget();
        if (target == null || !target.isAlive()) {
            return;
        }

        // Chase target (Vex-like), but collision will prevent phasing through walls.
        Vec3d aim = target.getPos().add(0.0, target.getHeight() * 0.5, 0.0);
        Vec3d toTarget = aim.subtract(this.getPos());
        double distSq = toTarget.lengthSquared();
        if (distSq > 0.0001) {
            Vec3d desired = toTarget.normalize().multiply(CHASE_ACCEL);
            this.setVelocity(this.getVelocity().multiply(VEL_DAMPING).add(desired));
        }

        // Contact damage when close enough, with a short cooldown.
        if (distSq <= CONTACT_RANGE_SQ && contactAttackCooldown == 0) {
            float dmg = (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
            target.damage(this.getDamageSources().mobAttack(this), dmg);
            contactAttackCooldown = 20;
        }
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        boolean took = super.damage(source, amount);
        if (!took || this.getWorld().isClient()) {
            return took;
        }

        if (amount > 0.0f && source.getAttacker() instanceof PlayerEntity player) {
            float reflected = amount * REFLECT_RATIO;
            if (reflected > 0.0f) {
                player.damage(this.getDamageSources().thorns(this), reflected);
            }
        }

        return took;
    }

}

