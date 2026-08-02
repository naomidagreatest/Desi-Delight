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

                    //cashew

                    //decor and other blocks

                    //function blocks
                    pOutput.accept(ModBlocks.TANDOOR);

                    //wild crops

                    //seeds

                    //crops with dried variants
                    pOutput.accept(ModItems.FENNEL);

                    //other crops

                    //tree ingredients

                    //storage blocks

                    //other ingredients

                    //small foods

                    //meals and feasts

                    //desserts

                }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
