package com.SansTranslate.android.sanskrit;

import android.graphics.Color;
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
    private static RadioButton correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        final ArrayList<Test> test = new ArrayList<Test>();
        test.add(new Test("ONE", "एकम्"));
        test.add(new Test("TWO", "द्वे"));
        test.add(new Test("THREE", "त्रीणि"));
        test.add(new Test("FOUR", "चत्वारि"));
        test.add(new Test("FIVE", "पञ्च"));
        test.add(new Test("SIX", "षट"));
        test.add(new Test("SEVEN", "सप्त"));
        test.add(new Test("EIGHT", "अष्ट"));
        test.add(new Test("NINE", "नव"));
        test.add(new Test("TEN", "दश"));

        test.add(new Test("RED", "लोहितः"));
        test.add(new Test("GREEN", "पलाशः"));
        test.add(new Test("BROWN", "श्यावः"));
        test.add(new Test("GRAY", "धूसरः"));
        test.add(new Test("BLACK", "श्यामः"));
        test.add(new Test("WHITE", "श्वेतः"));
        test.add(new Test("YELLOW", "हरिद्राभः"));

        test.add(new Test("father", "पिता"));
        test.add(new Test("mother", "माता"));
        test.add(new Test("son", "पुत्रः"));
        test.add(new Test("daughter", "पुत्री"));
        test.add(new Test("older brother", "ज्येष्ठभ्राता"));
        test.add(new Test("younger brother", "कनिष्ठभ्राता"));
        test.add(new Test("older sister", "ज्येष्ठभगिनी"));
        test.add(new Test("younger sister", "कनिष्ठभगिनी"));
        test.add(new Test("grandmother", "पितामही"));
        test.add(new Test("grandfather", "पितामहः"));
        getQuesAns(test);

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


    }

    private void getQuesAns(ArrayList<Test> test) {

        int[] num = {1, 2, 3, 4};

        Random randomQuests = new Random();
        int randomInt = randomQuests.nextInt(27);
        String randomQuestion = test.get(randomInt).getQuestion();

        TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
        String ques = "What is the correct sanskrit translation of the english word " + randomQuestion;
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
}
