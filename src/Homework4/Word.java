package Homework4;

/**
 * Class: Counter
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 4/12/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class Word implements Comparable<Word> {
    private String aWord;
    private int count;

    public Word(String word) {
        aWord = word;
        count = 1;
    }

    public String getaWord() {
        return aWord;
    }

    public void setaWord(String aWord) {
        this.aWord = aWord;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "word=" + aWord +
                ", count=" + count;
    }

    @Override
    public int compareTo(Word o) {
        return o.aWord.compareTo(this.aWord);
    }
}
