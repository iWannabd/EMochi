package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.skybox.isasetiawan.emochi.Kutil;
import com.skybox.isasetiawan.emochi.PetaActivity;
import com.skybox.isasetiawan.emochi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PilihaAngkotActivity extends AppCompatActivity {

    @BindView(R.id.list)
    ListView listView;

    String[] angkots = {
            "Terminal Sukaraja - ",
            "Terminal Bungbulang – Jl.Stasiun Timur",
            "Terminal Lembursitu – Jl.Pabuaran",
            "Terminal Lembursitu – Jl.Pasundan",
            "Goalpara – Jl.Stasiun Timur",
            "Subangjaya – Jl.Stasiun Timur",
            "Terminal Lembursitu – Term.Sudirman",
            "Cisaat – Pasar Pelita",
            "Cikareo – Jl.Lettu Bakri",
            "Selabintana – Jl.RE.Martadinata",
            "Parungseah – Jl.Mesjid",
            "Bhayangkara – Jl.RE.Martadinata (1)",
            "Bhayangkara – Jl.RE.Martadinata (2)",
            "Balandongan – Jl.Tipar Gede (Ramayana)",
            "Cicadas – Jl.Tipar Gede (Ramayana)",
            "Santiong – Jl.Tipar Gede (Ramayana)",
            "Terminal Jubleg – Jl.Tipar Gede (Ramayana)",
            "Terminal Bungbulang – Jl.Tipar Gede (Ramayana)",
            "Perum Nanggeleng – Pasar Pelita",
            "Limusnunggal – Jl.Stasiun Timur",
            "Cikundul - Jl.Tipar Gede (Ramayana) via Jl.Baros"
    };

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piliha_angkot);
        ButterKnife.bind(this);

        intent = new Intent(this, PetaActivity.class);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,angkots);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent.putExtra("kodeangkot",i);
                startActivity(intent);
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


}
