package ExtraHomework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class: Dictionary
 *
 * @author
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/13/2021
 * <p>
 * This class contains methods to create, print, and sort a Dictionary object. It also contains the main method,
 * which makes this the driver class also.
 * <p>
 * I worked on this assignment alone and referred to my Discrete Maths notes about sorting algorithms.
 * <p>
 * Purpose: To demonstrate how to print in a specific format while also using sorting algorithms.
 */
public class Dictionary {
    //field containing UNIQUE random integer ranks
    private static final ArrayList<Integer> RANK_LIST = generateRanks();

    public static void main(String[] args) {
        //Create array of ProgLanguage objects
        ProgLanguage[] myDictionary;

        //Initialize array by method call
        myDictionary = createDictionary();

        //printing unsorted dictionary
        printDictionary(myDictionary);

        //printing sorted dictionary
        printDictionary(sortDictionary(myDictionary));

        //ask user to search a term
        searchByName(askUser(), myDictionary);
    }

    /**
     * This method asks the user to enter a term to search in the dictionary
     *
     * @return user's input as a String
     */
    public static String askUser() {
        //Prompt user
        System.out.println("\nWelcome to the Program Language Dictionary!");
        System.out.println("Which term name do you want to search for? ");

        //Receive input using Scanner
        Scanner keyboard = new Scanner(System.in);

        return keyboard.nextLine();
    }

    /**
     * This method generates a shuffled list of integers from 1 to 100 to be used as "randomized" ranks for dictionary
     * entries.
     *
     * @return an ArrayList of shuffled integer values
     */
    public static ArrayList<Integer> generateRanks() {
        //List of sorted integers from 1 to 100
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            temp.add(i);
        }

        //call to Collection class shuffle method to "randomize" ranks
        Collections.shuffle(temp);

        return temp;
    }

    /**
     * This method searches a specific dictionary for a specific entry
     *
     * @param name       String to be searched thoroughly in the dictionary
     * @param dictionary array of ProgLanguage objects where the search will take place
     */
    public static void searchByName(String name, ProgLanguage[] dictionary) {
        //Flag variable
        boolean isFound = false;

        //Iterate through the array to find a match
        for (ProgLanguage progLanguage : dictionary) {
            if (progLanguage.getProgName().equalsIgnoreCase(name)) {
                //Raise the flag
                isFound = true;
                break;
            }
        }

        //Print appropriate statement depending on results
        if (isFound) {
            System.out.println("Term '" + name + "' Found!");
        } else {
            System.out.println("Term '" + name + "' Not Found!");
        }
    }

    /**
     * This method creates a "dictionary" (array) of 10 ProgLanguage objects with a specific name and rank
     *
     * @return an array of ProgLanguage objects
     */
    public static ProgLanguage[] createDictionary() {
        //Print to console that the dictionary is being created
        System.out.println("The dictionary is being created...");

        //Create array
        ProgLanguage[] progDictionary = new ProgLanguage[10];

//        Constructs 10 ProgLanguage objects with names and ranks
//        ProgLanguage java = new ProgLanguage("java", RANK_LIST.get(0));
//        ProgLanguage python = new ProgLanguage("python", RANK_LIST.get(1));
//        ProgLanguage ruby = new ProgLanguage("ruby", RANK_LIST.get(2));
//        ProgLanguage swift = new ProgLanguage("swift", RANK_LIST.get(3));
//        ProgLanguage javascript = new ProgLanguage("javascript", RANK_LIST.get(4));
//        ProgLanguage html = new ProgLanguage("html", RANK_LIST.get(5));
//        ProgLanguage php = new ProgLanguage("php", RANK_LIST.get(6));
//        ProgLanguage sql = new ProgLanguage("sql", RANK_LIST.get(7));
//        ProgLanguage scala = new ProgLanguage("scala", RANK_LIST.get(8));
//        ProgLanguage rust = new ProgLanguage("rust", RANK_LIST.get(9));

        //Create array of String for language names
        String[] progNames = {"java", "python", "ruby", "swift", "javascript", "html", "php", "sql", "scala", "rust"};

        //Populate array of ProgLanguage objects with object number, name, and rank
        for (int i = 0; i < progDictionary.length; i++) {
            progDictionary[i] = new ProgLanguage(i + 1, progNames[i], RANK_LIST.get(i));
        }

//        Populate array with ProgLanguage objects
//        progDictionary[0] = java;
//        progDictionary[1] = python;
//        progDictionary[2] = ruby;
//        progDictionary[3] = swift;
//        progDictionary[4] = javascript;
//        progDictionary[5] = html;
//        progDictionary[6] = php;
//        progDictionary[7] = sql;
//        progDictionary[8] = scala;
//        progDictionary[9] = rust;

        System.out.println("");

        return progDictionary;
    }

    /**
     * This method prints an dictionary array to the console in a specific and neat format
     *
     * @param dictionary array of ProgLanguage objects to be printed
     */
    public static void printDictionary(ProgLanguage[] dictionary) {
        //Format to be used for all entries in the dictionary
        String format = "%-6s %-1s %-10s %-1s %-30s %n";

        //Print title of dictionary
        System.out.printf(format, "Object", "|", "Language", "|", "Rank");
        System.out.println("---------------------------");

        //Print entries of dictionary
        for (int i = 0; i < dictionary.length; i++) {
            System.out.printf(format, dictionary[i].getObjectNum(), "|", dictionary[i].getProgName(), "|", dictionary[i].getProgRank());
        }
    }

    /**
     * This method sorts the inputted array of ProgLanguage objects by rank
     *
     * @param dictionary array of ProgLanguage objects to be sorted
     * @return sorted array of ProgLanguage objects
     */
    public static ProgLanguage[] sortDictionary(ProgLanguage[] dictionary) {
        //Print to console that the dictionary is being sorted
        System.out.println("\nSorting Dictionary...");

        //Bubble Sort algorithm
        for (int i = 0; i < dictionary.length; i++) {
            for (int j = 0; j < dictionary.length - i - 1; j++) {
                if (dictionary[j].getProgRank() > dictionary[j + 1].getProgRank()) {
                    ProgLanguage temp = dictionary[j];
                    dictionary[j] = dictionary[j + 1];
                    dictionary[j + 1] = temp;
                }
            }
        }

        System.out.println("");

        return dictionary;
    }
}
