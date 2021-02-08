package project.mod.broodjekaas.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;


import net.minecraft.client.world.GeneratorType;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.decorator.EndIslandDecorator;

// @Mixin(GeneratorType.class)
// public interface GeneratorTypeAccessor {
//   @Accessor("VALUES")
//   public static List<GeneratorType> getValues() {
//     thr  ow new AssertionError();
//   }
// }

@Mixin(EndIslandDecorator.class)
public interface EndIslandDecorator {
    
}

