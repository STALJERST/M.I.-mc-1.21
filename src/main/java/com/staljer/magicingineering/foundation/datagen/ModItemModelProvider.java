package com.staljer.magicingineering.foundation.datagen;

import com.staljer.magicingineering.Mg_In;
import com.staljer.magicingineering.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

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
    }
}
