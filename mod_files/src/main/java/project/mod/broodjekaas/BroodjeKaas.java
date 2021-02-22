// package
package project.mod.broodjekaas;

// used libraries
import net.fabricmc.api.ModInitializer;

// imports other files
import project.mod.broodjekaas.registry.ModItems;
import project.mod.broodjekaas.registry.ModBlocks;
import project.mod.broodjekaas.registry.ModEntities;
import project.mod.broodjekaas.registry.ModGenTypes;
import project.mod.broodjekaas.registry.ModOres;
import project.mod.broodjekaas.registry.ModStructures;


// mod class init
public class BroodjeKaas implements ModInitializer {

	// runs on startup game
	@Override
	public void onInitialize() {

		ModItems.registerItems();
		ModBlocks.registerBlocks();
		
		ModGenTypes.registerGens();
		ModOres.registerOres();
		ModStructures.registerStructures();

		ModEntities.registerEntites();

	}
}
