package net.zenanaomi.desidelight.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.zenanaomi.desidelight.block.custom.Tandoor;
import net.zenanaomi.desidelight.recipe.ModRecipes;
import net.zenanaomi.desidelight.recipe.TandoorCookingRecipe;
import net.zenanaomi.desidelight.recipe.TandoorRecipeInput;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class TandoorBlockEntity extends BlockEntity {
    private final ItemStackHandler itemHandler= new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            TandoorBlockEntity.this.setChanged();

            if(level != null && !level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            }
        }
    };

    private int progress = 0;
    private int maxProgress = 60;
    private int cooldown = 0;

    public void drops() {
        SimpleContainer inventory= new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public TandoorBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.TANDOOR_BE.get(), pos, blockState);
    }

    public void tick (Level level, BlockPos pos, BlockState state) {
        if (cooldown > 0) {
            cooldown--;
        }

        if (level == null || level.isClientSide()) return;
        Optional<RecipeHolder<TandoorCookingRecipe>> recipe = getCurrentRecipe();

        boolean wasLit = state.getValue(Tandoor.LIT);
        boolean isLit = recipe.isPresent();

        if (wasLit != isLit) {
            level.setBlock(pos, state.setValue(Tandoor.LIT, isLit), 3);
        }

        if (recipe.isPresent()) {
            progress++;

            if (progress >= maxProgress) {
                craftItem(recipe.get().value());
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
                ItemStack stack =itemHandler.getStackInSlot(i);

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

    private Optional<RecipeHolder<TandoorCookingRecipe>> getCurrentRecipe() {

        ItemStack[] stacks =
                new ItemStack[itemHandler.getSlots()];

        for(int i = 0; i < itemHandler.getSlots(); i++) {

            stacks[i] =
                    itemHandler.getStackInSlot(i);

        }

        TandoorRecipeInput input = new TandoorRecipeInput(stacks);

        return this.level.getRecipeManager()
                .getRecipeFor(
                        ModRecipes.TANDOOR_COOKING_TYPE.get(),
                        input,
                        level
                );
    }

    public ItemStack getItem(int slot) {
        return this.itemHandler.getStackInSlot(slot);
    }

    public void setItem (int slot, ItemStack stack) {
        this.itemHandler.setStackInSlot(slot, stack.copy());
        this.progress = 0;
        ItemStack copy = stack.copy();
        copy.setCount(1);

        this.itemHandler.setStackInSlot(slot, copy);
        if (!stack.isEmpty()) {
            stack.setCount(1);
        }
        this.progress= 0;

        setChanged();

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

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("progress", progress);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if(tag.contains("inventory")) {
            itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
        }

        progress = tag.getInt("progress");
    }
}
