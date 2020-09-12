package e.welcome.acmbkbiet.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import e.welcome.acmbkbiet.R;
import e.welcome.acmbkbiet.moneyactivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class JoinUs extends Fragment {
    EditText sname,semail,snumber,sbranch,syear;
    Button submit;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Enteries");
    public JoinUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_join_us, container, false);
       sname=v.findViewById(R.id.stdname);
       semail=v.findViewById(R.id.stdmail);
       snumber=v.findViewById(R.id.stdphone);
       sbranch=v.findViewById(R.id.stdbranch);
       syear=v.findViewById(R.id.stdyear);
       submit=v.findViewById(R.id.clicktosubmit);
       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name,email,number,branch,year;
               name=sname.getText().toString();
               email=semail.getText().toString();
               number=snumber.getText().toString();
               branch=sbranch.getText().toString();
               year=syear.getText().toString();
               if(name==""||email==""||number==""||branch==""||year=="")
               {
                   Toast.makeText(getActivity(), "All fields are cumpulsory to fill", Toast.LENGTH_SHORT).show();
               }
               else
               {
               myRef.child(name).child("name").setValue(name);
               myRef.child(name).child("email").setValue(email);
               myRef.child(name).child("number").setValue(number);
               myRef.child(name).child("branch").setValue(branch);
               myRef.child(name).child("year").setValue(year);
                   Intent i=new Intent(getActivity(), moneyactivity.class);
                   startActivity(i);
           }
           }
       });
        return v;
    }

}
