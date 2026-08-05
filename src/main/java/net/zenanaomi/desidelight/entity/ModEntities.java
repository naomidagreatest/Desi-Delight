package net.zenanaomi.desidelight.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.entity.custom.ModBoatEntity;
import net.zenanaomi.desidelight.entity.custom.ModChestBoatEntity;

public class ModEntities {
    public static final DeferredRegister <EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, DesiDelight.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<ModBoatEntity>> DESI_DELIGHT_BOAT = ENTITY_TYPES.register("desidelight_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("desidelight_boat"));
    public static final DeferredHolder<EntityType<?>, EntityType<ModChestBoatEntity>> DESI_DELIGHT_CHEST_BOAT = ENTITY_TYPES.register("desidelight_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("desidelight_chest_boat"));

    public static void register (IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
