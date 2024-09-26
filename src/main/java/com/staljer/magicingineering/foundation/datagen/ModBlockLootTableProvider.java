package com.staljer.magicingineering.foundation.datagen;

import com.staljer.magicingineering.item.ModItems;
import com.staljer.magicingineering.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.TITANIUM_BLOCK.get());
        dropSelf(ModBlocks.RAW_TITANIUM_BLOCK.get());
        dropSelf(ModBlocks.TUNGSTEN_BLOCK.get());
        dropSelf(ModBlocks.RAW_TUNGSTEN_BLOCK.get());
        dropSelf(ModBlocks.TITANIUM_ORE.get());
        dropSelf(ModBlocks.TUNGSTEN_ORE.get());
        dropSelf(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
        dropSelf(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
        dropSelf(ModBlocks.PALLADIUM_BLOCK.get());
        dropSelf(ModBlocks.PALLADIUM_ORE.get());
        dropSelf(ModBlocks.DEEPSLATE_PALLADIUM_ORE.get());
        dropSelf(ModBlocks.RAW_PALLADIUM_BLOCK.get());
        //dropSelf(ModBlocks.CONVERTER.get());


        this.add(ModBlocks.TITANIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.TITANIUM_ORE.get(), ModItems.TITANIUM_RAW.get()));
        this.add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), ModItems.TITANIUM_RAW.get(), 2, 6));
        this.add(ModBlocks.TUNGSTEN_ORE.get(),
                block -> createOreDrop(ModBlocks.TUNGSTEN_ORE.get(), ModItems.TUNGSTEN_RAW.get()));
        this.add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), ModItems.TUNGSTEN_RAW.get(), 2, 6));
        this.add(ModBlocks.PALLADIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.PALLADIUM_ORE.get(), ModItems.PALLADIUM_RAW.get()));
        this.add(ModBlocks.DEEPSLATE_PALLADIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_PALLADIUM_ORE.get(), ModItems.PALLADIUM_RAW.get(), 2, 6));
    }
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
