package net.zenanaomi.desidelight.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.zenanaomi.desidelight.DesiDelight;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(DesiDelight.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TANDOOR_INGREDIENTS = tag("tandoor_ingredients");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(DesiDelight.MOD_ID, name));
        }
    }
}
