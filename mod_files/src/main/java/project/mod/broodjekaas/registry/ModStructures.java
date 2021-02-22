// package
package project.mod.broodjekaas.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
// used libraries
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import project.mod.broodjekaas.world.structures.CheeseTreeGen;
import net.minecraft.world.gen.GenerationStep;

// ModStructures class, the register method is called on init (startup)
public class ModStructures {
    
    // mod id
    public static final String MODID = "informaticaproject";
    
    // register method
    public static void registerStructures() {

        // cheese tree structure
        Registry.register(Registry.FEATURE, new Identifier(MODID, "cheese_tree"), CheeseTreeGen.CHEESE_TREE);
        
        RegistryKey<ConfiguredFeature<?, ?>> cheeseTree = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
        new Identifier(MODID, "cheese_tree"));
        
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, cheeseTree.getValue(), CheeseTreeGen.CHEESE_TREE_CONFIGURED);
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, cheeseTree);
        

        // ok
        
    }
}


// TODO: add to correct folder