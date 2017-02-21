package com.skybox.isasetiawan.emochi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class sp2hpActivity extends AppCompatActivity {

    @BindView(R.id.nama)
    EditText nama;

    ProgressDialog pg;

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp2hp);
        ButterKnife.bind(this);

        pg = new ProgressDialog(this);
        pg.setMessage("Sebentar");
    }

    @OnClick(R.id.btn_submit)
    public void submit(){
        pg.show();

        JsonObject query = new JsonObject();
        query.addProperty("code",nama.getText().toString());

        RequestBody requestBody = RequestBody.create(JSON,query.toString());

        OkHttpClient ok = new OkHttpClient.Builder()
                .addInterceptor(new Loader.LoggingInterceptor())
                .build();
        Request request = new Request.Builder()
                .url(Loader.domain+"spph/cari")
                .post(requestBody)
                .build();

        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code()==200){
                    final String data = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(sp2hpActivity.this,ActivityDokumen.class);
                            intent.putExtra("data",data);
                            startActivity(intent);
                            pg.dismiss();
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(sp2hpActivity.this,"SP2H tidak ditemukan",Toast.LENGTH_LONG).show();
                            pg.dismiss();
                        }
                    });
                }
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
        return true;
    }
}
