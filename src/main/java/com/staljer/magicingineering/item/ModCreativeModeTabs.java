package com.staljer.magicingineering.item;

import com.staljer.magicingineering.Mg_In;
import com.staljer.magicingineering.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mg_In.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RESURSES = CREATIVE_MODE_TABS.register("mi_resurses",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TITANIUM_RAW.get()))
                    .title(Component.translatable("creativetab.magicingineering.mi_resurses"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TITANIUM_INGOT.get());
                        output.accept(ModItems.TITANIUM_RAW.get());
                        output.accept(ModItems.TITANIUM_NUGGET.get());
                        output.accept(ModItems.TUNGSTEN_INGOT.get());
                        output.accept(ModItems.TUNGSTEN_NUGGET.get());
                        output.accept(ModItems.TUNGSTEN_RAW.get());
                        output.accept(ModItems.PALLADIUM_INGOT.get());
                        output.accept(ModItems.PALLADIUM_NUGGET.get());
                        output.accept(ModItems.PALLADIUM_RAW.get());
                        output.accept(ModItems.MORPH.get());
                        output.accept(ModItems.ULTIMATE_PICKAXE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> BLOCKS_TAB = CREATIVE_MODE_TABS.register("mi_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TITANIUM_ORE.get()))
                    .withTabsBefore(RESURSES.getId())
                    .title(Component.translatable("creativetab.magicingineering.mi_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TITANIUM_BLOCK.get());
                        output.accept(ModBlocks.RAW_TITANIUM_BLOCK.get());
                        output.accept(ModBlocks.TITANIUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
                        output.accept(ModBlocks.TUNGSTEN_ORE.get());
                        output.accept(ModBlocks.TUNGSTEN_BLOCK.get());
                        output.accept(ModBlocks.RAW_TUNGSTEN_BLOCK.get());
                        output.accept(ModBlocks.DEEPSLATE_PALLADIUM_ORE.get());
                        output.accept(ModBlocks.PALLADIUM_ORE.get());
                        output.accept(ModBlocks.PALLADIUM_BLOCK.get());
                        output.accept(ModBlocks.RAW_PALLADIUM_BLOCK.get());
//                        output.accept(ModBlocks.CONVERTER.get());
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}