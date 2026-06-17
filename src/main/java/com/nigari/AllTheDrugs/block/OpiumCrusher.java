package com.nigari.AllTheDrugs.block;

import net.minecraft.world.level.block.Block;

public class OpiumCrusher extends Block {
    public OpiumCrusher() {
        super(Properties.of()
                .strength(5.5F, 7.0F)
                .requiresCorrectToolForDrops()
        );
    }
}
