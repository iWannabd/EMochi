package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.skybox.isasetiawan.emochi.Models.Spph;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityDokumen extends AppCompatActivity {

    Spph spph;
    Gson gson = new Gson();

    @BindView(R.id.rv_dokumen)
    RecyclerView rv;

    @BindView(R.id.nama_dok)
    TextView namadok;

    @BindView(R.id.lp_num)
    TextView lpnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumen);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        spph = gson.fromJson(intent.getStringExtra("data"),Spph.class);
        rv.setAdapter(new DokumenAdapter());

        namadok.append(spph.nama);
        lpnum.append(spph.lpnum);
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

    public class DokumenAdapter extends RecyclerView.Adapter<DokumenAdapter.ViewHolder>{
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(ActivityDokumen.this.getBaseContext()).inflate(R.layout.item_dokumen,parent,false));
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
//            int pos = position +1;
            holder.namadok.setText(spph.data.get(position).nama);
            holder.bg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Kutil.openlink(ActivityDokumen.this,Kutil.storageurl+spph.data.get(position).fileurl);
                }
            });
        }

        @Override
        public int getItemCount() {
            return spph.data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            @BindView(R.id.nama_dok)
            TextView namadok;

            @BindView(R.id.bg_dok)
            ConstraintLayout bg;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }


}
