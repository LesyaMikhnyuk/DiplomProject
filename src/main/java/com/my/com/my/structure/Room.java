package com.my.com.my.structure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Room {

    private static int wet=0;
    private static int light=0;
    private static int temperature=0;
    public static boolean upTemperature;
    public static boolean downTemperature;
    public static boolean upWet;
    public static boolean upLight;

    public static void SetWet(int value)
    {
        wet = value;
        if(wet<50)
        {
            upWet = true;
        }
        else upWet = false;
    }

    public static int GetWet(){
        return wet;
    }

    public static void SetLight(int value)
    {
        light = value;
        if(light<50)
        {
            upLight = true;
        }
        else upLight = false;
    }

    public static int GetLight(){
        return wet;
    }

    public static void SetTemperature(int value)
    {
        temperature = value;
        if(value>40)
        {
            downTemperature = true;
            upTemperature=false;
        }
        else if(value<30)
        {
            upTemperature=true;
            downTemperature=false;
        }
        else
        {
            upTemperature=true;
            downTemperature=true;
        }
    }

    public static int GetTemperature(){
        return temperature;
    }
}
