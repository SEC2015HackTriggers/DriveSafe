package becker.andy.drivesafe.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import becker.andy.drivesafe.PrefConfig;
import becker.andy.drivesafe.R;
import becker.andy.drivesafe.fragments.*;
import becker.andy.drivesafe.retrofit.ApiClient;
import becker.andy.drivesafe.retrofit.ApiInterface;

public class AdminActivity extends AppCompatActivity implements AdminLoginFragment.OnPerformanceListerner {
    public static PrefConfig prefConfig;
    public static ApiInterface apiInterface;
    FrameLayout admin_frame, container_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Fragment selectedFragment=new adminItemOneFragment_driverslist();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_admin, selectedFragment);
        transaction.commit();


        admin_frame=(FrameLayout)findViewById(R.id.frame_layout_admin);
        container_frame=(FrameLayout)findViewById(R.id.admin_fragment_container);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        prefConfig=new PrefConfig(this);

        if(findViewById(R.id.admin_fragment_container)!= null){
            if(savedInstanceState != null){
                return;
            }
            if(prefConfig.readLoginStatus()){
                performWelcome();

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
        container_frame.setVisibility(View.GONE);
        admin_frame.setVisibility(View.VISIBLE);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.admin_navigation);
        bottomNavigationView.setVisibility(View.VISIBLE);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.driver_list_admin:
                                selectedFragment = adminItemOneFragment_driverslist.newInstance();
                                break;
                            case R.id.recent_affairs_admin:
                                selectedFragment = adminItemTwoFragment_recentaffairs.newInstance();
                                break;
                            case R.id.pending_drivers_admin:
                                selectedFragment = adminItemThreeFragment_pendingdrivers.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout_admin, selectedFragment);


                        transaction.commit();
                        return true;
                    }
                });
    }

    @Override
    public void performWelcomeDriver() {

    }
}
