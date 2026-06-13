package net.zenanaomi.desidelight.item;

import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.block.ModBlocks;
import net.zenanaomi.desidelight.entity.custom.ModBoatEntity;
import net.zenanaomi.desidelight.item.custom.ModBoatItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, DesiDelight.MOD_ID);

    //wood stuff
    public static final RegistryObject<Item> CINNAMON_SIGN = ITEMS.register("cinnamon_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.CINNAMON_SIGN.get(), ModBlocks.CINNAMON_WALL_SIGN.get()));
    public static final RegistryObject<Item> CINNAMON_HANGING_SIGN = ITEMS.register("cinnamon_hanging_sign", () -> new HangingSignItem(ModBlocks.CINNAMON_HANGING_SIGN.get(), ModBlocks.CINNAMON_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> CINNAMON_BOAT = ITEMS.register("cinnamon_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.CINNAMON, new Item.Properties()));
    public static final RegistryObject<Item> CINNAMON_CHEST_BOAT = ITEMS.register("cinnamon_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.CINNAMON, new Item.Properties()));
    public static final RegistryObject<Item> CASHEW_SIGN = ITEMS.register("cashew_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.CASHEW_SIGN.get(), ModBlocks.CASHEW_WALL_SIGN.get()));
    public static final RegistryObject<Item> CASHEW_HANGING_SIGN = ITEMS.register("cashew_hanging_sign", () -> new HangingSignItem(ModBlocks.CASHEW_HANGING_SIGN.get(), ModBlocks.CASHEW_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> CASHEW_BOAT = ITEMS.register("cashew_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.CASHEW, new Item.Properties()));
    public static final RegistryObject<Item> CASHEW_CHEST_BOAT = ITEMS.register("cashew_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.CASHEW, new Item.Properties()));

    //crops
    public static final RegistryObject<Item> FENNEL = ITEMS.register("fennel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLOVES = ITEMS.register("cloves", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CUMIN = ITEMS.register("cumin", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STAR_ANISE = ITEMS.register("star_anise", () -> new Item(new Item.Properties()));

    //dried variants
    public static final RegistryObject<Item> DRIED_FENNEL = ITEMS.register("dried_fennel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_CLOVES = ITEMS.register("dried_cloves", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_CUMIN = ITEMS.register("dried_cumin", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_STAR_ANISE = ITEMS.register("dried_star_anise", () -> new Item(new Item.Properties()));

    //crops (no dried variants)
    public static final RegistryObject<Item> PEPPERCORN = ITEMS.register("peppercorn", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BAY_LEAVES = ITEMS.register("bay_leaves", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CORIANDER = ITEMS.register("coriander", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RED_CHILI = ITEMS.register("red_chili", () -> new Item(new Item.Properties().food(ModFoods.RED_CHILI)));
    public static final RegistryObject<Item> GREEN_CHILI = ITEMS.register("green_chili", () -> new Item(new Item.Properties().food(ModFoods.GREEN_CHILI)));

    //tree ingredients
    public static final RegistryObject<Item> CINNAMON = ITEMS.register("cinnamon", () -> new Item(new Item.Properties()));

    //finger food
    public static final RegistryObject<Item> NAAN = ITEMS.register("naan", () -> new Item(new Item.Properties().food(ModFoods.NAAN)));
    public static final RegistryObject<Item> TANDOORI_CHICKEN = ITEMS.register("tandoori_chicken", () -> new Item(new Item.Properties().food(ModFoods.TANDOORI_CHICKEN)));

    //meals
    public static final RegistryObject<Item> BUTTER_CHICKEN = ITEMS.register("butter_chicken", () -> new Item(new Item.Properties().food(ModFoods.BUTTER_CHICKEN)));

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
