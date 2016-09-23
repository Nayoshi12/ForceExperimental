package com.kyloka.forcePlugin.events;

/**
 * Created by Matthew on 9/21/2016.
 */
public class PlayerDirection {
    public static String pitchToDirection(float pitch){
        if (pitch > 135 && pitch < 225){
            return "NORTH";
        }
        else if (pitch < 45 && pitch > 0 || pitch < 360 && pitch > 315){
            return "SOUTH";
        }
        else if (pitch> 225 && pitch < 315){
            return "EAST";
        }
        else if (pitch> 45&&pitch <135){
            return "WEST";
        }
        return null;
    }
}
