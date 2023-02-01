package com.frozenbloo.frostcore.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ChatUtils {

    /**
     * Regex pattern for hex
     */
    private static final Pattern hexPattern = Pattern.compile("&(#\\w{6})");

    /**
     * Translates strings from & to colour codes.
     * @param str The String to translate into COLOUR
     * @return The translated String
     */
    public static String Coloured(String str) {

        Matcher matcher = hexPattern.matcher(ChatColor.translateAlternateColorCodes('&', str));
        StringBuffer buffer = new StringBuffer();

        while (matcher.find())
            matcher.appendReplacement(buffer, ChatColor.of(matcher.group(1)).toString());

        return matcher.appendTail(buffer).toString();
    }
}
