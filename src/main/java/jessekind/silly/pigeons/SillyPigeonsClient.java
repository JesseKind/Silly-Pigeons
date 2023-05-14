package jessekind.silly.pigeons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import jessekind.silly.pigeons.block.ModBlocks;
import jessekind.silly.pigeons.entity.ModEntities;
import jessekind.silly.pigeons.entity.client.CityPigeonRenderer;

public class SillyPigeonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PIGEON_NEST, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.CITY_PIGEON, CityPigeonRenderer::new);
        EntityRendererRegistry.register(ModEntities.PIGEON_EGG, FlyingItemEntityRenderer::new);
    }
}