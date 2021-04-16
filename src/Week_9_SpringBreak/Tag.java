package Week_9_SpringBreak;

/**
 * Class: Tag
 *
 * @author
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/25/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class Tag {
    public static void main(String[] args) {
        System.out.println(createTag("<i>", "Yay"));
        System.out.println(createTag("<b>", "Java"));
    }

    public static String createTag(String tag, String word) {
        return tag + word + "</" + tag.charAt(1) + ">";
    }
}
