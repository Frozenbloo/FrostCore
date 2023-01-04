package com.frozenbloo.frostcore.Command.Commands.Util;

import com.frozenbloo.frostcore.Command.Command;
import com.frozenbloo.frostcore.Utils.ChatUtils;
import com.frozenbloo.frostcore.Utils.CommandUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Feed extends Command {

    /**
     * Default Constructor
     */
    public Feed() {
        super("feed",
                new String[]{},
                "",
                "frost.player");
    }

    @Override
    public void execute(CommandSender sender , String[] args) {
        Player player = CommandUtils.handleTarget(sender, args);
        if (player == null) return;
        if (player != sender) {
            sender.sendMessage(ChatUtils.Coloured("&#3AB0FF🌊 &#F9F2EDYou have fed " + player.getName()));
            player.sendMessage(ChatUtils.Coloured("&#3AB0FF🌊 &#F9F2EDYou feel a sharp chill as your hunger is suddenly filled"));
        } else player.sendMessage(ChatUtils.Coloured("&#3AB0FF🌊 &#F9F2EDYou feel a sharp chill as your hunger is suddenly filled"));
        player.setFoodLevel(20);
        player.setFreezeTicks(20);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender , String[] args) {
        return null;
    }
}
