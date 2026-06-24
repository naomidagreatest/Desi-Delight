package net.zenanaomi.desidelight.block.custom.feasts;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.function.Supplier;

public class ButterChickenBlock extends FeastBlock {

    protected static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.box(2, 0, 2, 14, 3, 14),
            Block.box(2, 0, 2, 14, 3, 14),
            Block.box(2, 0, 2, 14, 3, 14),
            Block.box(2, 0, 2, 14, 3, 14),
            Block.box(2, 0, 2, 14, 3, 14)
    };

    public ButterChickenBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(SERVINGS)];
    }
}
