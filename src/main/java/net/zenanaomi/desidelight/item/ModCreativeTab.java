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
                    .icon(() -> new ItemStack(ModItems.BUTTER_CHICKEN.get()))
                    .title(Component.translatable("creativetab.desi_delight_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.TANDOOR.get());
                        pOutput.accept(ModItems.NAAN.get());
                        pOutput.accept(ModItems.TANDOORI_CHICKEN.get());
                        pOutput.accept(ModItems.BUTTER_CHICKEN.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {CREATIVE_MODE_TABS.register(eventBus);}
}
