package project.mod.broodjekaas.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.Rules;


// ModOres class
public class ModOres {

    // mod id
    public static final String MODID = "informaticaproject";


    // new ores   ->   reconfigure for end implementation
    private static ConfiguredFeature<?, ?> ORE_CHEESE = Feature.ORE
    .configure(new OreFeatureConfig(
      OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
      ModBlocks.ORE_CHEESE.getDefaultState(),
      9)) // vein size
    .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
      0, // bottom offset
      0, // min y level
      64))) // max y level
    .spreadHorizontally()
    .repeat(50); // number of veins per chunk


    // register method
    public static void registerOres() {

        // cheese ore overworld
        RegistryKey<ConfiguredFeature<?, ?>> OreCheeseOverworldConfig = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
        new Identifier(MODID, "ore_cheese"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, OreCheeseOverworldConfig.getValue(), ORE_CHEESE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, OreCheeseOverworldConfig);
        // ignore: deprecated


        // cheese_ore end dimension implementation  //  change all endstone in cheese_block??
        



    }

}
