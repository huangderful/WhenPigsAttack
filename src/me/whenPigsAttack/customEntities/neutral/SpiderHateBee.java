package me.whenPigsAttack.customEntities.neutral;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityBee;
import net.minecraft.server.v1_16_R3.EntityLiving;

import net.minecraft.server.v1_16_R3.EntitySpider;
import net.minecraft.server.v1_16_R3.EntityTypes;

import net.minecraft.server.v1_16_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_16_R3.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalLeapAtTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomStrollLand;

public class SpiderHateBee extends EntitySpider{

	public SpiderHateBee(Location loc) {
	    super(EntityTypes.SPIDER, (((CraftWorld)loc.getWorld()).getHandle()));
	    this.setCustomName(new ChatComponentText(ChatColor.RED + "Spider"));
	    this.setCustomNameVisible(true);
	    this.setPosition(loc.getX(), loc.getY(), loc.getZ());
	 }
	@Override
	public void tick() {
		super.tick();
		

	}
	@Override
	protected void initPathfinder() {
	    this.goalSelector.a(1, new PathfinderGoalFloat(this));
	    this.goalSelector.a(3, new PathfinderGoalLeapAtTarget(this, 0.4F));
	    this.goalSelector.a(4, new PathfinderGoalSpiderMeleeAttack(this));
	    this.goalSelector.a(5, new PathfinderGoalRandomStrollLand(this, 0.8D));
	    this.goalSelector.a(6, new PathfinderGoalRandomLookaround(this));
	    this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, new Class[0]));
	    this.targetSelector.a(2, new PathfinderGoalSpiderNearestAttackableTarget<>(this, EntityBee.class));
	  }
	@Override
	public void movementTick() {
		super.movementTick();
		this.extinguish();
		
	}
	static class PathfinderGoalSpiderMeleeAttack extends PathfinderGoalMeleeAttack {
		    public PathfinderGoalSpiderMeleeAttack(EntitySpider entityspider) {
		      super(entityspider, 1.0D, true);
		   }
	  }
	static class PathfinderGoalSpiderNearestAttackableTarget<T extends EntityLiving> extends PathfinderGoalNearestAttackableTarget<T> {
	    public PathfinderGoalSpiderNearestAttackableTarget(EntitySpider entityspider, Class<T> oclass) {
	      super(entityspider, oclass, true);
	    }
	}
}

