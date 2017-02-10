package com.skybox.isasetiawan.emochi;

import android.content.Intent;
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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PemerintahanActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    ArrayList<Goverment> data = new ArrayList<>();

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
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }

    public class Goverment{
        String nama,alamat,kontak,url;
        double lat,lon;

        public Goverment(String nama, String alamat, String kontak, String url, double lat,double lon) {
            this.nama = nama;
            this.alamat = alamat;
            this.kontak = kontak;
            this.url = url;
            this.lat = lat;
            this.lon = lon;
        }
    }

    protected void addData(){
        data.add(new Goverment("Pemda Kota Sukabumi",
                "Jl.R.Syamsudin, S.H. No.25 Kota Sukabumi – Jawa Barat",
                "0266 221123",
                "http://www.sukabumikota.go.id/",
                -6.918065,106.931627));

        data.add(new Goverment("Kodim 0607 Sukabumi",
                "JL. R.A. Kosasih, No. 12, Cisarua, Kec. Sukabumi, Kota Sukabumi, Jawa Barat 43192",
                "0266 4203294",
                "http://kodim0607-kotasukabumi.com/",
                -6.919318,106.954733));

        data.add(new Goverment("Kejaksaan Negeri Kota Sukabumi",
                "Jl. Perintis Kemerdekaan No. 6 Kota Sukabumi – Jawa Barat",
                "0266 215481",
                "http://www.kejari-sukabumi.go.id/",
                -6.921596,106.926251));

        data.add(new Goverment("Pengadilan Negeri Kota Sukabumi",
                "JL. R.A. Kosasih, No. 12, Cisarua, Kec. Sukabumi, Kota Sukabumi, Jawa Barat 43192",
                "0266 221074",
                "http://pn-sukabumikota.go.id/",
                -6.912517,106.920218));

        data.add(new Goverment("Pengadilan Agama Kota Sukabumi",
                "Jl. Taman Bahagia No. 19, Benteng, Warudoyong, Benteng, Sukabumi, Kota Sukabumi, Jawa Barat 43132",
                "0266 213790",
                "http://www.pa-sukabumi.go.id/",
                -6.925628,106.919062));

        data.add(new Goverment("DPRD Kota Sukabumi",
                "Jl. Insinyur H. Djuanda No.10, Cikole, Kec. Sukabumi, Kota Sukabumi, Jawa Barat 43111",
                "0266 221127",
                "http://dprd-sukabumikota.go.id/",
                -6.919217,106.931597));

        data.add(new Goverment("Damkar UPT Kota Sukabumi",
                "Jl. Julius Usman No.2, Nyomplong, Warudoyong, Kota Sukabumi, Jawa Barat 65117",
                "0266 222155",
                "-",
                -6.923028,106.925753));

        data.add(new Goverment("Dishub Kota Sukabumi",
                "JL. Arief Rahman Hakim, Benteng, Warudoyong, Kota Sukabumi, Jawa Barat 43132",
                "0266 222142",
                "http://twitter.com/dishubkotsi",
                -6.921178,106.919879));

        data.add(new Goverment("KPU Kota Sukabumi",
                "Jalan Otista No. 175, Nanggeleng, Citamiang, Kota Sukabumi, Jawa Barat 43145",
                "0266 221048",
                "http://www.kpu-sukabumikota.go.id/",
                -6.931119,106.932620));

        data.add(new Goverment("RSUD R. Syamsudin, SH",
                "Jl. Rumah Sakit No. 1, Cikole, Kota Sukabumi, Jawa Barat 43113",
                "0266 225180",
                "-",
                -6.914943,106.934876));

        data.add(new Goverment("RSUD Al-Mulk",
                "Jl. Pelabuhan II Km 6 Lembursitu Kota Sukabumi",
                "0266 6243088",
                "-",
                -6.958609,106.897543));

        data.add(new Goverment("RS. Kartika",
                "Jl. Jendral Ahmad Yani No. 18 A, Nyomplong, Sukabumi, Kota Sukabumi, Jawa Barat 43131",
                "0266 6250905",
                "http://kartikamedika.co.id/",
                -6.921926,106.923865));

        data.add(new Goverment("RS. Asyifa",
                "Jl. Jend. Sudirman, Gunungpuyuh, Kec. Sukabumi, Kota Sukabumi, Jawa Barat 43123",
                "0266 218762",
                "http://www.rsi-assyifa.com/",
                -6.919156,106.917148));

        data.add(new Goverment("RS. Ridogalih",
                "Jalan Gudang No. 24, Kebonjati, Cikole, Kebonjati, Kec. Sukabumi, Kota Sukabumi, Jawa Barat 43113",
                "0266 221983",
                "-",
                -6.921899,106.934472));

        data.add(new Goverment("RS. Hermina",
                "Jl. Raya Sukaraja, RT. 003/ RW. 03, Sukaraja, Sukabumi, Jawa Barat 43192",
                "0266 6252525",
                "http://herminahospitalgroup.com/home/cabang/sukabumi",
                -6.918369,106.961154));

        data.add(new Goverment("RS. Bhayangkara",
                "Jl. Aminta Azmali No.59A, Sriwidari, Kec. Sukabumi, Kota Sukabumi, Jawa Barat 43121",
                "0266 226262",
                "-",
                -6.912081,106.922557));

        recyclerView.setAdapter(new GovAdapter());
    }

    public class GovAdapter extends RecyclerView.Adapter<GovAdapter.ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(PemerintahanActivity.this.getBaseContext())
                    .inflate(R.layout.gov_item,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Goverment selected = data.get(position);
            holder.nama.setText(selected.nama);
            holder.alamat.setText(selected.alamat);
            holder.url.setText(selected.url);
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
                    // Creates an Intent that will load a map of San Francisco
                    Uri gmmIntentUri = Uri.parse("geo:"+selected.lat+","+selected.lon+"?q="+selected.lat+","+selected.lon+"("+selected.nama+")");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            @BindView(R.id.nama_polres)
            TextView nama;
            @BindView(R.id.almat_polres)
            TextView alamat;
            @BindView(R.id.phone_polres)
            TextView url;
            @BindView(R.id.btn_map)
            ImageView map;
            @BindView(R.id.btn_phone)
            ImageView call;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }

    }

}
