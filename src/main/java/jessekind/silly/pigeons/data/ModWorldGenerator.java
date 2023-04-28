package jessekind.silly.pigeons.data;

import java.util.concurrent.CompletableFuture;

import jessekind.silly.pigeons.SillyPigeons;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class ModWorldGenerator extends FabricDynamicRegistryProvider{

    public ModWorldGenerator(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(WrapperLookup arg0, Entries arg1) {
        // Here goes future world gen
    }

    @Override
    public String getName() {
        return SillyPigeons.MOD_ID;
    }

    
}
