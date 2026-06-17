package net.zenanaomi.desidelight.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.zenanaomi.desidelight.DesiDelight;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> CINNAMON_TREE_KEY = registerKey("cinnamon_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CASHEW_TREE_KEY = registerKey("cashew_tree");

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(DesiDelight.MOD_ID, name));
    }
}
