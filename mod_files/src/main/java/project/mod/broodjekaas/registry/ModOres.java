package project.mod.broodjekaas.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;


// ModOres class
public class ModOres {

    // mod id
    public static final String MODID = "informaticaproject";


    // new ores
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
    .repeat(50); // number of ore veins/generations per chunk

    private static ConfiguredFeature<?, ?> ORE_SUPER_CHEESE = Feature.ORE
    .configure(new OreFeatureConfig(
      new BlockMatchRuleTest(Blocks.END_STONE),
      ModBlocks.ORE_SUPER_CHEESE.getDefaultState(),
      4)) // vein size
    .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
      0, // bottom offset
      0, // min y level
      69))) // max y level
    .spreadHorizontally()
    .repeat(20); // number of ore veins/generations per chunk


    // register method
    public static void registerOres() {
      
      // cheese ore overworld
      RegistryKey<ConfiguredFeature<?, ?>> OreCheeseOverworldConfig = RegistryKey.of( Registry.CONFIGURED_FEATURE_WORLDGEN,
      new Identifier(  MODID,  "ore_cheese"  ));
      Registry.register(  BuiltinRegistries.CONFIGURED_FEATURE,   OreCheeseOverworldConfig.getValue(),   ORE_CHEESE  );
      BiomeModifications.addFeature(  BiomeSelectors.foundInOverworld()  , GenerationStep.Feature.UNDERGROUND_ORES,   
      OreCheeseOverworldConfig  );
      // ignore: deprecated ^ (line above). It does actually work, its not invalid.


      // super cheese ore end dimension implementation
      RegistryKey<ConfiguredFeature<?, ?>> OreSuperCheeseEndConfig = RegistryKey.of( Registry.CONFIGURED_FEATURE_WORLDGEN,
      new Identifier(  MODID,  "ore_super_cheese"  ));
      Registry.register(  BuiltinRegistries.CONFIGURED_FEATURE,   OreSuperCheeseEndConfig.getValue(),   ORE_SUPER_CHEESE  );
      BiomeModifications.addFeature(  BiomeSelectors.foundInTheEnd() , GenerationStep.Feature.UNDERGROUND_ORES,   
      OreSuperCheeseEndConfig  );
      // ignore: deprecated ^ (line above). It does actually work, its not invalid.
      // /fill ~-8 0 ~-8 ~8 ~ ~8 minecraft:air replace minecraft:end_stone


      // for actual changing the end stone we might have to look into: GenerationStep.Feature.UNDERGROUND_ORES -> Feature.
      // ->  change all endstone in cheese_block
      
      // https://fabricmc.net/wiki/tutorial:features
      // https://github.com/FabricMC/fabric/pull/1097
      // https://minecraft.gamepedia.com/Biome/JSON_format
      // https://fabricmc.net/wiki/tutorial:1.15:jigsaw
      // https://fabricmc.net/wiki/tutorial:ores


    }

}
