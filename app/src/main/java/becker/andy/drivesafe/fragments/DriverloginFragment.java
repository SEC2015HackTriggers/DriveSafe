package becker.andy.drivesafe.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import becker.andy.drivesafe.R;

public class DriverloginFragment extends Fragment {
    EditText driverEmail, driverPass;
    Button driverLogin;

    public DriverloginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reporter_login, container, false);

        driverEmail = view.findViewById(R.id.driver_login_email);
        driverPass = view.findViewById(R.id.driver_login_pass);
        driverLogin = view.findViewById(R.id.driver_login_login);

        return view;
    }
}
