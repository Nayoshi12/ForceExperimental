package com.kyloka.forcePlugin;

import com.kyloka.forcePlugin.commands.Commandforce;
import com.kyloka.forcePlugin.events.EventActivateForce;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 9/21/2016.
 */
public class LightSaberPlugin extends JavaPlugin {

    private PluginManager pluginManager;
    @Override
    public void onEnable() {
        pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new EventActivateForce(this),this);
        getCommand("lightsaber").setExecutor(new Commandforce(this));

    }
    public PluginManager getPluginManager(){
        return pluginManager;
    }
    @Override
    public void onDisable() {
        super.onDisable();
    }
//    public static LightSaberPlugin getInstance(){
//        return instance;
//    }
}
