package jessekind.silly.pigeons.item;

import jessekind.silly.pigeons.SillyPigeons;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup SILLY_PIGEONS;

    public static void registerItemGroups() {
        SILLY_PIGEONS = FabricItemGroup.builder(new Identifier(SillyPigeons.MOD_ID, "silly_pigeons"))
            .displayName(Text.translatable("itemgroup.silly_pigeons"))
            .icon(() -> new ItemStack(ModItems.PIGEON_FEATHER)).build();
    }
}
