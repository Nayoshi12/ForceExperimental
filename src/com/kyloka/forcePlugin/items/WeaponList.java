package com.kyloka.forcePlugin.items;

import com.kyloka.forcePlugin.object.ForceItem;
import org.bukkit.Material;

/**
 * Created by Matthew-PC on 5/1/2018.
 */
public enum WeaponHandle {
    RED("§4Red §fLightsaber","red",Material.DIAMOND_SWORD,33,true),
    BLUE("§1Blue §fLightsaber","blue",Material.DIAMOND_SWORD,33,true),
    PURPLE("§5Purple §fLightsaber","purple",Material.DIAMOND_SWORD,33,true),
    GREEN("§2Green §fLightsaber","green",Material.DIAMOND_SWORD,33,true);

    private String name;
    private String key;
    private Material material;
    private int durability;
    private boolean isUnbreakable;

    WeaponHandle(String name,String key, Material material,int durability,boolean isUnbreakable){
        this.name = name;
        this.key = key;
        this.material = material;
        this.durability = durability;
        this.isUnbreakable = isUnbreakable;
    }
    public ForceItem getForceItem(){
        ForceItem item = new ForceItem();

        item.setName(this.name);
        item.addKeyword(this.key);
        item.setMaterial(this.material);
        item.setDurability(this.durability);
        item.setUnbreakable(this.isUnbreakable);
        return item;
    }
}
