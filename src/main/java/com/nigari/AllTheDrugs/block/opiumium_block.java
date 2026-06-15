package com.nigari.AllTheDrugs.block;

import net.minecraft.world.level.block.Block;

public class opiumium_block extends Block {
    public opiumium_block() {
        super(Properties.of()
                .strength(5.0F, 6.0F)
                .lightLevel((a) -> 6)
                .requiresCorrectToolForDrops()
        );
    }
}
