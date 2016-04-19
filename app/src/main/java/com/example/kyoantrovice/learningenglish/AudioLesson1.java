package com.example.kyoantrovice.learningenglish;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

/**
 * Created by KyoAntrovice on 12/7/2015.
 */
public class AudioLesson1 extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button b1,b2,b3,b4;
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private TextView tx1,tx2;
    public static int oneTimeOnly = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audiolesson);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        tx1=(TextView)findViewById(R.id.textview2);
        tx2=(TextView)findViewById(R.id.textview3);

        mediaPlayer = MediaPlayer.create(this,R.raw.lionrabit);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setClickable(false);
        b2.setEnabled(false);
        String [] listLesson = {
            "THE LION AND THE RABIT",
                "A cruel lion lived in the forest",
                "Every day, he killed and ate a lot of animals",
                "The other animals were afraid the lion would kill them all",
                "The animals told the lion,Let’s make a deal",
                "If you promise to eat only one animal each day, then one of us will come to you every day",
                "Then you don’t have to hunt and kill us",
                "The plan sounded well thought-out to the lion",
                "so he agreed, but he also said",
                "If you don’t come every day, I promise to kill all of you the next day!",
                "Each day after that, one animal went to the lion so that the lion could eat it",
                "Then, all the other animals were safe.",
                "Finally, it was the rabbit’s turn to go to the lion",
                "The rabbit went very slowly that day",
                "so the lion was angry when the rabbit finally arrived",
                "The lion angrily asked the rabbit",
                "Why are you late?",
                "I was hiding from another lion in the forest",
                "That lion said he was the king, so I was afraid",
                "The lion told the rabbit",
                "I am the only king here! Take me to that other lion and I will kill him",
                "The rabbit replied, “I will be happy to show you where he lives.",
                "The rabbit led the lion to an old well in the middle of the forest",
                "The well was very deep with water at the bottom",
                "The rabbit told the lion, “Look in there. The lion lives at the bottom",
                "When the lion looked in the well, he could see his own face in-the water",
                "He thought that was the other lion. Without waiting another moment",
                "the lion jumped into the well to attack the other lion",
                "He never came out",
                "All of the other animal in the forest were very pleased with the rabbit’s clevpriirick."
        };

        final ArrayAdapter<String> Lessons = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listLesson
        );

        ListView myLessons = (ListView) findViewById(R.id.listview_audio);
        myLessons.setAdapter(Lessons);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing Lion and Rabit", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();
                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }
                tx2.setText(String.format("%d min, %d sec",
                                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime)))
                );

                tx1.setText(String.format("%d min, %d sec",
                                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)))
                );

                seekbar.setProgress((int) startTime);
                myHandler.postDelayed(UpdateSongTime, 100);
                b2.setEnabled(true);
                b3.setEnabled(false);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AudioLesson1.this, "Pausing sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                b2.setEnabled(false);
                b3.setEnabled(true);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp+forwardTime)<=finalTime){
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(AudioLesson1.this,"You have Jumped forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AudioLesson1.this,"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp-backwardTime)>0){
                    startTime = startTime - backwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(AudioLesson1.this,"You have Jumped backward 5 seconds",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AudioLesson1.this,"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            tx1.setText(String.format("%d min, %d sec",

                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                            toMinutes((long) startTime)))
            );
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
}
