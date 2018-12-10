package becker.andy.drivesafe.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import becker.andy.drivesafe.R;

public class adminItemTwoFragment_recentaffairs extends Fragment {
    public static adminItemTwoFragment_recentaffairs newInstance() {
        adminItemTwoFragment_recentaffairs fragment = new adminItemTwoFragment_recentaffairs();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_two_admin_recentaffairs, container, false);
    }
}