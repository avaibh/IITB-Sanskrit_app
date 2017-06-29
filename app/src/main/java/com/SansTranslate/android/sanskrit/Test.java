package com.SansTranslate.android.sanskrit;

/**
 * Created by vaibhavagrawal on 29/06/17.
 */

public class Test {
    /** Default translation for the word */
    private String mQuestion;

    /** Sanskrit translation for the word */
    private String mAnswer;
    public Test(String question, String answer) {
        mQuestion = question;
        mAnswer = answer;
    }
    public String getQuestion() {

        return mQuestion;
    }

    /**
     * Get the Sanskrit translation of the word.
     */
    public String getAnswer() {

        return mAnswer;
    }
}
