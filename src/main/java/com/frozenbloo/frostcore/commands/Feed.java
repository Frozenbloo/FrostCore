package com.frozenbloo.frostcore.commands;

import com.frozenbloo.frostcore.Core;
import com.frozenbloo.frostcore.managers.ConfigManager;
import com.frozenbloo.frostcore.utils.ChatUtils;
import com.frozenbloo.frostcore.utils.CommandUtils;
import com.frozenbloo.frostlibrary.command.FrostCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

import static com.frozenbloo.frostlibrary.string.colour.StringColour.HexColour;

public class Feed extends FrostCommand {

    public Feed() {
        super("feed",
                new String[]{},
                "",
                "frost.player",
                ConfigManager.noPermission);
    }

    @Override
    public void execute(CommandSender sender , String[] args) {
        Player player = CommandUtils.handleTarget(sender, args);
        if (player.hasPermission(this.getPermission())){
            if (player == null) return;
            if (player != sender) {
                sender.sendMessage(HexColour("&#3AB0FF🌊 &#F9F2EDYou have fed " + player.getName()));
                player.sendMessage(HexColour("&#3AB0FF🌊 &#F9F2EDYou feel a sharp chill as your hunger is suddenly filled"));
            } else player.sendMessage(HexColour("&#3AB0FF🌊 &#F9F2EDYou feel a sharp chill as your hunger is suddenly filled"));
            player.setFoodLevel(20);
            return;
        }
        player.sendMessage(HexColour(this.getPermissionMessage()));
    }

    @Override
    public List<String> onTabComplete(String[] args) {
        return null;
    }
}
