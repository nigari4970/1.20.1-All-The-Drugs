package com.nigari.AllTheDrugs.regi.tab;

import com.nigari.AllTheDrugs.main.AllTheDrugs;
import com.nigari.AllTheDrugs.regi.ATD_items;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ATD_tabs {
    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AllTheDrugs.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ATD_MAIN = MOD_TABS.register("atd_main",
            ()-> {return CreativeModeTab.builder()
                    .icon(()->new ItemStack(ATD_items.OPIUM_SEED.get()))
                    .title(Component.translatable("itemGroup.ATD"))
                    .displayItems((param,output)->{
                        for(Item item:main_tab.items){
                            output.accept(item);
                        }
                    })
                    .build();
    });
}
