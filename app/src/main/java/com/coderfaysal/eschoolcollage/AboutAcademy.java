package com.coderfaysal.eschoolcollage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutAcademy extends AppCompatActivity {

    ImageView backPres, md_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_academy);

        backPres = findViewById(R.id.backPres);
        backPres.setOnClickListener(v -> {
            onBackPressed();
        });

        md_logo = findViewById(R.id.md_logo);
        Picasso.get().load("https://i.ibb.co/LzQ9XnD/image.jpg").placeholder(R.drawable.placeholder).into(md_logo);




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}