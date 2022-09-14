package Lectures;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class L5Training {
    public static void main(String[] args) {
// HashMap
        Map<Integer, String> db= new HashMap<>();
        db.putIfAbsent(1, "один");
        db.put(2, "два");
        db.put(null, "!null");
        System.out.println(db);
        db.remove(null);
        System.out.println(db);
        System.out.println(db.containsValue("один"));
        System.out.println(db.containsKey("один"));
        System.out.println(db.containsKey(1));
        System.out.println(db.keySet());
        System.out.println(db.values());

        // TreeMap

        TreeMap<Integer, String> tMap = new TreeMap<>();
        tMap.put(1, "один");
        tMap.put(6, "шесть");
        tMap.put(4, "четыре");
        tMap.put(3, "три");
        tMap.put(2, "два");
        System.out.println(tMap);
        tMap.put(2, "два");
        System.out.println(tMap);
        System.out.println(tMap.descendingKeySet());
        System.out.println(tMap.descendingMap());

        // LinkedHashMap

        Map<Integer, String> linkmap = new LinkedHashMap<>();
        linkmap.put(11, "один один");
        linkmap.put(1, "один");
        linkmap.put(2, "два");
        System.out.println(linkmap);
        Map<Integer, String> map = new HashMap<>();
        map.put(11, "один один");
        map.put(1, "один");
        map.put(2, "два");
        System.out.println(map);
    }
}
