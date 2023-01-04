package com.frozenbloo.frostcore.Command.Commands.Util;

import com.frozenbloo.frostcore.Command.Command;
import com.frozenbloo.frostcore.Utils.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Ping extends Command {

    public Ping() {
        super("ping",
                new String[]{"connection"},
                "Returns the time in milliseconds for an action you send to register on the server.",
                "frost.player");
    }

    @Override
    public void execute(CommandSender sender , String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            sender.sendMessage(ChatUtils.Coloured("&#3AB0FF🌊 &#F9F2ED Pong &8[&#F9F2ED" + player.getPing() +"&#F9F2EDms&8]"));
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender , String[] args) {
        return null;
    }
}
