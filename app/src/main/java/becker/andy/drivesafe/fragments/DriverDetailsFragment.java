package becker.andy.drivesafe.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import becker.andy.drivesafe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DriverDetailsFragment extends Fragment {

    TextView dName, dEmail, dPhone, dOwnerPhone, dLicense;
    EditText cardPlate;

    public DriverDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_driver_details, container, false);

        dName = view.findViewById(R.id.name);
        dEmail = view.findViewById(R.id.email);
        dPhone = view.findViewById(R.id.phone);
        dOwnerPhone = view.findViewById(R.id.ownerPhone);
        dLicense = view.findViewById(R.id.license);

        cardPlate = view.findViewById(R.id.numberPlate);

        return view;
    }

}
