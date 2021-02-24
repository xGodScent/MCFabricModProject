// package
package project.mod.broodjekaas.registry;


// used libraries
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
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

        // registers cheese tree structure
        // cheese tree structure (end dimension only as defined in -> .addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.TOP_LAYER_MODIFICATION, cheeseTree);)
        Registry.register(Registry.FEATURE, new Identifier(MODID, "cheese_tree"), CheeseTreeGen.CHEESE_TREE);
        RegistryKey<ConfiguredFeature<?, ?>> cheeseTree = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
        new Identifier(MODID, "cheese_tree"));
       
        // here we define where and how we want it to generate
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, cheeseTree.getValue(), CheeseTreeGen.CHEESE_TREE_CONFIGURED);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.TOP_LAYER_MODIFICATION, cheeseTree);
        

        // maybe add molten cheese lakes???


        
    }
}
