package com.skybox.isasetiawan.emochi;

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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContacUs extends AppCompatActivity {

    ArrayList<Polres> polresArrayList;

    @BindView(R.id.rvcontact)
    RecyclerView recyclerView;
    @BindView(R.id.btn_add)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just_recycleview);
        ButterKnife.bind(this);
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
        if (item.getItemId() == android.R.id.home)
            finish();

        return true;
    }

    public void addData(){
        polresArrayList = new ArrayList<>();
        polresArrayList.add(new Polres("POLRES SUKABUMI KOTA","Jalan Perintis Kemerdekaan No. 10, Kel. Gunung Parang, Kec. Cikole, Kota Sukabumi 43111","02666248110",-6.921052,106.926484));
        polresArrayList.add(new Polres("POLSEK CIKOLE","Jalan Tubagus Abdullah No. 2, Cikole, Kota Sukabumi, Jawa Barat 43111","0266215785",-6.910744,106.933282));
        polresArrayList.add(new Polres("POLSEK GUNUNG PUYUH","Jalan Merbabu No. 07, Gn. Puyuh, Kota Sukabumi 43122","0266218182",-6.912437,106.913317));
        polresArrayList.add(new Polres("POLSEK CITAMIANG","Jalan Pramuka No. 14, Citamiang, Kota Sukabumi 43143","0266216110",-6.943792,106.928239));
        polresArrayList.add(new Polres("POLSEK WARUDOYONG","Jalan Cemerlang No. 99, Warudoyong  Kota Sukabumi 43135","0266241712",-6.924842,106.903475));
        polresArrayList.add(new Polres("POLSEK BAROS","Jalan Raya Baros No. 203 Baros, Kota Sukabumi 43161","0266221834",-6.964552,106.939321));
        polresArrayList.add(new Polres("POLSEK CIBEUREUM","Jalan Akasia  No . 1 Cibereum, Kota Sukabumi 43162","0266234919",-6.955600,106.948333));
        polresArrayList.add(new Polres("POLSEK LEMBURSITU","Jalan Merdeka No. 158 Lembursitu, Kota Sukabumi 43168","0266231210",-6.970866,106.904186));
        polresArrayList.add(new Polres("POLSEK CISAAT","Jalan Raya Cisaat No. 190 Cisaat, Kota Sukabumi 43152","0266222352",-6.907693,106.891260));
        polresArrayList.add(new Polres("POLSEK SUKABUMI","Jalan Selabintana Km. 5.5 Sukabumi, Kab. Sukabumi 43111","0266223298",-6.886444,106.942985));
        polresArrayList.add(new Polres("POLSEK SUKARAJA","Jalan Raya Sukaraja No.176 Sukaraja, Kab. Sukabumi 43192","0266221745",-6.917732,106.963996));
        polresArrayList.add(new Polres("POLSEK SUKALARANG","Jalan Raya Sukalarang Km. 13 Sukalarang, Kab. Sukabumi 43191","0266261349",-6.876735,107.021434));
        polresArrayList.add(new Polres("POLSEK CIREUNGHAS","Jalan   Raya   Cireunghas   Km. 11.5 Cireunghas, Kab. Sukabumi 43193","0266243376",-6.945308,107.008078));
        polresArrayList.add(new Polres("POLSEK KEBONPEDES","Jalan  Sasagaran  No. 9  Kebonpedes, Kab. Sukabumi 43191","0266245983",-6.956302,106.962073));
        polresArrayList.add(new Polres("POLSEK GUNUNG GURUH","Jalan  Padjadjaran  Blok Kutamaneh Cikujang Gunung Guruh 43156","02666254856",-6.938560,106.905712));
        polresArrayList.add(new Polres("POLSEK KADUDAMPIT","Jalan Raya Situgunung Km. 8 Kadudampit, Kab. Sukabumi 43153","0266214643",-6.846843,106.925019));
        recyclerView.setAdapter(new PolresAdapter());

    }

    public class PolresAdapter extends RecyclerView.Adapter<PolresAdapter.ViewHolder>{
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ContacUs.this.getBaseContext())
                    .inflate(R.layout.gov_item,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Polres selected = polresArrayList.get(position);
            holder.nama.setText(selected.nama);
            holder.alamat.setText(selected.alamat);
            holder.phone.setText(selected.kontak);
            holder.call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+selected.kontak));
                    startActivity(intent);
                }
            });
            holder.map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri gmmIntentUri = Uri.parse("geo:"+selected.lat+","+selected.lon+"?q="+selected.lat+","+selected.lon+"("+selected.nama+")");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return polresArrayList.size() ;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            @BindView(R.id.nama_polres)
            TextView nama;
            @BindView(R.id.almat_polres)
            TextView alamat;
            @BindView(R.id.phone_polres)
            TextView phone;
            @BindView(R.id.btn_map)
            ImageView map;
            @BindView(R.id.btn_phone)
            ImageView call;

            ViewHolder(View itemView) {
                super(itemView);
                    ButterKnife.bind(this,itemView);
            }
        }
    }

    public class Polres{
        String nama,kontak,alamat;
        double lat,lon;

        Polres(String nama,String kontak,String alamat) {
            this.nama = nama;
            this.kontak = kontak;
            this.alamat = alamat;
        }

        public Polres(String nama, String alamat, String kontak, double lat, double lon) {
            this.nama = nama;
            this.kontak = kontak;
            this.alamat = alamat;
            this.lat = lat;
            this.lon = lon;
        }
    }
}
