package com.example.redbaron.towntoday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Constants {

    static{
        categories = new ArrayList<>(Arrays.asList("a21", "after5pm", "art", "casinotiles", "charity", "comedytiles", "concerts",
                "conventions", "dance", "environmental", "farmmarket", "festivals", "foodtruck"));
        eventThumbs = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"));
    }

    public static float dpHeight, dpWidth;
    public static float dpPadding = 3;
    public static float dpEventPadding = 15;
    public static Set<String> selected= new HashSet<>();
    public static ArrayList<String> categories;
    public static ArrayList<String> eventThumbs;

}
