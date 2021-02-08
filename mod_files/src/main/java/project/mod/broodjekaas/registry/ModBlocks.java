// package
package project.mod.broodjekaas.registry;

import javax.tools.DocumentationTool.Location;

// used libraries
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.RegistryOps;
import net.minecraft.util.registry.Registry;



// ModBlocks class, the register method is called on init (startup)
public class ModBlocks {

    // mod id
    public static final String MODID = "informaticaproject";

    // new blocks
	public static final Block CHEESE_BLOCK = new Block( FabricBlockSettings.of(  Material.SOIL  ) 
    .strength(  0.6F,  3.0F  ) .sounds( BlockSoundGroup.CROP )
    .breakByTool( FabricToolTags.PICKAXES, 1 ));

    public static final Block ORE_CHEESE = new Block( FabricBlockSettings.of(  Material.STONE  )
    .strength(  3.0F,  3.0F  ) .sounds( BlockSoundGroup.NETHER_ORE ) .breakByHand(false)
    .breakByTool( FabricToolTags.PICKAXES, 2 ));


    public static final Block CHEESE_WHEEL = new Block( FabricBlockSettings.of(  Material.STONE  )
    .strength(  1.0F,  2.5F  ) .sounds( BlockSoundGroup.BAMBOO ));


    // register method
    public static void registerBlocks() {

		// loads cheese_block item/block
		Registry.register( Registry.BLOCK, new Identifier(  MODID, "cheese_block"  ),  CHEESE_BLOCK );
		Registry.register( Registry.ITEM, new Identifier(  MODID, "cheese_block"  ),  new BlockItem(
            CHEESE_BLOCK, new FabricItemSettings().group(  ItemGroup.BUILDING_BLOCKS  )));

        Registry.register( Registry.BLOCK, new Identifier(  MODID, "ore_cheese"  ), ORE_CHEESE);
        Registry.register( Registry.ITEM, new Identifier(  MODID, "ore_cheese"  ), new BlockItem(
            ORE_CHEESE, new FabricItemSettings().group(  ItemGroup.MATERIALS  )));
        

        Registry.register( Registry.BLOCK, new Identifier(  MODID, "cheese_wheel"  ), CHEESE_WHEEL);
        Registry.register( Registry.ITEM,  new Identifier(  MODID, "cheese_wheel"  ), new BlockItem(
            CHEESE_WHEEL, new FabricItemSettings().group(  ItemGroup.DECORATIONS  ) .maxCount( 1 ) ));


    }

    
}
