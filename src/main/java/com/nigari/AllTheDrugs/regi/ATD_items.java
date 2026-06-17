package com.nigari.AllTheDrugs.regi;

import com.nigari.AllTheDrugs.item.DriedOpiumLatex;
import com.nigari.AllTheDrugs.item.OpiumLatex;
import com.nigari.AllTheDrugs.item.OpiumSeed;
import com.nigari.AllTheDrugs.item.OpiumiumIngot;
import com.nigari.AllTheDrugs.main.AllTheDrugs;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ATD_items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AllTheDrugs.MOD_ID);

    public static final RegistryObject<Item> OPIUM_SEED = ITEMS.register("opium_seed", OpiumSeed::new);
    public static final RegistryObject<Item> OPIUMIUM_INGOT = ITEMS.register("opiumium_ingot", OpiumiumIngot::new);
    public static final RegistryObject<Item> OPIUM_LATEX = ITEMS.register("opium_latex", OpiumLatex::new);
    public static final RegistryObject<Item> DRIED_OPIUM_LATEX = ITEMS.register("dried_opium_latex", DriedOpiumLatex::new);
}
