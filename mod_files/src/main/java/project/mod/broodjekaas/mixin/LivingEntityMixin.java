package project.mod.broodjekaas.mixin;

import javax.print.event.PrintEvent;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;


@Mixin(LivingEntity.class)
public class LivingEntityMixin extends Entity {

    @Shadow @Final private DefaultedList<ItemStack> equippedArmor;

    // inject code into tick method
    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {

        // TODO: mixins make me want to kms

        ItemStack helmetStack = equippedArmor.get(0); // 0 is for the helmet, 3 is leggings for example.

        if (isOnFire()) {
            // another way of implementing:
            // player.getEquippedStack(EquipmentSlot.HEAD).isOf(Items.DIAMOND_HELMET)  ->  "player" isnt recognised??? plz fix...

            System.out.println("Air: ", getAir(), ", Armor: ", getArmorItems(), ", ItemHand: ", getItemsHand(), "EntityName: ", getEntityName() + ";");


        } 

    }


}
