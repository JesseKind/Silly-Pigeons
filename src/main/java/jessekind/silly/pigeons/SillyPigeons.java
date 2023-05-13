package jessekind.silly.pigeons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jessekind.silly.pigeons.block.ModBlocks;
import jessekind.silly.pigeons.entity.ModEntities;
import jessekind.silly.pigeons.entity.custom.CityPigeonEntity;
import jessekind.silly.pigeons.item.ModItemGroup;
import jessekind.silly.pigeons.item.ModItems;

public class SillyPigeons implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static String MOD_ID = "silly-pigeons";	
	public static final Logger LOGGER = LoggerFactory.getLogger("silly-pigeons");

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		FabricDefaultAttributeRegistry.register(ModEntities.CITY_PIGEON, CityPigeonEntity.setAttributes());
	}
	
}