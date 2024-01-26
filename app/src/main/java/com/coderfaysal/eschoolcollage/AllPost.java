package com.coderfaysal.eschoolcollage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class AllPost extends Fragment {

    ListView listView;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_post, container, false);


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


        listView = view.findViewById(R.id.listView);

        // New Content

        hashMap = new HashMap<>();
        hashMap.put("time", ""+formattedTime);
        hashMap.put("date", ""+formattedDate);
        hashMap.put("st_name", "Kadir");
        hashMap.put("st_class", "৭ম");
        hashMap.put("st_roll", "১২");
        hashMap.put("subject", "আমার অসুস্থতার জন্য অনুগ্রহ করে আমাকে ২ দিন ছুটি দিন।");
        arrayList.add(hashMap);


        HomeAdapter homeAdapter = new HomeAdapter();
        listView.setAdapter(homeAdapter);

        return view;

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
            View mainView = layoutInflater.inflate(R.layout.post_item, null);

            TextView notice_time = mainView.findViewById(R.id.notice_time);
            TextView notice_date = mainView.findViewById(R.id.notice_date);
            TextView student_name = mainView.findViewById(R.id.student_name);
            TextView student_class = mainView.findViewById(R.id.student_class);
            TextView student_roll = mainView.findViewById(R.id.student_roll);
            TextView subject = mainView.findViewById(R.id.subject);

            HashMap<String, String> hashMap = arrayList.get(position);

            String tvTime = hashMap.get("time");
            String tvDate = hashMap.get("date");
            String tvName = hashMap.get("st_name");
            String tvClass = hashMap.get("st_class");
            String tvRoll = hashMap.get("st_roll");
            String tvSubject = hashMap.get("subject");

            notice_time.setText("সময়ঃ "+tvTime);
            notice_date.setText("তারিখঃ "+tvDate);
            student_name.setText("নামঃ "+tvName);
            student_class.setText("ক্লাসঃ "+tvClass);
            student_roll.setText("রোলঃ "+tvRoll);
            subject.setText("বিষয়ঃ "+tvSubject);


            return mainView;
        }
    }

}