// package
package project.mod.broodjekaas;

// libraries used
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

// class that handles (mod added) food items
public class AddedFoodComponents {
    
    public static final FoodComponent CHEESE = (new FoodComponent.Builder()).hunger(5).saturationModifier((float) 0.5).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 100, 0), 1.0F).build();

}
