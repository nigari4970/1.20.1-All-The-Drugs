package com.nigari.AllTheDrugs.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class CocaLog extends RotatedPillarBlock {
    public CocaLog() {
        super(Properties.of()
                .strength(5.5F, 7.0F)
                .requiresCorrectToolForDrops()
        );
    }
}
