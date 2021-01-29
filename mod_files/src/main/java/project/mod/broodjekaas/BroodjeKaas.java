// package
package project.mod.broodjekaas;

// used libraries
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


// mod class init
public class BroodjeKaas implements ModInitializer {

	// new/modded items
	public static final Item CHEESE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(AddedFoodComponents.CHEESE));


	// runs on startup game (loads in items)
	@Override
	public void onInitialize() {
		
		Registry.register(Registry.ITEM, new Identifier("informaticaproject", "cheese"), CHEESE);
		
	}
}
