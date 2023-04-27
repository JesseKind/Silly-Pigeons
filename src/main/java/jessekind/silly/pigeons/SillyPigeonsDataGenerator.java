// package jessekind.silly.pigeons;


// import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
// import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

// public class TutorialModDataGenerator implements DataGeneratorEntrypoint {
// 	@Override
// 	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
// 		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

// 		pack.addProvider(ModLootTableGenerator::new);
// 		pack.addProvider(ModRecipeGenerator::new);
// 		pack.addProvider(ModModelProvider::new);
// 	}
// }