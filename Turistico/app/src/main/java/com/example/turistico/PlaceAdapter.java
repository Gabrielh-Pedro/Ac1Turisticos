package com.example.turistico;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    private Context context;
    private ArrayList<Place> placesList;

    public PlaceAdapter(@NonNull Context context, ArrayList<Place> placesList) {
        super(context, 0, placesList);
        this.context = context;
        this.placesList = placesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Place place = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.place_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);

        imageView.setImageResource(place.imageResource);
        textView.setText(place.name);

        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("place", place);  // passar o objeto é aqui caralho aleluia
            context.startActivity(intent);
        });

        return convertView;
    }
}
