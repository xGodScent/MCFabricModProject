// package
package project.mod.broodjekaas;

// used libraries
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


// mod class init
public class BroodjeKaas implements ModInitializer {

	// new/modded items
	public static final Item CHEESE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(AddedFoodComponents.CHEESE).maxCount(16));
	public static final Item CHEESE_WHEEL = new Item(new Item.Settings().group(ItemGroup.FOOD).maxCount(4));
	public static final Block CHEESE_BLOCK = new Block(
			net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.of(Material.SOIL).strength(0.6F, 3.0F)
					.sounds(BlockSoundGroup.GRAVEL).breakByTool(FabricToolTags.SHEARS));

					
	// runs on startup game (loads in items)
	@Override
	public void onInitialize() {

		// loads cheese item
		Registry.register(Registry.ITEM, new Identifier("informaticaproject", "cheese"), CHEESE);
		
		// loads cheese wheel block item (maybe use cake model??)
		Registry.register(Registry.ITEM, new Identifier("informaticaproject", "cheese_wheel"), CHEESE_WHEEL);

		// loads cheese block
		Registry.register(Registry.BLOCK, new Identifier("informaticaproject", "cheese_block"), CHEESE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("informaticaproject"), new BlockItem(CHEESE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		// FIXME: cheese_block item form doesnt work, it'll show default texture instead of the assigned block texture. It might be line 23.
		// I dont know what causes this strange behaviour, too bad!

	}
}
