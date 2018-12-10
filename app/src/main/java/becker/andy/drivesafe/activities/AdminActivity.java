package becker.andy.drivesafe.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import becker.andy.drivesafe.PrefConfig;
import becker.andy.drivesafe.R;
import becker.andy.drivesafe.fragments.AdminLoginFragment;

public class AdminActivity extends AppCompatActivity {
    private PrefConfig prefConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

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
}
