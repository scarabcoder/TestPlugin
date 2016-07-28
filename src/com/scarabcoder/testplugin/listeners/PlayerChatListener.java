package com.scarabcoder.testplugin.listeners;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.scarabcoder.testplugin.Main;

public class PlayerChatListener implements Listener {
	@EventHandler
	public void playerSendChat(AsyncPlayerChatEvent e){
		Set<Player> players = e.getRecipients();
		for(Player p : Bukkit.getOnlinePlayers()){
			if(Main.muted.contains(e.getPlayer().getUniqueId())){
				players.remove(p);
			}
		}
	}
}
