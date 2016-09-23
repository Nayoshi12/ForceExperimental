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
        item.setMaterial(Material.IRON_SWORD);
        item.setDurability(5);
        item.setUnbreakable(true);
        return item;
    }
    public static ForceItem redLightsaberHandle(){
        ForceItem item = new ForceItem();

        item.setName("§4Red §fLightsaber");
        item.addKeyword("Red");
        item.setMaterial(Material.IRON_SWORD);
        item.setDurability(120);
        item.setUnbreakable(true);
        return item;
    }





}
