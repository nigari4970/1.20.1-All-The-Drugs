package com.nigari.AllTheDrugs.block.entity;

import com.nigari.AllTheDrugs.blockentity.OpiumMortarBlockEntity;
import com.nigari.AllTheDrugs.regi.ATD_blockentities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OpiumMortarBlock extends BaseEntityBlock {
    public OpiumMortarBlock(){
        super(Properties.of());
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos,BlockState blockState) {
        return new OpiumMortarBlockEntity(blockPos,blockState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ATD_blockentities.OPIUM_MORTAR.get(),
                OpiumMortarBlockEntity::tick);
    }
}
