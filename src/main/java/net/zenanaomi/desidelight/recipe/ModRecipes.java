package net.zenanaomi.desidelight.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zenanaomi.desidelight.DesiDelight;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, DesiDelight.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, DesiDelight.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<TandoorCookingRecipe>> TANDOOR_COOKING_SERIALIZER =
            SERIALIZERS.register("tandoor_cooking", TandoorCookingRecipeSerializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<TandoorCookingRecipe>> TANDOOR_COOKING_TYPE =
            TYPES.register("tandoor_cooking", () -> new RecipeType<>(){});

    public static void register (IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
