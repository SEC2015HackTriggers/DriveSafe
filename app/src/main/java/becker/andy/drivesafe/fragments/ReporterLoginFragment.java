package becker.andy.drivesafe.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import becker.andy.drivesafe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReporterLoginFragment extends Fragment {

    EditText reporterEmail, reporterPass;
    Button reporterLogin;

    public ReporterLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reporter_login, container, false);

        reporterEmail = view.findViewById(R.id.reporter_login_email);
        reporterPass = view.findViewById(R.id.reporter_login_pass);
        reporterLogin = view.findViewById(R.id.reporter_login_login);

        return view;
    }

}
