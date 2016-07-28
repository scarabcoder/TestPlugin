package com.scarabcoder.testplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class InfoCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(arg2.equalsIgnoreCase("website")){
			arg0.sendMessage(ChatColor.GREEN + "Our website: http://www.serenitypvp.net");
		}else if(arg2.equalsIgnoreCase("teamspeak") || (arg2.equalsIgnoreCase("ts"))){
			arg0.sendMessage(ChatColor.GREEN + "Our Teamspeak: ts.serenitypvp.net");
		}else if(arg2.equalsIgnoreCase("twitter")){
			arg0.sendMessage(ChatColor.GREEN + "Our Twitter: http://www.twitter.com/Serenity_PvP");
		}
		return true;
	}

}
