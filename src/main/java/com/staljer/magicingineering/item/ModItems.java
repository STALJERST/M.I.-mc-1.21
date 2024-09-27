package com.staljer.magicingineering.item;

import com.staljer.magicingineering.Mg_In;
import com.staljer.magicingineering.item.custom.HammerItem;
import com.staljer.magicingineering.item.custom.ModToolTiers;
import com.staljer.magicingineering.item.custom.MorphItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mg_In.MOD_ID);

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_RAW = ITEMS.register("titanium_raw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MORPH = ITEMS.register("morph",
            () -> new MorphItem(new Item.Properties().durability(8)));
    public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_RAW = ITEMS.register("tungsten_raw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_RAW = ITEMS.register("palladium_raw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_NUGGET = ITEMS.register("palladium_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ULTIMATE_PICKAXE = ITEMS.register("ultimate_pickaxe",
            () -> new HammerItem(ModToolTiers.ULTIMATE,new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ULTIMATE,200,100)))
    );


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
