package com.kyloka.forcePlugin;

import com.kyloka.forcePlugin.commands.Commandforce;
import com.kyloka.forcePlugin.events.EventActivateForce;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 9/21/2016.
 */
public class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new EventActivateForce(),this);
        getCommand("lightsaber").setExecutor(new Commandforce());
        instance = this;
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
    public static Main getInstance(){
        return instance;
    }
}
