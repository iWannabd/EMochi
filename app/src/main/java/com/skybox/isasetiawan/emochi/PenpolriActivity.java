package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class PenpolriActivity extends AppCompatActivity {

    GridView gv;

    Integer[] thumbs = {
            R.drawable.taruna,
            R.drawable.perwira,
            R.drawable.bitara,
            R.drawable.tamtama
    };

    String[] urls = {
            "http://penerimaan.polri.go.id/syarat_akpol",
            "http://penerimaan.polri.go.id/syarat_brigadir",
            "http://penerimaan.polri.go.id/syarat_sipss",
            "http://penerimaan.polri.go.id/syarat_tamtama"
    };

    protected void openlink(String link){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penpolri);
        gv = (GridView) findViewById(R.id.geve);
        gv.setAdapter(new GridMenuAdapter(this,thumbs));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openlink(urls[i]);
            }
        });
    }
}
