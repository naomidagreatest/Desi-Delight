package net.zenanaomi.desidelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class Tandoor extends Block {
    public Tandoor(Properties pProperties) {
        super(pProperties);
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

    //    @Override
//    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
//        ItemStack heldStack = pPlayer.getItemInHand(pHand);
//
//
//        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
//    }
}
