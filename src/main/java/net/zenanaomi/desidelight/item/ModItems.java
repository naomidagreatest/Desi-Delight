package net.zenanaomi.desidelight.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zenanaomi.desidelight.DesiDelight;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DesiDelight.MOD_ID);

    //crops
    public static final DeferredItem<Item> FENNEL = ITEMS.register("fennel", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
