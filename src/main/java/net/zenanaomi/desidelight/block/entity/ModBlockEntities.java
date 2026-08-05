package net.zenanaomi.desidelight.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, DesiDelight.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TandoorBlockEntity>> TANDOOR_BE = BLOCK_ENTITIES.register("tandoor_be", () -> BlockEntityType.Builder.of(TandoorBlockEntity::new, ModBlocks.TANDOOR.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModSignBlockEntity>> DESI_DELIGHT_SIGN = BLOCK_ENTITIES.register("desidelight_sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new,
            ModBlocks.CINNAMON_SIGN.get(),
            ModBlocks.CINNAMON_WALL_SIGN.get(),
            ModBlocks.CASHEW_SIGN.get(),
            ModBlocks.CASHEW_WALL_SIGN.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModHangingSignBlockEntity>> DESI_DELIGHT_HANGING_SIGN = BLOCK_ENTITIES.register("desidelight_hanging_sign", () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
            ModBlocks.CINNAMON_HANGING_SIGN.get(),
            ModBlocks.CINNAMON_WALL_HANGING_SIGN.get(),
            ModBlocks.CASHEW_HANGING_SIGN.get(),
            ModBlocks.CASHEW_WALL_HANGING_SIGN.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModCabinetBlockEntity>> DESI_DELIGHT_CABINET = BLOCK_ENTITIES.register("desidelight_cabinet", () -> BlockEntityType.Builder.of(ModCabinetBlockEntity::new,
            ModBlocks.CINNAMON_CABINET.get(),
            ModBlocks.CASHEW_CABINET.get()
            ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
