package Week_11;

/**
 * Class: RatingComparator
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
// Class to compare Movies by ratings

import java.util.Comparator;

class RatingComparator implements Comparator<MovieComparable> {
    public int compare(MovieComparable m1, MovieComparable m2) {
        if (m1.getRating() < m2.getRating()) return -1;
        if (m1.getRating() > m2.getRating()) return 1;
        else return 0;
    }
}