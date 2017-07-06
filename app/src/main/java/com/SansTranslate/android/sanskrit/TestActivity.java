package com.SansTranslate.android.sanskrit;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
        test.add(new Test("ONE", "एकम्", "एक", R.raw.question1, R.drawable.number_one));
        test.add(new Test("TWO", "द्वे", "दो", R.raw.question2, R.drawable.number_two));
        test.add(new Test("THREE", "त्रीणि", "तीन", R.raw.question3, R.drawable.number_three));
        test.add(new Test("FOUR", "चत्वारि", "चार", R.raw.question4, R.drawable.number_four));
        test.add(new Test("FIVE", "पञ्च", "पंज", R.raw.question5, R.drawable.number_five));
        test.add(new Test("SIX", "षट", "छह", R.raw.question6, R.drawable.number_six));
        test.add(new Test("SEVEN", "सप्त","सात", R.raw.question7, R.drawable.number_seven));
        test.add(new Test("EIGHT", "अष्ट", "आठ", R.raw.question8, R.drawable.number_eight));
        test.add(new Test("NINE", "नव", "नौ", R.raw.question9, R.drawable.number_nine));
        test.add(new Test("TEN", "दश", "दस", R.raw.question10, R.drawable.number_ten));

        test.add(new Test("RED", "लोहितः", "लाल", R.raw.question11, R.drawable.color_red));
        test.add(new Test("GREEN", "पलाशः", "हरा", R.raw.question12, R.drawable.color_green));
        test.add(new Test("BROWN", "श्यावः", "भूरा", R.raw.question13, R.drawable.color_brown));
        test.add(new Test("GRAY", "धूसरः", "धूसर", R.raw.question14, R.drawable.color_gray));
        test.add(new Test("BLACK", "श्यामः", "काला", R.raw.question15, R.drawable.color_black));
        test.add(new Test("WHITE", "श्वेतः", "सफेद", R.raw.question16, R.drawable.color_white));
        test.add(new Test("YELLOW", "हरिद्राभः", "पीला", R.raw.question17, R.drawable.color_dusty_yellow));

        test.add(new Test("FATHER", "पिता", "पिता", R.raw.question18, R.drawable.family_father));
        test.add(new Test("MOTHER", "माता", "माता", R.raw.question19, R.drawable.family_mother));
        test.add(new Test("SON", "पुत्रः", "बेटा", R.raw.question20, R.drawable.family_son));
        test.add(new Test("DAUGHTER", "पुत्री", "बेटी", R.raw.question21, R.drawable.family_daughter));
        test.add(new Test("OLDER BROTHER", "ज्येष्ठभ्राता", "बड़ा भाई", R.raw.question22, R.drawable.family_older_brother));
        test.add(new Test("YOUNGER BROTHER", "कनिष्ठभ्राता", "छोटा भाई", R.raw.question23, R.drawable.family_younger_brother));
        test.add(new Test("OLDER SISTER", "ज्येष्ठभगिनी", "दीदी", R.raw.question24, R.drawable.family_older_sister));
        test.add(new Test("YOUNGER SISTER", "कनिष्ठभगिनी", "छोेटी बहन", R.raw.question25, R.drawable.family_younger_sister));
        test.add(new Test("GRANDMOTHER", "पितामही", "दादी", R.raw.question26, R.drawable.family_grandmother));
        test.add(new Test("GRANDFATHER", "पितामहः", "दादा", R.raw.question27, R.drawable.family_grandfather));
        final int quesInt = getQuesAns(test);

        Button submit = (Button) findViewById(R.id.submit_button);
        Button next = (Button) findViewById(R.id.next_button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuesAns(test);
                TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
                resultTextView.setText("");
                ImageView resultImageView = (ImageView) findViewById(R.id.result_image_view);
                resultImageView.setImageResource(0);
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

                    mMediaPlayer = MediaPlayer.create(TestActivity.this, R.raw.que);

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
        String randomHindiQuestion = test.get(randomInt).getHindiWord();
        String ques = "किम् इदं?";
        String error = "Unknown Error";
        questionTextView.setText(ques);

        ImageView quizImageView = (ImageView) findViewById(R.id.image_quiz);
        quizImageView.setImageResource(test.get(randomInt).getImageResourceId());

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
                radioButton_2.setText(test.get(randomInt).getAnswer());
                while (true) {
                    if (randomQuests.nextInt(27) != randomInt) {
                        radioButton_1.setText(test.get(randomQuests.nextInt(27)).getAnswer());
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
                        radioButton_4.setText(test.get(randomQuests.nextInt(27)).getAnswer());
                        break;
                    }
                }
                radioButton_3.setText(test.get(randomInt).getAnswer());
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
            resultTextView.setText("साधु! उचित प्रतिवदति");
            String color = getString(Integer.parseInt(String.valueOf(R.color.green)));
            resultTextView.setTextColor(Color.parseColor(color));
            resultTextView.setTextSize(20);

            MediaPlayer mp = MediaPlayer.create(TestActivity.this, R.raw.ans_1); // sound is inside res/raw/mysound
            mp.start();


            ImageView resultImageView = (ImageView) findViewById(R.id.result_image_view);
            resultImageView.setImageResource(R.drawable.ic_thumb_up_white_24dp);

        } else {
            // not checked
            TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
            resultTextView.setText("पुनः प्रयत्न करोति");
            String color = getString(Integer.parseInt(String.valueOf(R.color.red)));
            resultTextView.setTextColor(Color.parseColor(color));
            resultTextView.setTextSize(20);

            MediaPlayer mp = MediaPlayer.create(TestActivity.this, R.raw.ans_2); // sound is inside res/raw/mysound
            mp.start();

            ImageView resultImageView = (ImageView) findViewById(R.id.result_image_view);
            resultImageView.setImageResource(R.drawable.ic_loop_white_24dp);
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
