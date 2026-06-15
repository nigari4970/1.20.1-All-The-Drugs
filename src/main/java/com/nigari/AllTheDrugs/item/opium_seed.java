package com.nigari.AllTheDrugs.item;

import com.nigari.AllTheDrugs.regi.ATD_tags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class opium_seed extends Item {
    public opium_seed() {
        super(new Properties()
                .food(new FoodProperties.Builder().build())
        );
    }
}
