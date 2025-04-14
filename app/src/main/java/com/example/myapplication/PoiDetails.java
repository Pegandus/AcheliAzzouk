package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PoiDetails extends AppCompatActivity {

    private String siteName;
    private String siteDescription;
    private String sitePhone;
    private String siteEmail;
    private int siteImageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_details);

        Intent intent = getIntent();
        siteName = intent.getStringExtra("SITE_NAME");
        siteDescription = intent.getStringExtra("SITE_DESCRIPTION");
        sitePhone = intent.getStringExtra("SITE_PHONE");
        siteEmail = intent.getStringExtra("SITE_EMAIL");
        siteImageId = intent.getIntExtra("SITE_IMAGE_ID", R.drawable.bejaia);

        TextView nameTextView = findViewById(R.id.text_site_name);
        TextView descriptionTextView = findViewById(R.id.text_site_description);
        TextView phoneTextView = findViewById(R.id.text_site_phone);
        TextView emailTextView = findViewById(R.id.text_site_email);
        ImageView imageView = findViewById(R.id.image_site);

        Button callButton = findViewById(R.id.button_call);
        Button smsButton = findViewById(R.id.button_sms);
        Button emailButton = findViewById(R.id.button_email);

        nameTextView.setText(siteName);
        descriptionTextView.setText(siteDescription);
        phoneTextView.setText(getString(R.string.phone) + ": " + sitePhone);
        emailTextView.setText(getString(R.string.email) + ": " + siteEmail);
        imageView.setImageResource(siteImageId);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + sitePhone));
                startActivity(callIntent);
            }
        });

        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                smsIntent.setData(Uri.parse("smsto:" + sitePhone));
                startActivity(smsIntent);
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + siteEmail));
                startActivity(emailIntent);
            }
        });
    }
}