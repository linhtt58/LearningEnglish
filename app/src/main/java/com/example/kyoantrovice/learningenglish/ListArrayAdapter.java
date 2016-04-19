package com.example.kyoantrovice.learningenglish;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kyoantrovice.learningenglish.R;

import org.w3c.dom.Text;

/**
 * Created by KyoAntrovice on 11/26/2015.
 */
public class ListArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private final Integer[] imageID;

    public ListArrayAdapter(Context context, String[] values,Integer[] imageID){
        super(context, R.layout.target_item,values);
        this.context = context;
        this.values = values;
        this.imageID = imageID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.target_item,parent,false);
        // set Image Icon
        ImageView imageView = (ImageView) rootView.findViewById(R.id.item_icon);
        imageView.setImageResource(imageID[position]);
        // set Text
        TextView textView = (TextView) rootView.findViewById(R.id.label);
        textView.setText(values[position]);

        return rootView;
    }
}
