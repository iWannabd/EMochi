package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class ActivityPelantas extends AppCompatActivity {

    GridView gridView;

    private Integer[] thumbs = {
            R.drawable.samsat,
            R.drawable.pelayanansim,
            R.drawable.tilang,
            R.drawable.sim,
            R.drawable.angkot,
            R.drawable.inflantas,
    };

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just_gridview);
        gridView = (GridView) findViewById(R.id.geve);
        gridView.setAdapter(new GridMenuAdapter(this,thumbs));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    startActivity(new Intent(ActivityPelantas.this,SamsatActivity.class));
                }
                if (i==1){
                    openlink("http://satlantasressmikota.com/sim.html");
                }
                if (i==2){
                    openlink("http://satlantasressmikota.com/tilang.html");
                }
                if (i==3){
                    Toast.makeText(getBaseContext(),"Maaf, menu belum tersedia",Toast.LENGTH_SHORT).show();
                }
                if(i==4){
                    startActivity(new Intent(ActivityPelantas.this,AngkotActivity.class));
                }
                if (i==5){
                    startActivity(new Intent(ActivityPelantas.this,ArusLantasActivity.class));
                }

            }
        });
    }

    protected void openlink(String link){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }


}
