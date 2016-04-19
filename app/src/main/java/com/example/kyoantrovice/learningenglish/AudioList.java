package com.example.kyoantrovice.learningenglish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by KyoAntrovice on 12/7/2015.
 */
public class AudioList extends AppCompatActivity{
    String [] listLesson = {
            "Lesson 1 \n The lion and The rabit",
            "Lesson 2",
            "Lesson 3",
            "Lesson 4",
            "Lesson 5"
    };

    Integer [] imageID = {
            R.drawable.lionrabbit,
            R.drawable.audiolesson_logo,
            R.drawable.audiolesson_logo,
            R.drawable.audiolesson_logo,
            R.drawable.audiolesson_logo,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmainpage);
        final ListArrayAdapter Lessons = new
                ListArrayAdapter(AudioList.this,listLesson,imageID);

        ListView myLessons = (ListView) findViewById(R.id.listView_mainpage);
        myLessons.setAdapter(Lessons);
        myLessons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = Lessons.getItem(position);
                Toast.makeText(getApplicationContext(), text + " selected", Toast.LENGTH_SHORT).show();
                if (text == "Lesson 1 \n" +
                        " The lion and The rabit") {
                    Intent intent1 = new Intent(getBaseContext(), AudioLesson1.class);
                    startActivity(intent1);
                }
            }
        });
    }
}
