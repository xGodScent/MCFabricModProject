// package
package project.mod.broodjekaas.registry;

// used libraries
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemStack;
import project.mod.broodjekaas.AddedFoodComponents;
import project.mod.broodjekaas.items.super_cheese;


// ModItems class, the register method is called on init (startup)
public class ModItems {
    
    // mod id
    public static final String MODID = "informaticaproject";

    // items
    public static final Item CHEESE = new Item( new Item.Settings() .group( ItemGroup.FOOD ). food(  AddedFoodComponents.CHEESE) .maxCount(  64  ));
    public static final Item TOAST = new Item( new Item.Settings() .group( ItemGroup.FOOD ) .food(  AddedFoodComponents.TOAST  ) .maxCount(  32  ));
	public static final Item BREAD_CHEESE = new Item( new Item.Settings() .group(ItemGroup.FOOD) .maxCount(16) .food(AddedFoodComponents.BREAD_CHEESE));
	public static final Item TOAST_BUTTER = new Item( new Item.Settings() .group(ItemGroup.FOOD) .maxCount(16) .food(AddedFoodComponents.TOAST_BUTTER));
	public static final Item CHEESE_WHEEL = new Item( new Item.Settings() .group( ItemGroup.FOOD ) .food(  AddedFoodComponents.CHEESE_WHEEL  ) .maxCount(  1  ));
	public static final Item SUPER_CHEESE = new super_cheese( new Item.Settings() .group( ItemGroup.FOOD ) .food(  AddedFoodComponents.SUPER_CHEESE  ) .maxCount(  64  ));
	public static final Item BUTTER = new super_cheese( new Item.Settings() .group( ItemGroup.FOOD ) .maxCount(  64  ));

    // new item group (tab in creative menu)
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create( new Identifier( MODID, "modded_items" )).icon(() ->
	new ItemStack( ModItems.CHEESE )).appendItems( stacks -> {
		stacks.add( new ItemStack(  ModItems.CHEESE  ));
		stacks.add( new ItemStack(  ModItems.CHEESE_WHEEL  ));
		stacks.add( new ItemStack(  ModBlocks.CHEESE_BLOCK  ));
		stacks.add( new ItemStack(  ModBlocks.ORE_CHEESE  ));
		stacks.add( new ItemStack(  ModItems.SUPER_CHEESE  ));
		stacks.add( new ItemStack(  ModBlocks.ORE_SUPER_CHEESE  ));
		stacks.add( new ItemStack(  ModItems.TOAST  ));
		stacks.add( new ItemStack(  ModItems.BUTTER  ));
		stacks.add( new ItemStack(  ModItems.TOAST_BUTTER  ));
		stacks.add( new ItemStack(  ModItems.BREAD_CHEESE  ));
		stacks.add( new ItemStack(  ModBlocks.CHEESE_LOG  ));
		stacks.add( new ItemStack(  ModBlocks.CHEESE_LEAVES  ));
	}).build();


    // register method
    public static void registerItems() {

        // loads cheese item
		Registry.register( Registry.ITEM, new Identifier(  MODID, "cheese"  ), CHEESE);

		// toast item
		Registry.register( Registry.ITEM, new Identifier(  MODID, "toast"  ), TOAST);
		
		// broodje kaas
		Registry.register( Registry.ITEM, new Identifier(  MODID, "bread_cheese"  ), BREAD_CHEESE);

		// butter
		Registry.register( Registry.ITEM, new Identifier(  MODID, "butter"  ), BUTTER);

		// toast w/ butter
		Registry.register( Registry.ITEM, new Identifier(  MODID, "toast_butter"  ), TOAST_BUTTER);

		// cheese wheel
		Registry.register( Registry.ITEM, new Identifier(  MODID, "cheese_wheel"  ), CHEESE_WHEEL);

		// super cheese
		Registry.register( Registry.ITEM, new Identifier(  MODID, "super_cheese"  ), SUPER_CHEESE);
        
    }


}
