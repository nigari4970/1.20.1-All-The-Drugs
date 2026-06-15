package com.nigari.AllTheDrugs.block;

import net.minecraft.world.level.block.Block;

public class crusher extends Block {
    public crusher() {
        super(Properties.of()
                .strength(5.5F, 7.0F)
                .requiresCorrectToolForDrops()
        );
    }
}
