package com.staljer.magicingineering.foundation.util;

import com.staljer.magicingineering.Mg_In;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {



    public static final class Blocks {
        public static final TagKey<Block> NEEDS_ULTIMATE_TOOL = createTag("needs_ultimate_tool");
        public static final TagKey<Block> INCORRECT_FOR_ULTIMATE_TOOL = createTag("incorrect_for_ultimate_tool");
        public static final TagKey<Block> MINEABLE_WITH_HAMMER = createTag("mineable_with_hammer");


        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Mg_In.MOD_ID,name));
        }
    }

    public static final class Items {



        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Mg_In.MOD_ID,name));
        }
    }
}
