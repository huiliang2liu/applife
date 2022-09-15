package com.lhl.applife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
    public void click(View view){
        ((MyApplication)getApplication()).life.class2Activity(MainActivity.class).get(0).finish();
    }
}