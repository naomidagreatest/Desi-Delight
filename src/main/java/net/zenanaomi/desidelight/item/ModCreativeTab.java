package net.zenanaomi.desidelight.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.block.ModBlocks;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DesiDelight.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DESI_DELIGHT_TAB =
            CREATIVE_MODE_TABS.register("desi_delight_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.TANDOOR.get()))
                    .title(Component.translatable("creativetab.desi_delight_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.CINNAMON_LOG.get());
                        pOutput.accept(ModBlocks.CINNAMON_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_CINNAMON_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_CINNAMON_WOOD.get());

                        pOutput.accept(ModBlocks.CINNAMON_PLANKS.get());
                        pOutput.accept(ModBlocks.CINNAMON_STAIRS.get());
                        pOutput.accept(ModBlocks.CINNAMON_SLAB.get());
                        pOutput.accept(ModBlocks.CINNAMON_FENCE.get());
                        pOutput.accept(ModBlocks.CINNAMON_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.CINNAMON_DOOR.get());
                        pOutput.accept(ModBlocks.CINNAMON_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.CINNAMON_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.CINNAMON_BUTTON.get());

                        pOutput.accept(ModBlocks.CINNAMON_LEAVES.get());
                        pOutput.accept(ModBlocks.CINNAMON_SAPLING.get());

                        pOutput.accept(ModItems.CINNAMON_SIGN.get());
                        pOutput.accept(ModItems.CINNAMON_HANGING_SIGN.get());

                        pOutput.accept(ModItems.CINNAMON_BOAT.get());
                        pOutput.accept(ModItems.CINNAMON_CHEST_BOAT.get());

                        pOutput.accept(ModBlocks.CINNAMON_CABINET.get());

                        pOutput.accept(ModBlocks.CASHEW_LOG.get());
                        pOutput.accept(ModBlocks.CASHEW_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_CASHEW_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_CASHEW_WOOD.get());

                        pOutput.accept(ModBlocks.CASHEW_PLANKS.get());
                        pOutput.accept(ModBlocks.CASHEW_STAIRS.get());
                        pOutput.accept(ModBlocks.CASHEW_SLAB.get());
                        pOutput.accept(ModBlocks.CASHEW_FENCE.get());
                        pOutput.accept(ModBlocks.CASHEW_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.CASHEW_DOOR.get());
                        pOutput.accept(ModBlocks.CASHEW_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.CASHEW_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.CASHEW_BUTTON.get());

                        pOutput.accept(ModBlocks.CASHEW_LEAVES.get());
                        pOutput.accept(ModBlocks.CASHEW_LEAVES_GROWN.get());
                        pOutput.accept(ModBlocks.CASHEW_SAPLING.get());

                        pOutput.accept(ModItems.CASHEW_SIGN.get());
                        pOutput.accept(ModItems.CASHEW_HANGING_SIGN.get());

                        pOutput.accept(ModItems.CASHEW_BOAT.get());
                        pOutput.accept(ModItems.CASHEW_CHEST_BOAT.get());

                        pOutput.accept(ModBlocks.CASHEW_CABINET.get());

                        pOutput.accept(ModBlocks.HANDI.get());

                        pOutput.accept(ModBlocks.TANDOOR.get());

                        pOutput.accept(ModItems.FENNEL.get());
                        pOutput.accept(ModItems.CLOVES.get());
                        pOutput.accept(ModItems.CUMIN.get());
                        pOutput.accept(ModItems.STAR_ANISE.get());
                        pOutput.accept(ModItems.DRIED_FENNEL.get());
                        pOutput.accept(ModItems.DRIED_CLOVES.get());
                        pOutput.accept(ModItems.DRIED_CUMIN.get());
                        pOutput.accept(ModItems.DRIED_STAR_ANISE.get());

                        pOutput.accept(ModItems.PEPPERCORN.get());
                        pOutput.accept(ModItems.BAY_LEAVES.get());
                        pOutput.accept(ModItems.CORIANDER.get());
                        pOutput.accept(ModItems.RED_CHILI.get());
                        pOutput.accept(ModItems.GREEN_CHILI.get());
                        pOutput.accept(ModItems.GARLIC.get());
                        pOutput.accept(ModItems.GINGER.get());

                        pOutput.accept(ModItems.CINNAMON.get());
                        pOutput.accept(ModItems.RAW_CASHEW.get());
                        pOutput.accept(ModItems.CASHEW.get());

                        pOutput.accept(ModItems.BUTTER.get());
                        pOutput.accept(ModItems.CASHEW_BUTTER.get());
                        pOutput.accept(ModItems.GARAM_MASALA.get());
                        pOutput.accept(ModItems.TANDOORI_MASALA.get());

                        pOutput.accept(ModItems.NAAN.get());
                        pOutput.accept(ModItems.ALOO_PARATHA.get());
                        pOutput.accept(ModItems.TANDOORI_CHICKEN.get());

                        pOutput.accept(ModItems.BUTTER_CHICKEN.get());
                        pOutput.accept(ModBlocks.BUTTER_CHICKEN_BLOCK.get());
                        pOutput.accept(ModItems.BIRYANI.get());
                        pOutput.accept(ModBlocks.BIRYANI_BLOCK.get());


                        pOutput.accept(ModItems.DAHI.get());
                        pOutput.accept(ModItems.MISHTI_DOI.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {CREATIVE_MODE_TABS.register(eventBus);}
}
