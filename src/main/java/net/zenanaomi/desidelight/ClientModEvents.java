package net.zenanaomi.desidelight;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.zenanaomi.desidelight.block.client.render.TandoorRenderer;
import net.zenanaomi.desidelight.block.entity.ModBlockEntities;
import net.zenanaomi.desidelight.entity.ModEntities;
import net.zenanaomi.desidelight.entity.client.ModBoatRenderer;
import net.zenanaomi.desidelight.entity.client.ModModelLayers;
import net.zenanaomi.desidelight.util.ModWoodTypes;

@Mod(value = DesiDelight.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = DesiDelight.MOD_ID, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.CINNAMON_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.CINNAMON_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.CASHEW_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.CASHEW_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }


    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        Sheets.addWoodType(ModWoodTypes.CINNAMON);
        Sheets.addWoodType(ModWoodTypes.CASHEW);

        BlockEntityRenderers.register(ModBlockEntities.TANDOOR_BE.get(), TandoorRenderer::new);

        BlockEntityRenderers.register(ModBlockEntities.DESI_DELIGHT_SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.DESI_DELIGHT_HANGING_SIGN.get(), HangingSignRenderer::new);

        EntityRenderers.register(ModEntities.DESI_DELIGHT_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
        EntityRenderers.register(ModEntities.DESI_DELIGHT_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
    }
}