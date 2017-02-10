package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddOlangActivity extends AppCompatActivity {

    private int PICK_IMAGE_REQUEST = 1;

    @BindView(R.id.nama_orang)
    TextView nama;
    @BindView(R.id.alamat_alamat)
    TextView alamat;
    @BindView(R.id.usia_orang)
    TextView usia;
    @BindView(R.id.jk_orang)
    TextView orang;
    @BindView(R.id.call_orang)
    TextView call;

    @OnClick(R.id.btn_submit)
    public void sbmit(){
        Toast.makeText(this, "Maaf server belum tersedia", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_pick1)
    public void setImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_olang);
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

}
