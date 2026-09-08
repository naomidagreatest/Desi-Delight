package net.zenanaomi.desidelight.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DesiDelight.MOD_ID);

    public static final Supplier<CreativeModeTab> DESI_DELIGHT_TAB =
        CREATIVE_MODE_TABS.register("desi_delight_tab", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(ModBlocks.TANDOOR.get()))
                .title(Component.translatable("creativetab.desi_delight_tab"))
                .displayItems((itemDisplayParameters, pOutput) -> {
                    //cinnamon
                    pOutput.accept(ModBlocks.CINNAMON_LOG);
                    pOutput.accept(ModBlocks.CINNAMON_WOOD);
                    pOutput.accept(ModBlocks.STRIPPED_CINNAMON_LOG);
                    pOutput.accept(ModBlocks.STRIPPED_CINNAMON_WOOD);

                    pOutput.accept(ModBlocks.CINNAMON_PLANKS);
                    pOutput.accept(ModBlocks.CINNAMON_STAIRS);
                    pOutput.accept(ModBlocks.CINNAMON_SLAB);
                    pOutput.accept(ModBlocks.CINNAMON_FENCE);
                    pOutput.accept(ModBlocks.CINNAMON_FENCE_GATE);
                    pOutput.accept(ModBlocks.CINNAMON_DOOR);
                    pOutput.accept(ModBlocks.CINNAMON_TRAPDOOR);
                    pOutput.accept(ModBlocks.CINNAMON_PRESSURE_PLATE);
                    pOutput.accept(ModBlocks.CINNAMON_BUTTON);

                    pOutput.accept(ModBlocks.CINNAMON_LEAVES);
                    pOutput.accept(ModBlocks.CINNAMON_SAPLING);

                    pOutput.accept(ModItems.CINNAMON_SIGN);
                    pOutput.accept(ModItems.CINNAMON_HANGING_SIGN);

                    pOutput.accept(ModItems.CINNAMON_BOAT);
                    pOutput.accept(ModItems.CINNAMON_CHEST_BOAT);

                    pOutput.accept(ModBlocks.CINNAMON_CABINET);

                    //cashew
                    pOutput.accept(ModBlocks.CASHEW_LOG);
                    pOutput.accept(ModBlocks.CASHEW_WOOD);
                    pOutput.accept(ModBlocks.STRIPPED_CASHEW_LOG);
                    pOutput.accept(ModBlocks.STRIPPED_CASHEW_WOOD);

                    pOutput.accept(ModBlocks.CASHEW_PLANKS);
                    pOutput.accept(ModBlocks.CASHEW_STAIRS);
                    pOutput.accept(ModBlocks.CASHEW_SLAB);
                    pOutput.accept(ModBlocks.CASHEW_FENCE);
                    pOutput.accept(ModBlocks.CASHEW_FENCE_GATE);
                    pOutput.accept(ModBlocks.CASHEW_DOOR);
                    pOutput.accept(ModBlocks.CASHEW_TRAPDOOR);
                    pOutput.accept(ModBlocks.CASHEW_PRESSURE_PLATE);
                    pOutput.accept(ModBlocks.CASHEW_BUTTON);

                    pOutput.accept(ModBlocks.CASHEW_LEAVES);
                    pOutput.accept(ModBlocks.CASHEW_LEAVES_GROWN);
                    pOutput.accept(ModBlocks.CASHEW_SAPLING);

                    pOutput.accept(ModItems.CASHEW_SIGN);
                    pOutput.accept(ModItems.CASHEW_HANGING_SIGN);

                    pOutput.accept(ModItems.CASHEW_BOAT);
                    pOutput.accept(ModItems.CASHEW_CHEST_BOAT);

                    pOutput.accept(ModBlocks.CASHEW_CABINET);

                    //decor and other blocks
                    pOutput.accept(ModBlocks.HANDI);

                    //function blocks
                    pOutput.accept(ModBlocks.TANDOOR);

                    //wild crops
                    pOutput.accept(ModItems.WILD_FENNEL);
                    pOutput.accept(ModItems.WILD_CLOVES);
                    pOutput.accept(ModItems.WILD_CUMIN);
                    pOutput.accept(ModItems.WILD_STAR_ANISE);
                    pOutput.accept(ModItems.WILD_PEPPERCORN);
                    pOutput.accept(ModItems.WILD_CORIANDER);
                    pOutput.accept(ModItems.WILD_CHILI_PEPPER);
                    pOutput.accept(ModItems.WILD_GARLIC);
                    pOutput.accept(ModItems.WILD_GINGER);

                    //seeds
                    pOutput.accept(ModItems.TEJPAT_SEEDS);
                    pOutput.accept(ModItems.CORIANDER_SEEDS);
                    pOutput.accept(ModItems.CHILI_PEPPER_SEEDS);

                    //crops with dried variants
                    pOutput.accept(ModItems.FENNEL);
                    pOutput.accept(ModItems.CLOVES);
                    pOutput.accept(ModItems.CUMIN);
                    pOutput.accept(ModItems.STAR_ANISE);
                    pOutput.accept(ModItems.DRIED_FENNEL);
                    pOutput.accept(ModItems.DRIED_CLOVES);
                    pOutput.accept(ModItems.DRIED_CUMIN);
                    pOutput.accept(ModItems.DRIED_STAR_ANISE);

                    //other crops
                    pOutput.accept(ModItems.PEPPERCORN);
                    pOutput.accept(ModItems.BAY_LEAVES);
                    pOutput.accept(ModItems.CORIANDER);
                    pOutput.accept(ModItems.RED_CHILI);
                    pOutput.accept(ModItems.GREEN_CHILI);
                    pOutput.accept(ModItems.GARLIC);
                    pOutput.accept(ModItems.GINGER);

                    //tree ingredients
                    pOutput.accept(ModItems.CINNAMON);
                    pOutput.accept(ModItems.RAW_CASHEW);
                    pOutput.accept(ModItems.CASHEW);

                    //storage blocks
                    pOutput.accept(ModBlocks.FENNEL_BAG);
                    pOutput.accept(ModBlocks.CLOVES_BAG);
                    pOutput.accept(ModBlocks.CUMIN_BAG);
                    pOutput.accept(ModBlocks.STAR_ANISE_BAG);

                    pOutput.accept(ModBlocks.DRIED_FENNEL_BAG);
                    pOutput.accept(ModBlocks.DRIED_CLOVES_BAG);
                    pOutput.accept(ModBlocks.DRIED_CUMIN_BAG);
                    pOutput.accept(ModBlocks.DRIED_STAR_ANISE_BAG);

                    pOutput.accept(ModBlocks.PEPPERCORN_BAG);
                    pOutput.accept(ModBlocks.TEJPATTA_BAG);
                    pOutput.accept(ModBlocks.CORIANDER_BAG);
                    pOutput.accept(ModBlocks.RED_CHILI_CRATE);
                    pOutput.accept(ModBlocks.GREEN_CHILI_CRATE);
                    pOutput.accept(ModBlocks.GARLIC_CRATE);
                    pOutput.accept(ModBlocks.GINGER_CRATE);

                    pOutput.accept(ModBlocks.CINNAMON_BAG);
                    pOutput.accept(ModBlocks.RAW_CASHEW_CRATE);
                    pOutput.accept(ModBlocks.CASHEW_CRATE);

                    //other ingredients
//                    pOutput.accept(ModItems.BUTTER);
//                    pOutput.accept(ModItems.CASHEW_BUTTER);
//                    pOutput.accept(ModItems.GARAM_MASALA);
//                    pOutput.accept(ModItems.TANDOORI_MASALA);
//
//                    //small foods
//                    pOutput.accept(ModItems.NAAN);
//                    pOutput.accept(ModItems.ALOO_PARATHA);
//                    pOutput.accept(ModItems.TANDOORI_CHICKEN);
//
//                    //meals and feasts
//                    pOutput.accept(ModItems.BUTTER_CHICKEN);
//                    pOutput.accept(ModItems.BUTTER_CHICKEN_BLOCK);
//                    pOutput.accept(ModItems.BIRYANI);
//                    pOutput.accept(ModItems.BIRYANI_BLOCK);
//
//                    //desserts
//                    pOutput.accept(ModItems.DAHI);
//                    pOutput.accept(ModItems.MISHTI_DOI);

                }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
