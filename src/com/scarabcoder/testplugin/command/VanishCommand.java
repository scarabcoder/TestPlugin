package com.scarabcoder.testplugin.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.scarabcoder.testplugin.Main;

public class VanishCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(arg0 instanceof Player){
			Player p = (Player) arg0;
			if(p.hasPermission("vanish")){
				if(Main.vanished.contains(p.getUniqueId())){
					exitVanish(p);
				}else{
					p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1), false);
					ItemStack rand = new ItemStack(Material.FEATHER);
					ItemMeta meta = rand.getItemMeta();
					meta.setDisplayName(ChatColor.RESET.toString() + ChatColor.BOLD + "Teleport to random player");
					rand.setItemMeta(meta);
					
					ItemStack ban = new ItemStack(Material.ANVIL);
					meta.setDisplayName(ChatColor.RESET.toString() + ChatColor.BOLD + "Ban Player");
					ban.setItemMeta(meta);
					
					ItemStack leave = new ItemStack(Material.INK_SACK);
					meta.setDisplayName(ChatColor.RESET.toString() + ChatColor.BOLD + "Exit vanish");
					leave.setDurability((short)1);
					leave.setItemMeta(meta);
					
					Inventory inv = p.getInventory();
					inv.clear();
					inv.setItem(0, rand);
					inv.setItem(4, ban);
					inv.setItem(8, leave);
					p.updateInventory();
					Main.vanished.add(p.getUniqueId());
					
					p.sendMessage(ChatColor.GREEN + "Entered Vanish mode.");
				}
			}else{
				p.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
			}
		}else{
			arg0.sendMessage(ChatColor.RED + "Player-only command!");
		}
		return true;
	}
	
	public static void exitVanish(Player p){
		Main.vanished.remove(p.getUniqueId());
		p.getInventory().clear();
		p.updateInventory();
		p.removePotionEffect(PotionEffectType.INVISIBILITY);
		p.sendMessage(ChatColor.GREEN + "Exited vanish mode.");
	}

}
