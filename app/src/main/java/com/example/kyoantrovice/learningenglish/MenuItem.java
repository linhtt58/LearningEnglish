package com.example.kyoantrovice.learningenglish;

import android.graphics.drawable.Drawable;

/**
 * Created by KyoAntrovice on 12/23/2015.
 */
public class MenuItem {
    String taskname;
    public void setTaskname(String taskname){
        this.taskname = taskname;
    }

    public String getTaskname(){
        return taskname;
    }

    String definition;
    public void setDefinition(String definition){
        this.definition = definition;
    }

    public String getDefinition(){
        return definition;
    }

    Drawable img;
    public void setImg(Drawable img){
        this.img = img;
    }

    public Drawable getImg(){
        return img;
    }
}
