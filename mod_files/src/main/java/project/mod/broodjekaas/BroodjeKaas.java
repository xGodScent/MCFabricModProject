// package
package project.mod.broodjekaas;

// used libraries
import net.fabricmc.api.ModInitializer;

// imports other files
import project.mod.broodjekaas.registry.ModItems;
import project.mod.broodjekaas.registry.ModBlocks;
import project.mod.broodjekaas.registry.ModEntities;
import project.mod.broodjekaas.registry.ModOres;
import project.mod.broodjekaas.registry.ModWorldGeneration;


// mod class init
public class BroodjeKaas implements ModInitializer {

	// runs on startup game
	@Override
	public void onInitialize() {

		ModItems.registerItems();
		ModBlocks.registerBlocks();
		ModEntities.registerEntites();
		ModOres.registerOres();

		// ModWorldGeneration.registerGen();
		// TODO: FIX world generation, we need to implement acces widener, see fabric-wiki


	}
}
