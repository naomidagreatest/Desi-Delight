package net.zenanaomi.desidelight;

import net.zenanaomi.desidelight.block.ModBlocks;
import net.zenanaomi.desidelight.block.entity.ModBlockEntities;
import net.zenanaomi.desidelight.effect.ModEffects;
import net.zenanaomi.desidelight.entity.ModEntities;
import net.zenanaomi.desidelight.item.ModCreativeTab;
import net.zenanaomi.desidelight.item.ModItems;
import net.zenanaomi.desidelight.recipe.ModRecipes;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(DesiDelight.MOD_ID)
public class DesiDelight {
    public static final String MOD_ID = "zenadesidelight";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DesiDelight(IEventBus modEventBus, ModContainer modContainer) {

        ModCreativeTab.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModEffects.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
