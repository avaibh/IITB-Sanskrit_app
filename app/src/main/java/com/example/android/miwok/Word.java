package com.example.android.miwok;

/**
 * Created by vaibhavagrawal on 16/06/17.
 */

public class Word {
    // private states
    private String mMiwokTranslation;
    private String mDefaultTranslation;

    //Constructor for the word class
    public Word( String defaultTranslation, String miwokTranslation ){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /*
     * Gets Miwok Translation of the default word
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /*
     * Gets Default Translation of the Miwok word
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }


}
