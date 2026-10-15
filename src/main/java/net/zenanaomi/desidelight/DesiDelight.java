package net.zenanaomi.desidelight;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zenanaomi.desidelight.block.ModBlocks;
import net.zenanaomi.desidelight.block.client.render.TandoorRenderer;
import net.zenanaomi.desidelight.block.entity.ModBlockEntities;
import net.zenanaomi.desidelight.effect.ModEffects;
import net.zenanaomi.desidelight.entity.ModEntities;
import net.zenanaomi.desidelight.entity.client.ModBoatRenderer;
import net.zenanaomi.desidelight.item.ModCreativeTab;
import net.zenanaomi.desidelight.item.ModItems;
import net.zenanaomi.desidelight.recipe.ModRecipes;
import net.zenanaomi.desidelight.util.ModWoodTypes;
import org.slf4j.Logger;

@Mod(DesiDelight.MOD_ID)
public class DesiDelight
{
    public static final String MOD_ID = "zenadesidelight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DesiDelight(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        ModCreativeTab.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModEffects.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            registerCompostables();
        });
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            Sheets.addWoodType(ModWoodTypes.CINNAMON);
            Sheets.addWoodType(ModWoodTypes.CASHEW);

            //BlockEntityRenderers.register(ModBlockEntities.TANDOOR_BE.get(), TandoorRenderer::new);
            //BlockEntityRenderers.register(ModBlockEntities.DESI_DELIGHT_SIGN.get(), SignRenderer::new);
            //BlockEntityRenderers.register(ModBlockEntities.DESI_DELIGHT_HANGING_SIGN.get(), HangingSignRenderer::new);

            EntityRenderers.register(ModEntities.DESI_DELIGHT_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.DESI_DELIGHT_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));

        }
    }

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_FENNEL.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_CLOVES.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_CUMIN.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_STAR_ANISE.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_PEPPERCORN.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_CORIANDER.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_CHILI_PEPPER.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_GARLIC.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.WILD_GINGER.get(), 0.65f);

        ComposterBlock.COMPOSTABLES.put(ModItems.TEJPAT_SEEDS.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CORIANDER_SEEDS.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CHILI_PEPPER_SEEDS.get(), 0.3f);

        ComposterBlock.COMPOSTABLES.put(ModItems.FENNEL.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CLOVES.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CUMIN.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.STAR_ANISE.get(), 0.65f);

        ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_FENNEL.get(), 0.75f);
        ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_CLOVES.get(), 0.75f);
        ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_CUMIN.get(), 0.75f);
        ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_STAR_ANISE.get(), 0.75f);

        ComposterBlock.COMPOSTABLES.put(ModItems.PEPPERCORN.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CORIANDER.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.RED_CHILI.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.GREEN_CHILI.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.GARLIC.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.GINGER.get(), 0.65f);

        ComposterBlock.COMPOSTABLES.put(ModItems.CINNAMON.get(), 0.75f);
        ComposterBlock.COMPOSTABLES.put(ModItems.RAW_CASHEW.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CASHEW.get(), 0.75f);

        ComposterBlock.COMPOSTABLES.put(ModItems.NAAN.get(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(ModItems.ALOO_PARATHA.get(), 0.85f);
    }
}
