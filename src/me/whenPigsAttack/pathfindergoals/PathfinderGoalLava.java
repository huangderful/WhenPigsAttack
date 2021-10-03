package me.whenPigsAttack.pathfindergoals;

import net.minecraft.server.v1_16_R3.BlockPosition;
import net.minecraft.server.v1_16_R3.EntityCreature;
import net.minecraft.server.v1_16_R3.MathHelper;
import net.minecraft.server.v1_16_R3.PathfinderGoal;
import net.minecraft.server.v1_16_R3.TagsFluid;

public class PathfinderGoalLava extends PathfinderGoal {
	  private final EntityCreature a;
	  
	  public PathfinderGoalLava(EntityCreature var0) {
	    this.a = var0;
	  }
	  
	  public boolean a() {
	    return (this.a.isOnGround() && !this.a.world.getFluid(this.a.getChunkCoordinates()).a(TagsFluid.LAVA));
	  }
	  
	  public void c() {
	    BlockPosition var0 = null;
	    Iterable<BlockPosition> var1 = BlockPosition.b(
	        MathHelper.floor(this.a.locX() - 2.0D), 
	        MathHelper.floor(this.a.locY() - 2.0D), 
	        MathHelper.floor(this.a.locZ() - 2.0D), 
	        MathHelper.floor(this.a.locX() + 2.0D), 
	        MathHelper.floor(this.a.locY()), 
	        MathHelper.floor(this.a.locZ() + 2.0D));
	    for (BlockPosition var3 : var1) {
	      if (this.a.world.getFluid(var3).a(TagsFluid.LAVA)) {
	        var0 = var3;
	        break;
	      } 
	    } 
	    if (var0 != null)
	      this.a.getControllerMove().a(var0.getX(), var0.getY(), var0.getZ(), 1.0D); 
	  }
	}