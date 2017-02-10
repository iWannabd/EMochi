package com.skybox.isasetiawan.emochi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.einmalfel.earl.EarlParser;
import com.einmalfel.earl.Feed;
import com.einmalfel.earl.Item;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BeritaActivity extends AppCompatActivity {
    String TAG = getClass().getSimpleName();

    RecyclerView rv;
    Feed feed;

    ProgressDialog pg;

    @BindView(R.id.judul_headline)
    TextView judulh;

    @BindView(R.id.waktu_headline)
    TextView waktuh;

    @BindView(R.id.gambar_headline)
            ImageView headline_pict;

    ArrayList<News> data = new ArrayList<>();

    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    //
    public class News {
        String title;
        String link;
        String description;
        String content;
        String date;

        public News(String title, String link, String description,String content,String date) {
            this.title = title;
            this.link = link;
            this.description = description;
            this.content = content;
            this.date = date;
        }

        String getImgLink() throws XmlPullParserException {
            if (this.content.equals("")) return "";
            Document p = Jsoup.parse(this.content);
            Element img = p.select("img").first();

            return img.attr("src");
        }

        @Override
        public String toString() {
            return this.title;
        }
    }

    public void parsingXML(String s) throws XmlPullParserException, IOException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);

        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(s));

        int event = xpp.getEventType();
        String title="",link="",description="",text = "",img="",date="";
        while (event != XmlPullParser.END_DOCUMENT){
            String name = xpp.getName();
            switch (event){
                case XmlPullParser.START_TAG:
                    Log.d(TAG, "parsingXML: start tag "+name);
                    break;

                case XmlPullParser.TEXT:
                    Log.d(TAG, "parsingXML:");
                    text = xpp.getText();
                    break;

                case XmlPullParser.END_TAG:
                    Log.d(TAG, "parsingXML: end tag "+text);
                    switch (name) {
                        case "title":
                            title = text;
                            break;
                        case "link":
                            link = text;
                            break;
                        case "description":
                            description = text;
                            break;
                        case "pubDate":
                            date = text;
                        case "encoded":
                            img = text;
                            break;
                    }
                    break;
            }
            event = xpp.next();
            addNews(new News(title,link,description,img,date));
        }

    }

    public void addNews(News n){
        Boolean ada = false;
        for (News d:data) {
            if (d.link.equals(n.link)) ada = true;
        }
        if (!ada){
            data.add(n);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        ButterKnife.bind(this);
        rv = (RecyclerView) findViewById(R.id.recview);
        pg = new ProgressDialog(this);
        loadberita();
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

    public void setImageFromUrl(final ImageView iv, String url){
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
                Toast.makeText(BeritaActivity.this,"Gagal Memuat Gambar",Toast.LENGTH_SHORT);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Bitmap bmp = BitmapFactory.decodeStream(response.body().byteStream());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(bmp);
                    }
                });
            }
        });
    }


    public void loadberita(){
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        pg.setMessage("Sebentar");
        pg.show();
        OkHttpClient ok = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://tribratanewspolrestasukabumi.com/index.php/feed/")
                .get()
                .build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    parsingXML(response.body().string());
                    if (data.size()<=0) {
                        Toast.makeText(BeritaActivity.this,"Maaf, server bermasalah",Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        data.remove(0);
                        data.remove(0);
                        data.remove(0);
                        data.remove(0);
                        for (News n: data) {
                            Log.d(TAG, "onResponse: "+n.getImgLink());
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                rv.setAdapter(new NewsAdapter());
                                judulh.setText(data.get(0).title);
                                waktuh.setText(data.get(0).date);
                                pg.dismiss();
                                try {
                                    setImageFromUrl(headline_pict,data.get(0).getImgLink());
                                } catch (XmlPullParserException e) {
                                    e.printStackTrace();
                                }
//                    waktuh.setText(df.format(feed.getItems().get(0).getPublicationDate()));
                            }
                        });
                    }
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
        });

//        Feeder f = new Feeder();
//        f.execute();
//        pg = new ProgressDialog(this);
//        pg.setMessage("Harap tunggu");
//        pg.show();
//        rv.setHasFixedSize(true);
//        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(BeritaActivity.this.getBaseContext())
                    .inflate(R.layout.item_news,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            final News news = data.get(position);
            try {
                setImageFromUrl(holder.gambar,news.getImgLink());
            } catch (XmlPullParserException e) {
                Log.e(TAG, "onBindViewHolder: ",e);
            }
            holder.judul.setText(news.title);
            holder.wakut.setText(news.date);
            holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(news.link));
                    startActivity(intent);
                }
            });

//            final Item item = feed.getItems().get(position);
//
//            if (item.getImageLink()!=null){
//                setImageFromUrl(holder.gambar,item.getImageLink());
//            }
//
//            holder.judul.setText(item.getTitle());
//            holder.wakut.setText(df.format(item.getPublicationDate()));
//            holder.judul.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(item.getLink()));
//                    startActivity(intent);
//                }
//            });
//            holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(item.getLink()));
//                    startActivity(intent);
//                }
//            });
        }

        @Override
        public int getItemCount() {
            return data.size();
//            return feed.getItems().size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            @BindView(R.id.gambar)
            ImageView gambar;
            @BindView(R.id.judul)
            TextView judul;
            @BindView(R.id.waktu)
            TextView wakut;
            @BindView(R.id.bg_news)
            ConstraintLayout constraintLayout;


            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }

//    public class Feeder extends AsyncTask<String,String,String>{
//
//        @Override
//        protected String doInBackground(String... strings) {
//            InputStream inputStream = null;
//            try {
//                inputStream = new URL("http://tribratanewspolrestasukabumi.com/index.php/feed/").openConnection().getInputStream();
//                feed = EarlParser.parseOrThrow(inputStream, 0);
//                Log.i(TAG, "Processing feed: " + feed.getTitle());
//                for (Item item : feed.getItems()) {
//                    String title = item.getImageLink();
//                    Log.i(TAG, "Item title: " + (title == null ? "N/A" : title));
//                }
//            } catch (IOException | DataFormatException | XmlPullParserException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            rv.setAdapter(new NewsAdapter());
//            judulh.setText(feed.getItems().get(0).getTitle());
//            waktuh.setText(df.format(feed.getItems().get(0).getPublicationDate()));
//            pg.dismiss();
//            if (feed.getItems().get(0).getImageLink()!=null)
//                setImageFromUrl(headline_pict,feed.getItems().get(0).getImageLink());
//            super.onPostExecute(s);
//        }
//    }

}
