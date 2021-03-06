package misteryman.frostburnorigins.status_effects;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import io.github.apace100.origins.util.AttributedEntityAttributeModifier;
import net.minecraft.client.gui.hud.BackgroundHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.registry.Registry;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FrostbiteStatusEffect extends StatusEffect {
    public FrostbiteStatusEffect() {
        super(StatusEffectType.HARMFUL, BackgroundHelper.ColorMixer.getArgb(255, 138, 235, 241));
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean isInstant() {
        return false;
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        entity.damage(DamageSource.MAGIC, 1.0F + (1.0F * amplifier));
    }
}
