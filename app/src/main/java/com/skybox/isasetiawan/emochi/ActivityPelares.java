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
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityPelares extends AppCompatActivity {

    GridView gridView;
    ImageView sp2hp;

    private Integer[] thumbs = {
            R.drawable.penpol,
            R.drawable.skck,
            R.drawable.hilang,
            R.drawable.rame,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_grid_view_layout);
        gridView = (GridView) findViewById(R.id.geve);
        sp2hp = (ImageView) findViewById(R.id.sp2hp);
        gridView.setAdapter(new GridMenuAdapter(this,thumbs));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0) startActivity(new Intent(ActivityPelares.this,PenpolriActivity.class));
                else openlink(urls[i]);
            }
        });
        sp2hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityPelares.this,sp2hpActivity.class));
            }
        });
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

    String[] urls = {
            "https://www.google.com",
            "https://www.polri.go.id/layanan-skck.php",
            "https://www.polri.go.id/layanan-spkt.php",
            "https://www.polri.go.id/layanan-keramaian.php",
            "https://google.com",
    };

    protected void openlink(String link){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }
}
