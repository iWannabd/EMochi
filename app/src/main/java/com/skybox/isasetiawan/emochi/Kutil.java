package com.skybox.isasetiawan.emochi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by isasetiawan on 08/02/2017.
 */

public class Kutil {

    public static String storageurl = "http://e-moci.satlantasressmikota.com/storage/app/public/";

    public static void openlink(AppCompatActivity activity, String link){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link));
        activity.startActivity(intent);
    }

    public static void emergencyCall(AppCompatActivity activity){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: 02666248110"));
        activity.startActivity(intent);
    }
    public static void setImageFromUrl(final AppCompatActivity activity, final ImageView iv, String url){
        if (url.equals("")) return;
        //setting photo
        OkHttpClient ok = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(activity.getBaseContext(),"Gagal Memuat Gambar",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Bitmap bmp = BitmapFactory.decodeStream(response.body().byteStream());
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(bmp);
                    }
                });
            }
        });
    }
}
