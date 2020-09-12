package e.welcome.acmbkbiet.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import e.welcome.acmbkbiet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends Fragment {
    Button b_call,b_message,b_website;
    ImageView imgface,imglinked;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contact_us2, container, false);
        b_call=view.findViewById(R.id.call_us);
        b_message=view.findViewById(R.id.meesage_us);
        b_website=view.findViewById(R.id.visitwebsite);
        imgface=view.findViewById(R.id.facebookacm);
        imglinked=view.findViewById(R.id.linkedinacm);
        b_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:8946824470"));
                startActivity(i);
            }
        });
        b_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u=Uri.parse("smsto:8946824470");
                Intent i=new Intent(Intent.ACTION_SENDTO,u);
                i.putExtra(Intent.EXTRA_TEXT,"Hiiiiii");
                startActivity(i);
            }
        });
        b_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse(""));
                startActivity(i);
            }
        });
        imgface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/acmbkbiet/"));
                startActivity(i);
            }
        });
        imglinked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("https://in.linkedin.com/company/acm-bkbiet"));
                startActivity(i);
            }
        });

        return view;
    }

}
