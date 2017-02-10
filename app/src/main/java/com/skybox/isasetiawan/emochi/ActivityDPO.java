package com.skybox.isasetiawan.emochi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skybox.isasetiawan.emochi.Models.DPO;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityDPO extends AppCompatActivity {

    ArrayList<DPO.Datum> data = new ArrayList<>();

    @BindView(R.id.rvcontact)
    RecyclerView recyclerView;
    @BindView(R.id.btn_add)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just_recycleview);
        ButterKnife.bind(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityDPO.this,AddDpoActivity.class);
                startActivity(intent);
            }
        });
        fab.setVisibility(View.GONE);
        addData();
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

    protected void addData(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Loader<DPO> loader = new Loader<>(this,DPO.class, new Loader.AfterLoad<DPO>() {
            @Override
            public void doifsuccess(DPO object) {
                data = (ArrayList<DPO.Datum>) object.data;
                recyclerView.setAdapter(new OrangAdapter());
            }
        });
        loader.load("DPO/index");
    }


    public class OrangAdapter extends RecyclerView.Adapter<OrangAdapter.ViewHolder>{


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(ActivityDPO.this.getBaseContext()).inflate(R.layout.olang_item,parent,false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            DPO.Datum selected = data.get(position);
            holder.nama.setText(selected.nama);
            holder.address.append(selected.kasus);
            holder.usia.append(selected.usia);
            holder.sex.append(selected.sex);
            holder.cp.setText("Call Center: "+selected.call);
            Kutil.setImageFromUrl(ActivityDPO.this,holder.gambar,Kutil.storageurl+selected.img);

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            @BindView(R.id.person_name)
            TextView nama;
            @BindView(R.id.person_age)
            TextView usia;
            @BindView(R.id.person_sex)
            TextView sex;
            @BindView(R.id.person_cp)
            TextView cp;
            @BindView(R.id.person_address)
            TextView address;
            @BindView(R.id.gambar)
            ImageView gambar;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}
