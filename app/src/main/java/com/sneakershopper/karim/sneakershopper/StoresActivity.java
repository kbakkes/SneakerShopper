package com.sneakershopper.karim.sneakershopper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class StoresActivity extends AppCompatActivity {

    public final static String LOG_TAG = "Sneaker Shopper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);

        Resources res = getResources();



        String[] store_logos = res.getStringArray(R.array.store_logos);
        LinearLayout layout = (LinearLayout)findViewById(R.id.LinearLayout);







    }



    private class ListAdapter extends ArrayAdapter<String> {

        private int layout;

        public ListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
            super(context, resource, objects);

            layout = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView == null){

                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout,parent,false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.logo_thumbnail);
            }

            return super.getView(position, convertView, parent);
        }
    }


        public class ViewHolder {

            ImageView thumbnail;
            TextView  title;
            Button button;



        }

}
