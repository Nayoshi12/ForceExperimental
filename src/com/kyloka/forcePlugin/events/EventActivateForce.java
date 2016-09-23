package com.kyloka.forcePlugin.events;

import com.kyloka.forcePlugin.Main;
import com.kyloka.forcePlugin.commands.Commandforce;
import com.kyloka.forcePlugin.items.Weapons;
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

        String yaw2Direction = PlayerDirection.pitchToDirection(target.getLocation().getYaw());

        double radius = 4;
        List<Entity> entities = target.getNearbyEntities(radius, radius, radius); // All entities withing a box
        double radiusSquared = radius * radius;
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            //target.sendMessage("1");
            if (e.getItem().getType() == Weapons.redlightsaber().getMaterial()) {
                if (e.getItem().getItemMeta().getDisplayName().equals(Weapons.redlightsaber().getName())){
                    target.sendMessage("2");

                    for (Entity entity : entities) {
                        //target.sendMessage(entity.getType().toString());
                        if(entity instanceof  Player||entity instanceof FallingBlock||entity instanceof TNTPrimed){
                            //target.sendMessage(entity.getName());
                            if (entity.getLocation().distanceSquared(target.getLocation()) > radiusSquared)
                                continue; // All entities within a sphere


                            if (yaw2Direction.equalsIgnoreCase("NORTH")) {

                                entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().setZ(target.getVelocity().getZ() - 3.5)));
                            } else if (yaw2Direction.equalsIgnoreCase("SOUTH")) {
                                //entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().setX(target.getVelocity().getX() + 3.5)));
                                entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().setZ(target.getVelocity().getZ() + 3.5)));
                            } else if (yaw2Direction.equalsIgnoreCase("EAST")) {
                                //entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().multiply(2).setY(target.getVelocity().getY() + 3.5)));
                                entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().setX(target.getVelocity().getX() + 3.5)));
                            } else if (yaw2Direction.equalsIgnoreCase("WEST")) {
                                entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().setX(target.getVelocity().getX() - 3.5)));

                            }

                        }
                    }
                }

            }
        }
    }

    @EventHandler

    public void test(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action act = e.getAction();
        ForceItem test1 = Weapons.redlightsaber();
        ForceItem test2 = Weapons.redLightsaberHandle();
        ItemStack itemInhand = player.getInventory().getItemInMainHand();
        HashMap<String,Integer> same = new HashMap<>();

        int inventorySlot = 0;
        if (act == Action.RIGHT_CLICK_AIR){
            if (itemInhand.getType() == test2.getMaterial()){
                player.sendMessage(itemInhand.getItemMeta().getDisplayName());
                if (itemInhand.getItemMeta().getDisplayName().equals(test2.getName()) ){
                    player.sendMessage("test");
                    for (ItemStack inv: player.getInventory()){
                        if (inv != null){
                            if (inv.equals(itemInhand)){
                                break;
                            }
                        }

                        inventorySlot += 1;
                    }
                    player.sendMessage(Integer.toString(inventorySlot) + " ");

                    player.getInventory().setItem(inventorySlot,test1.createMaterial());
                }
            }

        }
        if (act== Action.RIGHT_CLICK_BLOCK){
            if (itemInhand.getType() == test1.getMaterial()){
                if(itemInhand.getItemMeta().getDisplayName().equals(test1.getName())){
                    for (ItemStack inv: player.getInventory()){
                        if (inv != null){
                            if (inv.equals(itemInhand)){
                                break;
                            }
                        }

                        inventorySlot += 1;
                    }
                    player.sendMessage(inventorySlot + " ");
                    player.getInventory().setItem(inventorySlot, test2.createMaterial());
                }
            }

        }


    }

}

