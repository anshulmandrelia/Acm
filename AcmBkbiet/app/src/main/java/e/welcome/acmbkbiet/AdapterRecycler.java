package e.welcome.acmbkbiet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.viewholder> {
    List<Eventdetails> notelist;
    private Context context1;
    public AdapterRecycler(List<Eventdetails> noteslist, Context context)
    {
        this.context1=context;
        this.notelist=noteslist;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflate =LayoutInflater.from(viewGroup.getContext());
        View view=inflate.inflate(R.layout.eventscardview,viewGroup,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int i) {
        Eventdetails data=notelist.get(i);
        viewholder.title.setText(data.getName());
        viewholder.description.setText(data.getDescription());
        viewholder.venue.setText(data.getVenue());
        Picasso.get().load(data.getImage()).into(viewholder.img);
    }

    @Override
    public int getItemCount() {
        return notelist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder
    {   TextView title,description,venue;
    ImageView img;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.eventname);
            description=itemView.findViewById(R.id.eventdescription);
            venue=itemView.findViewById(R.id.eventvenue);
            img=itemView.findViewById(R.id.eventimage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Eventdetails listData =notelist.get(getAdapterPosition());
                    Intent i=new Intent(context1, NextActivity.class);
                    i.putExtra("imageurl",listData.getImage());
                    i.putExtra("eventname",listData.getName());
                    i.putExtra("eventdescription",listData.getDescription());
                    i.putExtra("eventvenue",listData.getVenue());
                    context1.startActivity(i);
                }
            });
        }
    }
}
