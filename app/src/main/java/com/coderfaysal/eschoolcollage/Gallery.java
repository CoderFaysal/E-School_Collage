package com.coderfaysal.eschoolcollage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class Gallery extends AppCompatActivity {

    ImageView backPres;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    ListView listView;
    String IMAGES = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        backPres = findViewById(R.id.backPres);
        backPres.setOnClickListener(v -> {
            onBackPressed();
        });

        listView = findViewById(R.id.listView);

        hashMap = new HashMap<>();
        hashMap.put("image", "https://static.theprint.in/wp-content/uploads/2022/05/Students.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image", "https://i.ibb.co/V23q6T6/download.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image", "https://banglatv.tv/wp-content/uploads/2022/06/projonmonews24_hsc-exam-sobujbarta.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIjfjRzjiVclGBWO8y5tTgBEdpY_-4jDyvfshg-ya9prjHIfzabJ-Q7oYXHj8pr72yTJ0&usqp=CAU");
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
            View mainView = layoutInflater.inflate(R.layout.gallery_items, null);


            ImageView gallery_image = mainView.findViewById(R.id.gallery_image);

            HashMap<String, String> hashMap = arrayList.get(position);

            String tvImg = hashMap.get("image");

            assert tvImg != null;
            Picasso.get().load(tvImg).placeholder(R.drawable.placeholder).into(gallery_image);

            gallery_image.setOnClickListener(v -> {
                IMAGES = tvImg;
                customPopup();
            });



            return mainView;
        }
    }

    private void customPopup(){

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                final Dialog dialog = new Dialog(Gallery.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialog_popup);
                dialog.show();
                ImageView tvThanks = dialog.findViewById(R.id.tvThanks);

                tvThanks.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });


                ZoomableImageView full_image = dialog.findViewById(R.id.full_image);
                Picasso.get().load(IMAGES).placeholder(R.drawable.placeholder).into(full_image);



            }
        }, 1000);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}