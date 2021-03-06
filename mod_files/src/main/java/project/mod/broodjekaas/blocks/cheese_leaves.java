package project.mod.broodjekaas.blocks;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import project.mod.broodjekaas.registry.ModBlocks;

public class cheese_leaves extends Block {

    public cheese_leaves(Settings settings) {
        // super(Settings.of(Material.LEAVES).nonOpaque());
        BlockRenderLayerMap.INSTANCE.putBlock(this.asBlock(), RenderLayer.getCutout());
    }

    

}
