package net.zenanaomi.desidelight.item;

import net.minecraft.world.item.*;
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

    //wild crops
    public static final DeferredItem<Item> WILD_FENNEL = ITEMS.register("wild_fennel", () -> new BlockItem(ModBlocks.WILD_FENNEL.get(), new Item.Properties()));
    public static final DeferredItem<Item> WILD_CLOVES = ITEMS.register("wild_cloves", () -> new BlockItem(ModBlocks.WILD_CLOVES.get(), new Item.Properties()));
    public static final DeferredItem<Item> WILD_CUMIN = ITEMS.register("wild_cumin", () -> new BlockItem(ModBlocks.WILD_CUMIN.get(), new Item.Properties()));
    public static final DeferredItem<Item> WILD_STAR_ANISE = ITEMS.register("wild_star_anise", () -> new BlockItem(ModBlocks.WILD_STAR_ANISE.get(), new Item.Properties()));
    public static final DeferredItem<Item> WILD_PEPPERCORN = ITEMS.register("wild_peppercorn", () -> new BlockItem(ModBlocks.WILD_PEPPERCORN.get(), new Item.Properties()));
    public static final DeferredItem<Item> WILD_CORIANDER = ITEMS.register("wild_coriander", () -> new BlockItem(ModBlocks.WILD_CORIANDER.get(), new Item.Properties()));
    public static final DeferredItem<Item> WILD_CHILI_PEPPER = ITEMS.register("wild_chili_pepper", () -> new BlockItem(ModBlocks.WILD_CHILI_PEPPER.get(), new Item.Properties()));
    public static final DeferredItem<Item> WILD_GARLIC = ITEMS.register("wild_garlic", () -> new BlockItem(ModBlocks.WILD_GARLIC.get(), new Item.Properties()));
    public static final DeferredItem<Item> WILD_GINGER = ITEMS.register("wild_ginger", () -> new BlockItem(ModBlocks.WILD_GINGER.get(), new Item.Properties()));

    //seeds
    public static final DeferredItem<Item> TEJPAT_SEEDS = ITEMS.register("tejpat_seeds", () -> new ItemNameBlockItem(ModBlocks.BAY_LEAVES_CROP_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> CORIANDER_SEEDS = ITEMS.register("coriander_seeds", () -> new ItemNameBlockItem(ModBlocks.CORIANDER_CROP_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHILI_PEPPER_SEEDS = ITEMS.register("chili_pepper_seeds", () -> new ItemNameBlockItem(ModBlocks.CHILI_PEPPER_CROP_BLOCK.get(), new Item.Properties()));

    //crops
    public static final DeferredItem<Item> FENNEL = ITEMS.register("fennel", () -> new ItemNameBlockItem(ModBlocks.FENNEL_CROP_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> CLOVES = ITEMS.register("cloves", () -> new ItemNameBlockItem(ModBlocks.CLOVES_CROP_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> CUMIN = ITEMS.register("cumin", () -> new ItemNameBlockItem(ModBlocks.CUMIN_CROP_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> STAR_ANISE = ITEMS.register("star_anise", () -> new ItemNameBlockItem(ModBlocks.STAR_ANISE_CROP_BLOCK.get(), new Item.Properties()));

    //dried variants
    public static final DeferredItem<Item> DRIED_FENNEL = ITEMS.register("dried_fennel", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRIED_CLOVES = ITEMS.register("dried_cloves", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRIED_CUMIN = ITEMS.register("dried_cumin", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRIED_STAR_ANISE = ITEMS.register("dried_star_anise", () -> new Item(new Item.Properties()));

    //crops (no dried variant)
    public static final DeferredItem<Item> PEPPERCORN = ITEMS.register("peppercorn", () -> new ItemNameBlockItem(ModBlocks.PEPPERCORN_CROP_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> BAY_LEAVES = ITEMS.register("bay_leaves", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CORIANDER = ITEMS.register("coriander", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RED_CHILI = ITEMS.register("red_chili", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREEN_CHILI = ITEMS.register("green_chili", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GARLIC = ITEMS.register("garlic", () -> new ItemNameBlockItem(ModBlocks.GARLIC_CROP_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> GINGER = ITEMS.register("ginger", () -> new ItemNameBlockItem(ModBlocks.GINGER_CROP_BLOCK.get(), new Item.Properties()));

    //tree ingredients
    public static final DeferredItem<Item> CINNAMON = ITEMS.register("cinnamon", () -> new Item((new Item.Properties())));
    public static final DeferredItem<Item> RAW_CASHEW = ITEMS.register("raw_cashew", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CASHEW = ITEMS.register("cashew", () -> new Item(new Item.Properties()));

    //other ingredients
    //finger food
    //feast servings
    //feast blocks
    //sweets

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
