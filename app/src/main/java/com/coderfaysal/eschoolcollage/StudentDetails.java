package com.coderfaysal.eschoolcollage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class StudentDetails extends AppCompatActivity {

    TextView stName, detailsName, detailsRoll, detailsClass, detailsFathers, detailsMothers, detailsAddress, detailsPhone;
    public static String ST_IMG = "";
    public static String ST_NAME = "";
    public static String ST_ROLL = "";
    public static String ST_CLASS = "";
    public static String FATHER = "";
    public static String MOTHER = "";
    public static String LOCATION = "";
    public static String PHONE = "";
    ImageView backPres, nameImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_details);
        backPres = findViewById(R.id.backPres);
        backPres.setOnClickListener(v -> {
            onBackPressed();
        });

        stName = findViewById(R.id.stName);
        detailsName = findViewById(R.id.detailsName);
        nameImage = findViewById(R.id.nameImage);
        detailsRoll = findViewById(R.id.detailsRoll);
        detailsClass = findViewById(R.id.detailsClass);
        detailsFathers = findViewById(R.id.detailsFathers);
        detailsMothers = findViewById(R.id.detailsMothers);
        detailsAddress = findViewById(R.id.detailsAddress);
        detailsPhone = findViewById(R.id.detailsPhone);

        stName.setText(ST_NAME);
        detailsName.setText(ST_NAME);
        detailsRoll.setText(ST_ROLL);
        detailsClass.setText(ST_CLASS);
        detailsFathers.setText(FATHER);
        detailsMothers.setText(MOTHER);
        detailsAddress.setText(LOCATION);
        detailsPhone.setText(PHONE);

        assert ST_IMG != null;
        Picasso.get().load(ST_IMG).placeholder(R.drawable.placeholder).into(nameImage);



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}