package com.scarabcoder.testplugin.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class ColorsGui {
	
	public static void openGui(Player p){
		List<ChatColor> colors = new ArrayList<ChatColor>(Arrays.asList(ChatColor.values()));
		colors.remove(ChatColor.MAGIC);
		colors.remove(ChatColor.BOLD);
		colors.remove(ChatColor.ITALIC);
		colors.remove(ChatColor.RESET);
		colors.remove(ChatColor.UNDERLINE);
		colors.remove(ChatColor.YELLOW);
		colors.remove(ChatColor.LIGHT_PURPLE);
		colors.remove(ChatColor.STRIKETHROUGH);
		colors.remove(ChatColor.DARK_BLUE);
		colors.remove(ChatColor.DARK_RED);
		colors.remove(ChatColor.DARK_GRAY);
		colors.remove(ChatColor.DARK_GREEN);
		Inventory inv = Bukkit.createInventory(null, (int) Math.ceil((double)colors.size() / 9d) * 9, ChatColor.GREEN + "Username color");
		int i = 0;
		for(ChatColor color : colors){
			
			ItemStack stack = new ItemStack(Material.WOOL);
			stack.setDurability((short)ChatColorToData(color));
			ItemMeta meta = stack.getItemMeta();
			meta.setDisplayName(color + "Change Your Username Color");
			stack.setItemMeta(meta);
			inv.setItem(i, stack);
			i += 1;
		}
		p.openInventory(inv);
		
	}
	public static int ChatColorToData(ChatColor color){
		switch(color){
		case AQUA:
			return 3;
		case BLACK:
			return 15;
		case BLUE:
			return 11;
		case DARK_AQUA:
			return 9;
		case DARK_PURPLE:
			return 2;
		case RED:
			return 14;
		case GOLD:
			return 4;
		case GRAY:
			return 8;
		case GREEN:
			return 5;
		case WHITE:
			return 0;
			
		default:
			return 0;
		}
	}
}
