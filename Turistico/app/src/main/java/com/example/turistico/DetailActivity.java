package com.example.turistico;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Place place = (Place) getIntent().getSerializableExtra("place");

        ImageView detailImageView = findViewById(R.id.detailImageView);
        TextView detailNameTextView = findViewById(R.id.detailNameTextView);
        TextView detailDescriptionTextView = findViewById(R.id.detailDescriptionTextView);

        if (place != null) {
            detailImageView.setImageResource(place.imageResource);
            detailNameTextView.setText(place.name);
            detailDescriptionTextView.setText(place.description);
        }

        Button mapButton = findViewById(R.id.mapButton);
        Button websiteButton = findViewById(R.id.websiteButton);
        Button callButton = findViewById(R.id.callButton);

        mapButton.setOnClickListener(v -> {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(place.mapLink));
            startActivity(mapIntent);
        });

        websiteButton.setOnClickListener(v -> {
            Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(place.website));
            startActivity(websiteIntent);
        });

        callButton.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + place.phone));
            startActivity(callIntent);
        });
    }
}
