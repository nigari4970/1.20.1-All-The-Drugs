package com.nigari.AllTheDrugs.block;

import net.minecraft.world.level.block.Block;

public class OpiumiumBlock extends Block {
    public OpiumiumBlock() {
        super(Properties.of()
                .strength(5.0F, 6.0F)
                .lightLevel((a) -> 6)
                .requiresCorrectToolForDrops()
        );
    }
}
