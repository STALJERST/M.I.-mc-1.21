package com.staljer.magicingineering.foundation.datagen;

import com.staljer.magicingineering.Mg_In;
import com.staljer.magicingineering.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Mg_In.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.RAW_TITANIUM_BLOCK.get())
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get())
                .add(ModBlocks.TUNGSTEN_ORE.get())
                .add(ModBlocks.RAW_TUNGSTEN_BLOCK.get())
                .add(ModBlocks.TUNGSTEN_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.RAW_TITANIUM_BLOCK.get())
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get())
                .add(ModBlocks.TUNGSTEN_ORE.get())
                .add(ModBlocks.RAW_TUNGSTEN_BLOCK.get())
                .add(ModBlocks.TUNGSTEN_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
        ;
    }
}
