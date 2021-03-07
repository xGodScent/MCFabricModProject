package project.mod.broodjekaas.world.structures;

import java.beans.VetoableChangeListener;
// used libraries
import java.util.Random;
import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import project.mod.broodjekaas.registry.ModBlocks;
import net.minecraft.world.Heightmap;

// chrees = cheese + trees
public class CheeseTreeGen extends Feature<DefaultFeatureConfig> {
    
  public CheeseTreeGen(Codec<DefaultFeatureConfig> config) {
      super(config);
  }
   
    
    // cheese_tree is defined to call for register
    public static final Feature<DefaultFeatureConfig> CHEESE_TREE = new CheeseTreeGen(DefaultFeatureConfig.CODEC);

    // penis
    public static final ConfiguredFeature<?, ?> CHEESE_TREE_CONFIGURED = CHEESE_TREE.configure(FeatureConfig.DEFAULT)
    .decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(5))); // tbh idk what this is lmao



    // NOTE: yes.. we have to this terribleness...
    // structure generation method -> here we define how we want the structure to generate
    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
      
      System.out.println(  world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos)  );
      System.out.println(  new BlockPos( pos.getX(), 0, pos.getZ())  );

      System.out.println(  world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos)   ==   new BlockPos( pos.getX(), 0, pos.getZ())  );


      // checks if highest block is equal to 0   ->   if topPos is equal to 0 : we just return a true so it thinks generation was succesful and then we dont generate the structure
      if (  world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos).equals( new BlockPos( pos.getX(), 0, pos.getZ()) )  ) {
        return true;
      } else {

        // some shit we need
        BlockPos topPos = world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos);
        Direction offset = Direction.NORTH;

        Block LOG = ModBlocks.CHEESE_LOG; 
        Block LEAVES = ModBlocks.CHEESE_LEAVES;
        Block EMPTY = Blocks.AIR;


        // NOTE: maxLeaveGenHeight breaks the generation if its not set to the default (3)
        // defaults = maxLogGenHeight= 1 to 4   -   maxLeaveGenHeight=3
        int maxLogGenHeight = 3;    // this is still random as it gets configured as the following -> [  random.nextInt(maxLogGenHeight)+3  ]
        int maxLeaveGenHeight = 3;  // max leaves gen height on top of the logs -> 2 of the blocks get replaced with logs in the middle later
        

        // generates tree
        boolean done = false;
        for (int logY = (random.nextInt(maxLogGenHeight)+3); logY > 0; logY--) { // this decides how tall the tree will be
          offset = offset.getOpposite();

          // generates logs -> each iteration it adds a block downwards
          world.setBlockState(topPos.up(logY), LOG.getDefaultState(), 3);


          // generates leaves -> makes sure we only get leaves on the top blocks (and not all the way down)
          if (!done) {
            for (int x = 0; x < random.nextInt(2)+3; x++) { // generates base leaves -> cross shape

              offset = offset.getOpposite(); // tbh idek wtf this does, WHO CARES?!
              int remover = 0;

              // this is what torture looks like...
              for (int lY = 1; lY < (maxLeaveGenHeight+1); lY++) {
                
                world.setBlockState(topPos.up(logY+lY).north(x-remover), LEAVES.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).east(x-remover), LEAVES.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).south(x-remover), LEAVES.getDefaultState(), 3);
                world.setBlockState(topPos.up(logY+lY).west(x-remover), LEAVES.getDefaultState(), 3);

                
                // makes square out of leaves
                for (int xz = 1; xz < x+1; xz++) {
                  
                  // if leave generation height isnt top layer
                  if (lY != maxLeaveGenHeight) {

                    // draws a square into a certain dimension
                    world.setBlockState(topPos.up(logY+lY).north(x-remover).east(xz-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).north(xz-remover).east(x-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).north(x-remover).east(x-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).north(xz-remover).east(x-remover), LEAVES.getDefaultState(), 3);

                    // repeat it for other dimensions
                    world.setBlockState(topPos.up(logY+lY).east(x-remover).south(xz-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).east(xz-remover).south(x-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).east(x-remover).south(x-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).east(xz-remover).south(x-remover), LEAVES.getDefaultState(), 3);

                    world.setBlockState(topPos.up(logY+lY).south(x-remover).west(xz-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).south(xz-remover).west(x-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).south(x-remover).west(x-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).south(xz-remover).west(x-remover), LEAVES.getDefaultState(), 3);

                    world.setBlockState(topPos.up(logY+lY).west(x-remover).north(xz-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).west(xz-remover).north(x-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).west(x-remover).north(x-remover), LEAVES.getDefaultState(), 3);
                    world.setBlockState(topPos.up(logY+lY).west(xz-remover).north(x-remover), LEAVES.getDefaultState(), 3);


                  // check if top layer for leaves
                  } else if (lY == maxLeaveGenHeight) {

                    if (xz > 2) { // add some extra leaves around the top
                  
                      world.setBlockState(topPos.up(logY+3).north(x-2), LEAVES.getDefaultState(), 3);
                      world.setBlockState(topPos.up(logY+3).east(x-2), LEAVES.getDefaultState(), 3);
                      world.setBlockState(topPos.up(logY+3).south(x-2), LEAVES.getDefaultState(), 3);
                      world.setBlockState(topPos.up(logY+3).west(x-2), LEAVES.getDefaultState(), 3);
                  
                    } else { // some extra leave removal 

                      world.setBlockState(topPos.up(logY+lY).north(x), EMPTY.getDefaultState(), 3);
                      world.setBlockState(topPos.up(logY+lY).east(x), EMPTY.getDefaultState(), 3);
                      world.setBlockState(topPos.up(logY+lY).south(x), EMPTY.getDefaultState(), 3);
                      world.setBlockState(topPos.up(logY+lY).west(x), EMPTY.getDefaultState(), 3);
                    
                    }
  
                  }
                  
                  // the remover var removes some leaves
                  remover++;

                }

              }

              // completions:
              // re-add base log block
              world.setBlockState(topPos, LOG.getDefaultState(), 3);

              // add for extra block in the middle so leaves grow around instead of on top
              world.setBlockState(topPos.up(logY+1), LOG.getDefaultState(), 3);
              world.setBlockState(topPos.up(logY+2), LOG.getDefaultState(), 3);
          
              // replace leaves corners lowest y level
              world.setBlockState(topPos.up(logY+1).north(x).east(x), EMPTY.getDefaultState(), 3);
              world.setBlockState(topPos.up(logY+1).east(x).south(x), EMPTY.getDefaultState(), 3);
              world.setBlockState(topPos.up(logY+1).south(x).west(x), EMPTY.getDefaultState(), 3);
              world.setBlockState(topPos.up(logY+1).west(x).north(x), EMPTY.getDefaultState(), 3);

              // replace leaves corners second y level
              world.setBlockState(topPos.up(logY+2).north(x-1).east(x-1), EMPTY.getDefaultState(), 3);
              world.setBlockState(topPos.up(logY+2).east(x-1).south(x-1), EMPTY.getDefaultState(), 3);
              world.setBlockState(topPos.up(logY+2).south(x-1).west(x-1), EMPTY.getDefaultState(), 3);
              world.setBlockState(topPos.up(logY+2).west(x-1).north(x-1), EMPTY.getDefaultState(), 3);


            }
            
          } // if (!done) statement

          // set to true so we dont keep running the leaves generation
          done = true;

        } // tree gen for loop
      

        // generation was succesful
        return true;
      }

    }


  }