package ExtraHomework;

/**
 * Class: ProgLanguage
 *
 * @author
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/13/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * <p>
 * "I worked on the homework assignment alone, using only this semester's course materials." OR  "I/We worked on this homework with [give the names of the people you worked with] and/or referred to [cite any texts, web sites, or other materials not provided as this semester's course materials for ITEC 3150]."
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class ProgLanguage {
    private String progName;
    private int progRank;

    public ProgLanguage() {
        progName = "xxxxx";
        progRank = 0;
    }

    public ProgLanguage(String name, int rank) {
        progName = name;
        progRank = rank;
    }

    public String capitalizeName(String name) {
        progName = name.toUpperCase();
        return name.toUpperCase();
    }

    public char getFirstLetter(String name) {
        return name.charAt(0);
    }

    public String getProgName() {
        return progName;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    public int getProgRank() {
        return progRank;
    }

    public void setProgRank(int progRank) {
        this.progRank = progRank;
    }

    public void sortDictionary(ProgLanguage[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {

        }
    }
}
