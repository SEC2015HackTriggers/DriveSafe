package becker.andy.drivesafe.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import becker.andy.drivesafe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminLoginFragment extends Fragment {

    EditText adminemail, adminpass;
    Button adminlogin;


    public AdminLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_login, container, false);


        adminemail = view.findViewById(R.id.admin_login_email);
        adminpass = view.findViewById(R.id.admin_login_pass);
        adminlogin = view.findViewById(R.id.admin_login_login);
        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAdminLogin();
            }
        });

        return view;
    }

    private void performAdminLogin() {
    }

}
