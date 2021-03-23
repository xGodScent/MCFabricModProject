package project.mod.broodjekaas;


import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {

    public static final String MODID = "informaticaproject";

    public static final Identifier PAVLE_SOUNDTRACK_ID = new Identifier("informaticaproject:sound_track_pavle");
    public static SoundEvent PAVLE_SOUNDTRACK_EVENT = new SoundEvent(PAVLE_SOUNDTRACK_ID);

    public static final Identifier FUNNY_MONKEY_ID = new Identifier("informaticaproject:funny_monkey");
    public static SoundEvent FUNNY_MONKEY_EVENT = new SoundEvent(FUNNY_MONKEY_ID);


    public static void registerSounds() {
        
        Registry.register(Registry.SOUND_EVENT, ModSounds.PAVLE_SOUNDTRACK_ID, PAVLE_SOUNDTRACK_EVENT);
        Registry.register(Registry.SOUND_EVENT, ModSounds.FUNNY_MONKEY_ID, FUNNY_MONKEY_EVENT);
    
    }

}
