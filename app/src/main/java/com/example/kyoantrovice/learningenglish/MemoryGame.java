package com.example.kyoantrovice.learningenglish;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by KyoAntrovice on 12/27/2015.
 */
public class MemoryGame extends AppCompatActivity {
    String[] words = new String[] {"accept", "lot", "finally", "safe", "attack", "tấn công", "an toàn", "cuối cùng", "nhiều", "đồng ý"};
    int[] stt = new int[] {0, 1, 2, 3, 4, -5, -4, -3, -2, -1};
    TextView tv;
    TextView winner_tv;
    Random rand = new Random();
    Button selectedButton1, selectedButton2;
    Handler handler = new Handler();
    Drawable background;
    Drawable faceup;
    Drawable facedown;
    SoundPool sound;
    int pick, correct, error, win;
    int remaining_pair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memorygame);

        background = ContextCompat.getDrawable(getApplicationContext(), R.drawable.background);
        faceup = ContextCompat.getDrawable(getApplicationContext(), R.drawable.faceupcard);
        facedown = ContextCompat.getDrawable(getApplicationContext(), R.drawable.facedowncard);
        background.setAlpha(50);
        facedown.setAlpha(200);

        sound = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);

        pick = sound.load(this, R.raw.pick, 1);
        correct = sound.load(this, R.raw.correct, 1);
        error = sound.load(this, R.raw.error, 1);
        win = sound.load(this, R.raw.win, 1);

        Point pt = new Point();
        getWindowManager().getDefaultDisplay().getSize(pt);
        int x = pt.x;
        int y = pt.y;
        LinearLayout ll = (LinearLayout) findViewById(R.id.mainlayout);
        ll.setBackground(background);
        winner_tv = new TextView(this);
        winner_tv.setText("WINNER");
        winner_tv.setTextSize(y/20);
        winner_tv.setTextColor(Color.RED);
        winner_tv.setTypeface(Typeface.DEFAULT_BOLD);
        winner_tv.setWidth(x);
        winner_tv.setHeight(y);
        winner_tv.setGravity(Gravity.CENTER);
        winner_tv.setVisibility(View.GONE);
        ll.addView(winner_tv);
        tv = new TextView(this);
        tv.setText("MEMORY GAME");
        tv.setTextSize(y / 50);
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setTextColor(Color.BLACK);
        tv.setWidth(x);
        tv.setHeight(y / 6);
        tv.setGravity(Gravity.CENTER);
        ll.addView(tv);
        LinearLayout[] rowButton = new LinearLayout[5];
        for (int i = 0; i < 5; i++){
            rowButton[i] = new LinearLayout(this);
            rowButton[i].setOrientation(LinearLayout.HORIZONTAL);
            rowButton[i].setGravity(Gravity.CENTER);
            ll.addView(rowButton[i]);
        }
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(x/3, y/10);
        lp.setMargins(x/18, y/50, x/18, y/50);
        scramble();
        Button[] bt = new Button[10];
        for (int i = 0; i < 10; i++){
            bt[i] = new Button(this);
            bt[i].setLayoutParams(lp);
            bt[i].setId(1000 + stt[i]);
            bt[i].setTextSize(y/50);
            bt[i].setBackground(facedown);
            bt[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonClick((Button) v);
                }
            });
            rowButton[i/2].addView(bt[i]);
        }
        remaining_pair = 5;
    }

    protected void scramble(){
        int j, temp;
        for (int i = 9; i > 0; i--){
            temp = stt[i];
            j = rand.nextInt(i);
            stt[i] = stt[j];
            stt[j] = temp;
        }
    }

    protected void buttonClick(Button b){
        if (selectedButton1 == null){
            sound.play(pick, 1, 1, 0, 0, 1);
            selectedButton1 = b;
            selectedButton1.setText(words[(selectedButton1.getId()-990)%10]);
            selectedButton1.setBackground(faceup);
        }
        else if (selectedButton2 == null){
            if (selectedButton1 != b) {
                sound.play(pick, 1, 1, 0, 0, 1);
                selectedButton2 = b;
                selectedButton2.setText(words[(selectedButton2.getId() - 990) % 10]);
                selectedButton2.setBackground(faceup);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (selectedButton1.getId() + selectedButton2.getId() == 1999) {
                            sound.play(correct, 1, 1, 0, 0, 1);
                            selectedButton1.setVisibility(View.INVISIBLE);
                            selectedButton2.setVisibility(View.INVISIBLE);
                            remaining_pair--;
                            if (remaining_pair == 0){
                                sound.play(win, 1, 1, 0, 0, 1);
                                winner_tv.setVisibility(View.VISIBLE);
                            }
                        } else {
                            sound.play(error, 1, 1, 0, 0, 1);
                            selectedButton1.setText("");
                            selectedButton1.setBackground(facedown);
                            selectedButton2.setText("");
                            selectedButton2.setBackground(facedown);
                        }
                        selectedButton1 = null;
                        selectedButton2 = null;
                    }
                }, 600);
            }
        }
    }
}
