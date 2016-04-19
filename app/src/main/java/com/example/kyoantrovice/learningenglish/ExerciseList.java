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
 * Created by KyoAntrovice on 12/3/2015.
 */
public class ExerciseList extends AppCompatActivity {
    String [] exerciselist = {
            "Exercise 1",
            "Exercise 2",
            "Exercise 3",
            "Exercise 4",
            "Exercise 5"
    };

    Integer [] imageID = {
            R.drawable.exercise,
            R.drawable.exercise,
            R.drawable.exercise,
            R.drawable.exercise,
            R.drawable.exercise,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmainpage);

        final ListArrayAdapter exercises = new
                ListArrayAdapter(ExerciseList.this,exerciselist,imageID);

        ListView myExercises = (ListView) findViewById(R.id.listView_mainpage);
        myExercises.setAdapter(exercises);
        myExercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = exercises.getItem(position);
                Toast.makeText(ExerciseList.this,text,Toast.LENGTH_SHORT).show();
                if(text == "Exercise 1"){
                    Intent intent = new Intent(ExerciseList.this,Exercise1a.class);
                    startActivity(intent);
                }
            }
        });
    }
}
