package com.kyloka.forcePlugin.events;

import com.kyloka.forcePlugin.LightSaberPlugin;
import com.kyloka.forcePlugin.items.WeaponList;
import com.kyloka.forcePlugin.items.Weapons;
import com.kyloka.forcePlugin.methods.Push;
import com.kyloka.forcePlugin.object.ForceItem;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.EnumSet;
import java.util.List;

/**
 * Created by Matthew on 9/21/2016.
 */
public class EventActivateForce implements Listener {
    private LightSaberPlugin instance;

    public EventActivateForce(LightSaberPlugin instance) {
        this.instance = instance;
    }

    @EventHandler
    public void playerRightClick(PlayerInteractEvent e) {
        Player target = e.getPlayer();

        Chunk currentChunk = target.getLocation().getChunk();
        ItemStack stick = new ItemStack(Material.STICK);
        Entity[] same = currentChunk.getEntities();


        if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            //target.sendMessage("1");
            if (e.getItem().getType() == WeaponList.RED.getForceItem().getMaterial()) {
                if (e.getItem().getItemMeta().isUnbreakable()) {
                    if (target.hasPermission("force.power.initiate")) {
                        Push.themAway(target, 4, 0.1);
                    }
                    if (target.hasPermission("force.power.padawan")) {
                        Push.themAway(target, 4, 0.5);
                    }
                    if (target.hasPermission("force.power.apprentice")) {
                        Push.themAway(target, 4, 0.9);
                    }
                    if (target.hasPermission("force.power.knight")) {
                        Push.themAway(target, 4, 1.2);
                    }
                    if (target.hasPermission("force.power.master")) {
                        Push.themAway(target, 4, 2.5);
                    }
                }
                if (target.hasPermission("force.yoda")) {
                    List<Player> listOfPlayers = Push.getPlayerInRadius(target, 4);
                    for (Player lmaoset : listOfPlayers) {
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 1));
                        lmaoset.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 5));
                    }
                }

                EnumSet<WeaponList> weaponListEnumSet = EnumSet.allOf(WeaponList.class);

                for(WeaponList weaponList:weaponListEnumSet){
                    if(ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName()).equals(ChatColor.stripColor(weaponList.getForceItem().getName()))){
                        List<Player> listOfPlayers = Push.getPlayerInRadius(target,4);
                        for(Player player:listOfPlayers){
                            for(PotionEffect potionEffect:weaponList.getWeaponEffect().getPotionEffects()){
                                player.addPotionEffect(potionEffect);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void unsheatheEvent(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action act = e.getAction();
        ForceItem[] lightsaber = {WeaponList.RED.getForceItem(), WeaponList.GREEN.getForceItem(), WeaponList.BLUE.getForceItem(), WeaponList.PURPLE.getForceItem()};
        ForceItem[] lightsaberHandle = {WeaponList.RED_HANDLE.getForceItem(), WeaponList.GREEN_HANDLE.getForceItem(), WeaponList.BLUE_HANDLE.getForceItem(), WeaponList.PURPLE_HANDLE.getForceItem()};
        ItemStack itemInhand = player.getInventory().getItemInMainHand();

        int inventorySlot = 0;
        for (int i = 0; i < lightsaber.length; i++) {

            if (act == Action.RIGHT_CLICK_AIR) {
                swishySwoosh(itemInhand,lightsaberHandle,lightsaber,i,player,inventorySlot);
            }
            if(act == Action.RIGHT_CLICK_BLOCK){
                swishySwoosh(itemInhand,lightsaber,lightsaberHandle,i,player,inventorySlot);
            }







        }

    }
 public void swishySwoosh(ItemStack itemInhand,ForceItem[] fromForceItem,ForceItem[] toForceItem,int i,Player player,int inventorySlot){

         if (itemInhand.getType() == fromForceItem[i].getMaterial()) {
             if (itemInhand.getItemMeta().getDisplayName().equals(fromForceItem[i].getName())) {
                 for (ItemStack inv : player.getInventory()) {
                     if (inv != null) {
                         if (inv.equals(itemInhand)) {
                             break;
                         }
                     }
                     inventorySlot += 1;
                 }
                 player.getInventory().setItem(inventorySlot, toForceItem[i].createMaterial());
             }
         }


 }

}



