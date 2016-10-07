package net.gusakov.testprojectexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import net.gusakov.testprojectexample.R;
import net.gusakov.testprojectexample.adapters.ImageAdapter;

/**
 * Created by hasana on 10/6/2016.
 */

public class ListViewAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    Integer[] objects;

    public ListViewAdapter(Context context, Integer[] images) {
        ctx = context;
        objects = images;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return objects.length;
    }

    @Override
    public Object getItem(int position) {
        return objects[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position==1){
            View galleryView =lInflater.inflate(R.layout.galerry_view,parent,false);
            final Gallery gallery = (Gallery) galleryView.findViewById(R.id.gallery1);
            gallery.setAdapter(new ImageAdapter(ctx));
            return galleryView;
        }else {
            ImageView view=(ImageView)convertView;
            if(view==null) {
                view = new ImageView(ctx);
            }
            view.setImageResource(objects[position]);
            view.setScaleType(ImageView.ScaleType.FIT_XY);
            return view;
        }
    }
}