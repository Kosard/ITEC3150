package Week_4_Whiteboard;

public class Prompt2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("tacocat"));
        System.out.println(isPalindrome("cat"));
    }

    /**
     * Checks to see if a word is a palindrome, ie. a word that is spelled the same backwards as it does forward
     *
     * @param word
     * @return
     */
    public static boolean isPalindrome(String word) {
        char[] wordArr = word.toCharArray();
        int j = wordArr.length - 1;

        for (char c : wordArr) {
            if (c != wordArr[j]) {
                return false;
            }
            j--;
        }
        return true;
    }
}
