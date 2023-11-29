package src.main;

import java.util.ArrayList;

public class Word implements Comparable<Word> {
    private String word_target;
    private String word_explain;

    public String getWord_target() {
        return word_target;
    }

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public void printWord() {
        System.out.printf("%-20s%c %-60s%n", getWord_target(), '|', getWord_explain());
    }
    @Override
    public int compareTo(Word other) {
        return this.word_target.compareToIgnoreCase(other.getWord_target());
    }
}
