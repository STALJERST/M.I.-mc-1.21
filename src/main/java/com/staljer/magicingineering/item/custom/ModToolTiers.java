package com.staljer.magicingineering.item.custom;

import com.staljer.magicingineering.foundation.util.ModTags;
import com.staljer.magicingineering.item.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier ULTIMATE = new ForgeTier(2000000,2000,150,40,
            ModTags.Blocks.NEEDS_ULTIMATE_TOOL, () -> Ingredient.of(ModItems.TITANIUM_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_ULTIMATE_TOOL);

    /*public int getMiningLevel() {
        return 4; // Рівень видобутку
    }*/

}
