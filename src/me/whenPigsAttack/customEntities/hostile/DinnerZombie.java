package me.whenPigsAttack.customEntities.hostile;


import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_16_R3.Block;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityBee;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityLiving;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityZombie;
import net.minecraft.server.v1_16_R3.EnumItemSlot;
import net.minecraft.server.v1_16_R3.IMaterial;
import net.minecraft.server.v1_16_R3.Item;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.PathfinderGoal;
import net.minecraft.server.v1_16_R3.PathfinderGoalFollowEntity;
import net.minecraft.server.v1_16_R3.PathfinderGoalGotoTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalInteract;
import net.minecraft.server.v1_16_R3.PathfinderGoalLeapAtTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R3.PathfinderGoalTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalZombieAttack;


public class DinnerZombie extends EntityZombie{
	Entity nearestEntity;

	public DinnerZombie(Location loc) {
	    super(EntityTypes.ZOMBIE, ((CraftWorld)loc.getWorld()).getHandle());
	    this.setPosition(loc.getX(), loc.getY(), loc.getZ());
	    
	    ((Zombie)(this.getBukkitEntity())).getEquipment().getItemInMainHand().setType(org.bukkit.Material.ACACIA_DOOR);
	    
	    
	    ItemStack name = new ItemStack(Material.NAME_TAG);
	    ItemMeta m = name.getItemMeta();
	    m.setDisplayName("Dinnerbone");
	    net.minecraft.server.v1_16_R3.ItemStack nametag = CraftItemStack.asNMSCopy(name);
	    
	    this.setSlot(EnumItemSlot.MAINHAND, nametag);

	    
		nearestEntity = null;
		List<Entity> nearbyEntities = this.getBukkitEntity().getNearbyEntities(10, 10, 10);
		for(Entity e : nearbyEntities) {
			if(nearbyEntities.size() < 2) {
				return;
			}
			if(nearestEntity == null
					&& ((CraftEntity) e).getHandle() instanceof EntityLiving 
					&& !(e instanceof Player) 
					&& e.getCustomName() == null) {
				nearestEntity = e;
			} else {
				if(nearestEntity != null &&
						this.getBukkitEntity().getLocation().distance(e.getLocation()) < 
						this.getBukkitEntity().getLocation().distance(nearestEntity.getLocation())
						&& ((CraftEntity) e).getHandle() instanceof EntityLiving && !(e instanceof Player)
						&& e.getCustomName() == null) {
					nearestEntity = e;
				}
			}
		}
		System.out.println(nearestEntity);
	 }
	
	@Override
	public void tick() {
		super.tick();
		
	}
	@Override
	protected void initPathfinder() {
		if(nearestEntity != null) {
			this.goalSelector.a(1, new PathfinderGoalLeapAtTarget(this, 1F));
			this.goalSelector.a(2, new PathfinderGoalRandomLookaround(this));
			this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget<>(this, ((EntityLiving)((CraftEntity) nearestEntity).getHandle()).getClass(), true));

			this.targetSelector.a(1, new PathfinderGoalNearestAttackableTarget<>(this, ((EntityLiving)((CraftEntity) nearestEntity).getHandle()).getClass(), true));
			this.targetSelector.a(2, new PathfinderGoalZombieAttack(this, 10, true));
			
			

			if(this.getBukkitEntity().getLocation().distance(nearestEntity.getLocation()) < 2) {
				((CraftEntity)nearestEntity).getHandle().setCustomName((new ChatComponentText("Dinnerbone")));
				List<Entity> nearbyEntities = this.getBukkitEntity().getNearbyEntities(10, 10, 10);
				nearestEntity = null;
				for(Entity e : nearbyEntities) {
					if(nearbyEntities.size() < 2) {
						return;
					}
					if(nearestEntity == null
							&& ((CraftEntity) e).getHandle() instanceof EntityLiving 
							&& !(e instanceof Player) 
							&& e.getCustomName() == null) {
						nearestEntity = e;
					} else {
						if(nearestEntity != null &&
								this.getBukkitEntity().getLocation().distance(e.getLocation()) < 
								this.getBukkitEntity().getLocation().distance(nearestEntity.getLocation())
								&& ((CraftEntity) e).getHandle() instanceof EntityLiving && !(e instanceof Player)
								&& e.getCustomName() == null) {
							nearestEntity = e;
						}
					}
				}
			}
			


		} else {
			List<Entity> nearbyEntities = this.getBukkitEntity().getNearbyEntities(10, 10, 10);
			nearestEntity = null;
			for(Entity e : nearbyEntities) {
				if(nearbyEntities.size() < 2) {
					return;
				}
				if(nearestEntity == null
						&& ((CraftEntity) e).getHandle() instanceof EntityLiving 
						&& !(e instanceof Player) 
						&& e.getCustomName() == null) {
					nearestEntity = e;
				} else {
					if(nearestEntity != null &&
							this.getBukkitEntity().getLocation().distance(e.getLocation()) < 
							this.getBukkitEntity().getLocation().distance(nearestEntity.getLocation())
							&& ((CraftEntity) e).getHandle() instanceof EntityLiving && !(e instanceof Player)
							&& e.getCustomName() == null) {
						nearestEntity = e;
					}
				}
			}
		}

	  
	}
	@Override
	public void movementTick() {
		super.movementTick();
		this.extinguish();
		
	}
}

