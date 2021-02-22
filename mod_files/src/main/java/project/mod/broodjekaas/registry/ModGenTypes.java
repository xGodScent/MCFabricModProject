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

public class ModGenTypes {

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

    // register method
    public static void registerGens() {

        // adds generation type to mixin
        GeneratorTypeAccessor.getValues().add(VOID);

    }


}
