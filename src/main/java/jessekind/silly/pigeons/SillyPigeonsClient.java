package jessekind.silly.pigeons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import jessekind.silly.pigeons.entity.ModEntities;
import jessekind.silly.pigeons.entity.client.CityPigeonRenderer;

public class SillyPigeonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_MAPLE_LEAVES, RenderLayer.getCutout());
        // BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_MAPLE_SAPLING, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.CITY_PIGEON, CityPigeonRenderer::new);
        EntityRendererRegistry.register(ModEntities.PIGEON_EGG, FlyingItemEntityRenderer::new);
    }
}