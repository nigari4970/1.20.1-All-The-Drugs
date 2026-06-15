package com.nigari.AllTheDrugs.block;

import net.minecraft.world.level.block.Block;

public class opium_casing extends Block {
    public opium_casing() {
        super(Properties.of()
                .strength(5.5F, 7.0F)
                .requiresCorrectToolForDrops()
        );
    }
}
