package project.mod.broodjekaas.registry;

import java.util.Collections;
import java.util.Optional;

import net.minecraft.client.world.GeneratorType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.FlatChunkGenerator;
import net.minecraft.world.gen.chunk.FlatChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;

import project.mod.broodjekaas.mixin.GeneratorTypeAccessor;

public class ModWorldGeneration {

    // mod id
    public static final String MODID = "informaticaproject";

    // generation type:
    private static final GeneratorType VOID = new GeneratorType("void") {
        protected ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry,
                Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed) {
            FlatChunkGeneratorConfig config = new FlatChunkGeneratorConfig(
                    new StructuresConfig(Optional.empty(), Collections.emptyMap()), biomeRegistry);
            config.updateLayerBlocks();
            return new FlatChunkGenerator(config);
        }
    };

    private static final GeneratorType TEST_WORLDGEN = new GeneratorType("test_worldgen") {
        protected ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry,
                Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed) {
            FlatChunkGeneratorConfig config = new FlatChunkGeneratorConfig(
                    new StructuresConfig(Optional.empty(), Collections.emptyMap()), biomeRegistry);
            config.updateLayerBlocks();

            return new FlatChunkGenerator(config);

        }
    };

    private static final GeneratorType TESTER = new GeneratorType("tester") { 
        protected ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry,
            Registry<ChunkGeneratorSettings> settingsRegistry, long seed) {
            return new NoiseChunkGenerator(new BiomeSource(biomeRegistry, seed), 
            seed,
            () -> settingsRegistry.get(ChunkGeneratorSettings.OVERWORLD));
        }
    };


    public static void registerGen() {

        // adds generation type to mixin
        GeneratorTypeAccessor.getValues().add(VOID);
        GeneratorTypeAccessor.getValues().add(TEST_WORLDGEN);
        GeneratorTypeAccessor.getValues().add(TESTER);

    }


}
