package net.zenanaomi.desidelight.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class TandoorCookingRecipeSerializer implements RecipeSerializer<TandoorCookingRecipe> {

    public static final MapCodec<TandoorCookingRecipe> CODEC =
            RecordCodecBuilder.mapCodec(tandoorCookingRecipeInstance -> tandoorCookingRecipeInstance.group(
                    Ingredient.CODEC.listOf().xmap(list -> NonNullList.of(Ingredient.EMPTY, list.toArray(new Ingredient[0])), list -> list).fieldOf("ingredients").forGetter(TandoorCookingRecipe::getIngredients),
                    ItemStack.CODEC.fieldOf("result").forGetter(TandoorCookingRecipe::getOutput),
                    Codec.INT.optionalFieldOf("cook_time", 60).forGetter(TandoorCookingRecipe::getCookTime)
            ).apply(tandoorCookingRecipeInstance, TandoorCookingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, TandoorCookingRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.collection(NonNullList::createWithCapacity)),
                    TandoorCookingRecipe::getIngredients,
                    ItemStack.STREAM_CODEC,
                    TandoorCookingRecipe::getOutput,
                    ByteBufCodecs.INT,
                    TandoorCookingRecipe::getCookTime,
                    TandoorCookingRecipe::new
            );

    @Override
    public MapCodec<TandoorCookingRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, TandoorCookingRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
