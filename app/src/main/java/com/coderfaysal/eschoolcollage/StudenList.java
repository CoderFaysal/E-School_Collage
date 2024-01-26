package com.coderfaysal.eschoolcollage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class StudenList extends AppCompatActivity {

    ImageView backPres;
    ListView listView;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studen_list);

        backPres = findViewById(R.id.backPres);
        backPres.setOnClickListener(v -> {
            onBackPressed();
        });


        listView = findViewById(R.id.listView);

        // New Content

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.student);
        hashMap.put("name", "৬ষ্ঠ শ্রেণি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.student);
        hashMap.put("name", "৭ম শ্রেণি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.student);
        hashMap.put("name", "৮ম শ্রেণি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.student);
        hashMap.put("name", "৯ম শ্রেণি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.student);
        hashMap.put("name", "১০ম শ্রেণি");
        arrayList.add(hashMap);


        HomeAdapter homeAdapter = new HomeAdapter();
        listView.setAdapter(homeAdapter);



    }

    private class HomeAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View mainView = layoutInflater.inflate(R.layout.result_items, null);

            TextView resultName = mainView.findViewById(R.id.resultName);
            ImageView resultImage = mainView.findViewById(R.id.resultImage);
            LinearLayout checkResult = mainView.findViewById(R.id.checkResult);

            HashMap<String, String> hashMap = arrayList.get(position);

            String tvText = hashMap.get("name");
            String tvImg = hashMap.get("img");

            resultName.setText(tvText);

            assert tvImg != null;
            resultImage.setImageResource(Integer.parseInt(tvImg));

            checkResult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    assert tvText != null;

                    if (tvText.contains("৬ষ্ঠ শ্রেণি")){
                        Class_Six();
                    } else if (tvText.contains("৭ম শ্রেণি")){
                        Class_Seven();
                    } else if (tvText.contains("৮ম শ্রেণি")){
                        Class_Eight();
                    } else if (tvText.contains("৯ম শ্রেণি")){
                        Class_Nine();
                    } else if (tvText.contains("১০ম শ্রেণি")){
                        Class_Ten();
                    }

                    Student.CLASS_NAME = tvText;

                    startActivity(new Intent(StudenList.this, Student.class));
                }
            });




            return mainView;
        }
    }


    public void Class_Six(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("img", "https://d2jyir0m79gs60.cloudfront.net/news/images/successful-college-student-lg.png");
        hashMap.put("name", "Faysal");
        hashMap.put("roll", "01");
        hashMap.put("class", "SIX");
        hashMap.put("father", "ABC");
        hashMap.put("mother", "ABC");
        hashMap.put("address", "Char Kumariya");
        hashMap.put("phone", "123456789");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", "https://d2jyir0m79gs60.cloudfront.net/news/images/successful-college-student-lg.png");
        hashMap.put("name", "Somrat");
        hashMap.put("roll", "02");
        hashMap.put("class", "SIX");
        hashMap.put("father", "ABC");
        hashMap.put("mother", "DEF");
        hashMap.put("address", "Char Kumariya");
        hashMap.put("phone", "123456789");
        arrayList.add(hashMap);



        Student.studentArrayList = arrayList;

    }
    public void Class_Seven(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("img", "https://d2jyir0m79gs60.cloudfront.net/news/images/successful-college-student-lg.png");
        hashMap.put("name", "Rakib");
        hashMap.put("roll", "01");
        hashMap.put("class", "SIX");
        hashMap.put("father", "ABC");
        hashMap.put("mother", "ABC");
        hashMap.put("address", "Char Kumariya");
        hashMap.put("phone", "123456789");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", "https://d2jyir0m79gs60.cloudfront.net/news/images/successful-college-student-lg.png");
        hashMap.put("name", "Kadir");
        hashMap.put("roll", "02");
        hashMap.put("class", "SIX");
        hashMap.put("father", "ABC");
        hashMap.put("mother", "DEF");
        hashMap.put("address", "Char Kumariya");
        hashMap.put("phone", "123456789");
        arrayList.add(hashMap);



        Student.studentArrayList = arrayList;

    }

    public void Class_Eight(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("img", "https://d2jyir0m79gs60.cloudfront.net/news/images/successful-college-student-lg.png");
        hashMap.put("name", "Kuddus");
        hashMap.put("roll", "01");
        hashMap.put("class", "SIX");
        hashMap.put("father", "ABC");
        hashMap.put("mother", "ABC");
        hashMap.put("address", "Char Kumariya");
        hashMap.put("phone", "123456789");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", "https://d2jyir0m79gs60.cloudfront.net/news/images/successful-college-student-lg.png");
        hashMap.put("name", "Rahim");
        hashMap.put("roll", "02");
        hashMap.put("class", "SIX");
        hashMap.put("father", "ABC");
        hashMap.put("mother", "DEF");
        hashMap.put("address", "Char Kumariya");
        hashMap.put("phone", "123456789");
        arrayList.add(hashMap);



        Student.studentArrayList = arrayList;

    }

    public void Class_Nine(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("img", "https://d2jyir0m79gs60.cloudfront.net/news/images/successful-college-student-lg.png");
        hashMap.put("name", "Korim");
        hashMap.put("roll", "01");
        hashMap.put("class", "SIX");
        hashMap.put("father", "ABC");
        hashMap.put("mother", "ABC");
        hashMap.put("address", "Char Kumariya");
        hashMap.put("phone", "123456789");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", "https://d2jyir0m79gs60.cloudfront.net/news/images/successful-college-student-lg.png");
        hashMap.put("name", "Habib");
        hashMap.put("roll", "02");
        hashMap.put("class", "SIX");
        hashMap.put("father", "ABC");
        hashMap.put("mother", "DEF");
        hashMap.put("address", "Char Kumariya");
        hashMap.put("phone", "123456789");
        arrayList.add(hashMap);



        Student.studentArrayList = arrayList;

    }

    public void Class_Ten(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("img", "https://d2jyir0m79gs60.cloudfront.net/news/images/successful-college-student-lg.png");
        hashMap.put("name", "Rasel");
        hashMap.put("roll", "01");
        hashMap.put("class", "SIX");
        hashMap.put("father", "ABC");
        hashMap.put("mother", "ABC");
        hashMap.put("address", "Char Kumariya");
        hashMap.put("phone", "123456789");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", "https://d2jyir0m79gs60.cloudfront.net/news/images/successful-college-student-lg.png");
        hashMap.put("name", "Jahid");
        hashMap.put("roll", "02");
        hashMap.put("class", "SIX");
        hashMap.put("father", "ABC");
        hashMap.put("mother", "DEF");
        hashMap.put("address", "Char Kumariya");
        hashMap.put("phone", "123456789");
        arrayList.add(hashMap);



        Student.studentArrayList = arrayList;

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}