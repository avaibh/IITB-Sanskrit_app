package com.SansTranslate.android.sanskrit;

/**
 * Created by vaibhavagrawal on 29/06/17.
 */

public class Test {
    /** Default translation for the word */
    private String mQuestion;

    /** Sanskrit translation for the word */
    private String mAnswer;

    // Audio resource ID for the word
    private int mAudioResourceId = R.raw.number_one;

    public Test(String question, String answer, int audioResourceId) {
        mQuestion = question;
        mAnswer = answer;
        mAudioResourceId = audioResourceId;
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

    public int getAudioResourceId() {

        return mAudioResourceId;
    }
}
