package e.welcome.acmbkbiet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import e.welcome.acmbkbiet.fragments.Glimpses;

public class AdapterGlimpses extends RecyclerView.Adapter<AdapterGlimpses.viewholder> {
    List<GlimpsesDetails> notelist;
    private Context context1;
    public AdapterGlimpses(List<GlimpsesDetails> noteslist, Context context)
    {
        this.context1=context;
        this.notelist=noteslist;
    }
    @NonNull
    @Override
    public AdapterGlimpses.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflate =LayoutInflater.from(viewGroup.getContext());
        View view=inflate.inflate(R.layout.cardviewglimpses,viewGroup,false);
        return new AdapterGlimpses.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGlimpses.viewholder viewholder, int i) {
        GlimpsesDetails data=notelist.get(i);
        viewholder.title.setText(data.getName());
        Picasso.get().load(data.getImage()).into(viewholder.img);
    }

    @Override
    public int getItemCount() {
        return notelist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder
    {   TextView title;
        ImageView img;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.glimpsesname);
            img=itemView.findViewById(R.id.glimpsesimage);

        }
    }
}
