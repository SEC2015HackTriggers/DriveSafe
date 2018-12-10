package becker.andy.drivesafe.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import becker.andy.drivesafe.R;
import becker.andy.drivesafe.activities.AdminActivity;
import becker.andy.drivesafe.adapters.PendingDriversAdapter;
import becker.andy.drivesafe.classes.Mytoast;
import becker.andy.drivesafe.models.GetPendingDrivers;
import becker.andy.drivesafe.retrofit.AdminApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class adminItemThreeFragment_pendingdrivers extends Fragment {
    public static adminItemThreeFragment_pendingdrivers newInstance() {
        adminItemThreeFragment_pendingdrivers fragment = new adminItemThreeFragment_pendingdrivers();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
            public RecyclerView myrecyler;
            public List<GetPendingDrivers>Mylist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_item_three_admin_pendingdrivers, container, false);
        myrecyler=view.findViewById(R.id.pending_recycler);

        Call<List<GetPendingDrivers>> call= AdminActivity.apiInterface.getPendingDrivers("getPendingDrivers");
        call.enqueue(new Callback<List<GetPendingDrivers>>() {
            @Override
            public void onResponse(Call<List<GetPendingDrivers>> call, Response<List<GetPendingDrivers>> response) {
                Mylist=response.body();
                Mytoast.showToast(getActivity(),"in Pending");
                LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
                myrecyler.setLayoutManager(layoutManager);
                PendingDriversAdapter pendingDriversAdapter=new PendingDriversAdapter(Mylist,getActivity());
                myrecyler.setAdapter(pendingDriversAdapter);
                pendingDriversAdapter.setListener(new PendingDriversAdapter.Listener() {
                    @Override
                    public void onClick(int position) {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<GetPendingDrivers>> call, Throwable t) {
                Mytoast.showToast(getActivity(),t.getMessage().toString());
            }
        });





        return view;
    }
}