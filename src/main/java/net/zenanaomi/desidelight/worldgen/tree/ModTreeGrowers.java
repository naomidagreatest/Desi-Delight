package net.zenanaomi.desidelight.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower CINNAMON = new TreeGrower(DesiDelight.MOD_ID + ":cinnamon", Optional.empty(), Optional.of(ModConfiguredFeatures.CINNAMON_TREE_KEY), Optional.empty());
    public static final TreeGrower CASHEW = new TreeGrower(DesiDelight.MOD_ID + ":cashew", Optional.empty(), Optional.of(ModConfiguredFeatures.CASHEW_TREE_KEY), Optional.empty());
}
