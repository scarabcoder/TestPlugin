package com.scarabcoder.testplugin.listeners;

import com.scarabcoder.testplugin.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener{
	@EventHandler
	public void playerDrop(PlayerDropItemEvent e){
		if(Main.vanished.contains(e.getPlayer().getUniqueId())){
			int slot = e.getPlayer().getInventory().getHeldItemSlot();
			if(slot == 0 || slot == 4 || slot == 8)
			e.setCancelled(true);
		}
	}
}
