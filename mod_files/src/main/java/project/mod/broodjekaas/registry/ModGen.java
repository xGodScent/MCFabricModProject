package project.mod.broodjekaas.registry;

import project.mod.broodjekaas.world.gen.CheeseWorldGenEnd;

public class ModGen {
    
    // mod id
    public static final String MODID = "informaticaproject";

    public static void registerGenerators() {

        CheeseWorldGenEnd.generate();

    }

}
