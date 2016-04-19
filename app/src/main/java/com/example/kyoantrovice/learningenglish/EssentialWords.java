package com.example.kyoantrovice.learningenglish;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

/**
 * Created by KyoAntrovice on 11/23/2015.
 */
public class EssentialWords extends AppCompatActivity {
    String [] listLesson = {
            "Lesson 1",
            "Lesson 2",
            "Lesson 3",
            "Lesson 4",
            "Lesson 5"
    };

    Integer [] imageID = {
            R.drawable.lesson,
            R.drawable.lesson,
            R.drawable.lesson,
            R.drawable.lesson,
            R.drawable.lesson
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmainpage);
        final ListArrayAdapter Lessons = new
                ListArrayAdapter(EssentialWords.this,listLesson,imageID);

        ListView myLessons = (ListView) findViewById(R.id.listView_mainpage);
        myLessons.setAdapter(Lessons);
        myLessons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = Lessons.getItem(position);
                Toast.makeText(getApplicationContext(),text + " selected",Toast.LENGTH_SHORT).show();
                if(text == "Lesson 1"){
                    Intent intent1 = new Intent(getBaseContext(),Lesson1.class);
                    startActivity(intent1);
                }
            }
        });
    }
}
