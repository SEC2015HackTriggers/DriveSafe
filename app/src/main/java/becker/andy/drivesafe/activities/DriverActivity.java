package becker.andy.drivesafe.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import becker.andy.drivesafe.PrefConfig;
import becker.andy.drivesafe.R;
import becker.andy.drivesafe.fragments.AdminLoginFragment;
import becker.andy.drivesafe.fragments.DriverRegistrationFragment;
import becker.andy.drivesafe.fragments.DriverSuccessFullFragment;
import becker.andy.drivesafe.retrofit.ApiClient;
import becker.andy.drivesafe.retrofit.ApiInterface;

public class DriverActivity extends AppCompatActivity  implements DriverRegistrationFragment.OnPerformanceListerner {

    public static ApiInterface apiInterface;
    public static PrefConfig prefConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        prefConfig=new PrefConfig(this);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        if(findViewById(R.id.driver_fragment_container) != null){
            if(savedInstanceState != null){

                return;
            }
            if(prefConfig.readLoginStatus()){
                performWelcomeDriver();
            }
            else {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.driver_fragment_container,new DriverRegistrationFragment())
                        .commit();
            }

        }

    }


    @Override
    public void performWelcomeDriver() {
        getSupportFragmentManager().beginTransaction().replace(R.id.driver_fragment_container,new DriverSuccessFullFragment()).commit();
    }

    @Override
    public void performWelcome() {

    }
}
