package com.nigari.AllTheDrugs.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class OpiumPowder extends Item {
    public OpiumPowder() {
        super(new Properties()
                .food(new FoodProperties.Builder().build())
        );
    }
}
