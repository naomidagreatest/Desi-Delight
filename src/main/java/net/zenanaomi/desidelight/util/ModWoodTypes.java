package net.zenanaomi.desidelight.util;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.zenanaomi.desidelight.DesiDelight;

public class ModWoodTypes {
    public static final WoodType CINNAMON = WoodType.register(new WoodType(DesiDelight.MOD_ID + ":cinnamon", BlockSetType.OAK));
    public static final WoodType CASHEW = WoodType.register(new WoodType(DesiDelight.MOD_ID + ":cashew", BlockSetType.BIRCH));
}
