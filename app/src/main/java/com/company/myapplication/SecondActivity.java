package com.company.myapplication;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onResume() {
        Toast.makeText(this, "Task ID : " + getTaskId(), Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();

        if (getIntent() != null) {
            Intent i = getIntent();
            if (i.getAction() != null) {
                String action = i.getAction();

                if (action.equals("OWN_ACTION")) {
                    Toast.makeText(this, "\'OWN_ACTION\' Intent action received", Toast.LENGTH_SHORT).show();
                } else if (action.equals("SECOND_ACTIVITY")){
                    Toast.makeText(this, "\'SECOND_ACTIVITY\' Intent action received", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
