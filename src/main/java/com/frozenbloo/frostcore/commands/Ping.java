package com.frozenbloo.frostcore.commands;

import com.frozenbloo.frostcore.managers.ConfigManager;
import com.frozenbloo.frostlibrary.command.FrostCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

import static com.frozenbloo.frostlibrary.string.colour.StringColour.HexColour;

public class Ping extends FrostCommand {

    public Ping() {
        super("ping",
                new String[]{"connection"},
                "Returns the time in milliseconds for an action you send to register on the server.",
                "frost.player",
                ConfigManager.noPermission);
    }

    @Override
    public void execute(CommandSender sender , String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            sender.sendMessage(HexColour("&#3AB0FF🌊 &#F9F2ED Pong &8[&#F9F2ED" + player.getPing() +"&#F9F2EDms&8]"));
        }
    }

    @Override
    public List<String> onTabComplete(String[] args) {
        return null;
    }
}
