package com.example.turistico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Place> placesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placesList = new ArrayList<>();
        placesList.add(new Place("Facens", "Centro Universitário Facens, cursos de nível superior de qualidade!", R.drawable.campus, "geo:0,0?q=Sorocaba+Facens", "https://facens.br", "551532381188"));
        placesList.add(new Place("Fatec", "Faculdade de Tecnologia de Sorocaba", R.drawable.fatec, "geo:0,0?q=Fatec", "https://www.fatecsorocaba.edu.br", "1532385266"));
        placesList.add(new Place("Pontifícia Universidade Católica de São Paulo", "Uma das mais tradicionais faculdades de São Paulo, aqui em Sorocaba!", R.drawable.pux, "geo:0,0?q=PUC", "https://www.pucsp.br/universidade/campus-sorocaba", "1136708000"));

        ListView listViewPlaces = findViewById(R.id.listViewPlaces);
        PlaceAdapter adapter = new PlaceAdapter(this, placesList);
        listViewPlaces.setAdapter(adapter);

        listViewPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("place", placesList.get(i));  // Passando o objeto Place
                startActivity(intent);
            }
        });
    }
}
