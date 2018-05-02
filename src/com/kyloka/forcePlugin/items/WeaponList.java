package com.kyloka.forcePlugin.items;

import com.kyloka.forcePlugin.object.ForceItem;
import org.bukkit.Material;

/**
 * Created by Matthew-PC on 5/1/2018.
 */
public enum WeaponList {
    RED_HANDLE("§4Red §fLightsaber","red",Material.DIAMOND_SWORD,33,true,WeaponEffect.RED),
    BLUE_HANDLE("§1Blue §fLightsaber","blue",Material.DIAMOND_SWORD,33,true,WeaponEffect.BLUE),
    PURPLE_HANDLE("§5Purple §fLightsaber","purple",Material.DIAMOND_SWORD,33,true,WeaponEffect.PURPLE),
    GREEN_HANDLE("§2Green §fLightsaber","green",Material.DIAMOND_SWORD,33,true,WeaponEffect.GREEN),
    RED("§4Red §fLightsaber","red",Material.DIAMOND_SWORD,2,true,WeaponEffect.RED),
    BLUE("§1Blue §fLightsaber","blue",Material.DIAMOND_SWORD,10,true,WeaponEffect.BLUE),
    PURPLE("§5Purple §fLightsaber","purple",Material.DIAMOND_SWORD,25,true,WeaponEffect.PURPLE),
    GREEN("§2Green §fLightsaber","green",Material.DIAMOND_SWORD,18,true,WeaponEffect.GREEN);

    private String name;
    private String key;
    private Material material;
    private int durability;
    private boolean isUnbreakable;
    private WeaponEffect weaponEffect;

    WeaponList(String name, String key, Material material, int durability, boolean isUnbreakable,WeaponEffect weaponList){
        this.name = name;
        this.key = key;
        this.material = material;
        this.durability = durability;
        this.isUnbreakable = isUnbreakable;
        this.weaponEffect = weaponList;

    }

    public WeaponEffect getWeaponEffect() {
        return weaponEffect;
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
