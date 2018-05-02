package com.kyloka.forcePlugin;

import com.kyloka.forcePlugin.commands.Commandforce;
import com.kyloka.forcePlugin.events.EventActivateForce;
import com.kyloka.forcePlugin.items.WeaponEffect;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * Created by Matthew on 9/21/2016.
 */
public class LightSaberPlugin extends JavaPlugin {

    private PluginManager pluginManager;
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new EventActivateForce(this),this);
        getCommand("lightsaber").setExecutor(new Commandforce(this));
        WeaponEffect.getConfig(this);
        ConfigurationSection configSec = getConfig().getConfigurationSection("EFFECT");
        for(String key:configSec.getKeys(false)){
            getLogger().log(Level.INFO,key);
        }

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
