package com.SansTranslate.android.sanskrit;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, a Sanskrit translation, and an image for that word.
 */
public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Sanskrit translation for the word */
    private String mSanskritTranslation;

    /** Image resource ID for the word */
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    // Audio resource ID for the word
    private int mAudioResourceId ;
    /** Constant value that represents no image was provided for this word */

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in English that the user is already familiar with
     * @param sanskritTranslation is the word in the Sanskrit language
     */
    public Word(String defaultTranslation, String sanskritTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mSanskritTranslation = sanskritTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String sanskritTranslation, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mSanskritTranslation = sanskritTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {

        return mDefaultTranslation;
    }

    /**
     * Get the Sanskrit translation of the word.
     */
    public String getSanskritTranslation() {

        return mSanskritTranslation;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {

        return mImageResourceId;
    }

    public int getAudioResourceId() {

        return mAudioResourceId;
    }


    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}