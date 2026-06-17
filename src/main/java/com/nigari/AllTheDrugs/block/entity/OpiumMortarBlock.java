package com.nigari.AllTheDrugs.block.entity;

import com.nigari.AllTheDrugs.blockentity.OpiumMortarBlockEntity;
import com.nigari.AllTheDrugs.item.Pestle;
import com.nigari.AllTheDrugs.regi.ATD_blockentities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OpiumMortarBlock extends BaseEntityBlock {
    public OpiumMortarBlock(){
        super(Properties.of().noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {

        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof OpiumMortarBlockEntity mortar)) {
            return InteractionResult.PASS;
        }

        ItemStack stack = player.getItemInHand(hand);

        // すりこぎ棒は Item 側の useOn() で処理されるのでここでは無視
        if (stack.getItem() instanceof Pestle) {
            return InteractionResult.PASS;
        }

        if (!stack.isEmpty()) {
            boolean inserted = mortar.insertItem(stack);
            if (inserted) {
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    private static final VoxelShape SHAPE = Shapes.box(
            0.0, 3.0/16.0, 0.0,   // 最小 X, Y, Z（0.0 〜 1.0）
            1.0, 13.0/16.0, 1.0    // 最大 X, Y, Z
    );

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos,BlockState blockState) {
        return new OpiumMortarBlockEntity(blockPos,blockState);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level,
                               BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getInteractionShape(BlockState state, BlockGetter getter, BlockPos pos) {
        return super.getInteractionShape(state, getter, pos);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext collisionContext) {
        return super.getCollisionShape(state, getter, pos, collisionContext);
    }
}
