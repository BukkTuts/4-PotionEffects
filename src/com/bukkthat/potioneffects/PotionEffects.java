package com.bukkthat.potioneffects;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

// Notice that we don't implement Listener.  We don't listen for
// events, so there's no need to implement Listener.
public class PotionEffects extends JavaPlugin {

	// This method uses the same onCommand setup as the previous tutorial.
	// If you've forgotten what the different arguments mean, please refer to that tutorial.
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Check the command name, using #equalsIgnoreCase so the case won't matter.
		// Unlike the previous tutorial, we need to check the name of the command.
		// This is because we have multiple commands registered to our plugin,
		// and we aren't using a CommandExecutor(CommandExecutors will be explained
		// in a later tutorial).  This means whenever they type any one of the commands
		// in our plugin.yml this method is invoked, and for us to perform the correct
		// action on their command, we need to check which command they're using.
		if(cmd.getName().equalsIgnoreCase("dizzy")) {
			// Check if they are a player
			// If we cast the sender to a Player without
			// checking if it's a Player, we will throw
			// a ClassCastException.  This is VERY BAD.
			// Always avoid throwing uncatched exceptions.
			if(sender instanceof Player) {
				// Now we can cast to Player safely
				Player player = (Player) sender;
				/*
				 * Use Player#addPotionEffect to add the potion effect.
				 * The only parameter it takes is a PotionEffect object.
				 * The constructor for a PotionEffect is a PotionEffectType,
				 * which is the type of the potion,
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
				player.sendMessage(ChatColor.GOLD + "You begin to feel aged!");
			} else {
				// Yell at the console, because it can't be slowed.
				sender.sendMessage(ChatColor.RED + "Only a player can do that!");
			}
		}
		// Notice that we don't do anything if it doesn't equal one of our two commands.
		// There's no reason to add an "else" block as these two commands are the only two commands
		// that our plugin can handle.  We could technically handle the /slow command within an else
		// block, since the command would have to be /slow if it wasn't /dizzy.  However, we don't do
		// that on purpose.  It is much easier to read the code if we compare the command name for each
		// command(we don't want to end up guessing what the command is), and it's easier to add another 
		// command later.
		
		// Return true, not false so the usage message is not displayed.
		return true;
	}

}
