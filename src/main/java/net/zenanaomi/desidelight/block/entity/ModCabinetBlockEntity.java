package net.zenanaomi.desidelight.block.entity;

import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.zenanaomi.desidelight.block.custom.ModCabinetBlock;
import vectorwing.farmersdelight.common.registry.ModSounds;
import vectorwing.farmersdelight.common.utility.TextUtils;

public class ModCabinetBlockEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> contents;
    private ContainerOpenersCounter openersCounter;

    public ModCabinetBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.DESI_DELIGHT_CABINET.get(), pos, blockState);
        this.contents = NonNullList.withSize(27, ItemStack.EMPTY);
        this.openersCounter = new ContainerOpenersCounter() {
            protected void onOpen(Level level, BlockPos pos, BlockState state) {
                ModCabinetBlockEntity.this.playSound(state, (SoundEvent) ModSounds.BLOCK_CABINET_OPEN.get());
                ModCabinetBlockEntity.this.updateBlockState(state, true);
            }

            protected void onClose(Level level, BlockPos pos, BlockState state) {
                ModCabinetBlockEntity.this.playSound(state, (SoundEvent)ModSounds.BLOCK_CABINET_CLOSE.get());
                ModCabinetBlockEntity.this.updateBlockState(state, false);
            }

            protected void openerCountChanged(Level level, BlockPos pos, BlockState sta, int arg1, int arg2) {
            }

            protected boolean isOwnContainer(Player p_155060_) {
                if (p_155060_.containerMenu instanceof ChestMenu) {
                    Container container = ((ChestMenu)p_155060_.containerMenu).getContainer();
                    return container == ModCabinetBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModBlockEntities.DESI_DELIGHT_CABINET.get(), (be, context) -> new InvWrapper(be));
    }

    public void saveAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.saveAdditional(compound, registries);
        if (!this.trySaveLootTable(compound)) {
            ContainerHelper.saveAllItems(compound, this.contents, registries);
        }

    }

    public void loadAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.loadAdditional(compound, registries);
        this.contents = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(compound)) {
            ContainerHelper.loadAllItems(compound, this.contents, registries);
        }

    }

    @Override
    protected Component getDefaultName() {
        return TextUtils.getTranslation("container.cabinet", new Object[0]);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.contents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {
        this.contents = nonNullList;
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return ChestMenu.threeRows(id, player, this);
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    public void startOpen(Player pPlayer) {
        if (this.level != null && !this.remove && !pPlayer.isSpectator()) {
            this.openersCounter.incrementOpeners(pPlayer, this.level, this.getBlockPos(), this.getBlockState());
        }

    }

    public void stopOpen(Player pPlayer) {
        if (this.level != null && !this.remove && !pPlayer.isSpectator()) {
            this.openersCounter.decrementOpeners(pPlayer, this.level, this.getBlockPos(), this.getBlockState());
        }

    }

    public void recheckOpen() {
        if (this.level != null && !this.remove) {
            this.openersCounter.recheckOpeners(this.level, this.getBlockPos(), this.getBlockState());
        }

    }

    void updateBlockState(BlockState state, boolean open) {
        if (this.level != null) {
            this.level.setBlock(this.getBlockPos(), (BlockState)state.setValue(ModCabinetBlock.OPEN, open), 3);
        }

    }

    private void playSound(BlockState state, SoundEvent sound) {
        if (this.level != null) {
            Vec3i cabinetFacingVector = ((Direction)state.getValue(ModCabinetBlock.FACING)).getNormal();
            double x = (double)this.worldPosition.getX() + (double)0.5F + (double)cabinetFacingVector.getX() / (double)2.0F;
            double y = (double)this.worldPosition.getY() + (double)0.5F + (double)cabinetFacingVector.getY() / (double)2.0F;
            double z = (double)this.worldPosition.getZ() + (double)0.5F + (double)cabinetFacingVector.getZ() / (double)2.0F;
            this.level.playSound((Player)null, x, y, z, sound, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
        }
    }
}
