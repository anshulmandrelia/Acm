package e.welcome.acmbkbiet.fragments;


import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import e.welcome.acmbkbiet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Devlopers extends Fragment {
  ImageView linked;

    public Devlopers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_devlopers2, container, false);
       linked=v.findViewById(R.id.devloperlinked);
        linked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/anshul-mandrelia-097962153"));
                startActivity(i);
            }
        });
    return v;
    }

}
