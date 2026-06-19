package net.zenanaomi.desidelight.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.zenanaomi.desidelight.DesiDelight;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> CINNAMON_TREE_PLACED_KEY = registerKey("cinnamon_tree_placed");
    public static final ResourceKey<PlacedFeature> CASHEW_TREE_PLACED_KEY = registerKey("cashew_tree_placed");

    public static ResourceKey<PlacedFeature> registerKey (String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(DesiDelight.MOD_ID, name));
    }
}
