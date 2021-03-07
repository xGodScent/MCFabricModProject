package project.mod.broodjekaas.blocks;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import project.mod.broodjekaas.registry.ModBlocks;

import java.util.Random;


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

