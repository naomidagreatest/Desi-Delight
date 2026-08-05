package net.zenanaomi.desidelight.item;

import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.block.ModBlocks;
import net.zenanaomi.desidelight.entity.custom.ModBoatEntity;
import net.zenanaomi.desidelight.item.custom.ModBoatItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DesiDelight.MOD_ID);

    //wood stuff
    public static final DeferredItem<Item> CINNAMON_SIGN = ITEMS.register("cinnamon_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.CINNAMON_SIGN.get(), ModBlocks.CINNAMON_WALL_SIGN.get()));
    public static final DeferredItem<Item> CINNAMON_HANGING_SIGN = ITEMS.register("cinnamon_hanging_sign", () -> new HangingSignItem(ModBlocks.CINNAMON_HANGING_SIGN.get(), ModBlocks.CINNAMON_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> CINNAMON_BOAT = ITEMS.register("cinnamon_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.CINNAMON, new Item.Properties()));
    public static final DeferredItem<Item> CINNAMON_CHEST_BOAT = ITEMS.register("cinnamon_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.CINNAMON, new Item.Properties()));
    public static final DeferredItem<Item> CASHEW_SIGN = ITEMS.register("cashew_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.CASHEW_SIGN.get(), ModBlocks.CASHEW_WALL_SIGN.get()));
    public static final DeferredItem<Item> CASHEW_HANGING_SIGN = ITEMS.register("cashew_hanging_sign", () -> new HangingSignItem(ModBlocks.CASHEW_HANGING_SIGN.get(), ModBlocks.CASHEW_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> CASHEW_BOAT = ITEMS.register("cashew_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.CASHEW, new Item.Properties()));
    public static final DeferredItem<Item> CASHEW_CHEST_BOAT = ITEMS.register("cashew_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.CASHEW, new Item.Properties()));

    //crops
    public static final DeferredItem<Item> FENNEL = ITEMS.register("fennel", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
