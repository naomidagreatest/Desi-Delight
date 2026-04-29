package net.zenanaomi.desidelight.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zenanaomi.desidelight.DesiDelight;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DesiDelight.MOD_ID);

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, DesiDelight.MOD_ID);


    public static final RegistryObject<RecipeSerializer<TandoorCookingRecipe>> TANDOOR_COOKING_SERIALIZER =
            SERIALIZERS.register("tandoor_cooking", () -> TandoorCookingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeType<TandoorCookingRecipe>> TANDOOR_COOKING_TYPE =
            TYPES.register("tandoor_cooking", () -> TandoorCookingRecipe.Type.INSTANCE);


    public static void register (IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
