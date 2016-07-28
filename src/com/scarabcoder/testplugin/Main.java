package com.scarabcoder.testplugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.scarabcoder.testplugin.command.DonorCommand;
import com.scarabcoder.testplugin.command.InfoCommands;
import com.scarabcoder.testplugin.command.MutechatCommand;
import com.scarabcoder.testplugin.command.VanishCommand;
import com.scarabcoder.testplugin.gui.InventoryListener;
import com.scarabcoder.testplugin.listeners.InteractListener;
import com.scarabcoder.testplugin.listeners.PlayerChatListener;
import com.scarabcoder.testplugin.listeners.PlayerDropItemListener;
import com.scarabcoder.testplugin.listeners.PlayerJoinListener;

public class Main extends JavaPlugin{
	
	public static Plugin plugin;
	
	public static List<UUID> muted = new ArrayList<UUID>();
	
	public static List<UUID> vanished = new ArrayList<UUID>();
	
	@Override
	public void onEnable(){
		
		Main.plugin = this;
		
		plugin.getConfig().options().copyDefaults(true);
		plugin.saveConfig();
		
		this.getServer().getPluginManager().registerEvents(new InventoryListener(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerDropItemListener(), this);
		this.getServer().getPluginManager().registerEvents(new InteractListener(), this);
		
		
		Bukkit.getPluginCommand("donor").setExecutor(new DonorCommand());
		Bukkit.getPluginCommand("mutechat").setExecutor(new MutechatCommand());
		Bukkit.getPluginCommand("vanish").setExecutor(new VanishCommand());
		Bukkit.getPluginCommand("teamspeak").setExecutor(new InfoCommands());
		Bukkit.getPluginCommand("website").setExecutor(new InfoCommands());
		Bukkit.getPluginCommand("twitter").setExecutor(new InfoCommands());
		
	}
	
	@Override
	public void onDisable(){
		List<UUID> ids = new CopyOnWriteArrayList<UUID>(vanished);
		for(UUID id : ids){
			VanishCommand.exitVanish(Bukkit.getPlayer(id));
		}
	}
	
	public static Plugin getPlugin(){
		return plugin;
	}
}
