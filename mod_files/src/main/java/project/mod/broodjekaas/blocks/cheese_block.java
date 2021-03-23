package project.mod.broodjekaas.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import project.mod.broodjekaas.ModSounds;


public class cheese_block extends Block {

    public cheese_block(Settings settings) {
        super( Settings.of(  Material.SOIL  )
        .jumpVelocityMultiplier( 1.25F )
        .velocityMultiplier( 0.5F )
        .strength(  0.6F,  3.0F  )
        .sounds(BlockSoundGroup.CROP)
        );
    }

    @Override
    public void onLandedUpon(World world, BlockPos pos, Entity entity, float distance) {
        
        if (!world.isClient) {
            world.playSound(
                    null,
                    entity.getBlockPos(), // position sound
                    ModSounds.FUNNY_MONKEY_EVENT, // sound that will play
                    SoundCategory.MUSIC,
                    1f, // volume 
                    1f  // pitch
            );
        }

        super.onLandedUpon(world, pos, entity, distance);
    }

}

