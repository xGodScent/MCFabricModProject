// package
package project.mod.broodjekaas;

// used libraries
import net.fabricmc.api.ModInitializer;
import project.mod.broodjekaas.registry.ModItems;


// mod class init
public class BroodjeKaas implements ModInitializer {


	// runs on startup game
	@Override
	public void onInitialize() {

		ModItems.registerItems();
		ModEntities.registerEntites();

	}
}
