package becker.andy.drivesafe.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import becker.andy.drivesafe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminRegisterFragment extends Fragment {

    EditText dName, dEmail, dpassword, dphone, dOwnerPhone, dLicense;
    Button dRegister;
    ImageView dImage;

    public AdminRegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_admin_register, container, false);

        dName = view.findViewById(R.id.driver_name);
        dEmail = view.findViewById(R.id.driver_email);
        dpassword = view.findViewById(R.id.driver_pass);
        dphone = view.findViewById(R.id.driver_phone);
        dOwnerPhone = view.findViewById(R.id.driver_owner_phone);
        dLicense = view.findViewById(R.id.driver_license);
        dRegister = view.findViewById(R.id.driver_register);
        dImage = view.findViewById(R.id.driver_image);
        return view;
    }

}
