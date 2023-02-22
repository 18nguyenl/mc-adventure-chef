package dev.LONG.adventurecooking.items;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BrieItem extends Item {
    public BrieItem(Item.Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        pEntityLiving.hurt(DamageSource.GENERIC, 5.0f);
        return super.finishUsingItem(pStack, pLevel, pEntityLiving);
    }
}
