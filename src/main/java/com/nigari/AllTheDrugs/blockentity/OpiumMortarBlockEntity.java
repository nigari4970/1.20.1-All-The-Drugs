package com.nigari.AllTheDrugs.blockentity;

import com.nigari.AllTheDrugs.item.OpiumSeed;
import com.nigari.AllTheDrugs.regi.ATD_blockentities;
import com.nigari.AllTheDrugs.regi.ATD_items;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class OpiumMortarBlockEntity extends BlockEntity {
    private ItemStack storedItem = ItemStack.EMPTY;
    private long lastGrindTime = 0;
    private static final int GRIND_INTERVAL = 10; // 10Tickごとに1個変換

    public OpiumMortarBlockEntity(BlockPos pos, BlockState state) {
        super(ATD_blockentities.OPIUM_MORTAR.get(), pos, state);
    }

    public boolean insertItem(ItemStack stack) {
        if(!stack.is(ATD_items.OPIUM_SEED.get())) return false;

        if (storedItem.isEmpty()) {
            storedItem = stack.copyWithCount(1);
            return true;
        }
        if (ItemStack.isSameItemSameTags(storedItem, stack) &&
                storedItem.getCount() < storedItem.getMaxStackSize()) {
            storedItem.grow(1);
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return storedItem.isEmpty();
    }

    public boolean grind(Level level) {
        if (storedItem.isEmpty()) {

            return false;
        }

        long currentTime = level.getGameTime();
        if (currentTime - lastGrindTime < GRIND_INTERVAL) {
            return false;
        }

        ItemStack result = getGrindResult(storedItem);
        if (result.isEmpty()) return false;

        lastGrindTime = currentTime;
        storedItem.shrink(1);
        spawnResult(level, result);
        setChanged();
        return true;
    }

    private ItemStack getGrindResult(ItemStack input) {
        if (input.is(ATD_items.OPIUM_SEED.get())) {
            return new ItemStack(ATD_items.OPIUM_LATEX.get());
        }
        return ItemStack.EMPTY;
    }

    private void spawnResult(Level level, ItemStack result) {
        BlockPos pos = this.getBlockPos();
        ItemEntity itemEntity = new ItemEntity(level,
                pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5,
                result.copyWithCount(1));
        level.addFreshEntity(itemEntity);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("storedItem", storedItem.save(new CompoundTag()));
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("storedItem")) {
            storedItem = ItemStack.of(tag.getCompound("storedItem"));
        }
    }


}
