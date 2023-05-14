package jessekind.silly.pigeons.block;

import jessekind.silly.pigeons.SillyPigeons;
import jessekind.silly.pigeons.block.custom.PigeonNest;
import jessekind.silly.pigeons.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PIGEON_NEST = registerBlock("pigeon_nest",
        new PigeonNest(FabricBlockSettings.of(Material.LEAVES).strength(0.2f).sounds(BlockSoundGroup.GRASS)), ModItemGroup.SILLY_PIGEONS);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(SillyPigeons.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        Item item = Registry.register(Registries.ITEM, new Identifier(SillyPigeons.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks(){
        SillyPigeons.LOGGER.info("Registering mod blocks for " + SillyPigeons.MOD_ID);

    }
}