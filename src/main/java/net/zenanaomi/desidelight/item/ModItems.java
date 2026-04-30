package net.zenanaomi.desidelight.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zenanaomi.desidelight.DesiDelight;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, DesiDelight.MOD_ID);

    public static final RegistryObject<Item> NAAN = ITEMS.register("naan", () -> new Item(new Item.Properties().food(ModFoods.NAAN)));
    public static final RegistryObject<Item> TANDOORI_CHICKEN = ITEMS.register("tandoori_chicken", () -> new Item(new Item.Properties().food(ModFoods.TANDOORI_CHICKEN)));
    public static final RegistryObject<Item> BUTTER_CHICKEN = ITEMS.register("butter_chicken", () -> new Item(new Item.Properties().food(ModFoods.BUTTER_CHICKEN)));

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
