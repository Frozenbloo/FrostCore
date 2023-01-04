package com.frozenbloo.frostcore.Command.Commands.Player;

import com.frozenbloo.frostcore.Command.Command;
import com.frozenbloo.frostcore.Utils.ChatUtils;
import com.frozenbloo.frostcore.Utils.CommandUtils;
import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Hat extends Command {

    public Hat() {
        super("hat",
                new String[]{},
                "",
                "frost.player");
    }
    @Override
    public void execute(CommandSender sender , String[] args) {
        if (CommandUtils.handleConsole(sender)) {
            Player player = (Player) sender;
            if (args.length == 0 || args[0].contentEquals("wear")) {
                final ItemStack hand = player.getInventory().getItemInMainHand();
                if (hand == null || hand.getType() == Material.AIR) {
                    player.sendMessage(ChatUtils.Coloured("&#FFB562⚠ &#F9F2EDPlease hold the item you would like to wear"));
                    return;
                }
                final ItemStack head = player.getInventory().getHelmet();
                player.getInventory().setHelmet(hand);
                player.getInventory().setItemInMainHand(head);
                player.sendMessage(ChatUtils.Coloured("&#3AB0FF🌊 &#F9F2EDHat changed"));
            }
            else if (args[0].contentEquals("remove")) {
                final ItemStack head = player.getInventory().getHelmet();
                if (head == null || head.getType() == Material.AIR) {
                    player.sendMessage(ChatUtils.Coloured("&#FFB562⚠ &#F9F2EDYou aren't wearing anything"));
                    return;
                }
                final ItemStack air = new ItemStack(Material.AIR);
                player.getInventory().setHelmet(air);
                player.getInventory().addItem(head);
                player.sendMessage(ChatUtils.Coloured("&#3AB0FF🌊 &#F9F2EDHat removed"));
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender , String[] args) {
        if (args.length == 1) {
            return Lists.newArrayList("remove", "wear");
        } else {
            return null;
        }
    }
}
