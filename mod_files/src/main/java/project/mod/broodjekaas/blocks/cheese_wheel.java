package project.mod.broodjekaas.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class cheese_wheel extends Block {

    public cheese_wheel(Settings settings) {
        super(settings.nonOpaque());
    }
  

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        
        // TODO:
        // here we have to implement that a value goes -1 to see at what state it is -> i want it to be like a cake but with 4 pieces
        // we have to get a top texture and we also have to update the json file

        return super.onUse(state, world, pos, player, hand, hit);
    }
    

}
