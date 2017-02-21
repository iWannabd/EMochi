package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class stnkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stnk);
        ButterKnife.bind(this);
    }

    protected void openlink(String link){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }

    @OnClick(R.id.stnkbaru)
    public void gotostnkbaru(){
        openlink("http://satlantasressmikota.com/pendaftaran-baru.html");
    }

    @OnClick(R.id.sahanstnk)
    public void aslkdj(){
        openlink("http://satlantasressmikota.com/pengesahan-stnk-tahunan.html");
    }

    @OnClick(R.id.ulangstnk)
    public void askdj(){
        openlink("http://satlantasressmikota.com/pendaftaran-ulang-stnk-5-tahun.html");
    }

    @OnClick(R.id.stnkhilang)
    public void asklda(){
        openlink("http://satlantasressmikota.com/stnk-hilang-duplikat.html");
    }
}
