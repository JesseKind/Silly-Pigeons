package jessekind.silly.pigeons.item;

import jessekind.silly.pigeons.SillyPigeons;
import jessekind.silly.pigeons.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PIGEON_FEATHER = registerItem("pigeon_feather",
        new Item(new FabricItemSettings()));
    public static final Item PIGEON_EGG = registerItem("pigeon_egg",
        new Item(new FabricItemSettings()));
    public static final Item CITY_PIGEON_SPAWN_EGG = registerItem("city_pigeon_spawn_egg",
        new SpawnEggItem(ModEntities.CITY_PIGEON, 0xffffff, 0x6a608c, new FabricItemSettings()));

        
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SillyPigeons.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, PIGEON_FEATHER);
        addToItemGroup(ModItemGroup.SILLY_PIGEONS, PIGEON_FEATHER);

        addToItemGroup(ItemGroups.INGREDIENTS, PIGEON_EGG);
        addToItemGroup(ModItemGroup.SILLY_PIGEONS, PIGEON_EGG);

        addToItemGroup(ItemGroups.SPAWN_EGGS, CITY_PIGEON_SPAWN_EGG);
        addToItemGroup(ModItemGroup.SILLY_PIGEONS, CITY_PIGEON_SPAWN_EGG);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        SillyPigeons.LOGGER.info("Registering Mod Items for" + SillyPigeons.MOD_ID);
        addItemsToItemGroup();
    }

}
