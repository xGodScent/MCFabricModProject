package project.mod.broodjekaas.mixin;

import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;


@Mixin(MinecraftClient.class)
public class PlayerEntityMixin extends LivingEntity {

    
    PlayerEntity player;

    @Inject(at = @At("TAIL"), method = "tick")
    public void onTick(CallbackInfo info) {

            if (MinecraftClient.getInstance().world != null) {

                world.spawnEntity(this.player);

            }

            System.out.println(MinecraftClient.getInstance());
       

    }
}
