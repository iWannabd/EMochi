package com.skybox.isasetiawan.emochi;

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

import com.skybox.isasetiawan.emochi.Models.Lantas;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArusLantasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    ArrayList<Lantas.Datum> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just_recycleview);
        recyclerView = (RecyclerView) findViewById(R.id.rvcontact);
        fab = (FloatingActionButton) findViewById(R.id.btn_add);
        fab.setVisibility(View.GONE);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
        return true;
    }

    protected void addData(){
        Loader<Lantas> loader = new Loader<>(this, Lantas.class, new Loader.AfterLoad<Lantas>() {
            @Override
            public void doifsuccess(Lantas object) {
                data = (ArrayList<Lantas.Datum>) object.data;
                recyclerView.setAdapter(new AdapterInfo());
            }
        });
        loader.load("Lantas/index");
    }

    class AdapterInfo extends RecyclerView.Adapter<AdapterInfo.ViewHolder>{
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ArusLantasActivity.this.getBaseContext())
                    .inflate(R.layout.item_info_lantas,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Lantas.Datum selected = data.get(position);
            holder.timestamp.setText(selected.createdAt);
            holder.isi.setText(selected.konten);
            Kutil.setImageFromUrl(ArusLantasActivity.this,holder.imageView,Kutil.storageurl+selected.img);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            @BindView(R.id.timestamp)
            TextView timestamp;
            @BindView(R.id.content)
            TextView isi;
            @BindView(R.id.imageView29)
            ImageView imageView;

            ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}
