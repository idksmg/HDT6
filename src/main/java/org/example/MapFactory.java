package org.example;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapFactory {

    public static <K, V> Map<K, V> createMap(String type){
        if(type.equals("HashMap")){
            return new HashMap<K, V>();
        }else if(type.equals("TreeMap")){
            return new TreeMap<K, V>();
        } else if (type.equals("LinkedHashMap")) {
            return new LinkedHashMap<K, V>();
        }else {
            throw new IllegalArgumentException("Tipo de mapa invalido");
        }
    }

    public static SortedMap<String, Map<String, Integer>> getSortedMap(Map<String, Map<String, Integer>> map){
        if(map instanceof TreeMap){
            return (TreeMap<String, Map<String, Integer>>) map;
        }else {
            return new TreeMap<>(map);
        }
    }
}
