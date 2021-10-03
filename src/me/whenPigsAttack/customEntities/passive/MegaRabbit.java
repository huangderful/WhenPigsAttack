package me.whenPigsAttack.customEntities.passive;



import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;



import me.whenPigsAttack.pathfindergoals.PathfinderGoalCaptureTarget;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityRabbit;
import net.minecraft.server.v1_16_R3.EntityStrider;
import net.minecraft.server.v1_16_R3.EntityTypes;

import net.minecraft.server.v1_16_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R3.PathfinderGoalWater;


public class MegaRabbit extends EntityRabbit{

	public MegaRabbit(Location loc) {
	    super(EntityTypes.RABBIT, ((CraftWorld)loc.getWorld()).getHandle());
	    this.setPosition(loc.getX(), loc.getY(), loc.getZ());
	    
	    this.setCustomName(new ChatComponentText(ChatColor.RED + "CHUNGUS"));
	    this.setCustomNameVisible(true);
	    
	 }
	
	@Override
	public void tick() {
		super.tick();
	}
	@Override
	public void initPathfinder() {
	    this.goalSelector.a(1, new PathfinderGoalLookAtPlayer(this, (Class)EntityHuman.class, 15F));
		this.goalSelector.a(1, new PathfinderGoalCaptureTarget(this, 0.7F));
		this.targetSelector.a(1, new PathfinderGoalNearestAttackableTarget<>(this, EntityHuman.class, false));
		
		this.goalSelector.a(1, new PathfinderGoalWater(this));

		
		this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));



	    

		
	}
	
}

