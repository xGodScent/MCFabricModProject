// package
package project.mod.broodjekaas.registry;

// used libraries
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import project.mod.broodjekaas.AddedFoodComponents;


// ModItems class, the register method is called on init (startup)
public class ModItems {
    
    // mod id
    public static final String MODID = "informaticaproject";

    // items
    public static final Item CHEESE = new Item( new Item.Settings() .group( ItemGroup.FOOD ). food(  AddedFoodComponents.CHEESE) .maxCount(  16  ));
	public static final Item CHEESE_WHEEL = new Item( new Item.Settings().group( ItemGroup.FOOD ) .maxCount(  4  ));

	public static final Item TOAST = new Item( new Item.Settings() .group( ItemGroup.FOOD ) .food(  AddedFoodComponents.TOAST  ) .maxCount(  32  ));


    // register method
    public static void registerItems() {

        // loads cheese item
		Registry.register( Registry.ITEM, new Identifier(  MODID, "cheese"  ), CHEESE);
		
		// loads cheese wheel block item (maybe use cake model??)
		Registry.register( Registry.ITEM, new Identifier(  MODID, "cheese_wheel"  ), CHEESE_WHEEL);


		// toast item
		Registry.register( Registry.ITEM, new Identifier(  MODID, "toast"  ), TOAST);
		
		// TODO: add recipe for broodje kaas and toast kaas
		// 			-> add textures etc first

        
    }


}
