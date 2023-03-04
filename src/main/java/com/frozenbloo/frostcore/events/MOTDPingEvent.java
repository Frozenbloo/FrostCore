package com.frozenbloo.frostcore.events;

import com.frozenbloo.frostcore.managers.ConfigManager;
import com.frozenbloo.frostcore.utils.ChatUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import static com.frozenbloo.frostlibrary.string.colour.StringColour.HexColour;

public class MOTDPingEvent implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e){
        e.setMotd(HexColour(ConfigManager.serverMOTD));
    }
}
