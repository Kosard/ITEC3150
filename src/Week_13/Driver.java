package Week_13;

import java.util.Set;

/**
 * Class: Driver
 *
 * @author
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 4/13/2021
 * <p>
 * This is a driver class, which means it contains the main method that tests the MediaHashMap class.
 * <p>
 * Purpose: To show how HashMaps work when creating and manipulating entries.
 */
public class Driver {
    public static void main(String[] args) {
        //Create Hashmap object
        MediaHashMap<String, Media> theMap = createMediaHashMap();

        //Print original hashmap
        printMediaHashMap(theMap);

        //Removing one entry
        System.out.println("\nAfter removing Key E");
        theMap.remove("e");

        //Print updated hashmap
        printMediaHashMap(theMap);
    }


    /**
     * This method creates and populates a MediaHashMap object
     *
     * @return a MediaHashMap object that has been populated with Media objects
     */
    public static MediaHashMap<String, Media> createMediaHashMap() {
        //Initialize dictionary
        MediaHashMap<String, Media> theMap = new MediaHashMap<>();

        //Populate dictionary
        theMap.put("c", new Media("102", "Star Wars", "Film"));
        theMap.put("a", new Media("100", "Rambo", "Film"));
        theMap.put("d", new Media("103", "Misery", "Music"));
        theMap.put("e", new Media("104", "Guernica", "Painting"));
        theMap.put("f", new Media("105", "Rocky", "Film"));
        theMap.put("b", new Media("101", "Fur Elise", "Music"));

        return theMap;
    }

    /**
     * This method iterates through the dictionary as a set and prints out each entry to the console
     *
     * @param map MediaHashMap object used to convert to set for iteration
     */
    public static void printMediaHashMap(MediaHashMap<String, Media> map) {
        //Create set from dictionary by calling keySet() method
        Set<String> keySet = map.keySet();

        //Iterate and print each entry
        for (String key : keySet) {
            Media med = map.get(key);
            System.out.println(key + " | " + med);
        }
    }
}
