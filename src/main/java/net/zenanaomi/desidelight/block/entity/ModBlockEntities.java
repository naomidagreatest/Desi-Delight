package net.zenanaomi.desidelight.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DesiDelight.MOD_ID);

    public static final RegistryObject<BlockEntityType<TandoorBlockEntity>> TANDOOR_BE =
            BLOCK_ENTITIES.register("tandoor_be", () -> BlockEntityType.Builder.of(TandoorBlockEntity::new, ModBlocks.TANDOOR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
