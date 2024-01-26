package com.coderfaysal.eschoolcollage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class Library extends AppCompatActivity {

    GridView gridView;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    ImageView backPres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        backPres = findViewById(R.id.backPres);
        backPres.setOnClickListener(v -> {
            onBackPressed();
        });


        gridView = findViewById(R.id.gridView);

        // New Content

        hashMap = new HashMap<>();
        hashMap.put("img", "https://i.ibb.co/XJ72ghW/book.jpg");
        hashMap.put("name", "কারা জান্নাতি কুমারিদের ভালোবাসে");
        hashMap.put("url", "https://drive.google.com/file/d/1xndY6DD-zR374l0NoGybEJG7-JS7k1BP/view?usp=sharing");
        arrayList.add(hashMap);



        HomeAdapter homeAdapter = new HomeAdapter();
        gridView.setAdapter(homeAdapter);


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
            View mainView = layoutInflater.inflate(R.layout.books_items, null);

            TextView title = mainView.findViewById(R.id.title);
            ImageView book_cover = mainView.findViewById(R.id.book_cover);
            LinearLayout book = mainView.findViewById(R.id.book);

            HashMap<String, String> hashMap = arrayList.get(position);

            String tvText = hashMap.get("name");
            String tvImg = hashMap.get("img");
            String tvUrl = hashMap.get("url");

            title.setText(tvText);

            assert tvImg != null;
            Picasso.get().load(tvImg).placeholder(R.drawable.placeholder).into(book_cover);


            book.setOnClickListener(v -> {
                WebView.WEB_URL = tvUrl;
                WebView.BOOK_TITLE = tvText;
                startActivity(new Intent(Library.this, WebView.class));
            });


            return mainView;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}