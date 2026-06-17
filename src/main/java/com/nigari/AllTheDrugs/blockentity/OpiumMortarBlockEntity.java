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
    private static final int PROCESS_TIME = 20; // 変換にかかるTick（1秒）
    private int timer = 0;

    public OpiumMortarBlockEntity(BlockPos pos, BlockState state) {
        super(ATD_blockentities.OPIUM_MORTAR.get(), pos, state);
    }

    // 毎Tick呼ばれる静的メソッド
    public static void tick(Level level, BlockPos pos, BlockState state, OpiumMortarBlockEntity entity) {
        if (level.isClientSide) return; // サーバー側のみ処理

        // ブロックの上のアイテムエンティティを取得
        List<ItemEntity> items = getItemsAbove(level, pos);
        if (items.isEmpty()) {
            entity.timer = 0; // アイテムがなければリセット
            return;
        }

        entity.timer++;

        if (entity.timer >= PROCESS_TIME) {
            entity.timer = 0;
            convertItem(level, pos, items);
        }
    }

    // ブロックの上にあるアイテムエンティティを取得
    private static List<ItemEntity> getItemsAbove(Level level, BlockPos pos) {
        AABB area = new AABB(pos.above()); // 1ブロック上の範囲
        return level.getEntitiesOfClass(ItemEntity.class, area);
    }

    // アイテムを変換する
    private static void convertItem(Level level, BlockPos pos, List<ItemEntity> items) {
        ItemEntity itemEntity = items.get(0);
        ItemStack stack = itemEntity.getItem();

        // レシピの定義（例：ダイヤ→エメラルド）
        ItemStack result = getResult(stack);
        if (result.isEmpty()) return;

        stack.shrink(1);
        // 元のアイテムを消す
        if(stack.isEmpty()) {
            itemEntity.discard();
        }
        // 変換後のアイテムをスポーン
        ItemEntity newItem = new ItemEntity(level,
                pos.getX() + 0.5,
                pos.getY() + 1.0,
                pos.getZ() + 0.5,
                result.copyWithCount(1));
        level.addFreshEntity(newItem);
    }

    // 変換レシピ
    private static ItemStack getResult(ItemStack input) {
        if (input.is(ATD_items.OPIUM_SEED.get())) {
            return new ItemStack(ATD_items.OPIUM_LATEX.get());
        }
        return ItemStack.EMPTY; // 対応するレシピなし
    }

    // NBTにデータ保存
    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.putInt("timer", timer);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        timer = tag.getInt("timer");
    }
}
