package net.zenanaomi.desidelight.item;

import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.zenanaomi.desidelight.effect.ModEffects;

public class ModFoods {

    //ingredients
    public static final FoodProperties CASHEW = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(1.0f)
            .fast()
            .build();

    public static final FoodProperties GARLIC = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 40, 0, true, true, true), 1.0f)
            .build();

    public static final FoodProperties GINGER = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 40, 0, true, true, true), 1.0f)
            .build();

    public static final FoodProperties RED_CHILI = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.5f)
            .fast()
            .effect(() -> new MobEffectInstance(ModEffects.BURNING.get(), 20, 0, false, false, false), 1.0f)
            .build();

    public static final FoodProperties GREEN_CHILI = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.5f)
            .fast()
            .effect(() -> new MobEffectInstance(ModEffects.BURNING.get(), 20, 0, false, false, false), 1.0f)
            .build();

    public static final FoodProperties BUTTER = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.34f)
            .build();

    public static final FoodProperties CASHEW_BUTTER = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.34f)
            .build();

    //finger food
    public static final FoodProperties NAAN = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.5f)
            .build();

    public static final FoodProperties ALOO_PARATHA = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.5f)
            .build();

    public static final FoodProperties TANDOORI_CHICKEN = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.5f)
            .meat()
            .build();

    // feasts
    public static final FoodProperties BUTTER_CHICKEN = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.67f)
            .build();

    //sweets
    public static final FoodProperties DAHI = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.5f)
            .build();

    public static final FoodProperties MISHTI_DOI = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(vectorwing.farmersdelight.common.registry.ModEffects.COMFORT.get(), 600, 0, true, true, true), 1.0f)
            .build();
}
