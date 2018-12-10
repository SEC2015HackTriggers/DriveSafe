package becker.andy.drivesafe.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import becker.andy.drivesafe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminRegisterFragment extends Fragment {


    public AdminRegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_register, container, false);
    }

}
