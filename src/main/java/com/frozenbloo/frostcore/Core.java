package com.frozenbloo.frostcore;

import com.frozenbloo.frostcore.commands.Feed;
import com.frozenbloo.frostcore.commands.Ping;
import com.frozenbloo.frostcore.events.MOTDPingEvent;
import com.frozenbloo.frostcore.events.WelcomeEvent;
import com.frozenbloo.frostcore.managers.ConfigManager;
import com.frozenbloo.frostlibrary.FrostLibrary;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    public static Core plugin;

    private static FileConfiguration config;

    /**TODO LINKS
     https://colorhunt.co/palette/f9f2ed3ab0ffffb562f87474
    **/
    @Override
    public void onEnable() {
        FrostLibrary.setPlugin(this);
        this.plugin = this;
        new ConfigManager();
        System.out.println();
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
        config = getConfig();
        //region Register Commands
        new Ping();
        new Feed();
        //endregion

        //region Register Listeners
        getServer().getPluginManager().registerEvents(new MOTDPingEvent(), this);
        getServer().getPluginManager().registerEvents(new WelcomeEvent(), this);
        //endregion
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
