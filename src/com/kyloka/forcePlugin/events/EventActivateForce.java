package com.kyloka.forcePlugin.events;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by Matthew on 9/21/2016.
 */
public class EventActivateForce implements Listener {
    @EventHandler
    public void playerRightClick(PlayerInteractEvent e) {
        Player target = e.getPlayer();

        //target.sendMessage(e.getAction().toString() + " ");
        Chunk currentChunk = target.getLocation().getChunk();
        ItemStack stick = new ItemStack(Material.STICK);
        Entity[] same = currentChunk.getEntities();

        String yaw2Direction = PlayerDirection.pitchToDirection(target.getLocation().getYaw());
        //target.sendMessage(target.getLocation().getYaw() + "");
        //target.sendMessage(yaw2Direction);
        double radius = 4;
        List<Entity> entities = target.getNearbyEntities(radius, radius, radius); // All entities withing a box
        double radiusSquared = radius * radius;
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            //target.sendMessage("1");
            if (e.getItem().getType() == Material.STICK) {
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

    @EventHandler
    public void test(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        //player.sendMessage(PlayerDirection.pitchToDirection(player.getLocation().getYaw()));


    }

}

