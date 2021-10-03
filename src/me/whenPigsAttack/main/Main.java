package me.whenPigsAttack.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.whenPigsAttack.commands.Commands;
import me.whenPigsAttack.listeners.Listeners;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable(){
		new Commands(this);
		getServer().getPluginManager().registerEvents(new Listeners(), this);

	}
}
