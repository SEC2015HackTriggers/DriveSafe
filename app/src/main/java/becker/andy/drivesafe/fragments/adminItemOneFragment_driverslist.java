package becker.andy.drivesafe.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import becker.andy.drivesafe.R;

public class adminItemOneFragment_driverslist extends Fragment {
    public static adminItemOneFragment_driverslist newInstance() {
        adminItemOneFragment_driverslist fragment = new adminItemOneFragment_driverslist();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_one_admin_driverslist, container, false);
    }
}