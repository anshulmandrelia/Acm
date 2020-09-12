package e.welcome.acmbkbiet.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import e.welcome.acmbkbiet.AdapterGlimpses;
import e.welcome.acmbkbiet.AdapterRecycler;
import e.welcome.acmbkbiet.Eventdetails;
import e.welcome.acmbkbiet.GlimpsesDetails;
import e.welcome.acmbkbiet.R;
public class Glimpses extends Fragment {
    Button b1;
    FirebaseAuth mAuth;
    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<GlimpsesDetails> list =new ArrayList<>();
    Context context;
    public Glimpses() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_glimpses, container, false);
        mAuth=FirebaseAuth.getInstance();
        recyclerView=view.findViewById(R.id.recyclerglimpses);
        recyclerView.setAdapter(null);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Glimpses");
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        final AdapterGlimpses notesAdapter=new AdapterGlimpses(list,getContext());
        recyclerView.setAdapter(notesAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    GlimpsesDetails listData=dataSnapshot1.getValue(GlimpsesDetails.class);
                    list.add(listData);
                }
                notesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return view;
    }

}
