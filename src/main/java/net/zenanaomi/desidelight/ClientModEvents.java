package net.zenanaomi.desidelight;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.zenanaomi.desidelight.block.client.render.TandoorRenderer;
import net.zenanaomi.desidelight.block.entity.ModBlockEntities;
import net.zenanaomi.desidelight.util.ModWoodTypes;

@Mod(value = DesiDelight.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = DesiDelight.MOD_ID, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        Sheets.addWoodType(ModWoodTypes.CINNAMON);
        Sheets.addWoodType(ModWoodTypes.CASHEW);

        BlockEntityRenderers.register(ModBlockEntities.TANDOOR_BE.get(), TandoorRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.DESI_DELIGHT_SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.DESI_DELIGHT_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}