package jessekind.silly.pigeons.item;

import jessekind.silly.pigeons.SillyPigeons;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PIGEON_FEATHER = registerItem("pigeon_feather", new Item(new FabricItemSettings()));
    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SillyPigeons.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, PIGEON_FEATHER);
        addToItemGroup(ModItemGroup.SILLY_PIGEONS, PIGEON_FEATHER);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        SillyPigeons.LOGGER.info("Registering Mod Items for" + SillyPigeons.MOD_ID);
    }

}
