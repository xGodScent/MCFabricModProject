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

    //
    public static final ConfiguredFeature<?, ?> STONE_SPIRAL_CONFIGURED = STONE_SPIRAL.configure(FeatureConfig.DEFAULT)
    .decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(5)));


    // structure generation method -> here we define how we want the structure to generate
    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
      
      
      BlockPos topPos = world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos);
      Direction offset = Direction.NORTH;


      for (int logY = 0; logY < random.nextInt(3)+4; logY++) {
        
        offset = offset.getOpposite();
        world.setBlockState(topPos.up(logY), ModBlocks.CHEESE_BLOCK.getDefaultState(), 3);

      }

      // works!
      world.setBlockState(world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos).down(1)
        .offset(Direction.NORTH, 4), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 1);
      
      // doesnt fucking work??????? WHAT WHY???!!!! I ONLY PUT IT IN A LOOP WTF IS THIS BULLSHIT
      for (int lDistX = 4; lDistX == 1; lDistX--) {

        // fr who tf came up with this shit IM SO FUCKING DONE
        
        world.setBlockState(world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos).down(1)
        .offset(Direction.NORTH, lDistX), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 1); // kanker
        
        world.setBlockState(world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos).down(1)
        .offset(Direction.EAST, lDistX), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 1);
        
        world.setBlockState(world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos).down(1)
        .offset(Direction.SOUTH, lDistX), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 1);
       
        world.setBlockState(world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos).down(1)
        .offset(Direction.WEST, lDistX), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 1);


      }

      

      // world.setBlockState(world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos).offset(Direction.random(random), random.nextInt(3)), ModBlocks.ORE_SUPER_CHEESE.getDefaultState(), 3, 14);
      
      
      
      //new BlockPos(3, 3, 3)


      return true;

    }



  }