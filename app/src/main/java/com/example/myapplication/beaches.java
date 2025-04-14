package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class beaches extends AppCompatActivity {

    private ArrayList<String> siteNames = new ArrayList<>();
    private ArrayList<String> siteDescriptions = new ArrayList<>();
    private ArrayList<String> sitePhones = new ArrayList<>();
    private ArrayList<String> siteEmails = new ArrayList<>();
    private ArrayList<Integer> siteImageIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beaches);

        initializeSiteData();

        ListView sitesListView = findViewById(R.id.list_beaches);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                siteNames
        );
        sitesListView.setAdapter(adapter);

        sitesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(beaches.this, PoiDetails.class);

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

        siteNames.add(getString(R.string.beach1));
        siteDescriptions.add(getString(R.string.description1));
        sitePhones.add("+213 123456789");
        siteEmails.add("MelbouPlageExample@gmail.com");
        siteImageIds.add(R.drawable.melbou);

        siteNames.add(getString(R.string.beach2));
        siteDescriptions.add(getString(R.string.description2));
        sitePhones.add("+213 987654321");
        siteEmails.add("tighremtPlageExample@yahoo.fr");
        siteImageIds.add(R.drawable.tighremt);
    }
}