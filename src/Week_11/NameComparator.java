package Week_11;

/**
 * Class: NameComparator
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
// Class to compare Movies by name

import java.util.Comparator;

class NameComparator implements Comparator<MovieComparable> {
    public int compare(MovieComparable m1, MovieComparable m2) {
        return m1.getName().compareTo(m2.getName());
    }
}