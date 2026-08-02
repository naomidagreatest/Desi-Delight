package net.zenanaomi.desidelight.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.registry.ModSounds;


public class Tandoor extends BaseEntityBlock {

    public Tandoor(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(LIT, false));
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
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();

        double py = y + random.nextDouble() * 0.05;

        double px = x + random.nextDouble() * 0.35;
        double pz = z + random.nextDouble() * 0.20;

        double qx = x + random.nextDouble() * 0.20;
        double qz = z + random.nextDouble() * 0.35;

        level.addParticle(ParticleTypes.FLAME, px + 0.30, py + 0.2, pz - 0.15,0.0, 0.0, 0.0);
        level.addParticle(ParticleTypes.FLAME, px + 0.30, py + 0.2, pz + 0.90,0.0, 0.0, 0.0);

        level.addParticle(ParticleTypes.FLAME, qx - 0.15, py + 0.2, qz + 0.30,0.0, 0.0, 0.0);
        level.addParticle(ParticleTypes.FLAME, qx + 0.90, py + 0.2, qz + 0.30,0.0, 0.0, 0.0);

        if (random.nextInt(10) == 0) {
            level.playLocalSound(x, y, z, ModSounds.BLOCK_STOVE_CRACKLE.get(), SoundSource.BLOCKS, 1.0f, 1.0f, false);
        }

        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof TandoorBlockEntity tandoor && state.getValue(LIT)) {
            if (random.nextFloat() < 0.75f) {
                level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + 0.5, y + 1.5, z + 0.5, 0, 0.1, 0);
                level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + 0.5, y + 1.5, z + 0.5, 0, 0.15, 0);
                level.playLocalSound(x, y, z, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 2.0f, 1.0f, false);
            }
        }

        super.animateTick(state, level, pos, random);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof TandoorBlockEntity tandoor) {
                tandoor.drops();
            }
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);

            if(blockEntity instanceof TandoorBlockEntity tandoor) {
                if (player.isShiftKeyDown()) {
                    for (int i = 0; i < 4; i++) {
                        stack = tandoor.removeItem(i);
                        if (!stack.isEmpty()) {
                            player.addItem(stack);
                            break;
                        }
                    }
                    return ItemInteractionResult.SUCCESS;
                }
                ItemStack held = player.getItemInHand(hand);
                for (int i = 0; i < 4; i++) {
                    if (tandoor.getItem(i).isEmpty()) {
                        tandoor.setItem(i, held.split(1));
                        break;
                    }
                }
            }
        }
        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return null;
        }

        return createTickerHelper(blockEntityType, ModBlockEntities.TANDOOR_BE.get(), (level1, blockPos, blockState, tandoorBlockEntity) -> tandoorBlockEntity.tick(level1, blockPos, blockState));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(Tandoor::new);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TandoorBlockEntity(blockPos, blockState);
    }
}
