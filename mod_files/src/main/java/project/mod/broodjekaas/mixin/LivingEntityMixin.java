package project.mod.broodjekaas.mixin;

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

    // inject code in tick method
    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {

        ItemStack helmetStack = equippedArmor.get(0); // 0 is for the helmet, 3 is leggings for example.
        if (helmetStack.getItem() == Items.DIAMOND_HELMET) {
            // another way of implementing:
            // player.getEquippedStack(EquipmentSlot.HEAD).isOf(YOUR_CUSTOM_ITEM)

            this.isFireImmune();

        } else {
            this.setSwimming(true);
        }

    }


}
