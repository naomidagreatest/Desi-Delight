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

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
