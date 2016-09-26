package com.kyloka.forcePlugin.events;

import com.kyloka.forcePlugin.Main;
import com.kyloka.forcePlugin.commands.Commandforce;
import com.kyloka.forcePlugin.items.Weapons;
import com.kyloka.forcePlugin.methods.Push;
import com.kyloka.forcePlugin.object.ForceItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Matthew on 9/21/2016.
 */
public class EventActivateForce implements Listener {
    @EventHandler
    public void playerRightClick(PlayerInteractEvent e) {
        Player target = e.getPlayer();

        Chunk currentChunk = target.getLocation().getChunk();
        ItemStack stick = new ItemStack(Material.STICK);
        Entity[] same = currentChunk.getEntities();




        if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            //target.sendMessage("1");
            if (e.getItem().getType() == Weapons.redlightsaber().getMaterial()) {
                if (e.getItem().getItemMeta().spigot().isUnbreakable()){
                    if(target.hasPermission("force.power.initiate")){
                        Push.themAway(target,4,0.1);
                    }
                    if(target.hasPermission("force.power.padawan")){
                        Push.themAway(target,4,0.5);
                    }
                    if(target.hasPermission("force.power.apprentice")){
                        Push.themAway(target,4,0.9);
                    }
                    if(target.hasPermission("force.power.knight")){
                        Push.themAway(target,4,1.2);
                    }
                    if(target.hasPermission("force.power.master")){
                        Push.themAway(target,4,2.5);
                    }
                }
                if(target.hasPermission("force.yoda")){
                    List<Player> listOfPlayers = Push.getPlayerInRadius(target,4);
                    for(Player lmaoset: listOfPlayers){
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.HARM,1,1));
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,100,5));
                    }
                }
                if(ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName()).equals(ChatColor.stripColor(Weapons.redlightsaber().getName()))){

                    List<Player> listOfPlayers = Push.getPlayerInRadius(target,4);
                    for(Player lmaoset: listOfPlayers){
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,100,10));
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,100,4));
                    }

                }
                if(ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName()).equals(ChatColor.stripColor(Weapons.bluelightsaber().getName()))){

                    List<Player> listOfPlayers = Push.getPlayerInRadius(target,4);
                    for(Player lmaoset: listOfPlayers){
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,100,10));
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.POISON,100,4));
                    }

                }
                if(ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName()).equals(ChatColor.stripColor(Weapons.greenlightsaber().getName()))){

                    List<Player> listOfPlayers = Push.getPlayerInRadius(target,4);
                    for(Player lmaoset: listOfPlayers){
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER,100,10));
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,100,4));
                    }

                }
                if(ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName()).equals(ChatColor.stripColor(Weapons.purplelightsaber().getName()))){

                    List<Player> listOfPlayers = Push.getPlayerInRadius(target,4);
                    for(Player lmaoset: listOfPlayers){
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,100,10));
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,100,4));
                    }

                }
            }
        }
    }

    @EventHandler

    public void test(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action act = e.getAction();
        ForceItem[] test1 = {Weapons.redlightsaber(),Weapons.bluelightsaber(),Weapons.greenlightsaber(),Weapons.purplelightsaber()};
        ForceItem[] test2 = {Weapons.redLightsaberHandle(),Weapons.blueLightsaberHandle(),Weapons.greenLightsaberHandle(),Weapons.purpleLightsaberHandle()};
        ItemStack itemInhand = player.getInventory().getItemInMainHand();

        int inventorySlot = 0;
        for(int i = 0; i < test1.length; i++){
            if (act == Action.RIGHT_CLICK_AIR){
                if (itemInhand.getType() == test2[i].getMaterial()){

                    if (itemInhand.getItemMeta().getDisplayName().equals(test2[i].getName()) ){

                        for (ItemStack inv: player.getInventory()){
                            if (inv != null){
                                if (inv.equals(itemInhand)){
                                    break;
                                }
                            }

                            inventorySlot += 1;
                        }


                        player.getInventory().setItem(inventorySlot,test1[i].createMaterial());
                    }
                }

            }
            if (act== Action.RIGHT_CLICK_BLOCK){
                if (itemInhand.getType() == test1[i].getMaterial()){
                    if(itemInhand.getItemMeta().getDisplayName().equals(test1[i].getName())){
                        for (ItemStack inv: player.getInventory()){
                            if (inv != null){
                                if (inv.equals(itemInhand)){
                                    break;
                                }
                            }

                            inventorySlot += 1;
                        }

                        player.getInventory().setItem(inventorySlot, test2[i].createMaterial());
                    }
                }

            }
        }



    }

}

