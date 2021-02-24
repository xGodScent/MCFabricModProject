package project.mod.broodjekaas.registry;

import java.util.Collections;
import java.util.Optional;

import net.minecraft.client.world.GeneratorType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.FlatChunkGenerator;
import net.minecraft.world.gen.chunk.FlatChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;

import project.mod.broodjekaas.mixin.GeneratorTypeAccessor;

// what the fuck
public class ModGenTypes {

    // mod id
    public static final String MODID = "informaticaproject";

    // generation type: HOW DO I MAKE IT FOR A NORMAL WORLD TYPE WITH MY ORES??
    private static final GeneratorType CHEESE_END = new GeneratorType("cheese_end") {
        protected ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry,
                Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed) {
            FlatChunkGeneratorConfig config = new FlatChunkGeneratorConfig(
                    new StructuresConfig(Optional.empty(), Collections.emptyMap()), biomeRegistry);
            config.updateLayerBlocks();
            return new FlatChunkGenerator(config);
        }
    };


    // register method
    public static void registerGens() {

        // adds generation type to mixin
        GeneratorTypeAccessor.getValues().add(CHEESE_END);

    }


}
