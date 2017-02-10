package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.skybox.isasetiawan.emochi.Models.Olang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ActivityOrangHilang extends AppCompatActivity {

    @BindView(R.id.rvcontact)
    RecyclerView recyclerView;
    @BindView(R.id.btn_add)
    FloatingActionButton fab;
    Bitmap bmp;

    ArrayList<Olang.Datum> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just_recycleview);
        ButterKnife.bind(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityOrangHilang.this,AddOlangActivity.class);
                startActivity(intent);
            }
        });
        fab.setVisibility(View.GONE);
        setData();
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

    public void setData(){

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Loader<Olang> loader = new Loader<>(this,Olang.class, new Loader.AfterLoad<Olang>() {
            @Override
            public void doifsuccess(Olang object) {
                data = (ArrayList<Olang.Datum>) object.data;
                recyclerView.setAdapter(new OlangAdapeter());
            }
        });
        loader.load("orangHilang/index");

    }

    public class OlangAdapeter extends RecyclerView.Adapter<OlangAdapeter.ViewHolder>{
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ActivityOrangHilang.this.getBaseContext())
                    .inflate(R.layout.olang_item,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            Olang.Datum selected = data.get(position);
            holder.nama.setText(selected.nama);
            holder.address.append(selected.address);
            holder.cp.append(selected.kontak);
            holder.usia.append(selected.usia);
            holder.sex.append(selected.sex);

            //setting photo
            Kutil.setImageFromUrl(ActivityOrangHilang.this,holder.gambar,Kutil.storageurl+selected.img);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
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
