package e.welcome.acmbkbiet.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import e.welcome.acmbkbiet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutAcm extends Fragment {


    public AboutAcm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_acm, container, false);
    }

}
