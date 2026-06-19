package com.nigari.AllTheDrugs.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;

public class Crusher extends HorizontalDirectionalBlock {
    public Crusher() {
        super(Properties.of()
                .strength(5.5F, 7.0F)
                .requiresCorrectToolForDrops()
        );
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING,
                context.getHorizontalDirection().getOpposite()
        );
    }
}


