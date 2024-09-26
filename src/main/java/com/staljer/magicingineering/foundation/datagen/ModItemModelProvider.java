package com.staljer.magicingineering.foundation.datagen;

import com.staljer.magicingineering.Mg_In;
import com.staljer.magicingineering.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Mg_In.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TITANIUM_RAW.get());
        basicItem(ModItems.TUNGSTEN_NUGGET.get());
        basicItem(ModItems.TITANIUM_INGOT.get());
        basicItem(ModItems.TUNGSTEN_RAW.get());
        basicItem(ModItems.TITANIUM_NUGGET.get());
        basicItem(ModItems.TUNGSTEN_INGOT.get());
        basicItem(ModItems.MORPH.get());
        basicItem(ModItems.PALLADIUM_RAW.get());
        basicItem(ModItems.PALLADIUM_NUGGET.get());
        basicItem(ModItems.PALLADIUM_INGOT.get());

        handheldItem(ModItems.ULTIMATE_PICKAXE);
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Mg_In.MOD_ID,"item/" + item.getId().getPath()));
    }
}
