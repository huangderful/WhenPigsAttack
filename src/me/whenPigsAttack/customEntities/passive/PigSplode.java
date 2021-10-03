
package me.whenPigsAttack.customEntities.passive;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityLiving;
import net.minecraft.server.v1_16_R3.EntityPhantom;
import net.minecraft.server.v1_16_R3.EntityPig;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EnumMoveType;
import net.minecraft.server.v1_16_R3.MathHelper;
import net.minecraft.server.v1_16_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_16_R3.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalSwell;
import net.minecraft.server.v1_16_R3.Vec3D;

public class PigSplode extends EntityPig{

	public PigSplode(Location loc) {
	    super(EntityTypes.PIG, (((CraftWorld)loc.getWorld()).getHandle()));
	    this.setCustomName(new ChatComponentText(ChatColor.AQUA + "ssssssssssss"));
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
	 
	    this.targetSelector.a(1, new PathfinderGoalNearestAttackableTarget<>(this, EntityHuman.class, true));
	    this.targetSelector.a(2, new PathfinderGoalHurtByTarget(this, new Class[0]));
	}
	@Override
	public void movementTick() {
		super.movementTick();
		this.extinguish();
		
	}

}
