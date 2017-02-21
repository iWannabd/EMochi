package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vansuita.pickimage.PickImageDialog;
import com.vansuita.pickimage.PickSetup;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.listeners.IPickResult;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddDpoActivity extends AppCompatActivity implements IPickResult {

    private int PICK_IMAGE_REQUEST = 1;
    private static final MediaType MEDIA_TYPE = MediaType.parse("image/*");
    @BindView(R.id.nama_orang)
    EditText nama;
    @BindView(R.id.alamat_orang)
    EditText kasus;
    @BindView(R.id.usia_orang)
    EditText usia;
    @BindView(R.id.jk_orang)
    EditText orang;
    @BindView(R.id.call_orang)
    EditText call;
    @BindView(R.id.preview)
    ImageView preview;


    String TAG = getClass().getSimpleName();
    File file;

    @NonNull
    private Boolean isValid(){
        EditText[] fields = {nama,kasus,usia,orang,call};
        for (EditText e : fields) {
            if (e.getText().length()<=0) return false;
        }
        return true;
    }

    @OnClick(R.id.btn_submit)
    public void sbmit(){
        if (!isValid() && file==null) Toast.makeText(this, "Borang belum lengkap", Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(this, "Sebentar", Toast.LENGTH_LONG).show();
            OkHttpClient clien = new OkHttpClient();
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file",file.getName(),
                            RequestBody.create(MEDIA_TYPE,file))
                    .addFormDataPart("nama",nama.getText().toString())
                    .addFormDataPart("kasus",kasus.getText().toString())
                    .addFormDataPart("usia",usia.getText().toString())
                    .addFormDataPart("sex",orang.getText().toString())
                    .addFormDataPart("call",call.getText().toString())
                    .build();
            Request request = new Request.Builder()
                    .url(Loader.domain+"DPO/new")
                    .post(requestBody)
                    .build();

            clien.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(AddDpoActivity.this, "Maaf, gagal :(", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    Document doc = Jsoup.parse(response.body().string());
                    Log.d(TAG, "onResponse: "+doc.body().text());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (response.code()==201){
                                Toast.makeText(AddDpoActivity.this, "Berhasil :), Laporan anda akan divalidasi", Toast.LENGTH_SHORT).show();
                                finish();
                            } else Toast.makeText(AddDpoActivity.this, "Maaf, gagal :(", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }

    }
    @OnClick(R.id.btn_pick)
    public void selImage(){
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"), PICK_IMAGE_REQUEST);
        PickSetup pickSetup = new PickSetup("com.skybox.isasetiawan.emochi");
        pickSetup.setTitle("Pilih Gambar");
        PickImageDialog.on(this,pickSetup);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dpo);
        ButterKnife.bind(this);
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

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent spph) {
//        super.onActivityResult(requestCode, resultCode, spph);
//        if (requestCode==PICK_IMAGE_REQUEST && resultCode==AppCompatActivity.RESULT_OK){
//            File file = new File(spph.getData().getPath());
//            Bitmap bmp = BitmapFactory.decodeFile(file.getAbsolutePath());
//            Log.d(TAG, "onActivityResult: "+file.getAbsolutePath());
//            preview.setImageURI(Uri.fromFile(file));
//        }
//    }

    @Override
    public void onPickResult(PickResult r) {
        if (r.getError() == null){
            file = new File(r.getPath());
            preview.setImageBitmap(r.getBitmap());
            Log.d(TAG, "onPickResult: "+file.getPath());
        } else Toast.makeText(AddDpoActivity.this, "Gagal memuat media", Toast.LENGTH_SHORT).show();
    }
}
