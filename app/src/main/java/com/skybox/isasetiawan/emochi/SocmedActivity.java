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

public class SocmedActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just_gridview);
        gridView = (GridView) findViewById(R.id.geve);
        gridView.setAdapter(new GridMenuAdapter(this,thumbs));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openlink(urls[i]);
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

    private Integer[] thumbs = {
            R.drawable.web,
            R.drawable.fb,
            R.drawable.tw,
            R.drawable.ig,
            R.drawable.pi,
            R.drawable.yt,
    };

    private String[] urls = {
            "http://www.satlantasressmikota.com/",
            "https://m.facebook.com/profile.php?id=100005359785537&tsid=0.5811878519531355&source=typeahead",
            "https://twitter.com/LantasKotaSki",
            "https://www.instagram.com/tmc.ressmikota/",
            "https://plus.google.com/113282335178305512315",
            "https://www.youtube.com/channel/UCZ3cyMvgB3dlcUMJ7R3Yapw/"
    };

    protected void openlink(String link){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }

}
