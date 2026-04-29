package net.zenanaomi.desidelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class Tandoor extends BaseEntityBlock {

    public Tandoor(Properties pProperties) {
        super(pProperties);
    }

    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }


    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        double x = pPos.getX();
        double y = pPos.getY();
        double z = pPos.getZ();

        double py = y + pRandom.nextDouble() * 0.05;

        double px = x + pRandom.nextDouble() * 0.35;
        double pz = z + pRandom.nextDouble() * 0.20;

        double qx = x + pRandom.nextDouble() * 0.20;
        double qz = z + pRandom.nextDouble() * 0.35;

        pLevel.addParticle(ParticleTypes.FLAME, px + 0.30, py + 0.2, pz - 0.15,0.0, 0.0, 0.0);
        pLevel.addParticle(ParticleTypes.FLAME, px + 0.30, py + 0.2, pz + 0.90,0.0, 0.0, 0.0);

        pLevel.addParticle(ParticleTypes.FLAME, qx - 0.15, py + 0.2, qz + 0.30,0.0, 0.0, 0.0);
        pLevel.addParticle(ParticleTypes.FLAME, qx + 0.90, py + 0.2, qz + 0.30,0.0, 0.0, 0.0);

        if (pRandom.nextInt(10) == 0) {
            pLevel.playLocalSound(x, y, z, ModSounds.BLOCK_STOVE_CRACKLE.get(), SoundSource.BLOCKS, 1.0f, 1.0f, false);
        }

        super.animateTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }
}