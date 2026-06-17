package com.nigari.AllTheDrugs.main;

import com.nigari.AllTheDrugs.regi.ATD_blockentities;
import com.nigari.AllTheDrugs.regi.ATD_blocks;
import com.nigari.AllTheDrugs.regi.ATD_items;
import com.nigari.AllTheDrugs.regi.tab.ATD_tabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("all_the_drugs")
public class AllTheDrugs {

    public static final String MOD_ID = "all_the_drugs";

    public AllTheDrugs(){
        @SuppressWarnings("removal")
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ATD_items.ITEMS.register(bus);
        ATD_blocks.Blocks.BLOCKS.register(bus);
        ATD_blocks.Block_Items.BLOCK_ITEMS.register(bus);
        ATD_blockentities.BLOCKS.register(bus);
        ATD_tabs.MOD_TABS.register(bus);
    }
}
