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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class IPLink extends AppCompatActivity {

    ImageView backPres;
    ListView listView;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_link);

        backPres = findViewById(R.id.backPres);
        backPres.setOnClickListener(v -> {
            onBackPressed();
        });

        listView = findViewById(R.id.listView);

        // New Content

        hashMap = new HashMap<>();
        hashMap.put("img", "https://i.ibb.co/s5yG73W/bd-logo.png");
        hashMap.put("name", "JSC/JDC/SSC/Dakhil");
        hashMap.put("url", "https://eboardresults.com/v2/home");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", "https://i.ibb.co/s5yG73W/bd-logo.png");
        hashMap.put("name", "মাদ্রাসা শিক্ষা বোর্ড");
        hashMap.put("url", "http://www.bmeb.gov.bd/");
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
            String tvURL = hashMap.get("url");

            resultName.setText(tvText);

            assert tvImg != null;
            Picasso.get().load(tvImg).placeholder(R.drawable.placeholder).into(resultImage);

            checkResult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WebView.WEB_URL = tvURL;
                    WebView.BOOK_TITLE = tvText;
                    startActivity(new Intent(IPLink.this, WebView.class));
                }
            });

            return mainView;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}