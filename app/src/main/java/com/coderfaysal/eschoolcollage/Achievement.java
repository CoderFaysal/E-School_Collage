package com.coderfaysal.eschoolcollage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class Achievement extends AppCompatActivity {

    ImageView backPres;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        backPres = findViewById(R.id.backPres);
        backPres.setOnClickListener(v -> {
            onBackPressed();
        });


        listView = findViewById(R.id.listView);

        hashMap = new HashMap<>();
        hashMap.put("image", "https://www.banglanews24.com/public/uploads/2021/06/17/1623913540.1623834933974.jpg");
        hashMap.put("details", "বাংলাদেশ টেলিভিশনে আন্তঃস্কুল বিতর্ক প্রতিযোগিতা ২০১৩-য় ৩য় স্থান অর্জন");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXEW54EjPJQV2QgEmVzEKeBfX-KE6HvYvpurAS6a5mvyjVfYwTmCbR3V0cO1qLV7hvtqs&usqp=CAU");
        hashMap.put("details", "চ্যানেল আই-বিটিভি বলতে পারো কুইজ অনুষ্ঠান ২০১৪-য় রানার্স আপ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image", "https://i.ibb.co/V23q6T6/download.jpg");
        hashMap.put("details", "২০১২ সালে জে.এস.সি. পরীক্ষায় জেলাভিত্তিক সেরা দশ শিক্ষা প্রতিষ্ঠানের তালিকায় পঞ্চম স্থান অর্জন  ");
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
            View mainView = layoutInflater.inflate(R.layout.books_items, null);


            ImageView book_cover = mainView.findViewById(R.id.book_cover);
            TextView title = mainView.findViewById(R.id.title);

            HashMap<String, String> hashMap = arrayList.get(position);
            String tvImg = hashMap.get("image");
            String tvDetails = hashMap.get("details");

            assert tvImg != null;
            Picasso.get().load(tvImg).placeholder(R.drawable.placeholder).into(book_cover);

            title.setText(tvDetails);

            return mainView;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}