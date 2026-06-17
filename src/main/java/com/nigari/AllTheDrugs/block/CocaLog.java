package com.nigari.AllTheDrugs.block;

import net.minecraft.world.level.block.Block;

public class CocaLog extends Block {
    public CocaLog() {
        super(Properties.of()
                .strength(5.5F, 7.0F)
                .requiresCorrectToolForDrops()
        );
    }
}
