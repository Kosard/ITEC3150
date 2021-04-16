package ExtraHomework;

/**
 * Class: ProgLanguage
 *
 * @author
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/13/2021
 * <p>
 * This class contains the framework for the Programming Language entries in the dictionary
 * <p>
 * Purpose: Used to create entries in the Dictionary class main method
 */
public class ProgLanguage {
    //Private fields for this class
    private String progName;
    private int progRank;
    private int objectNum;

    //Default constructor
    public ProgLanguage() {
        this.progName = "xxxxx";
        progRank = 0;
        objectNum = 0;
    }

    //Constructor
    public ProgLanguage(int num, String name, int rank) {
        objectNum = num;
        progName = name;
        progRank = rank;
    }

    /**
     * This method takes in a string variable and capitalizes the whole word
     *
     * @param name String to be capitalized
     * @return capitalized String
     */
    public String capitalizeName(String name) {
        //call to uppercase method
        progName = name.toUpperCase();
        return name.toUpperCase();
    }

    /**
     * This method gets the first letter of the inputted String
     *
     * @param name String variable to extract its first letter from
     * @return char value containing the first letter of the String
     */
    public char getFirstLetter(String name) {
        //call to charAt method
        return name.charAt(0);
    }

    //Getters and Setters
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

    public int getObjectNum() {
        return objectNum;
    }

    public void setObjectNum(int objectNum) {
        this.objectNum = objectNum;
    }
}
