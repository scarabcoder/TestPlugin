package com.scarabcoder.testplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.scarabcoder.testplugin.Main;

public class PlayerJoinListener implements Listener {
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		if(Main.getPlugin().getConfig().contains("players." + e.getPlayer().getUniqueId().toString() + ".color")){
			e.getPlayer().setDisplayName((Main.getPlugin().getConfig().getString("players." + e.getPlayer().getUniqueId().toString() + ".color") + e.getPlayer().getName() + ChatColor.RESET));
			
			
		}
	}
}
