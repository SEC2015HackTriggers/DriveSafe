package becker.andy.drivesafe.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import becker.andy.drivesafe.MainActivity;
import becker.andy.drivesafe.R;
import becker.andy.drivesafe.activities.AdminActivity;
import becker.andy.drivesafe.classes.Mytoast;
import becker.andy.drivesafe.models.AdminLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminLoginFragment extends Fragment {

    EditText adminemail, adminpass;
    Button adminlogin;

    public static interface OnPerformanceListerner{
         public void performWelcome();
    }
    OnPerformanceListerner onPerformanceListerner;


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
        String email=adminemail.getText().toString().trim();
        String password=adminpass.getText().toString().trim();
        if(email.equals("") || password.equals("")){
            return;
        }

        Call<AdminLogin> call= AdminActivity.apiInterface.performLogin("admin",email,password);
        call.enqueue(new Callback<AdminLogin>() {
            @Override
            public void onResponse(Call<AdminLogin> call, Response<AdminLogin> response) {
                if(response.body().getResponse().equals("ok")){
                    AdminActivity.prefConfig.writeLoginStatus(true);
                    AdminActivity.prefConfig.writeShopName(response.body().getName());
                    Mytoast.showToast(getActivity(),"Admin Logged In");
                    onPerformanceListerner.performWelcome();

                }
            }

            @Override
            public void onFailure(Call<AdminLogin> call, Throwable t) {
                    Mytoast.showToast(getActivity(),t.getMessage().toString());
            }
        });
    }

    public void SetImage(View view){

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity= (Activity) context;
        onPerformanceListerner= (OnPerformanceListerner) activity;
    }
}
