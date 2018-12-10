package becker.andy.drivesafe.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import becker.andy.drivesafe.R;
import retrofit2.http.GET;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminOneFragment extends android.support.v4.app.Fragment {


    public AdminOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_one, container, false);
    }

}
