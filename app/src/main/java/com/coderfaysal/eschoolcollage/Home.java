package com.coderfaysal.eschoolcollage;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends Fragment {

    ImageSlider imageSlider;
    TextView marqueeText;
    GridView gridView;
    ImageView notification;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        notification = view.findViewById(R.id.notification);
        notification.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), Notice.class));
        });


        marqueeText = view.findViewById(R.id.marqueeText);
        marqueeText.setSelected(true);

        imageSlider = view.findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel("https://www.isdb-bisew.org/photos/shares/Module/2019-10/1572160244-Kapashia-crop.jpg", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://upload.wikimedia.org/wikipedia/commons/8/8c/RegistanSquare_Samarkand.jpg", ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(imageList);


        gridView = view.findViewById(R.id.gridView);

        // New Content

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.student);
        hashMap.put("name", "ছাত্র-ছাত্রী");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.teacher);
        hashMap.put("name", "শিক্ষক");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.routine);
        hashMap.put("name", "রুটিন");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.result);
        hashMap.put("name", "ফলাফল");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.syllabus);
        hashMap.put("name", "সিলেবাস");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.achievement);
        hashMap.put("name", "অর্জন");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.gallery);
        hashMap.put("name", "গ্যালারি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.komiti);
        hashMap.put("name", "কমিটি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.school);
        hashMap.put("name", "মাদ্রাসা সম্পর্কে");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.book);
        hashMap.put("name", "লাইব্রেরী");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.notice);
        hashMap.put("name", "নোটিশ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", ""+R.drawable.link);
        hashMap.put("name", "লিংক");
        arrayList.add(hashMap);




        HomeAdapter homeAdapter = new HomeAdapter();
        gridView.setAdapter(homeAdapter);





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
            View mainView = layoutInflater.inflate(R.layout.main_home_item, null);

            TextView tvDisplay = mainView.findViewById(R.id.itemName);
            ImageView tvImage = mainView.findViewById(R.id.itemImage);
            CardView gridItems = mainView.findViewById(R.id.fullItems);

            HashMap<String, String> hashMap = arrayList.get(position);

            String tvText = hashMap.get("name");
            String tvImg = hashMap.get("img");

            tvDisplay.setText(tvText);

            assert tvImg != null;
            tvImage.setImageResource(Integer.parseInt(tvImg));


            gridItems.setOnClickListener(v -> {

                assert tvText != null;

                if (tvText.contains("ছাত্র-ছাত্রী")){
                    startActivity(new Intent(getActivity(), StudenList.class));
                }
                if (tvText.contains("শিক্ষক")){
                    startActivity(new Intent(getActivity(), TeacherList.class));
                }
                if (tvText.contains("রুটিন")){
                    startActivity(new Intent(getActivity(), Routine.class));
                }
                if (tvText.contains("ফলাফল")){
                    startActivity(new Intent(getActivity(), Result.class));
                }
                if (tvText.contains("সিলেবাস")){
                    startActivity(new Intent(getActivity(), Syllabus.class));
                }
                if (tvText.contains("অর্জন")){
                    startActivity(new Intent(getActivity(), Achievement.class));
                }
                if (tvText.contains("গ্যালারি")){
                    startActivity(new Intent(getActivity(), Gallery.class));
                }
                if (tvText.contains("কমিটি")){
                    startActivity(new Intent(getActivity(), Comity.class));
                }
                if (tvText.contains("মাদ্রাসা সম্পর্কে")){
                    startActivity(new Intent(getActivity(), AboutAcademy.class));
                }
                if (tvText.contains("লাইব্রেরী")){
                    startActivity(new Intent(getActivity(), Library.class));
                }
                if (tvText.contains("নোটিশ")){
                    startActivity(new Intent(getActivity(), Notice.class));
                }
                if (tvText.contains("লিংক")){
                    startActivity(new Intent(getActivity(), IPLink.class));
                }



            });





            return mainView;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        arrayList.clear();
    }

}