package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SamsatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsat);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.imageView25)
    public void gotostnk(){
        startActivity(new Intent(this,stnkActivity.class));
    }

    @OnClick(R.id.imageView26)
    public void gotobpkb(){
        startActivity(new Intent(this,bpkbActivity.class));
    }
}
