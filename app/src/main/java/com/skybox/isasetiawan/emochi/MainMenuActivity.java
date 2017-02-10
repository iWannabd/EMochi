package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.darurat_call,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.darurat_call){
            Kutil.emergencyCall(this);
        }
        return true;
    }

    @OnClick(R.id.contact)
    public void goToContactUs(){
        Intent intent = new Intent(this,ContacUs.class);
        startActivity(intent);
    }
    @OnClick(R.id.imageView7)
    public void gotoSocmed(){
        Intent intent = new Intent(this,SocmedActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.imageView9)
    public void gotoPelayanan(){
        Intent intent = new Intent(this,ActivityPelares.class);
        startActivity(intent);
    }

    @OnClick(R.id.imageView10)
    public void gotoPelares(){
        Intent intent = new Intent(this,ActivityPelantas.class);
        startActivity(intent);
    }

    @OnClick(R.id.imageView8)
    public void gotoOlangIlang(){
        Intent intent = new Intent(this,ActivityOrangHilang.class);
        startActivity(intent);
    }

    @OnClick(R.id.imageView2)
    public void gotoDPO(){
        Intent intent = new Intent(this,ActivityDPO.class);
        startActivity(intent);
    }

    @OnClick(R.id.imageView3)
    public void gotoComplain(){
        Intent intent = new Intent(this,PengaduanActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.imageView5)
    public void gotogov(){
        Intent intent = new Intent(this,PemerintahanActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.imageView4)
    public void gotonews(){
        Intent intent = new Intent(this,BeritaActivity.class);
        startActivity(intent);
    }
}
