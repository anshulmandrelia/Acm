package e.welcome.acmbkbiet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NextActivity extends AppCompatActivity {
  ImageView imgshower;
  TextView txtname,txtdescription,txtvenue;
  String url,name,description,venue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        imgshower=findViewById(R.id.imageshowerevents);
        txtname=findViewById(R.id.eventname);
        txtdescription=findViewById(R.id.eventdescription);
        txtvenue=findViewById(R.id.eventvenue);
        url=getIntent().getStringExtra("imageurl");
        name=getIntent().getStringExtra("eventname");
        description=getIntent().getStringExtra("eventdescription");
        venue=getIntent().getStringExtra("eventvenue");
        Picasso.get().load(url).into(imgshower);
        txtname.setText("Event Name:-"+name);
        txtdescription.setText("Description:-"+description);
        txtvenue.setText("Venue:-"+venue);
    }
}
