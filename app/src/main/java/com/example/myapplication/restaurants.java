package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class restaurants extends AppCompatActivity {

    private ArrayList<String> siteNames = new ArrayList<>();
    private ArrayList<String> siteDescriptions = new ArrayList<>();
    private ArrayList<String> sitePhones = new ArrayList<>();
    private ArrayList<String> siteEmails = new ArrayList<>();
    private ArrayList<Integer> siteImageIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        initializeSiteData();

        ListView sitesListView = findViewById(R.id.list_restaurants);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                siteNames
        );
        sitesListView.setAdapter(adapter);

        sitesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(restaurants.this, PoiDetails.class);

                intent.putExtra("SITE_NAME", siteNames.get(position));
                intent.putExtra("SITE_DESCRIPTION", siteDescriptions.get(position));
                intent.putExtra("SITE_PHONE", sitePhones.get(position));
                intent.putExtra("SITE_EMAIL", siteEmails.get(position));
                intent.putExtra("SITE_IMAGE_ID", siteImageIds.get(position));

                startActivity(intent);
            }
        });
    }

    private void initializeSiteData() {

        siteNames.add(getString(R.string.restaurant1));
        siteDescriptions.add(getString(R.string.description5));
        sitePhones.add("+213 550028028");
        siteEmails.add("maison.opera@gmail.com");
        siteImageIds.add(R.drawable.opera);

        siteNames.add(getString(R.string.restaurant2));
        siteDescriptions.add(getString(R.string.description6));
        sitePhones.add("+213 558220060");
        siteEmails.add("atbaq.real@gmail.com");
        siteImageIds.add(R.drawable.atbaq);
    }
}