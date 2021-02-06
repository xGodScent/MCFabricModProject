// package
package project.mod.broodjekaas;

// used libraries
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

// imports other files
import project.mod.broodjekaas.registry.ModItems;
import project.mod.broodjekaas.registry.ModBlocks;
import project.mod.broodjekaas.registry.ModEntities;
import project.mod.broodjekaas.registry.ModOres;


// mod class init
public class BroodjeKaas implements ModInitializer {

	// mod id
	public static final String MODID = "informaticaproject";

	// new item group (tab in creative menu)
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create( new Identifier( MODID, "other" )).icon(() ->
	new ItemStack( ModItems.CHEESE )).appendItems( stacks -> {
		stacks.add( new ItemStack(  ModItems.CHEESE  ));
		stacks.add( new ItemStack(  ModItems.CHEESE_WHEEL  ));
		stacks.add( new ItemStack(  ModBlocks.CHEESE_BLOCK  ));
		stacks.add( new ItemStack(  ModItems.TOAST  ));
	}).build();


	// runs on startup game
	@Override
	public void onInitialize() {

		ModItems.registerItems();
		ModBlocks.registerBlocks();
		ModEntities.registerEntites();
		ModOres.registerOres();

	}
}
