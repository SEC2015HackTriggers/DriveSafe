package becker.andy.drivesafe;

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
import android.view.ViewConfiguration;

import java.lang.reflect.Field;


import becker.andy.drivesafe.activities.AdminActivity;

import becker.andy.drivesafe.activities.DriverActivity;
import becker.andy.drivesafe.fragments.generalItemOneFragment;
import becker.andy.drivesafe.fragments.generalItemThreeFragment;
import becker.andy.drivesafe.fragments.generalItemTwoFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        getSupportActionBar().setDisplayShowHomeEnabled(true);
        try{
            ViewConfiguration config=ViewConfiguration.get(this);
            Field menuKeyField=ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField !=null)
                menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        }catch(Exception ex)
        {

        }

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.general_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.driver_list:
                                selectedFragment = generalItemOneFragment.newInstance();
                                break;
                            case R.id.recent_affairs:
                                selectedFragment = generalItemTwoFragment.newInstance();
                                break;
                            case R.id.dang_driver:
                                selectedFragment = generalItemThreeFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.homeactionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.admin_login:
                startActivity(new Intent(MainActivity.this,AdminActivity.class));
                break;
           case R.id.reporter_login:
                //gotoadmin
                break;
            case R.id.driver_reg:
                startActivity(new Intent(MainActivity.this, DriverActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);

        //c
    }
}
