package net.zenanaomi.desidelight.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.zenanaomi.desidelight.block.entity.ModBlockEntities;
import net.zenanaomi.desidelight.block.entity.TandoorBlockEntity;
import net.zenanaomi.desidelight.util.ModTags;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class Tandoor extends BaseEntityBlock {

    public Tandoor(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false));
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


    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
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

        BlockEntity be = pLevel.getBlockEntity(pPos);
        if (be instanceof TandoorBlockEntity tandoor && pState.getValue(LIT)) {
            if (pRandom.nextFloat() < 0.75f) {
                pLevel.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + 0.5, y + 1.5, z + 0.5, 0, 0.1, 0);
                pLevel.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + 0.5, y + 1.5, z + 0.5, 0, 0.15, 0);
                pLevel.playLocalSound(x, y, z, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 2.0f, 1.0f, false);
            }
        }

        super.animateTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos,
                         BlockState pNewState, boolean pMovedByPiston) {

        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof TandoorBlockEntity tandoor) {
                tandoor.drops();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);

            if (blockEntity instanceof TandoorBlockEntity tandoor) {
                if (pPlayer.isShiftKeyDown()) {
                    for (int i = 0; i < 4; i++) {
                        ItemStack stack = tandoor.removeItem(i);
                        if (!stack.isEmpty()) {
                            pPlayer.addItem(stack);
                            break;
                        }
                    }
                    return InteractionResult.SUCCESS;
                }

                ItemStack held = pPlayer.getItemInHand(pHand);
                for (int i = 0; i < 4; i++) {
                    if (tandoor.getItem(i).isEmpty() && held.is(ModTags.Items.TANDOOR_INGREDIENTS)) { //if (tandoor.getItem(i).isEmpty() && isValidIngredient(held))
                        tandoor.setItem(i, held.split(1));
                        break;
                    }
                }

            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide()) {
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.TANDOOR_BE.get(), (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new TandoorBlockEntity(pPos, pState);
    }
}
