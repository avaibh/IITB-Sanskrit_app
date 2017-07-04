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

    //hindi word for the english word
    private String mHindiWord;

    //Image for the question
    private int mImageResourceId ;

    public Test(String question, String answer, String hindiWord, int audioResourceId, int imageResourceId) {
        mQuestion = question;
        mAnswer = answer;
        mHindiWord = hindiWord;
        mAudioResourceId = audioResourceId;
        mImageResourceId = imageResourceId;
    }

    // Methods for the functions (all are public)

    public String getQuestion() {

        return mQuestion;
    }

    public String getHindiWord(){

        return mHindiWord;
    }


    public String getAnswer() {

        return mAnswer;
    }

    public int getAudioResourceId() {

        return mAudioResourceId;
    }

    public int getImageResourceId(){

        return mImageResourceId;
    }
}
