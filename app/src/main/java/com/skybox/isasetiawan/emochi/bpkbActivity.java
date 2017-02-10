package com.skybox.isasetiawan.emochi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class bpkbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpkb);
        ButterKnife.bind(this);
    }

    protected void openlink(String link){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }

    @OnClick(R.id.stnkbaru)
    public void a(){
        openlink("http://satlantasressmikota.com/bpkb-baru.html");
    }
    @OnClick(R.id.sahanstnk)
    public void b(){
        openlink("http://satlantasressmikota.com/mutasi-kendaraan.html");

    }
    @OnClick(R.id.ulangstnk)
    public void c(){
        openlink("http://satlantasressmikota.com/balik-nama-kepemilikan-kendaraan.html");

    }
    @OnClick(R.id.imageView28)
    public void d(){
        openlink("http://satlantasressmikota.com/rubah-bentuk-ganti-warna-kendaraan.html");

    }
    @OnClick(R.id.stnkhilang)
    public void e(){
        openlink("http://satlantasressmikota.com/eks-lelang-kendaraan-milik-negara.html");

    }
}
