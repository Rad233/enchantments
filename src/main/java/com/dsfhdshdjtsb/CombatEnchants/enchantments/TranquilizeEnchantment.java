package com.dsfhdshdjtsb.CombatEnchants.enchantments;

import com.dsfhdshdjtsb.CombatEnchants.CombatEnchants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class TranquilizeEnchantment extends Enchantment {
    public TranquilizeEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.CROSSBOW, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return level * 25;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 50;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target.distanceTo(user) < 6)
            return;
        if(target instanceof LivingEntity)
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(CombatEnchants.SLEEPY_EFFECT, 200, level));
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}