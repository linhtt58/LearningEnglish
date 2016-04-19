package com.example.kyoantrovice.learningenglish;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

/**
 * Created by KyoAntrovice on 11/26/2015.
 */
public class Lesson1 extends AppCompatActivity {
    private TextToSpeech tts;
    ListView myLesson1;
    String[] listword1 = {
            "afraid /əˈfreɪd/ verb sợ hãi \n The woman was afraid of what she saw",
            "agree /əˈɡri/ verb đồng ý \n When she said that, I had to agree",
            "angry /ˈæŋɡri/ adjective tức giận \n She didn't do the homework so her father is angry",
            "arrive /əˈraɪv/ verb đến \n the bus arrives at 5p.m",
            "attack /əˈtæk/ verb tấn công \n The man attacked him with a knife",
            "bottom /ˈbɒtəm/ noun đáy \n The bottom of my shoe has a hole in it",
            "clever /ˈklevə(r)/ adjective thông minh \n The clever boy thought of a good idea",
            "cruel  /ˈkruːəl/ adjective độc ác \n The cruel man yelled at his sister",
            "finally  /ˈfaɪnəli/ adverb cuối cùng\n He finally crossed the finish line after five hours of running",
            "hide  /haɪd/ verb trốn \n The other children will hide while you count to 100",
            "hunt /hʌnt/ verb  săn bắn \n Long ago, people hunt with bows and arrows",
            "lot   /lɒt/ noun  số lượng lớn \n There are a lot of apples in the basket",
            "middle  /ˈmɪdl/ noun  giữa \n A lake with with an island in the middle",
            "moment  /ˈməʊmənt/ noun khoảng thời gian rất ngắn \n I was only a few moments late for the meeting",
            "pleased  /pliːzd/ adjective  hài lòng \n She was pleased with the phone call she received",
            "promise  /ˈprɒmɪs/ verb  hứa \n He promised to return my key by tomorrow",
            "reply /rɪˈplaɪ/ verb  phản hồi \n She only replied with a smile",
            "safe /seɪf/ adjective  an toàn \n Put on your seat belt in the car to be safe",
            "well  /wel/ adverb  tốt, giởi \n The couple can dance quite well",
    };

    Integer[] imageID = {
            R.drawable.afraid,
            R.drawable.agree,
            R.drawable.angry,
            R.drawable.arrival,
            R.drawable.attack,
            R.drawable.bottom,
            R.drawable.clever,
            R.drawable.cruel,
            R.drawable.finaal,
            R.drawable.hide,
            R.drawable.hunt,
            R.drawable.lot,
            R.drawable.middle,
            R.drawable.moment,
            R.drawable.pleased,
            R.drawable.promise,
            R.drawable.reply,
            R.drawable.safe,
            R.drawable.well
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmainpage);

       final ListArrayAdapter lesson1 = new ListArrayAdapter(Lesson1.this,listword1,imageID);
        myLesson1 = (ListView) findViewById(R.id.listView_mainpage);
        myLesson1.setAdapter(lesson1);
        myLesson1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = (String) lesson1.getItem(position);
                String[] parts = text.split(" ", 2);
                final String neededword = parts[0];
                tts = new TextToSpeech(Lesson1.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            int result = tts.setLanguage(Locale.US);
                            if (result == TextToSpeech.LANG_MISSING_DATA ||
                                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                Log.e("error", "This Language is not supported");
                            } else {
                                tts.speak(neededword, TextToSpeech.QUEUE_FLUSH,null);
                                Toast.makeText(getApplicationContext(),neededword + " has been read",Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.e("error", "Initilization failed!");
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onPause() {
        if(tts!=null){
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }
}
