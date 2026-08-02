package net.zenanaomi.desidelight.block.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.zenanaomi.desidelight.block.entity.TandoorBlockEntity;

public class TandoorRenderer implements BlockEntityRenderer<TandoorBlockEntity> {

    public TandoorRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(TandoorBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        for (int i = 0; i < 4; i++) {
            ItemStack stack = pBlockEntity.getItem(i);
            if (!stack.isEmpty()) {
                pPoseStack.pushPose();

                pPoseStack.translate(0.5f, 0.60f, 0.5f);
                pPoseStack.mulPose(Axis.YP.rotationDegrees(i * 90.0f));
                pPoseStack.translate(0.0f, 0.0f, 0.35f);
                pPoseStack.scale(0.5f, 0.5f, 0.5f);

                Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, pBlockEntity.getLevel(), 0);
                pPoseStack.popPose();
            }
        }
    }
}
