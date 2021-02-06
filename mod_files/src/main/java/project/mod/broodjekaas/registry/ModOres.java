package project.mod.broodjekaas.registry;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.GenerationStep.Feature;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

// ModOres class
public class ModOres {

    // mod id
    public static final String MODID = "informaticaproject";


    public static ConfiguredFeature<?, ?> ORE_WOOL_OVERWORLD = Feature.ORE
    .configure(new OreFeatureConfig(
      OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
      Blocks.WHITE_WOOL.getDefaultState(),
      9)) // vein size
    .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
      0, // bottom offset
      0, // min y level
      64))) // max y level
    .spreadHorizontally()
    .repeat(20); // number of veins per chunk


    // register method
    public static void registerOres() {
        
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("tutorial", "ore_wool_overworld"), ORE_WOOL_OVERWORLD);
    
    }

}
