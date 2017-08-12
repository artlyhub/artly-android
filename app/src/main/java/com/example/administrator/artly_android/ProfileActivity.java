package com.example.administrator.artly_android;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_profile);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        intent = new Intent(ProfileActivity.this,MainActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_search:
                        intent = new Intent(ProfileActivity.this,SearchActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_crowed_funding:
                        intent = new Intent(ProfileActivity.this,CrowedFundingActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_action:
                        intent = new Intent(ProfileActivity.this,ActionActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_profile:
                        return true;
                }
                return false;
            }
        });
    }
}
