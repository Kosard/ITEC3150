package Week_11;

/**
 * Class: MainComparator
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
//A Java program to demonstrate Comparator interface

import java.util.LinkedList;
import java.util.Collections;

// Driver class
class MainComparator {
    public static void main(String[] args) {
        LinkedList<MovieComparable> list = new LinkedList<MovieComparable>();
        list.add(new MovieComparable("Force Awakens", 8.3, 2015));
        list.add(new MovieComparable("Star Wars", 8.7, 1977));
        list.add(new MovieComparable("Empire Strikes Back", 8.8, 1980));
        list.add(new MovieComparable("Return of the Jedi", 8.4, 1983));

        // Sort by rating : (1) Create an object of ratingCompare
        //				 (2) Call Collections.sort
        //				 (3) Print Sorted list
        System.out.println("Sorted by rating");
        RatingComparator ratingCompare = new RatingComparator();
        Collections.sort(list, ratingCompare);
        for (MovieComparable movie : list)
            System.out.println(movie.getRating() + " " +
                    movie.getName() + " " +
                    movie.getYear());


        // Call overloaded sort method with RatingCompare
        // (Same three steps as above)
        System.out.println("\nSorted by name");
        NameComparator nameCompare = new NameComparator();
        Collections.sort(list, nameCompare);
        for (MovieComparable movie : list)
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());

        // Uses Comparable to sort by year
        System.out.println("\nSorted by year");
        Collections.sort(list);
        for (MovieComparable movie : list)
            System.out.println(movie.getYear() + " " +
                    movie.getRating() + " " +
                    movie.getName() + " ");
    }
}
