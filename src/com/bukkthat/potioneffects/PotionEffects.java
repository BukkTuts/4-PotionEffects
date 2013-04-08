package com.bukkthat.potioneffects;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionEffects extends JavaPlugin {

	// This method uses the same onCommand setup as the previous tutorial.
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Check the command name, using #equalsIgnoreCase so the case won't matter.
		if(cmd.getName().equalsIgnoreCase("dizzy")) {
			// Check if they are a player
			if(sender instanceof Player) {
				// Now we can cast to Player safely
				Player player = (Player) sender;
				/*
				 * Use Player#addPotionEffect to add the potion effect.
				 * The only parameter it takes is a PotionEffect object.
				 * The constructor for a PotionEffect is a PotionEffectType,
				 * an int, which is the duration in ticks, (20 per second)
				 * an int, which is the amplifier.
				 */
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 1));
				// Tell them what happened.
				player.sendMessage(ChatColor.GOLD + "You being to feel dizzy!");
			} else {
				// Yell at the console, because it can't be dizzy.
				sender.sendMessage(ChatColor.RED + "Only a player can do that!");
			}
			// If the command wasn't /dizzy, check if it was /slow
		} else if(cmd.getName().equalsIgnoreCase("slow")) {
			// Check if they are a player
			if(sender instanceof Player) {
				// Now we can cast to Player safely
				Player player = (Player) sender;
				/*
				 * Use Player#addPotionEffect to add the potion effect.
				 * The only parameter it takes is a PotionEffect object.
				 * The constructor for a PotionEffect is a PotionEffectType,
				 * an int, which is the duration in ticks, (20 per second)
				 * an int, which is the amplifier.
				 */
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
				// Tell them what happened.
				player.sendMessage(ChatColor.GOLD + "You being to feel aged!");
			} else {
				// Yell at the console, because it can't be slowed.
				sender.sendMessage(ChatColor.RED + "Only a player can do that!");
			}
		}
		// Return true, not false so the usage is not displayed.
		return true;
	}

}
