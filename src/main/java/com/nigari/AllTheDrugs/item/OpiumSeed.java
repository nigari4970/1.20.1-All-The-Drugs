package com.nigari.AllTheDrugs.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class OpiumSeed extends Item {
    public OpiumSeed() {
        super(new Properties()
                .food(new FoodProperties.Builder().build())
        );
    }
}
