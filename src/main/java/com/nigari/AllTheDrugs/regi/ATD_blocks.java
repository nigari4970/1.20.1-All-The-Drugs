package com.nigari.AllTheDrugs.regi;

import com.nigari.AllTheDrugs.block.CocaLog;
import com.nigari.AllTheDrugs.block.OpiumCrusher;
import com.nigari.AllTheDrugs.block.OpiumCasing;
import com.nigari.AllTheDrugs.block.OpiumiumBlock;
import com.nigari.AllTheDrugs.block.entity.OpiumMortarBlock;
import com.nigari.AllTheDrugs.main.AllTheDrugs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ATD_blocks {

    public static class Blocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AllTheDrugs.MOD_ID);

        public static final RegistryObject<Block> OPIUMIUM_BLOCK = BLOCKS.register("opiumium_block", OpiumiumBlock::new);
        public static final RegistryObject<Block> OPIUM_CASING = BLOCKS.register("opium_casing", OpiumCasing::new);
        public static final RegistryObject<Block> CRUSHER = BLOCKS.register("crusher", OpiumCrusher::new);
        public static final RegistryObject<Block> OPIUM_MORTAR = BLOCKS.register("opium_mortar", OpiumMortarBlock::new);
        public static final RegistryObject<Block> COCA_LOG = BLOCKS.register("coca_log", CocaLog::new);

    }

    public static class Block_Items {
        public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AllTheDrugs.MOD_ID);

        public static final RegistryObject<Item> OPIUMIUM_BLOCK = BLOCK_ITEMS.register("opiumium_block", () -> new BlockItem(Blocks.OPIUMIUM_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> OPIUM_CASING = BLOCK_ITEMS.register("opium_casing", () -> new BlockItem(Blocks.OPIUM_CASING.get(), new Item.Properties()));
        public static final RegistryObject<Item> CRUSHER = BLOCK_ITEMS.register("crusher", () -> new BlockItem(Blocks.CRUSHER.get(), new Item.Properties()));
        public static final RegistryObject<Item> OPIUM_MORTAR = BLOCK_ITEMS.register("opium_mortar",() -> new BlockItem(Blocks.OPIUM_MORTAR.get(),new Item.Properties()));
        public static final RegistryObject<Item> COCA_LOG = BLOCK_ITEMS.register("coca_log", () -> new BlockItem(Blocks.COCA_LOG.get(), new Item.Properties()));
    }
}
