package com.example.android.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {

        CheckBox question1Checked = findViewById(R.id.falseCheckBox1);
        boolean question1Correct = question1Checked.isChecked();
        CheckBox question2Checked = findViewById(R.id.trueCheckBox2);
        boolean question2Correct = question2Checked.isChecked();
        CheckBox question3Checked = findViewById(R.id.trueCheckBox3);
        boolean question3Correct = question3Checked.isChecked();
        CheckBox question4Checked = findViewById(R.id.trueCheckBox4);
        boolean question4Correct = question4Checked.isChecked();


        int totalScore = countPoints(question1Correct, question2Correct, question3Correct, question4Correct);
        displayPoints(totalScore);

    }

    private int countPoints(boolean correctChecked1, boolean correctChecked2, boolean correctChecked3, boolean correctChecked4) {
        int numberRight = 1;
        int correctPoints = 0;

        if (correctChecked1) {
            correctPoints = correctPoints + 1;
        }
        if (correctChecked2) {
            correctPoints = correctPoints + 1;
        }
        if (correctChecked3) {
            correctPoints = correctPoints + 1;
        }
        if (correctChecked4) {
            correctPoints = correctPoints + 1;
        }

        return numberRight * correctPoints;
    }

    private void displayPoints(int number) {
        TextView pointsTextView = findViewById(R.id.scoreView);
        pointsTextView.setText(number);
    }

}
