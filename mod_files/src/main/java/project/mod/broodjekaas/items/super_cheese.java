package project.mod.broodjekaas.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import project.mod.broodjekaas.ModSounds;

public class super_cheese extends Item {

    public super_cheese(Settings settings) 
    {
        super(settings);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        
        if (!world.isClient) {
            world.playSound(
                    null,
                    user.getBlockPos(), // position sound
                    ModSounds.PAVLE_SOUNDTRACK_EVENT, // sound that will play
                    SoundCategory.MUSIC,
                    1f, // volume 
                    1f  // pitch
            );
        }

        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

}
