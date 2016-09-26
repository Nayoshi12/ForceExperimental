package com.kyloka.forcePlugin.methods;

import com.kyloka.forcePlugin.events.PlayerDirection;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 9/23/2016.
 */
public class Push {
    public static double rad;
    public static double dist;
    public static Player player;
    public static void themAway(Player target, double radius, double distance) {
        rad = radius;
        dist = distance;
        String yaw2Direction = PlayerDirection.pitchToDirection(target.getLocation().getYaw());
        List<Entity> entities = target.getNearbyEntities(rad, rad, rad); // All entities withing a box
        double radiusSquared = rad * rad;
        for (Entity entity : entities) {
            //target.sendMessage(entity.getType().toString());
            if (entity instanceof Player||entity instanceof FallingBlock || entity instanceof TNTPrimed) {
                //target.sendMessage(entity.getName());
                if (entity.getLocation().distanceSquared(target.getLocation()) > radiusSquared)
                    continue; // All entities within a sphere

                try{
                    if (yaw2Direction.equalsIgnoreCase("NORTH")) {

                        entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().setZ(target.getVelocity().getZ() - dist)));
                    } else if (yaw2Direction.equalsIgnoreCase("SOUTH")) {
                        //entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().setX(target.getVelocity().getX() + 3.5)));
                        entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().setZ(target.getVelocity().getZ() + dist)));
                    } else if (yaw2Direction.equalsIgnoreCase("EAST")) {
                        //entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().multiply(2).setY(target.getVelocity().getY() + 3.5)));
                        entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().setX(target.getVelocity().getX() + dist)));
                    } else if (yaw2Direction.equalsIgnoreCase("WEST")) {
                        entity.setVelocity(target.getLocation().getDirection().add(entity.getLocation().getDirection().setX(target.getVelocity().getX() - dist)));

                    }
                }catch(Exception ex){
                    Bukkit.getLogger().info(ex.getMessage());
                    Bukkit.getLogger().info("Server is lagging/ Spigot/Bukkit is not trying hard enough.");
                }


            }

        }
    }
    public static List<Player> getPlayerInRadius(Player player,double rad){
        double radius = rad;
        List<Entity> entities = player.getNearbyEntities(radius, radius, radius); // All entities withing a box
        List<Player> playerInRadius = new ArrayList<>();
        double radiusSquared = rad * rad;
        for (Entity entity : entities) {
            if(entity instanceof Player ){
                playerInRadius.add(((Player) entity).getPlayer());
            }
        }
        return playerInRadius;
    }

}


