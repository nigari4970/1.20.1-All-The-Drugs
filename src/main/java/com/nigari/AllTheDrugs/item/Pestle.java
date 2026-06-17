package com.nigari.AllTheDrugs.item;

import com.nigari.AllTheDrugs.blockentity.OpiumMortarBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class Pestle extends Item {
    public Pestle() {
        super(new Properties()
        );
    }
    // 右クリックした瞬間：使用継続を開始する
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        if (player == null) return InteractionResult.PASS;

        // すり鉢でなければ何もしない
        if (!(level.getBlockEntity(pos) instanceof OpiumMortarBlockEntity)) {
            return InteractionResult.PASS;
        }

        // アイテムが空ならそもそも使用開始しない
        if (level.getBlockEntity(pos) instanceof OpiumMortarBlockEntity mortar && mortar.isEmpty()) {
            return InteractionResult.PASS;
        }

        // 使用継続状態に入る（長押し開始）
        player.startUsingItem(context.getHand());
        return InteractionResult.SUCCESS;
    }

    // 使用継続時間の最大値（長め推奨。実際は何度も叩く想定なのでとても長くする）
    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000; // 約1時間。実質「離すまで無限に続く」扱い
    }

    // どう使うか（食べる・構えるなど）を指定。今回はBOWのような構えアニメーションを流用
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BRUSH; // 構えアニメーション。専用アニメーションがなければこれで十分
    }

    // 毎Tick呼ばれる（長押し中）
    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseTicks) {
        if (level.isClientSide) return;
        if (!(entity instanceof Player player)) return;

        // プレイヤーが見ているブロック位置を取得
        BlockHitResult hit = getLookedAtBlock(player);
        if (hit == null) return;

        BlockPos pos = hit.getBlockPos();
        if (level.getBlockEntity(pos) instanceof OpiumMortarBlockEntity mortar) {
            mortar.grind(level); // 内部でクールダウン判定するのでここでは毎Tick呼んでOK
        }
    }

    // プレイヤーが見ているブロックを取得するヘルパー
    private BlockHitResult getLookedAtBlock(Player player) {
        Level level = player.level();
        Vec3 eyePos = player.getEyePosition();
        Vec3 viewVec = player.getViewVector(1.0F);
        Vec3 reachPos = eyePos.add(viewVec.x * 5, viewVec.y * 5, viewVec.z * 5);

        return level.clip(new ClipContext(eyePos, reachPos,
                ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
    }

    // 離したとき（releaseUsing）— 何もしない（onUseTickだけで処理が完結するため）
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {

    }
}
