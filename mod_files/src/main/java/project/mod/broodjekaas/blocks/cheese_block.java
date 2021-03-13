package project.mod.broodjekaas.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;


public class cheese_block extends Block {

    public cheese_block(Settings settings) {
        super( Settings.of(  Material.SOIL  )
        .jumpVelocityMultiplier( 1.25F )
        .velocityMultiplier( 0.5F )
        .strength(  0.6F,  3.0F  )
        .sounds(BlockSoundGroup.CROP)
        );
    }

}

