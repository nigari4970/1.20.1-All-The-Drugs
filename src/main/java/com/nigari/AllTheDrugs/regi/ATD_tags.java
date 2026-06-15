package com.nigari.AllTheDrugs.regi;

import com.nigari.AllTheDrugs.main.AllTheDrugs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ATD_tags {

    public static class Blocks{
        private static TagKey<Block> tag (String name) {
            return BlockTags.create(new ResourceLocation(AllTheDrugs.MOD_ID, name));
        }
    }

    public static class Items{

        public static final TagKey<Item> DRUGS = tag("drugs");

        private static TagKey<Item> tag (String name) {
            return ItemTags.create(new ResourceLocation(AllTheDrugs.MOD_ID, name));
        }
    }
}
