package com.bukkthat.potioneffects;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionEffects extends JavaPlugin {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("dizzy")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 1));
				player.sendMessage(ChatColor.GOLD + "You being to feel dizzy!");
			} else {
				sender.sendMessage(ChatColor.RED + "Only a player can do that!");
			}
		} else if(cmd.getName().equalsIgnoreCase("slow")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
				player.sendMessage(ChatColor.GOLD + "You being to feel aged!");
			} else {
				sender.sendMessage(ChatColor.RED + "Only a player can do that!");
			}
		}
		return true;
	}

}
