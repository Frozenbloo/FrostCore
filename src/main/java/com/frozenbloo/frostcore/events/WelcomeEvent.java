package com.frozenbloo.frostcore.events;

import com.frozenbloo.frostcore.Core;
import com.frozenbloo.frostcore.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static com.frozenbloo.frostlibrary.player.PlayerUtils.MessagePlayer;
import static com.frozenbloo.frostlibrary.string.colour.StringColour.HexColour;

public class WelcomeEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (ConfigManager.enableWelcomeMessages) e.setJoinMessage(HexColour(ConfigManager.welcomeJoinMessage.replace("%player%", player.getName())));
        else e.setJoinMessage("");

        player.sendTitle(HexColour(ConfigManager.welcomeTitleMessage.replace("%player%", player.getName())),
                HexColour(ConfigManager.welcomeSubtitleMessage.replace("%player%", player.getName())),
                ConfigManager.welcomeFadein,
                ConfigManager.welcomeStay,
                ConfigManager.welcomeFadeout);

        Bukkit.getScheduler().runTaskLater(Core.plugin, (() -> {
            for (Object msg : ConfigManager.welcomeMessage) {
                MessagePlayer(player, msg.toString().replace("%player%", player.getName()));
            }
        }), ConfigManager.welcomeMessageDelay);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if (ConfigManager.enableWelcomeMessages) e.setQuitMessage(HexColour(ConfigManager.welcomeLeaveMessage.replace("%player%", e.getPlayer().getName())));
        else e.setQuitMessage("");
    }
}
