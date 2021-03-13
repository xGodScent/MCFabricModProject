// package
package project.mod.broodjekaas;

// libraries used
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

// class that handles (mod added) food items
public class AddedFoodComponents {
    
    // is called when food is eaten 
    public static final FoodComponent CHEESE = ( new FoodComponent.Builder()) .hunger(  2  ).saturationModifier(  0.2F  ).statusEffect( new StatusEffectInstance( StatusEffects.NAUSEA,  200,  0),  0.15F ).snack().build();
    public static final FoodComponent TOAST = ( new FoodComponent.Builder()) .hunger(  3  ).saturationModifier(  0.3F  ).build();
	public static final FoodComponent BREAD_CHEESE = ( new FoodComponent.Builder()) .hunger(  5  ).saturationModifier(  0.5F  ).build();
    public static FoodComponent CHEESE_WHEEL = ( new FoodComponent.Builder()) .hunger(  6  ).saturationModifier(  0.8F  ).build();
    
}
