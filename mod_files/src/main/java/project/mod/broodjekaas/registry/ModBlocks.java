// package
package project.mod.broodjekaas.registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
// used libraries
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import project.mod.broodjekaas.blocks.cheese_block;
import project.mod.broodjekaas.blocks.cheese_leaves;
import project.mod.broodjekaas.blocks.cheese_wheel;



// ModBlocks class, the register method is called on init (startup)
public class ModBlocks {

    // mod id
    public static final String MODID = "informaticaproject";

    // new blocks
	public static final Block CHEESE_BLOCK = new cheese_block( FabricBlockSettings.of(  Material.SOIL  ) 
    .strength(  0.6F,  3.0F  ) .sounds( BlockSoundGroup.CROP )
    .breakByTool( FabricToolTags.PICKAXES, 1 ));

    public static final Block ORE_CHEESE = new Block( FabricBlockSettings.of(  Material.STONE  )
    .strength(  3.0F,  3.0F  ) .sounds( BlockSoundGroup.NETHER_ORE ) .breakByHand(false)
    .breakByTool( FabricToolTags.PICKAXES, 2 ));

    public static final Block ORE_SUPER_CHEESE = new Block( FabricBlockSettings.of(  Material.STONE  )
    .strength(  10.0F,  6.0F  ) .sounds( BlockSoundGroup.ANCIENT_DEBRIS ) .breakByHand(false)
    .breakByTool( FabricToolTags.PICKAXES, 3 ));

    public static final Block CHEESE_LOG = new Block( FabricBlockSettings.of(  Material.WOOD  )
    .strength(  2.0F,  2.0F  ) .sounds( BlockSoundGroup.WOOD ) .breakByHand(true)
    .breakByTool( FabricToolTags.AXES, 1 ));



    public static final Block CHEESE_WHEEL = new cheese_wheel( FabricBlockSettings.of(  Material.STONE  )
    .strength(  1.0F,  2.5F  ) .sounds( BlockSoundGroup.BAMBOO ));


    public static final Block CHEESE_LEAVES = new cheese_leaves( FabricBlockSettings.of(  Material.LEAVES  )
    .strength(  0.2F,  0.2F  ) .sounds( BlockSoundGroup.LILY_PAD ) .breakByHand(true)
    .breakByTool( FabricToolTags.SHEARS, 1 ));


    // register method
    public static void registerBlocks() {

		// cheese block
		Registry.register( Registry.BLOCK, new Identifier(  MODID, "cheese_block"  ),  CHEESE_BLOCK );
		Registry.register( Registry.ITEM, new Identifier(  MODID, "cheese_block"  ),  new BlockItem(
            CHEESE_BLOCK, new FabricItemSettings().group(  ItemGroup.BUILDING_BLOCKS  )));


        // cheese ores
        Registry.register( Registry.BLOCK, new Identifier(  MODID, "ore_cheese"  ), ORE_CHEESE);
        Registry.register( Registry.ITEM, new Identifier(  MODID, "ore_cheese"  ), new BlockItem(
            ORE_CHEESE, new FabricItemSettings().group(  ItemGroup.MATERIALS  )));

        Registry.register( Registry.BLOCK, new Identifier(  MODID, "ore_super_cheese"  ), ORE_SUPER_CHEESE);
        Registry.register( Registry.ITEM,  new Identifier(  MODID, "ore_super_cheese"  ), new BlockItem(
            ORE_SUPER_CHEESE, new FabricItemSettings().group(  ItemGroup.MATERIALS  ))); 
        

        // cheese wheel block
        Registry.register( Registry.BLOCK, new Identifier(  MODID, "cheese_wheel"  ), CHEESE_WHEEL);
        Registry.register( Registry.ITEM,  new Identifier(  MODID, "cheese_wheel"  ), new BlockItem(
            CHEESE_WHEEL, new FabricItemSettings().group(  ItemGroup.DECORATIONS  ) .maxCount( 1 ) ));


        // cheese log
        Registry.register( Registry.BLOCK, new Identifier(  MODID, "cheese_log"  ), CHEESE_LOG);
        Registry.register( Registry.ITEM,  new Identifier(  MODID, "cheese_log"  ), new BlockItem(
            CHEESE_LOG, new FabricItemSettings().group(  ItemGroup.MATERIALS  )));

        // cheese leaves
        Registry.register( Registry.BLOCK, new Identifier(  MODID, "cheese_leaves"  ), CHEESE_LEAVES);
        Registry.register( Registry.ITEM,  new Identifier(  MODID, "cheese_leaves"  ), new BlockItem(
            CHEESE_LEAVES, new FabricItemSettings().group(  ItemGroup.MATERIALS  )));


        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEESE_WHEEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEESE_LEAVES, RenderLayer.getCutout());

            //TODO: add super cheese item + features -> (maybe strength?)
            //TODO: add smelting recipe for super cheese


    }

    
}
