package net.zenanaomi.desidelight.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.zenanaomi.desidelight.block.custom.Tandoor;
import net.zenanaomi.desidelight.recipe.TandoorCookingRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Optional;

//okay so all this code is so horribly constructed i'm so sorry, i've been following like 5 different things trying to get this thing to work

public class TandoorBlockEntity extends BlockEntity {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            TandoorBlockEntity.this.setChanged();

            if (level != null && !level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            }
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.of(() -> itemHandler);

    private int progress = 0;
    private int maxProgress = 60;
    private int cooldown = 0;

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("tandoor_progress", progress);
        pTag.putInt("cooldown", cooldown);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("tandoor_progress");
        cooldown = pTag.getInt("cooldown");
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        load(tag);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        load(pkt.getTag());
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public TandoorBlockEntity( BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.TANDOOR_BE.get(), pPos, pBlockState);

    }

    public void tick(Level level, BlockPos pos, BlockState state) {

        if (cooldown > 0) {
            cooldown--;
            return;
        }

        if (level == null || level.isClientSide()) return;
        Optional<TandoorCookingRecipe> recipe = getCurrentRecipe();

        boolean wasLit = state.getValue(Tandoor.LIT);
        boolean isLit = recipe.isPresent();

        if (wasLit != isLit) {
            level.setBlock(pos, state.setValue(Tandoor.LIT, isLit), 3);
        }

        if (recipe.isPresent()) {
            progress++;

            if (progress >= maxProgress) {
                craftItem(recipe.get());
                progress = 0;
                for (int i = 0; i < 4; i++) {
                    itemHandler.extractItem(i, 1, false);
                }
            }
        } else {
            progress = 0;
        }

    }

    private void craftItem(TandoorCookingRecipe recipe) {
        ItemStack result = recipe.getResultItem(level.registryAccess());
        for (Ingredient ingredient : recipe.getIngredients()) {
            for (int i = 0; i < itemHandler.getSlots(); i++) {
                ItemStack stack = itemHandler.getStackInSlot(i);

                if (!stack.isEmpty() && ingredient.test(stack)) {
                    itemHandler.extractItem(i, 1, false);
                    break;
                }
            }
        }

        if (level != null && !level.isClientSide) {
            Containers.dropItemStack(level,
                    worldPosition.getX() + 0.5,
                    worldPosition.getY() + 1.0,
                    worldPosition.getZ() + 0.5,
                    result.copy());
        }

        progress = 0;
        setChanged();
        level.blockEntityChanged(worldPosition);
    }

    private Optional<TandoorCookingRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(TandoorCookingRecipe.Type.INSTANCE, inventory, level);
    }

    public ItemStack getItem(int slot) {
        return this.itemHandler.getStackInSlot(slot);
    }

    public void setItem(int slot, ItemStack stack) {
        this.itemHandler.setStackInSlot(slot, stack.copy());
        this.progress = 0;
        ItemStack copy = stack.copy();
        copy.setCount(1);

        this.itemHandler.setStackInSlot(slot, copy);
        if (!stack.isEmpty()) {
            stack.setCount(1);
        }
        this.progress= 0;

        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    public ItemStack removeItem(int slot) {
        ItemStack stack = this.itemHandler.extractItem(slot, 1, false);

        if (!stack.isEmpty()) {
            this.progress = 0;
        }

        setChanged();
        return stack;
    }
}