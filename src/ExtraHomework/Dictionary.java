package ExtraHomework;

import java.util.Random;

/**
 * Class: Dictionary
 *
 * @author
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/13/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * https://www.baeldung.com/java-generating-random-numbers-in-range
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class Dictionary {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        dict.printDictionary(dict.createDictionary());
    }

    public ProgLanguage[] createDictionary() {
        Random rand = new Random();
        //int randNum = rand.nextInt(100) + 1;

        ProgLanguage[] progDictionary = new ProgLanguage[10];
        ProgLanguage java = new ProgLanguage("java", rand.nextInt(100) + 1);
        ProgLanguage python = new ProgLanguage("python", rand.nextInt(100) + 1);
        ProgLanguage ruby = new ProgLanguage("ruby", rand.nextInt(100) + 1);
        ProgLanguage swift = new ProgLanguage("swift", rand.nextInt(100) + 1);
        ProgLanguage javascript = new ProgLanguage("javascript", rand.nextInt(100) + 1);
        ProgLanguage html = new ProgLanguage("html", rand.nextInt(100) + 1);
        ProgLanguage php = new ProgLanguage("php", rand.nextInt(100) + 1);
        ProgLanguage sql = new ProgLanguage("sql", rand.nextInt(100) + 1);
        ProgLanguage scala = new ProgLanguage("scala", rand.nextInt(100) + 1);
        ProgLanguage rust = new ProgLanguage("rust", rand.nextInt(100) + 1);

        progDictionary[0] = java;
        progDictionary[1] = python;
        progDictionary[2] = ruby;
        progDictionary[3] = swift;
        progDictionary[4] = javascript;
        progDictionary[5] = html;
        progDictionary[6] = php;
        progDictionary[7] = sql;
        progDictionary[8] = scala;
        progDictionary[9] = rust;

        return progDictionary;
    }

    public void printDictionary(ProgLanguage[] dictionary) {
        String titleFormat = "%-6s %-1s %-10s %-1s %-30s %n";
        //String entryFormat = "%-6d %-1s %-10s %-1s %-30d %n";
        System.out.printf(titleFormat, "Object", "|", "Language", "|", "Rank");
        System.out.println("---------------------------");
        for (int i = 0; i < dictionary.length; i++) {
            int counter = i + 1;
            System.out.printf(titleFormat, counter, "|", dictionary[i].getProgName(), "|", dictionary[i].getProgRank());
        }
    }
}
