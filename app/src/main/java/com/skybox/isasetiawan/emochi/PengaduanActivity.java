package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PengaduanActivity extends AppCompatActivity {

    @OnClick(R.id.imageView21)
    public void sms(){
        String nomer = "081563120868";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",nomer,null)));
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
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }

    @OnClick(R.id.imageView22)
    public void phone(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+"0266245067"));
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduan);
        ButterKnife.bind(this);
    }
}
