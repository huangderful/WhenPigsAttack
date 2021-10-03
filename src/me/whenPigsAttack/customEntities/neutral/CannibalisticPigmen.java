package me.whenPigsAttack.customEntities.neutral;



import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.whenPigsAttack.pathfindergoals.PathfinderGoalCaptureTarget;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityPigZombie;
import net.minecraft.server.v1_16_R3.EntityStrider;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EnumItemSlot;
import net.minecraft.server.v1_16_R3.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomStroll;
import net.minecraft.server.v1_16_R3.PathfinderGoalWater;
import net.minecraft.server.v1_16_R3.PathfinderGoalZombieAttack;


public class CannibalisticPigmen extends EntityPigZombie{

	public CannibalisticPigmen(Location loc) {
	    super(EntityTypes.ZOMBIFIED_PIGLIN, ((CraftWorld)loc.getWorld()).getHandle());
	    this.setPosition(loc.getX(), loc.getY(), loc.getZ());
	    
	    this.setCustomName(new ChatComponentText(ChatColor.BLUE + "honorable death."));
	    this.setCustomNameVisible(true);
	    ItemStack name = new ItemStack(Material.NETHERITE_SWORD);
	    net.minecraft.server.v1_16_R3.ItemStack nametag = CraftItemStack.asNMSCopy(name);
	    
	    this.setSlot(EnumItemSlot.MAINHAND, nametag);
	    this.setSlot(EnumItemSlot.OFFHAND, nametag);

	 }
	
	@Override
	public void tick() {
		super.tick();
	}
	@Override
	protected void initPathfinder() {
		this.goalSelector.a(2, new PathfinderGoalRandomStroll(this, 1.0D));
		this.goalSelector.a(2, new PathfinderGoalRandomLookaround(this));
		
		
		
		this.targetSelector.a(1, new PathfinderGoalNearestAttackableTarget<>(this, EntityPigZombie.class, true));
	    this.targetSelector.a(1, (new PathfinderGoalHurtByTarget(this, new Class[0])).a(new Class[0]));
	    

	    

		
	}	
}

