package com.kyloka.forcePlugin.commands;

import com.kyloka.forcePlugin.items.Weapons;
import com.kyloka.forcePlugin.object.ForceItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 9/21/2016.
 */
public class Commandforce implements CommandExecutor {
    public ForceItem test = new ForceItem();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("test")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Fuck you");
            }
            Player target = (Player) sender;

            target.getInventory().addItem(Weapons.redLightsaberHandle().createMaterial());

        }
        return false;
    }
}
