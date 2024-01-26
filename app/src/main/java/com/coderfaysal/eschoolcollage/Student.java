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

public class Student extends AppCompatActivity {

    SearchView searchView;
    ImageView backPres;
    ListView listView;
    public static ArrayList<HashMap<String, String>> studentArrayList = new ArrayList<>();
    HomeAdapter homeAdapter = new HomeAdapter(studentArrayList);
    TextView classNames;
    public static String CLASS_NAME = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        classNames = findViewById(R.id.classNames);
        classNames.setText(CLASS_NAME);

        backPres = findViewById(R.id.backPres);
        backPres.setOnClickListener(v -> {
            onBackPressed();
        });

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);



        listView.setAdapter(homeAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileList(newText);
                return true;
            }
        });

    }

    private class HomeAdapter extends BaseAdapter {
        ArrayList<HashMap<String, String>> studentArrayList;

        public HomeAdapter (ArrayList<HashMap<String, String>> arrayList) {
            this.studentArrayList = arrayList;
        }

        public void setFilteredList(ArrayList<HashMap<String, String>> filteredList) {
            this.studentArrayList = filteredList;
            notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            return studentArrayList.size();
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

            HashMap<String, String> hashMap = studentArrayList.get(position);

            String tvText = hashMap.get("name");
            String tvRoll = hashMap.get("roll");
            String tvImg = hashMap.get("img");
            String tvClass = hashMap.get("class");
            String tvFather = hashMap.get("father");
            String tvMother = hashMap.get("mother");
            String tvAddress = hashMap.get("address");
            String tvPhone = hashMap.get("phone");

            student_name.setText(tvText);
            student_roll.setText("রোল নংঃ "+tvRoll+" ক্লাসঃ "+tvClass);

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
                    StudentDetails.ST_ROLL = "রোল নংঃ "+tvRoll;
                    StudentDetails.ST_CLASS = "ক্লাসঃ "+tvClass;
                    StudentDetails.FATHER = "পিতাঃ "+tvFather;
                    StudentDetails.MOTHER = "মাতাঃ "+tvMother;
                    StudentDetails.LOCATION = "ঠিকানাঃ "+tvAddress;
                    StudentDetails.PHONE = "মোবাইলঃ "+tvPhone;

                    startActivity(new Intent(Student.this, StudentDetails.class));
                }
            });





            return mainView;
        }
    }

    private void fileList(String newText) {
        ArrayList<HashMap<String, String>> arrayList1 = new ArrayList<>();
        for (HashMap<String, String> detailsItem : studentArrayList) {
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