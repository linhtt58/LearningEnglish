package com.example.kyoantrovice.learningenglish;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by KyoAntrovice on 12/3/2015.
 */
public class Exercise1a extends AppCompatActivity {
    private RadioGroup radioGroup1,radioGroup2,radioGroup3,radioGroup4,radioGroup5;
    private RadioButton radioButton11,radioButton12,radioButton13,radioButton14;
    private RadioButton radioButton21,radioButton22,radioButton23,radioButton24;
    private RadioButton radioButton31,radioButton32,radioButton33,radioButton34;
    private RadioButton radioButton41,radioButton42,radioButton43,radioButton44;
    private RadioButton radioButton51,radioButton52,radioButton53,radioButton54;
    private TextView textView,textView1,textView2,textView3,textView4,textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises);

        // Initialize Radio Group and attach click handle
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup1.clearCheck();

        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup2.clearCheck();

        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        radioGroup3.clearCheck();

        radioGroup4 = (RadioGroup) findViewById(R.id.radioGroup4);
        radioGroup4.clearCheck();

        radioGroup5 = (RadioGroup) findViewById(R.id.radioGroup5);
        radioGroup5.clearCheck();

        // Initialize questions
        textView = (TextView) findViewById(R.id.textview);
        textView.setText("Part A: Choose the right word for the given definition");

        textView1 = (TextView) findViewById(R.id.textview1);
        textView1.setText("1. bad or hurting others");

        textView2 = (TextView) findViewById(R.id.textview2);
        textView2.setText("2. at last or at the end");

        textView3 = (TextView) findViewById(R.id.textview3);
        textView3.setText("3. to try to fight or hurt");

        textView4 = (TextView) findViewById(R.id.textview4);
        textView4.setText("4. to not let others see");

        textView5 = (TextView) findViewById(R.id.textview5);
        textView5.setText("5. the lowest part");

        // Initialize answer choice

        radioButton11 = (RadioButton) findViewById(R.id.radioButton11);
        radioButton11.setText("afraid");

        radioButton12 = (RadioButton) findViewById(R.id.radioButton12);
        radioButton12.setText("clever");

        radioButton13 = (RadioButton) findViewById(R.id.radioButton13);
        radioButton13.setText("cruel");

        radioButton14 = (RadioButton) findViewById(R.id.radioButton14);
        radioButton14.setText("hunt");

        radioButton21 = (RadioButton) findViewById(R.id.radioButton21);
        radioButton21.setText("angry");

        radioButton22 = (RadioButton) findViewById(R.id.radioButton22);
        radioButton22.setText("clever");

        radioButton23 = (RadioButton) findViewById(R.id.radioButton23);
        radioButton23.setText("finally");

        radioButton24 = (RadioButton) findViewById(R.id.radioButton24);
        radioButton24.setText("reply");

        radioButton31 = (RadioButton) findViewById(R.id.radioButton31);
        radioButton31.setText("attack");

        radioButton32 = (RadioButton) findViewById(R.id.radioButton32);
        radioButton32.setText("middle");

        radioButton33 = (RadioButton) findViewById(R.id.radioButton33);
        radioButton33.setText("pleased");

        radioButton34 = (RadioButton) findViewById(R.id.radioButton34);
        radioButton34.setText("trick");

        radioButton41 = (RadioButton) findViewById(R.id.radioButton41);
        radioButton41.setText("agree");

        radioButton42 = (RadioButton) findViewById(R.id.radioButton42);
        radioButton42.setText("hide");

        radioButton43 = (RadioButton) findViewById(R.id.radioButton43);
        radioButton43.setText("safe");

        radioButton44 = (RadioButton) findViewById(R.id.radioButton44);
        radioButton44.setText("well");

        radioButton51 = (RadioButton) findViewById(R.id.radioButton51);
        radioButton51.setText("bottom");

        radioButton52 = (RadioButton) findViewById(R.id.radioButton52);
        radioButton52.setText("lot");

        radioButton53 = (RadioButton) findViewById(R.id.radioButton53);
        radioButton53.setText("moment");

        radioButton54 = (RadioButton) findViewById(R.id.radioButton54);
        radioButton54.setText("promise");

        Button nextChapter = (Button) findViewById(R.id.nextchapter);
        nextChapter.setText("Next Chapter");
        nextChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exercise1a.this,Exercise1b.class);
                startActivity(intent);
            }
        });
        Button checkAnswer = (Button) findViewById(R.id.checkanswer);
        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show answer
                RadioButton rb1 = (RadioButton) radioGroup1.findViewById(R.id.radioButton14);
                rb1.setTextColor(Color.BLUE);

                RadioButton rb2 = (RadioButton) radioGroup2.findViewById(R.id.radioButton23);
                rb2.setTextColor(Color.BLUE);

                RadioButton rb3 = (RadioButton) radioGroup3.findViewById(R.id.radioButton31);
                rb3.setTextColor(Color.BLUE);

                RadioButton rb4 = (RadioButton) radioGroup4.findViewById(R.id.radioButton42);
                rb4.setTextColor(Color.BLUE);

                RadioButton rb5 = (RadioButton) radioGroup5.findViewById(R.id.radioButton51);
                rb5.setTextColor(Color.BLUE);
            }
        });
    }
}
