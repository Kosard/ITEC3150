package Week_11;

/**
 * Class: MovieComparable
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/30/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
// A Java program to demonstrate use of Comparable

// A class 'Movie' that implements Comparable
class MovieComparable implements Comparable<MovieComparable> {
    private double rating;
    private String name;
    private int year;

    // Constructor
    public MovieComparable(String nm, double rt, int yr) {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Getter methods for accessing private data
    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    // Used to sort movies by year
    public int compareTo(MovieComparable m) {
        //switch fields to switch descending/ascending
        //return this.year - m.year;

        //first letter in descending order
        return m.name.charAt(0) - this.name.charAt(0);
    }
}

