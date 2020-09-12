package e.welcome.acmbkbiet.fragments;


import android.content.Intent;
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
public class OurTeam extends Fragment {
    ImageView linkedharshit,linkeddhruv,linkeddev,linkedchinmay,linkedkamayani,linkeddeepika,
    linkedanshul,linkedayushi,linkedparikshit,linkedmansi,linkedashutosh,linenkedkunal,
            linkedmanal,linkedmayank,linkedkrishan,linkedankit;


    public OurTeam() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_our_team, container, false);
        linkedharshit=view.findViewById(R.id.harshitlinked);
        linkeddhruv=view.findViewById(R.id.dhruvlinkedin);
        linkeddev=view.findViewById(R.id.devlinkedin);
        linkeddeepika=view.findViewById(R.id.deepikalinked);
        linkedkamayani=view.findViewById(R.id.kamayanilinked);
        linkedchinmay=view.findViewById(R.id.linkedchinmay);
        linkedanshul=view.findViewById(R.id.linkedanshul);
        linkedayushi=view.findViewById(R.id.ayushilinked);
        linenkedkunal=view.findViewById(R.id.kunallinked);
        linkedparikshit=view.findViewById(R.id.linkedparikshit);
        linkedashutosh=view.findViewById(R.id.ashutoshlinked);
        linkedankit=view.findViewById(R.id.linkedankit);
        linkedmansi=view.findViewById(R.id.linkedmansi);
        linkedmanal=view.findViewById(R.id.manallinkedin);
        linkedmayank=view.findViewById(R.id.linkedmayank);
        linkedkrishan=view.findViewById(R.id.linkedkrishna);


        linkedharshit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/harshit-kalal-508a28150"));
                startActivity(i);
            }
        });
        linkeddhruv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/dhruv-dayal-gupta-64791a14a"));
                startActivity(i);
            }
        });
        linkeddev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/dev-bansal-a86818171/"));
                startActivity(i);
            }
        });
        linkedkamayani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/kamayani-goswami-90036017b"));
                startActivity(i);
            }
        });
        linkeddeepika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/deepika-sharma-461295186"));
                startActivity(i);
            }
        });
        linkedayushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/ayushidokwal"));
                startActivity(i);
            }
        });
        linkedanshul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/anshul-mandrelia-097962153"));
                startActivity(i);
            }
        });
        linkedankit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/ankit-sharma-231575118"));
                startActivity(i);
            }
        });
        linkedchinmay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.linkedin.com/in/chinmay-sahal-18883a177"));
                startActivity(i);
            }
        });
        linkedparikshit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/parikshit-singh-bhati-574b49179"));
                startActivity(i);
            }
        });
        linenkedkunal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/kunal-sharma-2a1bbb179"));
                startActivity(i);
            }
        });
        linkedmayank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mayank-gaur-397a87171"));
                startActivity(i);
            }
        });
        linkedashutosh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/ashutosh-rungta-42059718a"));
                startActivity(i);
            }
        });
        linkedmansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mansi-gupta-24481416a"));
                startActivity(i);
            }
        });
        linkedkrishan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/krishan-kumar-24067a170"));
                startActivity(i);
            }
        });
        linkedmanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/manal-swami-364289170"));
                startActivity(i);
            }
        });
     return view;
    }

}
