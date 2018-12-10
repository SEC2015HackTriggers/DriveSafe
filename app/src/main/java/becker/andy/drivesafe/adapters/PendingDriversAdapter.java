package becker.andy.drivesafe.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
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
    public void onBindViewHolder(@NonNull MyAdapter myAdapter, int i) {
        myAdapter.pending_name.setText(Mylist.get(i).driver_name);
        myAdapter.pending_licence.setText(Mylist.get(i).licence_no);

        Glide.with(context).load(Mylist.get(i).driver_pic_address)
                .into(myAdapter.pending_image);
    }

    @Override
    public int getItemCount() {
        return Mylist.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        TextView pending_name;
        TextView pending_licence;
        ImageView pending_image;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            pending_licence=itemView.findViewById(R.id.pending_licence);
            pending_name=itemView.findViewById(R.id.pending_name);
            pending_image=itemView.findViewById(R.id.pending_image);
        }
    }
}
