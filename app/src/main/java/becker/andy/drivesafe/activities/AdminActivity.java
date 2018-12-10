package becker.andy.drivesafe.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

import java.lang.reflect.Field;

import becker.andy.drivesafe.MainActivity;
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


        try{
            ViewConfiguration config=ViewConfiguration.get(this);
            Field menuKeyField=ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField !=null)
                menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        }catch(Exception ex)
        {

        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.drawer_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.pending_drivers:
                //startActivity(new Intent(MainActivity.this,AdminActivity.class));
                break;
            case R.id.create_user:
                //gotoadmin
                break;
            case R.id.reporters:
                //startActivity(new Intent(MainActivity.this, DriverActivity.class));
                break;
            case R.id.addreporters:
                //startActivity(new Intent(MainActivity.this, DriverActivity.class));
                break;
            case R.id.registered_drivers:
                //startActivity(new Intent(MainActivity.this, DriverActivity.class));
                break;
            case R.id.recent_affairs:
                //startActivity(new Intent(MainActivity.this, DriverActivity.class));
                break;
            case R.id.dangerous_drivers:
                //startActivity(new Intent(MainActivity.this, DriverActivity.class));
                break;
            case R.id.log_out:
                //startActivity(new Intent(MainActivity.this, DriverActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);

        //c
    }
}
