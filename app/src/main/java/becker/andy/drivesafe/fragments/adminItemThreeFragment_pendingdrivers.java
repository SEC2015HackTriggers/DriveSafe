package becker.andy.drivesafe.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import becker.andy.drivesafe.R;

public class adminItemThreeFragment_pendingdrivers extends Fragment {
    public static adminItemThreeFragment_pendingdrivers newInstance() {
        adminItemThreeFragment_pendingdrivers fragment = new adminItemThreeFragment_pendingdrivers();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_three_admin_pendingdrivers, container, false);
    }
}