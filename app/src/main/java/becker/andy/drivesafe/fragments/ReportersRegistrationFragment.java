package becker.andy.drivesafe.fragments;


import android.os.Bundle;
import android.app.Fragment;
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
public class ReportersRegistrationFragment extends Fragment {

    ImageView reporterImage;
    EditText reporterName, reporterEmail, reporterPass, reporterPhone, reporterLocation;
    Button reporterReg, uploadImage;


    public ReportersRegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_reporters_registration, container, false);

        reporterImage = view.findViewById(R.id.reporter_image);
        reporterName = view.findViewById(R.id.reporter_name);
        reporterEmail = view.findViewById(R.id.reporter_email);
        reporterPass = view.findViewById(R.id.reporter_pass);
        reporterPhone = view.findViewById(R.id.reporter_phone);
        reporterLocation = view.findViewById(R.id.reporter_location);
        reporterReg = view.findViewById(R.id.reporter_register);
        uploadImage = view.findViewById(R.id.upload_image);

        return view;
    }

}
