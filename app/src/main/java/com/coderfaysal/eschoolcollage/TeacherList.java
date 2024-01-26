package com.coderfaysal.eschoolcollage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class TeacherList extends AppCompatActivity {

    ImageView backPres;
    ListView listView;
    SearchView searchView;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HomeAdapter homeAdapter = new HomeAdapter(arrayList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);

        backPres = findViewById(R.id.backPres);
        backPres.setOnClickListener(v -> {
            onBackPressed();
        });


        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);


        hashMap = new HashMap<>();
        hashMap.put("img", "https://cdn.elearningindustry.com/wp-content/uploads/2019/10/professional-development-tools-for-teachers.jpg");
        hashMap.put("name", "Faysal");
        hashMap.put("id", "01");
        hashMap.put("subject", "Bangla");
        hashMap.put("nid", "91245834554");
        hashMap.put("blood", "O+");
        hashMap.put("address", "Char Kumariya, Shariatpur");
        hashMap.put("phone", "123456789");
        arrayList.add(hashMap);


        listView.setAdapter(homeAdapter);



    }

    private class HomeAdapter extends BaseAdapter {
        ArrayList<HashMap<String, String>> arrayList;

        public HomeAdapter (ArrayList<HashMap<String, String>> arrayList) {
            this.arrayList = arrayList;
        }

        public void setFilteredList(ArrayList<HashMap<String, String>> filteredList) {
            this.arrayList = filteredList;
            notifyDataSetChanged();
        }
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
            View mainView = layoutInflater.inflate(R.layout.name_items, null);

            TextView student_name = mainView.findViewById(R.id.student_name);
            TextView student_roll = mainView.findViewById(R.id.student_roll);
            ImageView studentImage = mainView.findViewById(R.id.studentImage);
            ImageView calltoAction = mainView.findViewById(R.id.calltoAction);
            LinearLayout studentInformation = mainView.findViewById(R.id.studentInformation);

            HashMap<String, String> hashMap = arrayList.get(position);

            String tvText = hashMap.get("name");
            String tvID = hashMap.get("id");
            String tvImg = hashMap.get("img");
            String tvSubject = hashMap.get("subject");
            String tvNID = hashMap.get("nid");
            String tvBlood = hashMap.get("blood");
            String tvAddress = hashMap.get("address");
            String tvPhone = hashMap.get("phone");



            student_name.setText(tvText);
            student_roll.setText("আইডি নংঃ "+tvID+" বিষয়ঃ "+tvSubject);

            assert tvImg != null;
            Picasso.get().load(tvImg).placeholder(R.drawable.placeholder).into(studentImage);

            calltoAction.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+tvPhone));
                startActivity(intent);
            });

            studentInformation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    StudentDetails.ST_IMG = tvImg;
                    StudentDetails.ST_NAME = tvText;
                    StudentDetails.ST_ROLL = "আইডি নংঃ "+tvID;
                    StudentDetails.ST_CLASS = "বিষয়ঃ "+tvSubject;
                    StudentDetails.FATHER = "এন আইডিঃ "+tvNID;
                    StudentDetails.MOTHER = "ব্লাড গ্রুপঃ "+tvBlood;
                    StudentDetails.LOCATION = "ঠিকানাঃ "+tvAddress;
                    StudentDetails.PHONE = "মোবাইলঃ "+tvPhone;

                    startActivity(new Intent(TeacherList.this, StudentDetails.class));
                }
            });





            return mainView;
        }
    }

    private void fileList(String newText) {
        ArrayList<HashMap<String, String>> arrayList1 = new ArrayList<>();
        for (HashMap<String, String> detailsItem : arrayList) {
            if (detailsItem.get("name").toLowerCase().contains(newText.toLowerCase())) {
                arrayList1.add(detailsItem);
            }
        }
        if (arrayList1.isEmpty()) {
            Toast.makeText(this, "Name Not Found", Toast.LENGTH_SHORT).show();
        } else {
            homeAdapter.setFilteredList(arrayList1);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}