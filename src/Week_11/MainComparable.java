package Week_11;

/**
 * Class: MainComparable
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
// Driver class

import java.util.LinkedList;
import java.util.Collections;

class MainComparable {
    public static void main(String[] args) {
        LinkedList<MovieComparable> list = new LinkedList<MovieComparable>();
        list.add(new MovieComparable("Force Awakens", 8.3, 2015));
        list.add(new MovieComparable("A New Hope", 8.7, 1977));
        list.add(new MovieComparable("Empire Strikes Back", 8.8, 1980));
        list.add(new MovieComparable("Return of the Jedi", 8.4, 1983));

        Collections.sort(list);

        System.out.println("Movies after sorting : ");
        for (MovieComparable movie : list) {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
    }
}
