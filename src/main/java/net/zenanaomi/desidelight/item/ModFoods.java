package net.zenanaomi.desidelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.zenanaomi.desidelight.effect.ModEffects;

public class ModFoods {
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

    public static final FoodProperties NAAN = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.5f)
            .build();

    public static final FoodProperties TANDOORI_CHICKEN = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.5f)
            .build();

    public static final FoodProperties BUTTER_CHICKEN = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.67f)
            .build();
}
