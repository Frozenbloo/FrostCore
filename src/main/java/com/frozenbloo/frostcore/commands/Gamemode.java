package com.frozenbloo.frostcore.commands;

import com.frozenbloo.frostcore.managers.ConfigManager;
import com.frozenbloo.frostcore.utils.CommandUtils;
import com.frozenbloo.frostlibrary.command.FrostCommand;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.frozenbloo.frostlibrary.string.colour.StringColour.HexColour;

public class Gamemode extends FrostCommand {

    public Gamemode(){
        super("gamemode",
                new String[]{"gm"},
                "Gamemode",
                "frost.admin",
                ConfigManager.noPermission);
    }

    @Override
    public void execute(CommandSender commandSender , String[] strings) {
        if (CommandUtils.handleConsole(commandSender)){
            Player player = (Player) commandSender;
            if (strings.length == 0) return;
            if (strings.length == 1){
                strings[0] = strings[0].toLowerCase().replace("1","creative").replace("0","survival").replace("2","adventure").replace("3","spectator");

                ArrayList<String> gmTypes = new ArrayList(Arrays.asList("survival", "creative", "adventure", "spectator"));
                if (gmTypes.contains(strings[0].toLowerCase())) {
                    player.setGameMode(GameMode.valueOf(strings[0].toUpperCase()));
                    player.sendMessage(HexColour(ConfigManager.gamemodeMessage.replace("%gamemode%",strings[0])));
                }
            }
        }
    }

    @Override
    public List<String> onTabComplete(String[] strings) {
        return Arrays.stream(new String[]{"Survival", "Creative", "Adventure", "Spectator"}).toList();
    }
}
