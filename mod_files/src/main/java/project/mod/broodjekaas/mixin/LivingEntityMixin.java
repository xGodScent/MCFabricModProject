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

        if (helmetStack.getItem().equals(Items.DIAMOND_HELMET)) {
            // another way of implementing:
            // player.getEquippedStack(EquipmentSlot.HEAD).isOf(YOUR_CUSTOM_ITEM)  ->  player isnt recognised??? plz fix...

            isFireImmune();         // what the fuck?? WORK??!!!11
            setOnFireFor(0);        // <-- this part decided to fucking die

        } else {
            setSwimming(true);      // isnt even called?? what.
            setOnFireFor(3);
        }

    }


}
