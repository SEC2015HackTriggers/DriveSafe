package becker.andy.drivesafe.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import becker.andy.drivesafe.R;
import becker.andy.drivesafe.models.GetPendingDrivers;

public class PendingDriversAdapter extends RecyclerView.Adapter<PendingDriversAdapter.MyAdapter> {

    List<GetPendingDrivers>Mylist;
    Context context;
    private Listener listener;
    public interface Listener {
        void onClick(int position);
    }

    public PendingDriversAdapter(List<GetPendingDrivers> mylist, Context context) {
        Mylist = mylist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.driver_pending_list_card_layout,null);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter myAdapter, final int i) {
        myAdapter.pending_name.setText(Mylist.get(i).driver_name);
        myAdapter.pending_licence.setText(Mylist.get(i).licence_no);
        myAdapter.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Mylist.size();
    }
    public void setListener(Listener listener){
        this.listener = listener;
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView pending_name;
        TextView pending_licence;
        ImageView pending_image;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.pending_card);
            pending_licence=itemView.findViewById(R.id.pending_licence);
            pending_name=itemView.findViewById(R.id.pending_name);
            pending_image=itemView.findViewById(R.id.pending_image);
        }
    }
}
