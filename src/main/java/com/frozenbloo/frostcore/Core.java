package com.frozenbloo.frostcore;

import com.frozenbloo.frostcore.Command.Commands.Basic.Feed;
import com.frozenbloo.frostcore.Command.Commands.Basic.Ping;
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
        //endregion

        //region Register Listeners
        //endregion
        System.out.println("It is the life of the crystal, the architect of the flake, the fire of the frost, the soul of the sunbeam. This crisp winter air is full of it. All that is gold does not glitter, not all those who wander are lost; the old that is strong does not wither, deep roots are not reached by the frost.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
