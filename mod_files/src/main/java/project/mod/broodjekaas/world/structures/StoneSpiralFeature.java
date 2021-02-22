package project.mod.broodjekaas.world.structures;

// used libraries
import java.util.Random;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import project.mod.broodjekaas.registry.ModBlocks;
import net.minecraft.world.Heightmap;

public class StoneSpiralFeature extends Feature<DefaultFeatureConfig> {
    
  public StoneSpiralFeature(Codec<DefaultFeatureConfig> config) {
      super(config);
  }
   
    
    // stone spiral is defined to call for register
    public static final Feature<DefaultFeatureConfig> STONE_SPIRAL = new StoneSpiralFeature(DefaultFeatureConfig.CODEC);

    // penis
    public static final ConfiguredFeature<?, ?> STONE_SPIRAL_CONFIGURED = STONE_SPIRAL.configure(FeatureConfig.DEFAULT)
    .decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(5)));



    // NOTE: yes.. we have to this terribleness...
    // structure generation method -> here we define how we want the structure to generate
    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
      
      // some shit we need
      BlockPos topPos = world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos);
      Direction offset = Direction.NORTH;


      // generates tree
      boolean done = false;
      for (int logY = (random.nextInt(4)+4); logY > 0; logY--) {
        offset = offset.getOpposite();

        // generates logs -> each iteration it adds a block downwards
        world.setBlockState(topPos.up(logY), ModBlocks.CHEESE_BLOCK.getDefaultState(), 3);


        // generates leaves -> makes sure we only get leaves on the top blocks (and not all the way down)
        if (!done) {
          for (int x = 0; x < random.nextInt(3)+3; x++) { // generates base leaves -> cross shape

            offset = offset.getOpposite(); // tbh idek wtf this does, WHO CARES?!

            // this is what torture looks like...
            for (int lY = 1; lY < 4; lY++) {
              
              world.setBlockState(topPos.up(logY+lY).north(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
              world.setBlockState(topPos.up(logY+lY).east(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
              world.setBlockState(topPos.up(logY+lY).south(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
              world.setBlockState(topPos.up(logY+lY).west(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);


              for (int xz = 1; xz < x+1; xz++) {
                
                // draws a square into a certain dimension
                world.setBlockState(topPos.up(logY+lY).north(x).east(xz), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).north(xz).east(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).north(x).east(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).north(xz).east(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);

                // repeat it for other dimensions
                world.setBlockState(topPos.up(logY+lY).east(x).south(xz), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).east(xz).south(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).east(x).south(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).east(xz).south(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);

                world.setBlockState(topPos.up(logY+lY).south(x).west(xz), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).south(xz).west(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).south(x).west(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).south(xz).west(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);

                world.setBlockState(topPos.up(logY+lY).west(x).north(xz), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).west(xz).north(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).west(x).north(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).west(xz).north(x), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3);


              }
            }


            




            // completions:
            // re -add base log block
            world.setBlockState(topPos, ModBlocks.CHEESE_BLOCK.getDefaultState(), 3);

            // add for extra block in the middle so leaves grow around instead of on top
            world.setBlockState(topPos.up(logY+1), ModBlocks.CHEESE_BLOCK.getDefaultState(), 3);
        
          }
        }

        done = true;

      }
    


      return true;

    }



  }