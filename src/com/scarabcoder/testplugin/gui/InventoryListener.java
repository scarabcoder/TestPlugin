package com.scarabcoder.testplugin.gui;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import com.scarabcoder.testplugin.Main;

public class InventoryListener implements Listener{
	
	@EventHandler
	public void inventoryClick(InventoryClickEvent e){
		if(e.getInventory().getName().equals(ChatColor.GREEN + "Username color")){
		if(e.getCurrentItem() != null){
			if(e.getCurrentItem().getItemMeta() != null){
				if(e.getCurrentItem().getItemMeta().getDisplayName() != null){
						e.setCancelled(true);
						Player p = (Player) e.getWhoClicked();
						
						p.setDisplayName(e.getCurrentItem().getItemMeta().getDisplayName().substring(0, 2) + p.getName() + ChatColor.RESET);
						Main.getPlugin().getConfig().set("players." + p.getUniqueId().toString() + ".color", e.getCurrentItem().getItemMeta().getDisplayName().substring(0, 2));
						Main.getPlugin().saveConfig();
						p.sendMessage("Changed your username to " + e.getCurrentItem().getItemMeta().getDisplayName().substring(0, 2) + p.getName() + ChatColor.RESET);
						e.setCancelled(true);
						p.closeInventory();
					}
				}
			}
		}
		if(e.getInventory().getType().equals(InventoryType.PLAYER)){
			if(Main.vanished.contains(e.getWhoClicked().getUniqueId())){
				if(e.getSlot() == 40 || e.getSlot() == 3 || e.getSlot() == 36){
					e.setCancelled(true);
					((Player)e.getWhoClicked()).updateInventory();
				}
			}
		}
	}

}
