package misteryman.frostburnorigins.mixin;

import misteryman.frostburnorigins.common.registry.FBPowers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.StrayEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractSkeletonEntity.class)

public class AbstractSkeletonEntityMixin {
    @Redirect(at = @At(value = "NEW", target = "net/minecraft/entity/ai/goal/FollowTargetGoal", ordinal = 0), method = "initGoals")
    private <T extends LivingEntity> FollowTargetGoal<T> replaceFollowPlayerGoal(MobEntity mobEntity, Class<T> clazz, boolean checkVisibility) {
        return new FollowTargetGoal<>(mobEntity, clazz, 10, checkVisibility, false, e ->!FBPowers.FROZEN_HEART.isActive(e) || !(mobEntity instanceof StrayEntity));
    }
}
