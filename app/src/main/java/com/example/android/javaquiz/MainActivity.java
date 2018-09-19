package com.example.android.javaquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {

        TextView question1 = findViewById(R.id.question1);
        TextView question2 = findViewById(R.id.question2);
        TextView question3 = findViewById(R.id.question3);
        TextView question4 = findViewById(R.id.question4);

        // Data for correct checkbox answers
        CheckBox question1Checked = findViewById(R.id.falseCheckBox1);
        boolean question1Correct = question1Checked.isChecked();
        CheckBox question2Checked = findViewById(R.id.trueCheckBox2);
        boolean question2Correct = question2Checked.isChecked();
        CheckBox question3Checked = findViewById(R.id.trueCheckBox3);
        boolean question3Correct = question3Checked.isChecked();
        CheckBox question4Checked = findViewById(R.id.trueCheckBox4);
        boolean question4Correct = question4Checked.isChecked();

        // Data for incorrect checkbox answers
        CheckBox question1CheckedIncorrect = findViewById(R.id.trueCheckBox1);
        boolean question1Incorrect = question1CheckedIncorrect.isChecked();
        CheckBox question2CheckedIncorrect = findViewById(R.id.falseCheckBox2);
        boolean question2Incorrect = question2CheckedIncorrect.isChecked();
        CheckBox question3CheckedIncorrect = findViewById(R.id.falseCheckBox3);
        boolean question3Incorrect = question3CheckedIncorrect.isChecked();
        CheckBox question4CheckedIncorrect = findViewById(R.id.falseCheckBox4);
        boolean question4Incorrect = question4CheckedIncorrect.isChecked();

        if (question1Incorrect){
            question1.setTextColor(Color.RED);
        }
        if (question2Incorrect){
            question2.setTextColor(Color.RED);
        }
        if (question3Incorrect){
            question3.setTextColor(Color.RED);
        }
        if (question4Incorrect){
            question4.setTextColor(Color.RED);
        }

        int totalScore = countPoints(question1Correct, question2Correct, question3Correct, question4Correct);
        displayPoints(totalScore);
        Toast.makeText(this, "You got " + totalScore + " out of 4 questions right.", Toast.LENGTH_LONG).show();

    }

    private int countPoints(boolean correctChecked1, boolean correctChecked2, boolean correctChecked3, boolean correctChecked4) {
        int correctPoints = 0;
        TextView question1 = findViewById(R.id.question1);
        TextView question2 = findViewById(R.id.question2);
        TextView question3 = findViewById(R.id.question3);
        TextView question4 = findViewById(R.id.question4);

        if (correctChecked1) {
            correctPoints = correctPoints + 1;
            question1.setTextColor(Color.BLACK);
        }
        if (correctChecked2) {
            correctPoints = correctPoints + 1;
            question2.setTextColor(Color.BLACK);
        }
        if (correctChecked3) {
            correctPoints = correctPoints + 1;
            question3.setTextColor(Color.BLACK);
        }
        if (correctChecked4) {
            correctPoints = correctPoints + 1;
            question4.setTextColor(Color.BLACK);
        }

        return correctPoints;
    }

    private void displayPoints(int number) {
        TextView pointsTextView = findViewById(R.id.scoreView);
        pointsTextView.setText("" + number);
    }

}
