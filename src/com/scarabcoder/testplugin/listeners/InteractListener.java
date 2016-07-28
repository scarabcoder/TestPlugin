package com.scarabcoder.testplugin.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.scarabcoder.testplugin.command.VanishCommand;

import net.md_5.bungee.api.ChatColor;

public class InteractListener implements Listener{
	
	@EventHandler
	public void playerInteract(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))){
			if(e.getItem() != null){
				if(e.getItem().getItemMeta() != null){
					if(e.getItem().getItemMeta().getDisplayName() != null){
						if(e.getItem().getItemMeta().getDisplayName().equals(ChatColor.RESET.toString() + ChatColor.BOLD + "Teleport to random player")){
							List<Player> players = new ArrayList<Player>(Bukkit.getOnlinePlayers());
							players.remove(e.getPlayer());
							e.getPlayer().teleport(players.get(new Random().nextInt(players.size())));
						}else if(e.getItem().getItemMeta().getDisplayName().equals(ChatColor.RESET.toString() + ChatColor.BOLD + "Ban Player")){
							//TODO Finish this
						}else if(e.getItem().getItemMeta().getDisplayName().equals(ChatColor.RESET.toString() + ChatColor.BOLD + "Exit vanish")){
							VanishCommand.exitVanish(e.getPlayer());
						}
					}
				}
			}
		}
	}


}
