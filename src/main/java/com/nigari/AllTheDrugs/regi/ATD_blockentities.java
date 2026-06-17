package com.nigari.AllTheDrugs.regi;

import com.nigari.AllTheDrugs.block.entity.OpiumMortarBlock;
import com.nigari.AllTheDrugs.blockentity.OpiumMortarBlockEntity;
import com.nigari.AllTheDrugs.main.AllTheDrugs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ATD_blockentities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AllTheDrugs.MOD_ID);

    public static final RegistryObject<BlockEntityType<OpiumMortarBlockEntity>> OPIUM_MORTAR = BLOCKS.register("opium_mortar",() -> set(OpiumMortarBlockEntity::new, ATD_blocks.Blocks.OPIUM_MORTAR.get()));
    private static <T extends BlockEntity> BlockEntityType<T> set (BlockEntityType.BlockEntitySupplier<T> entity, Block block){
        return BlockEntityType.Builder.of(entity,block).build(null);
    }
}
