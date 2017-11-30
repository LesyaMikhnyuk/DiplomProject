package com.my.controller;
import com.my.com.my.structure.Room;
import com.sun.org.apache.xpath.internal.operations.Bool;
import  org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.HashSet;
import java.util.Set;


@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home()
    {
        return "123";
    }


    @RequestMapping(value = "/ajaxSend", method = RequestMethod.GET)
    @ResponseBody
    public String ajaxSend(@RequestParam("num") String num,@RequestParam("i") String i,
                           @RequestParam("val") String val) {

        if(tryParseInt(val)){

            switch (Integer.parseInt(i))
            {
                case 1:
                {
                    Room.SetTemperature(Integer.parseInt(val));
                    Filewrite(num,"temperature"+i,val);
                    if(Room.upTemperature) return "runBattery";
                    else if (Room.downTemperature) return "runCooler";
                    else return "stop";
                }
                case 2:
                {
                    Room.SetWet(Integer.parseInt(val));
                    Filewrite(num,"wet"+i,val);
                    if(Room.upWet) return "runWet";
                    else return "stop";
                }
                case 3:
                {
                    Room.SetLight(Integer.parseInt(val));
                    Filewrite(num,"light"+i,val);
                    if(Room.upLight) return "runLight";
                    else return "stop";
                }
            }
            return "error";
        }
        else return "error";
    }



    boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    void Filewrite(String num, String device, String newValue)
    {
        File fl = new File("log.txt");

        if(!fl.exists())
        {

            try {
                fl.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String text = "room "+ num +" : device " + device + " - " + newValue + "\t\n";

        try {
            FileWriter writer = new FileWriter(fl.getPath(), true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
