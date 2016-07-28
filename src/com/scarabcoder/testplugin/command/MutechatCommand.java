package com.scarabcoder.testplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.scarabcoder.testplugin.Main;

import net.md_5.bungee.api.ChatColor;

public class MutechatCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(arg0 instanceof Player){
			Player p = (Player) arg0;
			if(Main.muted.contains(p.getUniqueId())){
				Main.muted.remove(p.getUniqueId());
				p.sendMessage(ChatColor.GREEN + "Unmuted player chat messages.");
			}else{
				p.sendMessage(ChatColor.GREEN + "Muted player chat messages.");
				Main.muted.add(p.getUniqueId());
			}
		}else{
			arg0.sendMessage(ChatColor.RED + "Player-only command!");
		}
		return true;
	}

}
