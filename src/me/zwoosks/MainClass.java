package me.zwoosks;

import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import disponibility.Sumo1Manager;

public class MainClass extends JavaPlugin {

	@Override
	public void onEnable() {
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		new ListenerClass(this);
		
	}
	
	
	@Override
	public void onDisable() {
		saveConfig();
	}
	
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("fix") && sender instanceof Player) {
			
			
			
			// Code
			Player player = (Player) sender;
			player.setWalkSpeed(0.2F);
			player.setFlySpeed(0.1F);
			
			Location loc = (Location) getConfig().get("cartel1");
			
			Sign sign = (Sign) loc.getBlock().getState();
			
			sign.setLine(1, Integer.toString(getServer().getWorld("sumoArena1").getPlayers().size()) + "/4");
			sign.update();
			
			Sumo1Manager.setDisponible(true);
			
			
			return true;
		}
		
		
		return false;
		
	}
	
}
