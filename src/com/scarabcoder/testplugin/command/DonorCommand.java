package com.scarabcoder.testplugin.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.scarabcoder.testplugin.gui.ColorsGui;

public class DonorCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		if(arg0 instanceof Player){
			Player p = (Player) arg0;
			if(p.hasPermission("donor.color")){
				ColorsGui.openGui(p);
			}else{
				p.sendMessage(ChatColor.RED + "This is a donor only command; you can donate at http://www.serenitypvp.com/donate");
			}
		}else{
			arg0.sendMessage(ChatColor.RED + "Player-only command!");
		}
		
		return true;
	}
	
}
