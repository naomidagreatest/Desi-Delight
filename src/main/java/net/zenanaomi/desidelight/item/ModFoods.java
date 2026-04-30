package net.zenanaomi.desidelight.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
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
