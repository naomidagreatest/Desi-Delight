package net.zenanaomi.desidelight;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.zenanaomi.desidelight.block.client.render.TandoorRenderer;
import net.zenanaomi.desidelight.block.entity.ModBlockEntities;

@Mod(value = DesiDelight.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = DesiDelight.MOD_ID, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        BlockEntityRenderers.register(ModBlockEntities.TANDOOR_BE.get(), TandoorRenderer::new);
    }
}