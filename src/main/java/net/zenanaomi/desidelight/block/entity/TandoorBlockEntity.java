package net.zenanaomi.desidelight.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;

public class TandoorBlockEntity extends BlockEntity implements BlockEntityTicker<TandoorBlockEntity> {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
    };

    public TandoorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.TANDOOR_BE.get(), pPos, pBlockState);
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState, TandoorBlockEntity pBlockEntity) {

    }
}
