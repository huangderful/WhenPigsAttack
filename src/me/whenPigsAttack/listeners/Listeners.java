package me.whenPigsAttack.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.whenPigsAttack.customEntities.CustomPhantom;
import me.whenPigsAttack.customEntities.hostile.DinnerZombie;
import me.whenPigsAttack.customEntities.neutral.CannibalisticPigmen;
import me.whenPigsAttack.customEntities.neutral.SpiderHateBee;
import me.whenPigsAttack.customEntities.passive.StriderDiver;
import net.minecraft.server.v1_16_R3.WorldServer;

public class Listeners implements Listener{
	
	
	@EventHandler
	public void a(PlayerInteractEvent event) {
		if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.GOLD_BLOCK)) {
			CannibalisticPigmen s = new CannibalisticPigmen(event.getPlayer().getLocation());
		
			
			WorldServer w = ((CraftWorld)event.getPlayer().getWorld()).getHandle();
			w.addEntity(s);
		}
		
		
		
	}
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if(event.getEntity().getType().equals(EntityType.ZOMBIE) &&
				event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
			event.setCancelled(true);
		}
	}
	
}
