// package
package project.mod.broodjekaas.registry;

// used libraries
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import project.mod.broodjekaas.AddedFoodComponents;


// ModItems class, the register method is called on init (startup)
public class ModItems {
    
    // items
    public static final Item CHEESE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(AddedFoodComponents.CHEESE).maxCount(16));
	public static final Item CHEESE_WHEEL = new Item(new Item.Settings().group(ItemGroup.FOOD).maxCount(4));
	public static final Block CHEESE_BLOCK = new Block(FabricBlockSettings.of(Material.SOIL).strength(0.6F, 3.0F).sounds(BlockSoundGroup.CROP).breakByTool(FabricToolTags.SHEARS));

	public static final Item TOAST = new Item(new Item.Settings().group(ItemGroup.FOOD).food(AddedFoodComponents.TOAST).maxCount(32));


    // register method
    public static void registerItems() {

        // loads cheese item
		Registry.register(Registry.ITEM, new Identifier("informaticaproject", "cheese"), CHEESE);
		
		// loads cheese wheel block item (maybe use cake model??)
		Registry.register(Registry.ITEM, new Identifier("informaticaproject", "cheese_wheel"), CHEESE_WHEEL);

		// TODO: maybe re-design cheese_block recipe
		// FIXME: CHEESE_BLOCK LOOT TABLE IS BROKEN! (CHEESE_BLOCK doesn't drop when broken) Please fix... 
		// loads cheese_block item/block
		Registry.register(Registry.BLOCK, new Identifier("informaticaproject", "cheese_block"), CHEESE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("informaticaproject", "cheese_block"), new BlockItem(CHEESE_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));


		// toast item
		Registry.register(Registry.ITEM, new Identifier("informaticaproject", "toast"), TOAST);
		
		// TODO: add recipe for broodje kaas and toast kaas
		// 			-> add textures etc first

        
    }


}
