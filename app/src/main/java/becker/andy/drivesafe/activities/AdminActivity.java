package becker.andy.drivesafe.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import becker.andy.drivesafe.PrefConfig;
import becker.andy.drivesafe.R;
import becker.andy.drivesafe.fragments.*;
import becker.andy.drivesafe.retrofit.ApiClient;
import becker.andy.drivesafe.retrofit.ApiInterface;

public class AdminActivity extends AppCompatActivity implements AdminLoginFragment.OnPerformanceListerner {
    public static PrefConfig prefConfig;
    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        prefConfig=new PrefConfig(this);

        if(findViewById(R.id.admin_fragment_container)!= null){
            if(savedInstanceState != null){
                return;
            }
            if(prefConfig.readLoginStatus()){


            }else{
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.admin_fragment_container,new AdminLoginFragment())
                        .commit();
            }
        }
    }

    @Override
    public void performWelcome() {
        getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container,new AdminOneFragment()).commit();
    }

    @Override
    public void performWelcomeDriver() {

    }
}
