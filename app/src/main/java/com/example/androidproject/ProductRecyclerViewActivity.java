package com.example.androidproject;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.movies.MovieContainer;
import com.example.androidproject.movies.MovieResults;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProductRecyclerViewActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private ArrayList<Product> productlist =new ArrayList<>();
    private MovieContainer movieData;
    private ArrayList<MovieResults> movieReasultlist = new  ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_recycler_view);
        ftoolbar();
        JsonAsyncTask jsonAsyncTask = new JsonAsyncTask();
        jsonAsyncTask.execute();
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                findView();
            }
        },5000);
    }
    private void findView(){
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ProductAdapter(movieReasultlist, ProductRecyclerViewActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ProductRecyclerViewActivity.this,LinearLayoutManager.VERTICAL,false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ProductRecyclerViewActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    private void ftoolbar(){
        toolbar = findViewById(R.id.RVtoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Recycle view");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setproductdata(){
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        p1.setName("Discord");
        p1.setDescription("this is discord");
        p1.setPrice(100);
        p1.setImage(R.drawable.discord);
        p2.setName("Bluetooth");
        p2.setDescription("this is bluetooth");
        p2.setPrice(13400);
        p2.setImage(R.drawable.bluetooth);
        p3.setName("android");
        p3.setDescription("this is android");
        p3.setPrice(1200);
        p3.setImage(R.drawable.android);
        p4.setName("comment");
        p4.setDescription("this is comment");
        p4.setPrice(1400);
        p4.setImage(R.drawable.comment);
        productlist.add(p1);
        productlist.add(p2);
        productlist.add(p3);
        productlist.add(p4);
    }
    class JsonAsyncTask extends AsyncTask<Void ,Void,Boolean > {
        ProgressDialog progressDialog = new ProgressDialog(ProductRecyclerViewActivity.this);
        protected void onPreExecute() {
            progressDialog.setMessage("Please wait");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
            super.onPreExecute();
        }
        @Override
        protected Boolean doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("https://api.themoviedb.org/3/movie/upcoming?api_key=ef8f48b43832a9e95b87408bf739ed51").build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    progressDialog.dismiss();
                    Log.d("Error", String.valueOf(e.getLocalizedMessage()));
                }
                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    progressDialog.dismiss();
                    if(response.isSuccessful()){
                        String jsonObject =  response.body().string();
                        Gson gsonObject = new Gson();
                        movieData = gsonObject.fromJson(jsonObject,MovieContainer.class);
                        movieReasultlist.clear();
                        movieReasultlist.addAll(movieData.getResultlist());

                    }
                }
            });
            return null;
        }
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}