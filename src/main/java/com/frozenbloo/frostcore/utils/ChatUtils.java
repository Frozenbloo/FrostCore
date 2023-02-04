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

    private final static int CENTER_PX = 154;

    public static String CenteredMessage(String message){
        String[] lines = ChatColor.translateAlternateColorCodes('&', message).split("\n", 40);
        StringBuilder returnMessage = new StringBuilder();


        for (String line : lines) {
            int messagePxSize = 0;
            boolean previousCode = false;
            boolean isBold = false;

            for (char c : line.toCharArray()) {
                if (c == '§') {
                    previousCode = true;
                } else if (previousCode) {
                    previousCode = false;
                    isBold = c == 'l';
                } else {
                    DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                    messagePxSize = isBold ? messagePxSize + dFI.getBoldLength() : messagePxSize + dFI.getLength();
                    messagePxSize++;
                }
            }
            int toCompensate = CENTER_PX - messagePxSize / 2;
            int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
            int compensated = 0;
            StringBuilder sb = new StringBuilder();
            while(compensated < toCompensate){
                sb.append(" ");
                compensated += spaceLength;
            }
            returnMessage.append(sb.toString()).append(line).append("\n");
        }

        return returnMessage.toString();
    }
}
