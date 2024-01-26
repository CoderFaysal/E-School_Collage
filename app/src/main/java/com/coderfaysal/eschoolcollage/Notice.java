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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Notice extends AppCompatActivity {

    ImageView backPres;
    ListView listView;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        backPres = findViewById(R.id.backPres);
        backPres.setOnClickListener(v -> {
            onBackPressed();
        });


        // Get the current time using the Calendar class
        Calendar calendar = Calendar.getInstance();
        Date currentTime = calendar.getTime();
        Date currentDate = calendar.getTime();

        // Format the current time using SimpleDateFormat
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String formattedTime = timeFormat.format(currentTime);

        // Format the current date using SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(currentDate);


        listView = findViewById(R.id.listView);

        // New Content

        hashMap = new HashMap<>();
        hashMap.put("time", ""+formattedTime);
        hashMap.put("date", ""+formattedDate);
        hashMap.put("notice", "এত দ্বারা জানানো যাচ্ছে যে কালকে (শনিবার) স্কুল বন্ধ থাকবে।");
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
            View mainView = layoutInflater.inflate(R.layout.notice_item, null);

            TextView notice_time = mainView.findViewById(R.id.notice_time);
            TextView notice_date = mainView.findViewById(R.id.notice_date);
            TextView notice = mainView.findViewById(R.id.notice);

            HashMap<String, String> hashMap = arrayList.get(position);

            String tvTime = hashMap.get("time");
            String tvDate = hashMap.get("date");
            String tvNotice = hashMap.get("notice");

            notice_time.setText("সময়ঃ "+tvTime);
            notice_date.setText("তারিখঃ "+tvDate);
            notice.setText(tvNotice);


            return mainView;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}