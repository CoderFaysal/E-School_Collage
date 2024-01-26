package com.coderfaysal.eschoolcollage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Contact extends Fragment {

    ImageView call, email, facebook, github, youtube, notification;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        call = view.findViewById(R.id.call);
        email = view.findViewById(R.id.email);
        facebook = view.findViewById(R.id.facebook);
        github = view.findViewById(R.id.github);
        youtube = view.findViewById(R.id.youtube);
        notification = view.findViewById(R.id.notification);
        notification.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), Notice.class));
        });

        call.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/+8801892837253")));
        });

        email.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","developerfaysal64@email.com", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Contact Us");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello, How Can I Help you?");
            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        });

        facebook.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/coderfaysal")));
        });

        github.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/CoderFaysal")));
        });

        youtube.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/@Innovative_Programmer")));
        });

        return view;
    }
}