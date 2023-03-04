package com.frozenbloo.frostcore.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.frozenbloo.frostlibrary.string.colour.StringColour.HexColour;

public final class CommandUtils {

    /**
     * Checks to see if the argument is a valid player, if not returns null
     * @param sender The Command Sender.
     * @param args The Supposed targeted player.
     * @return The decided player for the command, albeit the sender, the targeted player, or null.
     */
    public static Player handleTarget(CommandSender sender, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) return (Player) sender;
            else {
                sender.sendMessage(HexColour("&#FFB562⚠ &#F9F2EDYou need to be a player to execute this command!"));
                return null;
            }
        }
        if (Bukkit.getPlayer(args[0]) == null){
            sender.sendMessage(HexColour("&#FFB562⚠ &#F9F2EDThat player is either offline or doesn't exist!"));
            return null;
        }
        return Bukkit.getPlayer(args[0]);
    }

    public static boolean handleConsole(CommandSender sender) {
        if (sender instanceof Player) return true;
        else {
            sender.sendMessage(HexColour("&#FFB562⚠ &#F9F2EDYou need to be a player to execute this command!"));
            return false;
        }
    }
}
