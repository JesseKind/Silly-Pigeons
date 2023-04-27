package jessekind.silly.pigeons.entity.client;

import jessekind.silly.pigeons.SillyPigeons;
import jessekind.silly.pigeons.entity.custom.CityPigeonEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CityPigeonRenderer extends GeoEntityRenderer<CityPigeonEntity> {
    public CityPigeonRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CityPigeonModel());
    }

    @Override
    public Identifier getTextureLocation(CityPigeonEntity animatable) {
        return new Identifier(SillyPigeons.MOD_ID, "textures/entity/city-pigeon-texture.png");
    }

    @Override
    public void render(CityPigeonEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
            VertexConsumerProvider bufferSource, int packedLight) { 

            if(entity.isBaby()){
                poseStack.scale(0.8F, 0.8F, 0.8F);
            }   
            else{
                poseStack.scale(1.2F, 1.2F, 1.2F);
            }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
    
}

