package jessekind.silly.pigeons.world.gen;

import jessekind.silly.pigeons.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;

import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.BIRCH_FOREST), SpawnGroup.CREATURE,
            ModEntities.CITY_PIGEON, 35, 1, 3);

        SpawnRestriction.register(ModEntities.CITY_PIGEON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, AnimalEntity::isValidNaturalSpawn);
    }
}
