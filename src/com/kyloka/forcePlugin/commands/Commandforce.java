package com.kyloka.forcePlugin.commands;

import com.kyloka.forcePlugin.LightSaberPlugin;
import com.kyloka.forcePlugin.items.WeaponList;
import com.kyloka.forcePlugin.object.ForceItem;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 9/21/2016.
 */
public class Commandforce implements CommandExecutor {
    public ForceItem test = new ForceItem();
    private LightSaberPlugin instance;
    public Commandforce(LightSaberPlugin instance){
        this.instance = instance;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("lightsaber") && sender.isOp()) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command cannot be used on console");
            }
            Player target = (Player) sender;

//            target.getInventory().addItem(Weapons.redLightsaberHandle().createMaterial());
//            target.getInventory().addItem(Weapons.blueLightsaberHandle().createMaterial());
//            target.getInventory().addItem(Weapons.greenLightsaberHandle().createMaterial());
//            target.getInventory().addItem(Weapons.purpleLightsaberHandle().createMaterial());
            target.getInventory().addItem(WeaponList.RED_HANDLE.getForceItem().createMaterial());

        }
        if (command.getName().equalsIgnoreCase("lightsaber") && !sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "You have no access to this command.");

        }
        return false;
    }
}
