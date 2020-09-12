package e.welcome.acmbkbiet;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.Menu;

import e.welcome.acmbkbiet.fragments.AboutAcm;
import e.welcome.acmbkbiet.fragments.ContactUs;
import e.welcome.acmbkbiet.fragments.Devlopers;
import e.welcome.acmbkbiet.fragments.EventsFragment;
import e.welcome.acmbkbiet.fragments.Glimpses;
import e.welcome.acmbkbiet.fragments.JoinUs;
import e.welcome.acmbkbiet.fragments.OurTeam;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private boolean loadfrag(Fragment fragment)
    {
        if(fragment!=null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentshow,fragment)
                    .commit();
            return true;
        }
        return false;
    }
//    Button b1;
  FirebaseAuth mAuth;
//    RecyclerView recyclerView;
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;
//    List<Eventdetails> list =new ArrayList<>();
//    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       mAuth=FirebaseAuth.getInstance();
        loadfrag(new EventsFragment());
//        recyclerView=findViewById(R.id.recycler);
//        recyclerView.setAdapter(null);
//        firebaseDatabase= FirebaseDatabase.getInstance();
//        databaseReference=firebaseDatabase.getReference("Events");
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        final AdapterRecycler notesAdapter=new AdapterRecycler(list,this);
//        recyclerView.setAdapter(notesAdapter);
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
//                {
//                    Eventdetails listData=dataSnapshot1.getValue(Eventdetails.class);
//                    list.add(listData);
//                }
//                notesAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "NO NOTIFICATION YET", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            mAuth.signOut();
            finish();
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment=null;
        int id = item.getItemId();
        if (id == R.id.nav_events) {
            fragment=new EventsFragment();
        } else if (id == R.id.nav_glimpses) {
            fragment=new Glimpses();
        } else if (id == R.id.nav_joinus) {
          fragment=new JoinUs();
        } else if (id == R.id.nav_team) {
          fragment=new OurTeam();
        } else if (id == R.id.nav_about) {
            fragment=new AboutAcm();
        }
        else if (id == R.id.nav_devloper) {
            fragment=new Devlopers();
        }
        else if (id == R.id.nav_contactus) {
            fragment=new ContactUs();
        }
        else if (id == R.id.nav_logout) {
            mAuth.signOut();
            finish();
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return loadfrag(fragment);
    }
}
