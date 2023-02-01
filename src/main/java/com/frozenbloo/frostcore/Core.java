package com.frozenbloo.frostcore;

import com.frozenbloo.frostcore.command.commands.player.Hat;
import com.frozenbloo.frostcore.command.commands.util.Feed;
import com.frozenbloo.frostcore.command.commands.util.Ping;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    /**TODO LINKS
     https://colorhunt.co/palette/f9f2ed3ab0ffffb562f87474
    **/
    @Override
    public void onEnable() {
        //region Register Commands
        new Ping();
        new Feed();
        new Hat();
        //endregion

        //region Register Listeners
        //endregion
        Bukkit.getServer().getConsoleSender().sendMessage("It is the life of the crystal, the architect of the flake, the fire of the frost, the soul of the sunbeam.");
        Bukkit.getServer().getConsoleSender().sendMessage("This crisp winter air is full of it.");
        Bukkit.getServer().getConsoleSender().sendMessage("All that is gold does not glitter, not all those who wander are lost;");
        Bukkit.getServer().getConsoleSender().sendMessage("the old that is strong does not wither, deep roots are not reached by the frost.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
