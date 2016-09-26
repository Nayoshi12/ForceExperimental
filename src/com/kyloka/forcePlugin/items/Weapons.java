package com.kyloka.forcePlugin.items;

import com.kyloka.forcePlugin.object.ForceItem;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;

/**
 * Created by Matthew on 9/23/2016.
 */
public class Weapons {
    public static ForceItem redlightsaber(){
        ForceItem item = new ForceItem();
        item.setName("§4Red §fLightsaber");
        item.setMaterial(Material.DIAMOND_SWORD);
        item.setDurability(2);
        item.setUnbreakable(true);
        return item;
    }
    public static ForceItem redLightsaberHandle(){
        ForceItem item = new ForceItem();

        item.setName("§4Red §fLightsaber");
        item.addKeyword("Red");
        item.setMaterial(Material.DIAMOND_SWORD);
        item.setDurability(33);
        item.setUnbreakable(true);
        return item;
    }
    public static ForceItem bluelightsaber(){
        ForceItem item = new ForceItem();
        item.setName("§1Blue §fLightsaber");
        item.setMaterial(Material.DIAMOND_SWORD);
        item.setDurability(10);
        item.setUnbreakable(true);
        return item;
    }
    public static ForceItem blueLightsaberHandle(){
        ForceItem item = new ForceItem();

        item.setName("§1Blue §fLightsaber");
        item.addKeyword("Blue");
        item.setMaterial(Material.DIAMOND_SWORD);
        item.setDurability(33);
        item.setUnbreakable(true);
        return item;
    }
        public static ForceItem greenlightsaber(){
        ForceItem item = new ForceItem();
        item.setName("§2Green §fLightsaber");
        item.setMaterial(Material.DIAMOND_SWORD);
        item.setDurability(18);
        item.setUnbreakable(true);
        return item;
    }
    public static ForceItem greenLightsaberHandle(){
        ForceItem item = new ForceItem();

        item.setName("§2Green §fLightsaber");
        item.addKeyword("Red");
        item.setMaterial(Material.DIAMOND_SWORD);
        item.setDurability(33);
        item.setUnbreakable(true);
        return item;
    }
    public static ForceItem purplelightsaber(){
        ForceItem item = new ForceItem();
        item.setName("§5Purple §fLightsaber");
        item.setMaterial(Material.DIAMOND_SWORD);
        item.setDurability(25);
        item.setUnbreakable(true);
        return item;
    }
    public static ForceItem purpleLightsaberHandle(){
        ForceItem item = new ForceItem();

        item.setName("§5Purple §fLightsaber");
        item.addKeyword("Red");
        item.setMaterial(Material.DIAMOND_SWORD);
        item.setDurability(33);
        item.setUnbreakable(true);
        return item;
    }




}
