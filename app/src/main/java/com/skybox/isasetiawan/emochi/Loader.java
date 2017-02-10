package com.skybox.isasetiawan.emochi;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by isasetiawan on 01/02/2017.
 * hai, kelas ini dipergunakan untuk memuat obyek
 */

public class Loader<T> {
    private AppCompatActivity activity;
    public static String domain = "http://e-moci.satlantasressmikota.com/api/"; //ganti dengan domain api
    private Gson g = new Gson();
    T target;
    Class<T> tClass;
    private AfterLoad<T> afterLoad;

    public Loader(AppCompatActivity activity,Class<T> tClass, AfterLoad<T> afterLoad) {
        this.activity = activity;
        this.tClass = tClass;
        this.afterLoad = afterLoad;
    }

    public void load(String url){
        OkHttpClient ok = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();
        final Request request = new Request.Builder()
                .url(domain+url)
                .get()
                .build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity,"Terjadi kesalahan :(",Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code()==200){
                    final String datarespon = response.body().string();
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (afterLoad!=null){
                                target = (T) g.fromJson(datarespon,tClass);
                                afterLoad.doifsuccess(target);
                            }
                        }
                    });
                }
            }
        });
    }

    public interface AfterLoad<T> {
        void doifsuccess(T object);
    }

    public static class LoggingInterceptor implements Interceptor {
        @Override public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            Log.d("okhttp ",String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            Log.d("okhttp ",String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));

            return response;
        }
    }

}
