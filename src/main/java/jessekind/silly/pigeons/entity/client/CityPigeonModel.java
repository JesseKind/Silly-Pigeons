package jessekind.silly.pigeons.entity.client;

import jessekind.silly.pigeons.SillyPigeons;
import jessekind.silly.pigeons.entity.custom.CityPigeonEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CityPigeonModel extends GeoModel<CityPigeonEntity>{

    @Override
    public Identifier getModelResource(CityPigeonEntity animatable) {
        return new Identifier(SillyPigeons.MOD_ID, "geo/city-pigeon-geo.json");
    }

    @Override
    public Identifier getTextureResource(CityPigeonEntity animatable) {
        return new Identifier(SillyPigeons.MOD_ID, "textures/entity/city-pigeon-texture.png");
    }

    @Override
    public Identifier getAnimationResource(CityPigeonEntity animatable) {
        return new Identifier(SillyPigeons.MOD_ID, "animations/city-pigeon-animation.json");
    }
public void setCustomAnimations(CityPigeonEntity animatable, long instanceId, AnimationState<CityPigeonEntity> animationState){
    CoreGeoBone head = getAnimationProcessor().getBone("head");

    if (head != null){
        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
        head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
    }
}

    
}
