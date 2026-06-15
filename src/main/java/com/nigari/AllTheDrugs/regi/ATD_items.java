package com.nigari.AllTheDrugs.regi;

import com.nigari.AllTheDrugs.item.dried_opium_latex;
import com.nigari.AllTheDrugs.item.opium_latex;
import com.nigari.AllTheDrugs.item.opium_seed;
import com.nigari.AllTheDrugs.item.opiumium_ingot;
import com.nigari.AllTheDrugs.main.AllTheDrugs;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ATD_items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AllTheDrugs.MOD_ID);

    public static final RegistryObject<Item> OPIUM_SEED = ITEMS.register("opium_seed", opium_seed::new);
    public static final RegistryObject<Item> OPIUMIUM_INGOT = ITEMS.register("opiumium_ingot", opiumium_ingot::new);
    public static final RegistryObject<Item> OPIUM_LATEX = ITEMS.register("opium_latex", opium_latex::new);
    public static final RegistryObject<Item> DRIED_OPIUM_LATEX = ITEMS.register("dried_opium_latex", dried_opium_latex::new);
}
