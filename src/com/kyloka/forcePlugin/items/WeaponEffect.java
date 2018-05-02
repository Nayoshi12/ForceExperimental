package com.kyloka.forcePlugin.items;

import com.kyloka.forcePlugin.LightSaberPlugin;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

/**
 * Created by Matthew-PC on 5/1/2018.
 */
public enum WeaponEffect {
    RED()


    ,

    BLUE("BLUE",new PotionEffect(PotionEffectType.SLOW, 100, 10),
            new PotionEffect(PotionEffectType.POISON, 100, 4)),

    PURPLE("PURPLE",new PotionEffect(PotionEffectType.SLOW_DIGGING, 100, 10),
            new PotionEffect(PotionEffectType.CONFUSION, 100, 4)),

    GREEN("GREEN",new PotionEffect(PotionEffectType.HUNGER, 100, 10),
            new PotionEffect(PotionEffectType.GLOWING, 100, 4)),
    YODA("YODA",new PotionEffect(PotionEffectType.HARM, 1, 1),
            new PotionEffect(PotionEffectType.LEVITATION, 100, 5));
    private static FileConfiguration config;
    private List<PotionEffect> potionEffects = new ArrayList<>();
    private static LightSaberPlugin instance;
    WeaponEffect(String key,PotionEffect... potionEffectSet){
        for(PotionEffect potionEffect:potionEffectSet){
            potionEffects.add(potionEffect);
        }

    }
    WeaponEffect(PotionEffect... potionEffects){

    }
    public static void getConfig(LightSaberPlugin instance){
        WeaponEffect.instance = instance;
        WeaponEffect.config = instance.getConfig();
    }

    private void setValue(){
//        this =
    }
    public List<PotionEffect> getPotionEffects() {
        return potionEffects;
    }
}
