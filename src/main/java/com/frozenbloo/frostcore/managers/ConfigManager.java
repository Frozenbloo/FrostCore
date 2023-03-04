package com.frozenbloo.frostcore.managers;

import com.frozenbloo.frostcore.Core;

import java.util.List;

public class ConfigManager {

    //region Enable
    public static boolean enableWelcomeMessages;
    //endregion

    //region Messages
    public static String serverMOTD;

    public static String noPermission;
    public static String notOnline;
    public static String welcomeJoinMessage;
    public static String welcomeLeaveMessage;
    public static String welcomeTitleMessage;
    public static String welcomeSubtitleMessage;
    public static List<String> welcomeMessage;
    //endregion

    //region IntValues
    public static int welcomeMessageDelay, welcomeFadein, welcomeStay, welcomeFadeout;
    //endregion

    public ConfigManager() {

        noPermission = Core.plugin.getConfig().getString("noPermission");
        serverMOTD = Core.plugin.getConfig().getString("MOTD");

        enableWelcomeMessages = Core.plugin.getConfig().getBoolean("welcomeMessages");

        welcomeJoinMessage = Core.plugin.getConfig().getString("joinMessage");
        welcomeLeaveMessage = Core.plugin.getConfig().getString("quitMessage");
        welcomeTitleMessage = Core.plugin.getConfig().getString("joinTitleMessage");
        welcomeSubtitleMessage = Core.plugin.getConfig().getString("joinSubtitleMessage");

        welcomeMessageDelay = Core.plugin.getConfig().getInt("welcomeMessageDelay");
        welcomeMessage = Core.plugin.getConfig().getStringList("welcomeMessage");

        welcomeFadein = Core.plugin.getConfig().getInt("joinTitle.fadeIn");
        welcomeStay = Core.plugin.getConfig().getInt("joinTitle.stay");
        welcomeFadeout = Core.plugin.getConfig().getInt("joinTitle.fadeOut");
    }
}
