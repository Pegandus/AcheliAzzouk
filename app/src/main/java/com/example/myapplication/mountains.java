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

public class mountains extends AppCompatActivity {

    private ArrayList<String> siteNames = new ArrayList<>();
    private ArrayList<String> siteDescriptions = new ArrayList<>();
    private ArrayList<String> sitePhones = new ArrayList<>();
    private ArrayList<String> siteEmails = new ArrayList<>();
    private ArrayList<Integer> siteImageIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountains);

        initializeSiteData();

        ListView sitesListView = findViewById(R.id.list_mountains);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                siteNames
        );
        sitesListView.setAdapter(adapter);

        sitesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mountains.this, PoiDetails.class);

                // Pass site information to the SiteDetailsActivity
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

        siteNames.add(getString(R.string.mountain1));
        siteDescriptions.add(getString(R.string.description3));
        sitePhones.add("+213 213456789");
        siteEmails.add("gourayaOfficial@gmail.com");
        siteImageIds.add(R.drawable.yemma);

        siteNames.add(getString(R.string.mountain1));
        siteDescriptions.add(getString(R.string.description4));
        sitePhones.add("+213 321654987");
        siteEmails.add("contact@picSinges.dz");
        siteImageIds.add(R.drawable.pic);
    }
}