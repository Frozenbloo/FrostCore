package com.frozenbloo.frostcore.command;

import com.frozenbloo.frostcore.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public abstract class Command extends BukkitCommand {

    /**
     * Custom Command Class
     * I decided to use this as the command does not need to be added into the plugin.yml
     * allowing me to add commands with aliases using a config.
     * @param command The Command to be executed
     * @param aliases Any Command Aliases
     * @param description The Command Description
     * @param permission The Permission to use the Command
     */
    public Command(String command, String[] aliases, String description, String permission) {
        super(command);

        this.setAliases(Arrays.asList(aliases));
        this.setDescription(description);
        this.setPermission(permission);
        this.setPermissionMessage(ChatUtils.Coloured("&#F87474⚠ &#F9F2EDNo Permission"));

        try {
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            CommandMap map = (CommandMap) field.get(Bukkit.getServer());
            map.register(command, this);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean execute(@NotNull CommandSender sender , @NotNull String commandLabel , @NotNull String[] args) {
        execute(sender, args);
        return false;
    }

    public abstract void execute(CommandSender sender, String[] args);

    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender , @NotNull String alias , @NotNull String[] args) throws IllegalArgumentException {
        return onTabComplete(args);
    }
    public abstract List<String> onTabComplete(String[] args);

    public abstract List<String> onTabComplete(CommandSender sender , String[] args);
}