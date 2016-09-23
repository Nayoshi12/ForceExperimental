package com.kyloka.forcePlugin.object;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 9/23/2016.
 */
public class ForceItem {
    private Material material;
    private String name;
    private List<String> lore = new ArrayList<>();
    private float distance;
    private int radius;
    private List<Entity> entityList = new ArrayList<>();
    private Location location;
    private boolean unbreakable;

    public void addEntity(Entity ent){
        entityList.add(ent);
    }
    public void setRadius(int rad){
        radius = rad;
    }
    public void setLocation(Location loc){
        location = loc;
    }
    public void setDistance(float dist){
        distance = dist;
    }
    public void addLore(String lore1){
        lore.add(lore1);
    }
    public void setLore(List<String> lores){
        lore.clear();
        lore.addAll(lores);
    }
    public void setUnbreakable(boolean unbr){
        unbreakable = unbr;
    }
    public float getDistance(){
        return distance;
    }
    public int getRadius(){
        return radius;
    }
    public void setMaterial(Material m){
        material = m;
    }
    public void setName(String n){
        name = n;
    }
    public Material getMaterial(){
        return material;
    }
    public String getName(){
        return name;
    }
    public ItemStack createMaterial() {


        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(name);
        if (!lore.isEmpty()) {
            itemMeta.setLore(lore);
        }
        if (unbreakable) {
            itemMeta.spigot().setUnbreakable(true);
        }

        item.setItemMeta(itemMeta);
        return item;
    }
}
