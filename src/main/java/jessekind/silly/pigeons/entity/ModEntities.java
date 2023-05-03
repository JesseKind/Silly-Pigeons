package jessekind.silly.pigeons.entity;

import jessekind.silly.pigeons.SillyPigeons;
import jessekind.silly.pigeons.entity.custom.CityPigeonEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

// This class is used to register the entity types for the mod
public class ModEntities {

    // Makes a new entity type for the City Pigeon, edit hitbox size here
    public static final EntityType<CityPigeonEntity> CITY_PIGEON = Registry.register(Registries.ENTITY_TYPE, new Identifier(SillyPigeons.MOD_ID,"city_pigeon"),
    FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CityPigeonEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.5f)).build());
}
