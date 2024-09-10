package com.staljer.magicingineering.foundation.datagen;

import com.staljer.magicingineering.item.ModItems;
import com.staljer.magicingineering.block.ModBlocks;
import com.staljer.magicingineering.Mg_In;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> TITANIUM_SMELTABLES = List.of(ModItems.TITANIUM_RAW.get(),
                ModBlocks.TITANIUM_ORE.get(), ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
        List<ItemLike> TUNGSTEN_SMELTABLES = List.of(ModItems.TUNGSTEN_RAW.get(),
                ModBlocks.TUNGSTEN_ORE.get(), ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TITANIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 9)
                .requires(ModBlocks.TITANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TITANIUM_BLOCK.get()), has(ModBlocks.TITANIUM_BLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_TITANIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TITANIUM_RAW.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_RAW.get()), has(ModItems.TITANIUM_RAW.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM_RAW.get(), 9)
                .requires(ModBlocks.RAW_TITANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_TITANIUM_BLOCK.get()), has(ModBlocks.RAW_TITANIUM_BLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TUNGSTEN_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TUNGSTEN_INGOT.get())
                .unlockedBy(getHasName(ModItems.TUNGSTEN_INGOT.get()), has(ModItems.TUNGSTEN_INGOT.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 9)
                .requires(ModBlocks.TUNGSTEN_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TUNGSTEN_BLOCK.get()), has(ModBlocks.TUNGSTEN_BLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_TUNGSTEN_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TUNGSTEN_RAW.get())
                .unlockedBy(getHasName(ModItems.TUNGSTEN_RAW.get()), has(ModItems.TUNGSTEN_RAW.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TUNGSTEN_RAW.get(), 9)
                .requires(ModBlocks.RAW_TUNGSTEN_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_TUNGSTEN_BLOCK.get()), has(ModBlocks.RAW_TUNGSTEN_BLOCK.get())).save(pRecipeOutput);





        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TITANIUM_NUGGET.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_NUGGET.get()), has(ModItems.TITANIUM_NUGGET.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM_NUGGET.get(), 9)
                .requires(ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_TITANIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TITANIUM_RAW.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_RAW.get()), has(ModItems.TITANIUM_RAW.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM_RAW.get(), 9)
                .requires(ModBlocks.RAW_TITANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_TITANIUM_BLOCK.get()), has(ModBlocks.RAW_TITANIUM_BLOCK.get())).save(pRecipeOutput);












        oreSmelting(pRecipeOutput, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.25f, 200, "mi_blocks");
        oreBlasting(pRecipeOutput, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.25f, 100, "mi_blocks");
        oreSmelting(pRecipeOutput, TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 0.25f, 200, "mi_blocks");
        oreBlasting(pRecipeOutput, TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 0.25f, 100, "mi_blocks");


    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Mg_In.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
