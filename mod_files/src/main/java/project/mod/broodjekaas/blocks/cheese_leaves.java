package project.mod.broodjekaas.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class cheese_leaves extends Block {

    public cheese_leaves(Settings settings) {
        super(Settings.of(Material.LEAVES)
        .nonOpaque()
        .sounds(BlockSoundGroup.VINE)
        .strength(0.2F,  0.2F)        
        );
    }

}

