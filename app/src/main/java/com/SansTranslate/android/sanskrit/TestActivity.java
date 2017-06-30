package com.SansTranslate.android.sanskrit;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by vaibhavagrawal on 29/06/17.
 */

public class TestActivity  extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    private static RadioButton correctAnswer;

    public TestActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mAudioManager = (AudioManager) TestActivity.this.getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Test> test = new ArrayList<Test>();
        test.add(new Test("ONE", "एकम्", R.raw.question1));
        test.add(new Test("TWO", "द्वे", R.raw.question2));
        test.add(new Test("THREE", "त्रीणि", R.raw.question3));
        test.add(new Test("FOUR", "चत्वारि", R.raw.question4));
        test.add(new Test("FIVE", "पञ्च", R.raw.question5));
        test.add(new Test("SIX", "षट", R.raw.question6));
        test.add(new Test("SEVEN", "सप्त", R.raw.question7));
        test.add(new Test("EIGHT", "अष्ट", R.raw.question8));
        test.add(new Test("NINE", "नव", R.raw.question9));
        test.add(new Test("TEN", "दश", R.raw.question10));

        test.add(new Test("RED", "लोहितः", R.raw.question11));
        test.add(new Test("GREEN", "पलाशः", R.raw.question12));
        test.add(new Test("BROWN", "श्यावः", R.raw.question13));
        test.add(new Test("GRAY", "धूसरः", R.raw.question14));
        test.add(new Test("BLACK", "श्यामः", R.raw.question15));
        test.add(new Test("WHITE", "श्वेतः", R.raw.question16));
        test.add(new Test("YELLOW", "हरिद्राभः", R.raw.question17));

        test.add(new Test("FATHER", "पिता", R.raw.question18));
        test.add(new Test("MOTHER", "माता", R.raw.question19));
        test.add(new Test("SON", "पुत्रः", R.raw.question20));
        test.add(new Test("DAUGHTER", "पुत्री", R.raw.question21));
        test.add(new Test("OLDER BROTHER", "ज्येष्ठभ्राता", R.raw.question22));
        test.add(new Test("YOUNGER BROTHER", "कनिष्ठभ्राता", R.raw.question23));
        test.add(new Test("OLDER SISTER", "ज्येष्ठभगिनी", R.raw.question24));
        test.add(new Test("YOUNGER SISTER", "कनिष्ठभगिनी", R.raw.question25));
        test.add(new Test("GRANDMOTHER", "पितामही", R.raw.question26));
        test.add(new Test("GRANDFATHER", "पितामहः", R.raw.question27));
        final int quesInt = getQuesAns(test);

        Button submit = (Button) findViewById(R.id.submit_button);
        Button next = (Button) findViewById(R.id.next_button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuesAns(test);
                TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
                resultTextView.setText("");
                RadioButton radioButton_1 = (RadioButton) findViewById(R.id.opt1_radio_button);
                RadioButton radioButton_2 = (RadioButton) findViewById(R.id.opt2_radio_button);
                RadioButton radioButton_3 = (RadioButton) findViewById(R.id.opt3_radio_button);
                RadioButton radioButton_4 = (RadioButton) findViewById(R.id.opt4_radio_button);
                radioButton_1.setChecked(false);
                radioButton_2.setChecked(false);
                radioButton_3.setChecked(false);
                radioButton_4.setChecked(false);
            }
        });

        TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
        questionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(TestActivity.this, test.get(quesInt).getAudioResourceId());

                    // Start the audio file
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    private int getQuesAns(ArrayList<Test> test) {

        int[] num = {1, 2, 3, 4};

        TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
        Random randomQuests = new Random();
        int randomInt = randomQuests.nextInt(27);
        String randomQuestion = test.get(randomInt).getQuestion();
        String ques = "What is the correct sanskrit translation of the english word " + randomQuestion +"?"+ "\n\nअस्य आंग्लपदस्य \""+randomQuestion +"\" संस्कृते समीचीनम् अनुवादः कथम्? ";
        String error = "Unknown Error";
        questionTextView.setText(ques);

        RadioButton radioButton_1 = (RadioButton) findViewById(R.id.opt1_radio_button);
        RadioButton radioButton_2 = (RadioButton) findViewById(R.id.opt2_radio_button);
        RadioButton radioButton_3 = (RadioButton) findViewById(R.id.opt3_radio_button);
        RadioButton radioButton_4 = (RadioButton) findViewById(R.id.opt4_radio_button);

        int randNum = num[randomQuests.nextInt(4)];
        switch (randNum) {
            case 1:
                radioButton_1.setText(test.get(randomInt).getAnswer());
                while (true) {
                    if (randomQuests.nextInt(27) != randomInt) {
                        radioButton_2.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        radioButton_3.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        radioButton_4.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        break;
                    }
                }
                correctAnswer = radioButton_1;
                break;
            case 2:
                radioButton_1.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                radioButton_2.setText(test.get(randomInt).getAnswer());
                while (true) {
                    if (randomQuests.nextInt(27) != randomInt) {
                        radioButton_3.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        radioButton_4.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        break;
                    }
                }
                correctAnswer = radioButton_2;
                break;
            case 3:
                while (true) {
                    if (randomQuests.nextInt(27) != randomInt) {
                        radioButton_1.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        radioButton_2.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        radioButton_3.setText(test.get(randomInt).getAnswer());
                        radioButton_4.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        break;
                    }
                }
                correctAnswer = radioButton_3;
                break;
            case 4:
                while (true) {
                    if (randomQuests.nextInt(27) != randomInt) {
                        radioButton_1.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        radioButton_2.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        radioButton_3.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        break;
                    }
                }
                radioButton_4.setText(test.get(randomInt).getAnswer());
                correctAnswer = radioButton_4;
                break;
            default:
                radioButton_1.setText(error);
                radioButton_2.setText(error);
                radioButton_3.setText(error);
                radioButton_4.setText(error);
                break;
        }
        return randomInt;
    }

    public void checkAnswer(View view) {
        if (correctAnswer.isChecked()) {
            // is checked
            TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
            resultTextView.setText("Bravo! Correct Answer\n" + "साधु! उचित प्रतिवदति");
            String color = getString(Integer.parseInt(String.valueOf(R.color.green)));
            resultTextView.setTextColor(Color.parseColor(color));
            resultTextView.setTextSize(30);
        } else {
            // not checked
            TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
            resultTextView.setText("Wrong Answer! Please try again.\n" + "अनुचित प्रतिवदति! पुनः प्रयत्न करोति");
            String color = getString(Integer.parseInt(String.valueOf(R.color.red)));
            resultTextView.setTextColor(Color.parseColor(color));
            resultTextView.setTextSize(30);
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            mMediaPlayer.release();

            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
